
fun main() {

    val n = readLine()!!.toInt()
    var counter = 0

    val array = IntArray(n) {
        readLine()!!.toInt()
    }

    for (i in 0 until array.size) {
        if (i + 2 < array.size && array.get(i) == array.get(i + 1) - 1 && array.get(i + 1) == array.get(i + 2) - 1) counter++
    }
    println(counter)
}