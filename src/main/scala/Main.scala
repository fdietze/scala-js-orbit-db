package ipfs.orbitdb

object Main {
  def main(args:Array[String]):Unit = {
    val ipfsOptions = new IpfsOptions {
      override val EXPERIMENTAL = new IpfsOptionsExperimental {
        override val pubsub = true 
      }
    }

    val ipfs = new IPFS(ipfsOptions)

    ipfs.on("ready", () => {
      val orbitdb = new OrbitDB(ipfs)
    })
  }
}
