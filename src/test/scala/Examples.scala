package ipfs.orbitdb

import minitest._
import scala.concurrent.ExecutionContext.Implicits.global

object ExampleSuite extends SimpleTestSuite {
  test("readme example") {
    Main.main(Array.empty)
  }
}
