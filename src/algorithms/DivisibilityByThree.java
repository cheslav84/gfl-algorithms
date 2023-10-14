package algorithms;

import java.math.BigInteger;
import java.util.Scanner;

public class DivisibilityByThree {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long number = in.nextInt();
//        System.out.println(countDivisorsBI(number) + " " + countDivisors(number));
        System.out.println(countDivisors(number));
    }

    private static int countDivisorsBI(int number) {
        int counter = 0;
        BigInteger k = BigInteger.valueOf(0);
        for (int i = 1; i <= number; i++) {
            k = k.add(BigInteger.valueOf(i));
            if(k.remainder(BigInteger.valueOf(3)).compareTo(BigInteger.ZERO) == 0) {
                counter++;
            }
        }
        return counter;
    }

    private static long countDivisors(long number) {
//        int counter = 0;
//        for (int i = 1; i <= number; i++) {
//            if((number - 1) % 3 != 0) {
//                counter = number * 2 / 3;
//            }
//            if(i % 3 == 0 || (i + 1) % 3 == 0) counter++;
//        }
        return number * 2 / 3;
    }


//    private static int countDivisors(int number) {
//        int counter = 0;
//        int k = 0;
//        for (int i = 1; i <= number; i++) {
//            k += i;
////            System.out.println(k);
//            if(k % 3 == 0) counter++;
//        }
//        return counter;
//    }

//    private static int countDivisors(int number) {
//        int counter = 0;
//        int k = 0;
//        for (int i = 1; i <= number; i++) {
//            k += i;
//            if (k >= 10) k = add(k);
//            if (k % 3 == 0) counter++;
////            if (k % 3 == 0) counter++;
//        }
//        return counter;
//    }
//
//    private static int add(int k) {
//        String str = String.valueOf(k);
//        int first = Integer.parseInt(str.substring(0, 1));
//        int second = Integer.parseInt(str.substring(1));
//        return first + second;
//    }



//    private static int countDivisors(int number) {
//        int counter = 0;
//        for (int i = 1; i <= number; i++) {
//            int currentNumber = 0;
//            for (int j = 1; j <= number + 1 - i; j++) {
//                currentNumber += j;
//            }
//            if (currentNumber % 3 == 0) {
//                counter++;
//            }
//        }
//        return counter;
//    }

    //    private static int countDivisors(int number) {
//        int counter = 0;
//        String numberStr = "";
//        for (int i = 1; i <= number; i++) {
//            numberStr += i;
//            if (Integer.parseInt(numberStr) % 3 == 0) {
//                counter++;
//            }
//        }
//        return counter;
//    }
}
