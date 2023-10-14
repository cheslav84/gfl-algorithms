package algorithms;

import algorithms.util.Factorial;

import java.math.BigInteger;
import java.util.Scanner;

public class RooksOnChessboard {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int boardSize = in.nextInt();
        BigInteger possiblePermutations = Factorial.getFactorial(boardSize);
        System.out.println(possiblePermutations);
    }

//    public static BigDecimal getFactorial(int n){
//        BigDecimal res = new BigDecimal(1);
//        for (int i = 1; i <= n; i++) {
//            res = res.multiply(new BigDecimal(i));
//        }
//        return res;
//    }
}
