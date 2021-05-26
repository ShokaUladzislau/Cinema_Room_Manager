fun main() {
    val a = readLine()!!.split(" ")

    var sum = 0

    for (i in a) {
        sum += i.toInt()
    }

    println(sum)
}