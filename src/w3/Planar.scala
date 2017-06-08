package w3

/**
  * Created by Julia Julia on 2016.10.19..
  */
trait Planar {
  def height: Int
  def width: Int
  def surface = height * width
}
