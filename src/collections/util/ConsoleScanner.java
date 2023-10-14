package collections.util;

import java.util.*;

public class ConsoleScanner {

    public static List<Integer> getIntegerList(Scanner in) {
        int n = in.nextInt();
        return scanIntegersToList(n, in);
    }


    private static List<Integer> scanIntegersToList(int n, Scanner in) {
        List<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(in.nextInt());
        }
        return list;
    }




    public static List<String> getStringList(Scanner in) {
        int n = in.nextInt();
        return scanStringsToList(n, in);
    }


    private static List<String> scanStringsToList(int n, Scanner in) {
        List<String> list = new ArrayList<>(n);
        in.nextLine();
        for (int i = 0; i < n; i++) {
            list.add(in.nextLine());
        }
        return list;
    }




    public static Long[] getArray(Scanner in) {
        int n = in.nextInt();
        return scanGraph(n, in);
    }


    private static Long[] scanGraph(int n, Scanner in) {

        Long[] arr = new Long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextLong();
        }
        return arr;
    }



}
