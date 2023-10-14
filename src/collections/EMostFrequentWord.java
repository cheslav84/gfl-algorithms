package collections;

import collections.util.ConsoleScanner;

import java.util.*;
import java.util.stream.Collectors;

public class EMostFrequentWord {
    public static void main(String[] args) {
        List<String> list = ConsoleScanner.getStringList(new Scanner(System.in));

        Map<String, Integer> map = new TreeMap<>();
        for (String value : list) {
            map.merge(value, 1, Integer::sum);
        }

        Map.Entry<String, Integer> max = map.entrySet().iterator().next();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max.getValue()) {
                max = entry;
            }
        }

        Integer maxFrequency = max.getValue();


        List<String> mostFrequentWords = map
                .entrySet()
                .stream()
                .filter(entry -> maxFrequency.equals(entry.getValue()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        Collections.sort(mostFrequentWords, Collections.reverseOrder());

        String lastMostFrequentWord = mostFrequentWords.get(0);

        System.out.println(lastMostFrequentWord + " " + map.get(lastMostFrequentWord));
    }
}



