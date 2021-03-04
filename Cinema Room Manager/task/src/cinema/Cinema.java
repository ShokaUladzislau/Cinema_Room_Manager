package cinema;

import java.util.Arrays;
import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = scanner.nextInt();
        String[][] cinemaRoom = new String[rows][seats];

        createCinemaRoom(cinemaRoom);
        showMenu(cinemaRoom, rows, seats);
    }

    public static void createCinemaRoom(String[][] cinemaRoom) {
        for (String[] strings : cinemaRoom) {
            Arrays.fill(strings, "S");
        }
    }

    public static void showCinemaRoom(String[][] cinemaRoom, int rows, int seats) {
        System.out.println("\nCinema:");
        for (int i = 0; i <= rows; i++){
            for (int j = 0; j <= seats; j++) {
                if (i == 0) {
                    System.out.print(j == 0 ? " " : " " + j);
                } else {
                    System.out.print(j == 0 ? i : " " + cinemaRoom[i-1][j-1]);
                }
            }
            System.out.println();
        }
    }

    public static void buyATicket(String[][] cinemaRoom, int rows, int seats) {
        Scanner scanner = new Scanner(System.in);
        int price = 0;
        boolean purchased = false;
        boolean wrong = false;
        System.out.println("Enter a row number:");
        int row = scanner.nextInt();

        System.out.println("Enter a seat number in that row:");
        int seat = scanner.nextInt();
        System.out.println();

        if (rows * seats <= 60) {
            price = 10;
        } else if (rows * seats > 60) {
            if (row > rows/2){
                price = 8;
            } else {
                price = 10;
            }
        }

        for (int i = 0; i <= rows; i++){
            for (int j = 0; j <= seats; j++) {
                if (row > rows || seat > seats) {
                    System.out.println("Wrong input!");
                    wrong = true;
                    break;
                }
                if (cinemaRoom[row - 1][seat - 1] == "B") {
                    System.out.println("That ticket has already been purchased!");
                    purchased = true;
                    break;
                }
            }
            break;
        }

        if (purchased || wrong) {
            buyATicket(cinemaRoom, rows, seats);
        } else if (!purchased || !wrong) {
            System.out.println("Ticket price: $" + price + "\n");
        }


        for (int i = 0; i <= rows; i++){
            for (int j = 0; j <= seats; j++) {
                if (i == row && j == seat) {
                    cinemaRoom[i - 1][j - 1] = "B";
                }
            }
        }




    }

    public static void statistics (String[][] cinemaRoom, int rows, int seats) {

        int purchasedTickets = 0;
        int amount = 0;

        for (String [] row : cinemaRoom) {
            for (String element : row) {
                if (element == "B") {
                    purchasedTickets++;
                }
                amount++;
            }
        }

        double percentageOfSeats = (purchasedTickets / (double)amount) * 100;

        int currentIncome = 0;
        int totalIncome = 0;

        if (rows * seats < 60) {
            totalIncome = rows * 10 * seats;
        } else if (rows * seats > 60) {
            totalIncome = ( rows / 2 * 10 * seats) + ((rows - (rows / 2)) * 8 * seats);
        }

        for (int i = 0; i < rows; i++){
            for (int j = 0; j < seats; j++) {
                if (cinemaRoom[i][j] == "B") {
                    currentIncome += i >= rows/2 ? 8 : 10;
                }
            }
        }

        System.out.println("\n" +
                "Number of purchased tickets: " + purchasedTickets + "\n" +
                "Percentage: " + String.format("%,.2f", percentageOfSeats) + "%" + "\n" +
                "Current income: $" + currentIncome + "\n" +
                "Total income: $" + totalIncome);
    }

    public static void showMenu(String[][] cinemaRoom, int rows, int seats){
        System.out.println("\n" +
                "1. Show the seats\n" +
                "2. Buy a ticket\n" +
                "3. Statistics\n" +
                "0. Exit");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                showCinemaRoom(cinemaRoom, rows, seats);
                showMenu(cinemaRoom, rows, seats);
                break;
            case 2:
                buyATicket(cinemaRoom, rows, seats);
                showMenu(cinemaRoom, rows, seats);
                break;
            case 3:
                statistics(cinemaRoom, rows, seats);
                showMenu(cinemaRoom, rows, seats);
                break;
            case 0:
                System.out.println("0");
                break;
            default:
                showMenu(cinemaRoom, rows, seats);
        }
    }
}