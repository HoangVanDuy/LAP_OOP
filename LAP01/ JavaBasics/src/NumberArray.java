import java.util.Arrays;
import java.util.Scanner;

public class NumberArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println("Original array: " + Arrays.toString(arr));

        Arrays.sort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
        int[] desc = new int[n];
        for (int i = 0; i < n; i++) {
            desc[i] = arr[n - 1 - i];
        }
        System.out.println("Descending: " + Arrays.toString(desc));

        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        double average = (double) sum / n;
        System.out.println("Sum = " + sum);
        System.out.println("Average = " + average);

        scanner.close();
    }
}