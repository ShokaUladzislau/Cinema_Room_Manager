fun main() {
    val array = IntArray(readLine()!!.toInt()) { readLine()!!.toInt() }

    val find = readLine()

    if (find != null &&
        array.contains(find.first().toInt() - 48) &&
        array.contains(find.last().toInt() - 48) &&
        array.indexOf(find.first().toInt() - 48) - array.indexOf(find.last().toInt() - 48) != 1
    ) {
        print("YES")
    } else if (find != null &&
        array.contains(find.first().toInt() - 48) &&
        array.contains(find.last().toInt() - 48)) {
        print("NO")
    } else {
        print("YES")
    }
}
