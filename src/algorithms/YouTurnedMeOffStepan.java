package algorithms;

import java.util.Scanner;

public class YouTurnedMeOffStepan {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long firstBubble = in.nextInt();
        long secondBubble = in.nextInt();

        System.out.println(lcm(firstBubble, secondBubble));
    }

    static long lcm(long a, long b) {
        return (a * b) / (gcd(a, b));
    }



    static long gcd(long a, long b) {
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
