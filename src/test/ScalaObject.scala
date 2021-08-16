package test

import scala.collection.mutable.ArrayBuffer

object ScalaObject {
  def main(args: Array[String]): Unit = {
    val list = List(List(1, 2), List(3, 4))
    val array = Array(4, 2, 3)
    array.sorted
    println(array.sorted.mkString("Array(", ", ", ")"))
    val arrayBuffer = ArrayBuffer(3, 2, 1)
    println(arrayBuffer.sortWith((a, b) => a - b >=0).mkString)
    println(list(1)(1))
    list.foreach{l =>
      println(l)
    }
  }
}
