import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] matrix = new String[4][4];
        boolean result = true;

        for (int i = 0; i < matrix.length; i++) {
            String input = scanner.next();
            char[] inputToArray = input.toCharArray();
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = String.valueOf(inputToArray[j]);
            }
        }

        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                if (matrix[i][j].equals(matrix[i][j + 1]) &&
                        matrix[i + 1][j].equals(matrix[i + 1][j + 1]) &&
                        matrix[i][j].equals(matrix[i + 1][j + 1]) &&
                        matrix[i][j + 1].equals(matrix[i + 1][j])) {
                    result = false;
                }
            }
        }
        System.out.println(result ? "YES" : "NO");
    }
}