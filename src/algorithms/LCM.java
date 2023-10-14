package algorithms;

import java.math.BigInteger;
import java.util.Scanner;

public class LCM {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int amountOfNumbers = in.nextInt();

        int [] arr = new int[amountOfNumbers];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }


        System.out.println(lcmOfN(arr));
    }

    static BigInteger lcmOfN(int arr[]) {
        BigInteger lcm = lcm(BigInteger.valueOf(arr[0]), BigInteger.valueOf(arr[1]));
        for (int i = 2; i < arr.length; i++) {
            lcm = lcm(lcm, BigInteger.valueOf(arr[i]));
        }
        return lcm;
    }

    static BigInteger lcm(BigInteger a, BigInteger b) {
        return (a.multiply(b)).divide(gcd(a, b));
    }


    static BigInteger gcd(BigInteger a, BigInteger b) {
        while (!a.equals(BigInteger.ZERO) && !b.equals(BigInteger.ZERO)) {
            if (a.compareTo(b) > 0) {
                a = a.remainder(b);
            } else {
                b = b.remainder(a);
            }
        }
        return a.add(b);
    }

}
