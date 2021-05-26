fun main() {    
    val numbers = readLine()!!.split(' ').map { it.toInt() }.toIntArray()
    // Do not touch lines above
    // Write only exchange actions here.
    val x = numbers[numbers.lastIndex]
    numbers[numbers.lastIndex] = numbers[0]
    numbers[0] = x
    // Do not touch lines below
    println(numbers.joinToString(separator = " "))
}