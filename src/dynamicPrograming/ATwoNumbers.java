package dynamicPrograming;

import java.util.Scanner;

public class ATwoNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();

        int[] arr = new int[number + 3];
        fillSequences(arr, number);
        System.out.println(arr[number]);

    }

    private static void fillSequences(int[] arr, int number) {
        arr[1] = 2;
        arr[2] = 4;
        for (int i = 3; i <= number; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
    }
}
