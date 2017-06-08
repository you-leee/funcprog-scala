package w5

/**
  * Created by Julia Julia on 2016.11.10..
  */
object Main extends App{
  val lm = new ListMoreFunc
  println(lm.flatten(List(List(1, 1), 2, List(3, List(5, 8)))))

  val myList = List(1,2,3,4,5,6,7)
  val n = myList.length/2
  println(myList take n)
  println(myList drop n)


  val nums = List(1,-2,3,-4,5,16,7)
  println(lm.mergesort(nums).mkString(" "))
  println(lm.mergesortGeneral(nums)((x: Int, y: Int) => x < y).mkString(" "))
  println(lm.mergesortGeneral2(nums).mkString(" "))

  val fruits = List("apple", "orange", "bananaa", "pear", "dragonfuit")
  println(lm.mergesortGeneral(fruits)((x: String, y: String) => x < y).mkString(" "))
  println(lm.mergesortGeneral2(fruits).mkString(" "))

  println(nums.filter(x => x > 0))
  println(nums.filterNot(x => x > 0))
  println(nums.partition(x => x > 0))
  println(nums.span(x => x > 0))

  val lho = new ListHighOrderAndReductionFuns

  val data = List("a", "a", "a", "b", "c", "c", "a")
  println(lho.pack(data).mkString(" "))
  println(lho.encode(data).mkString(" "))
  println(lho.encodeWithPack(data).mkString(" "))


}
