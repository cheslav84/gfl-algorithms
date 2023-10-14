package algorithms.util;

import java.math.BigInteger;

public class Factorial {
    public static BigInteger getFactorial(int n){
        BigInteger res = new BigInteger(String.valueOf(1));
        for (int i = 1; i <= n; i++) {
            res = res.multiply(new BigInteger(String.valueOf(i)));
        }
        return res;
    }
}
