import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        int result = 0;
        int[] array = new int[scanner.nextInt()];

        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        for (int i = 0; i < array.length - 1; i++) {
            result = result < array[i] * array[i + 1] ? array[i] * array[i + 1] : result;
        }
        System.out.println(result);
    }
}