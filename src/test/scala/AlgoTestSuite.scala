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