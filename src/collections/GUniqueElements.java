package collections;

import collections.util.ConsoleScanner;

import java.util.*;

public class GUniqueElements {
    public static void main(String[] args) {
        List<Integer> list = ConsoleScanner.getIntegerList(new Scanner(System.in));

        Map<Integer, Integer> map = new TreeMap<>();
        for (Integer value : list) {
            map.merge(value, 1, Integer::sum);
        }


        Map.Entry<Integer, Integer> max = map.entrySet().iterator().next();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                list.removeAll(Collections.singleton(entry.getKey()));
            }
        }

        list.forEach(a -> System.out.print(a + " "));
    }
}
