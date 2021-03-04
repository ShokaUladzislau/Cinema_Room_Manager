import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int[] array = Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();

        int rotate = scanner.nextInt();
        rotate %= array.length;

        for (int i = 0; i < rotate; i++) {

            int last = array[array.length - 1];

            for (int j = array.length - 1; j > 0; j--) {
                array[j] = array[j - 1];
            }
            array[0] = last;
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}