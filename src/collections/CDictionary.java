package collections;

import collections.util.ConsoleScanner;

import java.util.*;

public class CDictionary {
    public static void main(String[] args) {

        List<String> list = ConsoleScanner.getStringList(new Scanner(System.in));
        Collections.sort(list);

        for (String word: list) {
            System.out.println(word);
        }
    }



}
