package algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CircleOfChoirs {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.lines()
                .forEach(CircleOfChoirs::solveSingers);
    }

    static void solveSingers(String str) {
        String[] arr = str.split(" ");
        int participants = Integer.parseInt(arr[0]);
        int singers = Integer.parseInt(arr[1]);

        if (gcd(participants, singers) == 1) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
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
