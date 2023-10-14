package algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class MirrorPrimeNumbers {
    private int firstNumber;
    private int lastNumber;
    private boolean [] sieve;


    public static void main(String[] args) {
        MirrorPrimeNumbers mirrorPrimeNumbers = new MirrorPrimeNumbers();
        mirrorPrimeNumbers.setNumbers();
        mirrorPrimeNumbers.setArray();
        mirrorPrimeNumbers.sievePrimes();
        int mirrorPrimes = mirrorPrimeNumbers.countMirrorPrimes();

        System.out.println(mirrorPrimes);
    }

    private void setNumbers() {
        Scanner in = new Scanner(System.in);
        firstNumber = setNumber(in);
        lastNumber = setNumber(in);
    }

    private void setArray() {
        sieve = new boolean [getRange()];
        Arrays.fill(sieve, true);
    }

    private void sievePrimes() {
        sieve[0] = false;
        sieve[1] = false;
        for (int i = 2; i * i < sieve.length; i++) {
            if (sieve[i]) {
                for (int j = i * i; j < sieve.length; j+=i) {
                    sieve[j] = false;
                }
            }
        }
    }

    private int countMirrorPrimes() {
        int counter = 0;
        for (int i = firstNumber; i <= lastNumber; i++) {
            if (isPrime(i) && isPrimeMirrored(i)){
                counter++;
            }
        }
        return counter;
    }

    private int setNumber(Scanner in) {
        if (in.hasNextInt()){
            return in.nextInt();
        }
        throw new IllegalArgumentException();
    }

    private int getRange() {
        int range = 0;
        int number = lastNumber;
        while (number != 0) {
            range = range * 10 + 9;
            number /= 10;
        }
        return range + 1;
    }

    private boolean isPrime(int number) {
        return sieve[number];
    }

    private boolean isPrimeMirrored(int prime) {
        int reversedNumber = reverseNumber(prime);
        return isPrime(reversedNumber);
    }

    private int reverseNumber(int number) {
        int reversed = 0;
        while (number != 0) {
            int digit = number % 10;
            reversed = reversed * 10 + digit;
            number /= 10;
        }
        return reversed;
    }

}
