package collections;

import collections.util.ConsoleScanner;

import java.util.*;

public class DDifferent {
    public static void main(String[] args) {
        List<Integer> list = ConsoleScanner.getIntegerList(new Scanner(System.in));
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer value: list) {
            map.merge(value, 1, Integer::sum);
        }
        System.out.println(map.size());
    }
}
