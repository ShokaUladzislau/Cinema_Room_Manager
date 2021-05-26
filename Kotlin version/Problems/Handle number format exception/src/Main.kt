fun parseCardNumber(cardNumber: String): Long {
    val number = cardNumber.split(" ")
    return (number[0] + number[1] + number[2] + number[3]).toLong()
}