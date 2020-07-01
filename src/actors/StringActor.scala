package actors

import akka.actor._

case object GetValue
case class Append(a: String)
case class Value(v:String)

class StringActor(str: String) extends Actor {
  var current: String = str
  def receive: Receive = {
    case append: Append => current += append.a
    case value: Value => println(value.v)
    case GetValue => sender() ! Value(current)
  }
}
