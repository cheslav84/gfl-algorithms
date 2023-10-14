package algorithms;
import java.util.Scanner;

public class StepanAlarmClocks {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long firstAlarm = in.nextInt();
        long secondAlarm = in.nextInt();

        System.out.println(lcm(firstAlarm, secondAlarm));
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