package algorithms;

import java.util.Scanner;

public class GreatestCommonDivisor {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int amountOfNumbers = in.nextInt();

        int [] arr = new int[amountOfNumbers];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }

        int d = gcdOfN(arr);
        System.out.println(d);

    }

    static int gcdOfN(int arr[]) {
        if (arr.length == 1) {
            return arr[0];
        }
        int gcd = gcd(arr[0], arr[1]);
        for (int i = 1; i < arr.length; i++) {
            gcd = gcd(gcd, arr[i]);
        }
        return gcd;
    }


    static int gcd(int a, int b) {
        while (a != 0 && b !=0) {
            if (a > b) {
                a %= b;
            } else {
                b %= a;
            }
        }
        return a + b;
    }


}
