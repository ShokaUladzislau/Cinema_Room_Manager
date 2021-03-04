import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        int[] array = new int[scanner.nextInt()];
        
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        
        int num = scanner.nextInt();

        boolean result = false;
        for (int number : array) {
            if (number == num) {
                result = true;
            }
        }
        System.out.println(result);

    }
}