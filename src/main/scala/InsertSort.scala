import scala.collection.mutable.ArrayBuffer
import scala.math.Ordering.Implicits.*

object InsertSort {
  def apply[T](xs: ArrayBuffer[T])(using Ordering[T]) =
    var handle = 0

    while handle < xs.length do
      var cursor = handle

      while cursor > 0 && xs(cursor) < xs(cursor - 1) do
        val x1 = xs(cursor)
        val x2 = xs(cursor - 1)

        xs(cursor) = x2
        xs(cursor - 1) = x1

        cursor = cursor - 1

      handle = handle + 1

    xs
}
