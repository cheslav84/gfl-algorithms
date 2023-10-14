package collections;

import java.util.*;

public class BSets {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int k = in.nextInt();
            for (int j = 0; j < k; j++) {
                int x = in.nextInt();
                set.add(x);
            }
        }

        System.out.println(set.size());
    }
}