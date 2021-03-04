import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[][]mass = new int[size][size];
        boolean result = true;

        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j < mass[i].length; j++) {
                mass[i][j] = scanner.nextInt();
            }
            System.out.println();
        }

        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j < mass[i].length; j++) {
                if (mass[i][j] != mass[j][i]) {
                    result = false;
                }
            }
        }
        System.out.println(result ? "YES" : "NO");

    }
}