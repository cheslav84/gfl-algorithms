package algorithms;

import java.util.Scanner;

public class BaghdadRegistration {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int traders = in.nextInt();

        int minNumbCitizens = getMinNumbCitizens(traders);
        int maxNumbCitizens = getMaxNumbCitizens(traders);

        System.out.println(minNumbCitizens + " " + maxNumbCitizens);
    }


    private static int getMinNumbCitizens(int number) {
        if (number % 3 == 0) {
            return number/3;
        }
        return number/3 + 1;
    }

    private static int getMaxNumbCitizens(int number) {
        return number/2;
    }

}
