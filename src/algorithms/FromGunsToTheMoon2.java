package algorithms;

import java.util.Scanner;

public class FromGunsToTheMoon2 {
    private static final double GRAVITATIONAL_CONSTANT = 6.973E-11;
    private static final double EARTH_MASS = 5.97219E24;
    private static final double MOON_MASS;
    private static final Point EARTH_POINT;
    private static final Point MOON_POINT;


    static  {
        MOON_MASS = EARTH_MASS * 81;
        EARTH_POINT = new Point(0, 0);
        MOON_POINT = new Point(384000, 0);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();

//        int x = 384000;
//        int y = 100000;

        Point shellPoint = new Point(x, y);

        double distanceToEarth = shellPoint.calculateDistance(EARTH_POINT);
        double distanceToMoon = shellPoint.calculateDistance(MOON_POINT);

        double earthForce = getForce(distanceToEarth);
        double moonForce = getForce(distanceToMoon);

        printGreatestForce(earthForce, moonForce);

    }

    private static void printGreatestForce(double earthForce, double moonForce) {
        String result = earthForce > moonForce ? "Earth" : earthForce < moonForce ? "Moon" : "Equal";
        System.out.println(result);
    }

    private static double getForce(double distance) {
        return (GRAVITATIONAL_CONSTANT * EARTH_MASS * MOON_MASS) /
                Math.pow(distance, 2);
    }

    static class Point {
        private final int x;
        private final int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        private double calculateDistance(Point other) {
            double xDiffPow = Math.pow((other.x - this.x), 2);
            double yDiffPow = Math.pow((other.y - this.y), 2);
            return Math.sqrt(xDiffPow + yDiffPow);
        }

    }

}
