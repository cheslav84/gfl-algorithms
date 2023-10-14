package algorithms;

//import java.math.BigInteger;
import java.util.Scanner;

public class NumberOfZeroesInFactorial {
    private static int counter;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
//        BigInteger factorial = Factorial.getFactorial(number);

//        String factorialStr = factorial.toString();
//        int lastZeroes = countLastZeroes(factorialStr);

        int zeroes = countZeroes(number);
        System.out.println(zeroes);

    }




    static int countZeroes(int number) {
        int count = 0;
        while (number > 0) {
            number /= 5;
            count += number;
        }
        return count;
    }



//    private static void countZeroes(BigInteger number){
//        if (number.mod(new BigInteger("10")).equals(BigInteger.ZERO)){
//            number = number.divide(new BigInteger("10"));
//            countZeroes(number);
//            counter++;
//        }
//    }


//    private static int countLastZeroes(String factorialStr) {
//        int counter = 0;
//        for (int i = factorialStr.length(); i > 0; i--) {
//            if(factorialStr.charAt(i - 1) == '0') {
//                counter++;
//            } else {
//                break;
//            }
//        }
//        return counter;
//    }
}
