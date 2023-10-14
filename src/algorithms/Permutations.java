package algorithms;

import java.util.Scanner;

public class Permutations {

    private static int [] arr;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        initArray(size);
        arrange();
    }
    private static void initArray(int size) {
        arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
    }

    private static void arrange() {
        printRow();
        while (!arranged()) {
            arrangeNextRow();
            printRow();
        }
    }

    private static boolean arranged() {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < arr[i + 1]){
                return false;
            }
        }
        return true;
    }

    private static void arrangeNextRow() {
        int firstIndex = getFirstIndex();
        int lastIndex = getLastLargestIndex(firstIndex);
        swap(firstIndex, lastIndex);
        invertArrayFrom(firstIndex + 1);
    }

    private static int getFirstIndex() {
        int firstIndex = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                firstIndex = i;
            }
        }
        return firstIndex;
    }

    private static int getLastLargestIndex(int firstIndex) {
        int lastIndex = arr.length - 1;
        for (int i = arr.length - 1; i >= firstIndex; i--) {
            if (arr[i] > arr[firstIndex]) {
                lastIndex = i;
                break;
            }
        }
        return lastIndex;
    }

    private static void invertArrayFrom(int index) {
        for (int i = index, j = arr.length; i < j; i++, j--) {
            swap(i, arr.length + index - i - 1);
        }
    }

    private static void swap (int firstIndex, int lastIndex) {
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[lastIndex];
        arr[lastIndex] = temp;
    }

    private static void printRow(){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
