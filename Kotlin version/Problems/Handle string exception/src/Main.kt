fun main() {
    val index = readLine()!!.toInt()
    val word = readLine()!!.toString()
    if (index > word.toCharArray().size - 1 || index < 0) {
        print("There isn't such an element in the given string, please fix the index!")
    } else {
        println(word[index])
    }
}