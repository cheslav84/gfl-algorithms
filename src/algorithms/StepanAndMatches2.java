package algorithms;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class StepanAndMatches2 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        long [] a = new long[12];

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < 12; i++) {
                a[i] = in.nextInt();
            }

            Arrays.sort(a);

            int m = 3;
            int j = 0;
            while (m < 12 && a[j] == a[m]) {
                j += 4;
                m += 4;
            }
            if (m < 12) {
                System.out.println("no");
            } else {
                System.out.println("yes");
            }
        }
    }

}
