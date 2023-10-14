package collections;


import collections.util.ConsoleScanner;

import java.util.*;

public class AAddAll {
    public static void main(String[] args) {

        Long[] arr = ConsoleScanner.getArray(new Scanner(System.in));
        List<Long> list = new ArrayList<>(Arrays.asList(arr));
        list.sort(Long::compareTo);

        long value = 0;

        while (list.size() > 1) {
            Long first = list.remove(0);
            Long second = list.remove(0);
            long sum = first + second;
            insert(list, sum);
            value += sum;
        }
        System.out.println(value);
    }

    private static void insert(List<Long> list, Long element) {
        int index = Collections.binarySearch(list, element, Comparator.naturalOrder());
        if (index < 0) {
            index = -index - 1;
        }
        list.add(index, element);
    }

}
