package dynamicPrograming;

import java.util.Scanner;

public class BTrimARow2 {
    static int[][] arr;
    static String line;


    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        line = in.nextLine();

        arr = new int[line.length()][line.length()];
        for (int i = 0; i < line.length(); ++i) {
            for (int j = 0; j < line.length(); ++j) {
                if (i == j) arr[i][j] = 1;
                else arr[i][j] = -1;
            }
        }

        System.out.print(findMin(0, line.length() - 1));
    }

    static int findMin(int left, int right) {
        if (left > right) {
            return 0;
        }
        if (arr[left][right] == -1) {
            arr[left][right] = line.length();
            if (line.charAt(left) == line.charAt(right)) {
                arr[left][right] = Math.min(arr[left][right], findMin(left + 1, right - 1));
            }
            for (int i = left; i < right; i++) {
                arr[left][right] = Math.min(arr[left][right], findMin(left, i) + findMin(i + 1, right));
            }
        }
        return arr[left][right];
    }
}
