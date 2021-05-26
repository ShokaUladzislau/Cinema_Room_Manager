package cinema

import java.util.*

object Cinema {
    @JvmStatic
    fun main(args: Array<String>) {
        val scanner = Scanner(System.`in`)
        println("Enter the number of rows:")
        val rows = scanner.nextInt()
        println("Enter the number of seats in each row:")
        val seats = scanner.nextInt()
        val cinemaRoom = Array(rows) {
            arrayOfNulls<String>(
                seats
            )
        }
        createCinemaRoom(cinemaRoom)
        showMenu(cinemaRoom, rows, seats)
    }

    fun createCinemaRoom(cinemaRoom: Array<Array<String?>>) {
        for (strings: Array<String?>? in cinemaRoom) {
            Arrays.fill(strings, "S")
        }
    }

    fun showCinemaRoom(cinemaRoom: Array<Array<String?>>, rows: Int, seats: Int) {
        println("\nCinema:")
        for (i in 0..rows) {
            for (j in 0..seats) {
                if (i == 0) {
                    print(if (j == 0) " " else " $j")
                } else {
                    print(if (j == 0) i else " " + cinemaRoom[i - 1][j - 1])
                }
            }
            println()
        }
    }

    fun buyATicket(cinemaRoom: Array<Array<String?>>, rows: Int, seats: Int) {
        val scanner = Scanner(System.`in`)
        var price = 0
        var purchased = false
        var wrong = false
        println("Enter a row number:")
        val row = scanner.nextInt()
        println("Enter a seat number in that row:")
        val seat = scanner.nextInt()
        println()
        if (rows * seats <= 60) {
            price = 10
        } else if (rows * seats > 60) {
            if (row > rows / 2) {
                price = 8
            } else {
                price = 10
            }
        }
        for (i in 0..rows) {
            for (j in 0..seats) {
                if (row > rows || seat > seats) {
                    println("Wrong input!")
                    wrong = true
                    break
                }
                if (cinemaRoom[row - 1][seat - 1] === "B") {
                    println("That ticket has already been purchased!")
                    purchased = true
                    break
                }
            }
            break
        }
        if (purchased || wrong) {
            buyATicket(cinemaRoom, rows, seats)
        } else if (!purchased || !wrong) {
            println("Ticket price: $$price\n")
        }
        for (i in 0..rows) {
            for (j in 0..seats) {
                if (i == row && j == seat) {
                    cinemaRoom[i - 1][j - 1] = "B"
                }
            }
        }
    }

    fun statistics(cinemaRoom: Array<Array<String?>>, rows: Int, seats: Int) {
        var purchasedTickets = 0
        var amount = 0
        for (row: Array<String?> in cinemaRoom) {
            for (element: String? in row) {
                if (element === "B") {
                    purchasedTickets++
                }
                amount++
            }
        }
        val percentageOfSeats = purchasedTickets / amount.toDouble() * 100
        var currentIncome = 0
        var totalIncome = 0
        if (rows * seats < 60) {
            totalIncome = rows * 10 * seats
        } else if (rows * seats > 60) {
            totalIncome = rows / 2 * 10 * seats + (rows - rows / 2) * 8 * seats
        }
        for (i in 0 until rows) {
            for (j in 0 until seats) {
                if (cinemaRoom[i][j] === "B") {
                    currentIncome += if (i >= rows / 2) 8 else 10
                }
            }
        }
        println(
            "\n" +
                    "Number of purchased tickets: " + purchasedTickets + "\n" +
                    "Percentage: " + String.format("%,.2f", percentageOfSeats) + "%" + "\n" +
                    "Current income: $" + currentIncome + "\n" +
                    "Total income: $" + totalIncome
        )
    }

    fun showMenu(cinemaRoom: Array<Array<String?>>, rows: Int, seats: Int) {
        println(
            ("\n" +
                    "1. Show the seats\n" +
                    "2. Buy a ticket\n" +
                    "3. Statistics\n" +
                    "0. Exit")
        )
        val scanner = Scanner(System.`in`)
        val choice = scanner.nextInt()
        when (choice) {
            1 -> {
                showCinemaRoom(cinemaRoom, rows, seats)
                showMenu(cinemaRoom, rows, seats)
            }
            2 -> {
                buyATicket(cinemaRoom, rows, seats)
                showMenu(cinemaRoom, rows, seats)
            }
            3 -> {
                statistics(cinemaRoom, rows, seats)
                showMenu(cinemaRoom, rows, seats)
            }
            0 -> println("0")
            else -> showMenu(cinemaRoom, rows, seats)
        }
    }
}