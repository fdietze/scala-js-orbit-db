package ipfs.orbitdb

import scalajs.js.`|`
import scalajs.js
import scala.scalajs.js.annotation._

@js.native
@JSImport("ipfs", JSImport.Namespace)
class IPFS(options: IpfsOptions) extends js.Object {
    def on(event:String, callback: js.Function0[Unit]):Unit = js.native
    def on(event:String, callback: js.Function1[Any, Unit]):Unit = js.native

    def stop():Unit = js.native
    def stop(callback: js.Function0[Unit]):Unit = js.native
}

trait IpfsOptions extends js.Object {
  val EXPERIMENTAL: js.UndefOr[IpfsOptionsExperimental] = js.undefined
}

trait IpfsOptionsExperimental extends js.Object {
  val pubsub: js.UndefOr[Boolean] = js.undefined
}

@js.native
@JSImport("orbit-db", JSImport.Namespace)
class OrbitDB(ipfs:IPFS) extends js.Object {
  def log(name:String):js.Promise[Log] = js.native

  def stop():Unit = js.native
  def stop(callback: js.Function0[Unit]):Unit = js.native
}

@js.native
trait Log extends js.Object {
  def add(content:String):js.Promise[String] = js.native
}

