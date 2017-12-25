package ipfs.orbitdb

import minitest._
import scala.concurrent.ExecutionContext.Implicits.global
import io.monadless.stdlib.MonadlessFuture._

object ExampleSuite extends SimpleTestSuite {
  test("readme example") {
    val ipfsOptions = new IpfsOptions {
      override val EXPERIMENTAL = new IpfsOptionsExperimental {
        override val pubsub = true 
      }
    }

    val ipfs = new IPFS(ipfsOptions)

    ipfs.on("error", (e) => println(e))
    ipfs.on("ready", () => {
      lift {
        // Create a database
        val orbitdb = new OrbitDB(ipfs)
        val db = unlift(orbitdb.log("hello").toFuture)
        val hash = unlift(db.add("hello world").toFuture)
        println(hash)
        orbitdb.stop(() => println("orbitdb stopped"))
        // ipfs.stop(() => println("ipfs stopped"))
        //   // Get last 5 entries
        // const latest = db.iterator({ limit: 5 }).collect()
        //   console.log(JSON.stringify(latest, null, 2))
      }
    })
  }
}
