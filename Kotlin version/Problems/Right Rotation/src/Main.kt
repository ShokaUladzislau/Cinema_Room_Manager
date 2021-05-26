fun main() {

    val n = readLine()!!.toInt()

    val array = IntArray(n) {
        readLine()!!.toInt()
    }

    var r = readLine()!!.toInt()

    if (r >= array.size) r %= array.size

    for (i in 0 until r) {
        var j: Int
        var last: Int

        last = array.get(array.size - 1)
        j = array.size - 1
        while (j > 0) {

            array[j] = array.get(j - 1)
            j--
        }

        array[0] = last
    }

    for (i in array) {
        print("$i ")
    }

}