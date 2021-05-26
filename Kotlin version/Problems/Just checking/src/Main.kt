fun main() {
    val array = IntArray(readLine()!!.toInt()) { readLine()!!.toInt() }

    val find = readLine()

    if (find != null) {
    val result = ((find.first().toInt() - 48) - (find.last().toInt() - 48) == 1 ||
            (find.last().toInt() - 48) - (find.first().toInt() - 48) == 1)


        print(
            if (

            array.contains(find.first().toInt() - 48) &&
            array.contains(find.last().toInt() - 48) &&
                    result) "YES" else "NO")
    }
}