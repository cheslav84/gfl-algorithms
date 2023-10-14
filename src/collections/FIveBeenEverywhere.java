package collections;

import collections.util.ConsoleScanner;

import java.util.*;

public class FIveBeenEverywhere {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int trips = in.nextInt();

        List<String> list;
        for (int i = 0; i < trips; i++) {
            list = ConsoleScanner.getStringList(in);
            Map<String, Integer> map = new HashMap<>();
            for (String value: list) {
                map.merge(value, 1, Integer::sum);
            }
            System.out.println(map.size());
        }
    }
}
