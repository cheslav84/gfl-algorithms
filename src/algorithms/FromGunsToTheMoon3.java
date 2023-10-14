package algorithms;

import java.util.Scanner;

public class FromGunsToTheMoon3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();

        double earth = 81 / (Math.pow(x, 2) + Math.pow(y, 2));
        double moon = 1 / (Math.pow(384000 - x, 2) + Math.pow(y, 2));
        if (earth == moon) {
            System.out.println("Equal");
        } else if (earth > moon) {
            System.out.println("Earth");
        } else {
            System.out.println("Moon");
        }

    }

}
