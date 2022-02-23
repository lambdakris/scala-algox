import scala.collection.mutable.ArrayBuffer

class AlgoTestSuite extends munit.FunSuite {
  def unaryTest[T]
  (
    name: String,
    original: ArrayBuffer[T],
    expected: ArrayBuffer[T],
    activity: ArrayBuffer[T] => ArrayBuffer[T]
  )
  (using munit.Location) = {
    test(name) {
      val obtained = activity(original)
      assertEquals(obtained,expected)
    }
  }
}

class InsertSortTests extends AlgoTestSuite {
  def check[T] 
  ( 
    name: String,
    original: ArrayBuffer[T],
    expected: ArrayBuffer[T]
  ) 
  (using munit.Location, Ordering[T]) = {
    unaryTest(name, original, expected, InsertSort.apply[T])
  }
  check(
    name = "case 1", 
    original = ArrayBuffer[Int](), 
    expected = ArrayBuffer[Int]()
  )
  check(
    name = "case 2",
    original = ArrayBuffer(1,2,3),
    expected = ArrayBuffer(1,2,3)
  )
  check(
    name = "case 3",
    original = ArrayBuffer(1,3,2),
    expected = ArrayBuffer(1,2,3)
  )
  check(
    name = "case 4",
    original = ArrayBuffer(3,1,2),
    expected = ArrayBuffer(1,2,3)
  )
  check(
    name = "case 5",
    original = ArrayBuffer(3,2,1),
    expected = ArrayBuffer(1,2,3)
  )
  check(
    name = "case 6",
    original = ArrayBuffer(1,2,1),
    expected = ArrayBuffer(1,1,2)
  )
  check(
    name = "case 7",
    original = ArrayBuffer(2,2,1),
    expected = ArrayBuffer(1,2,2)
  )
}
