import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        String[][] twoDimArray = new String[size][size];

        for (int i = 0; i < twoDimArray.length; i++) {
            for (int j = 0; j < twoDimArray[i].length; j++) {
                twoDimArray[i][j] = ".";
                if (i == size / 2 || j == size / 2 || i == j || twoDimArray.length - i == j + 1) {
                    twoDimArray[i][j] = "*";
                }
                System.out.print(twoDimArray[i][j] + " ");
            }
            System.out.println();
        }
    }
}