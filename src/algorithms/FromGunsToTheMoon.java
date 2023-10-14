package algorithms;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Scanner;

public class FromGunsToTheMoon {
    private static final BigDecimal GRAVITATIONAL_CONSTANT = new BigDecimal("6.973E-11");
    private static final BigDecimal EARTH_MASS = new BigDecimal("5.97219E24");
    private static final BigDecimal MOON_MASS;

    private static final Point EARTH_POINT;
    private static final Point MOON_POINT;
    private static final MathContext CONTEXT;


    static  {
        MOON_MASS = EARTH_MASS.multiply(BigDecimal.valueOf(81));
        EARTH_POINT = new Point(0, 0);
        MOON_POINT = new Point(384000, 0);
//        MOON_POINT = new Point(34, 67);
        CONTEXT = new MathContext(10, RoundingMode.HALF_UP);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();

//        int x = 467;
//        int y = 35;

        Point shellPoint = new Point(x, y);

//        double distanceToEarth = shellPoint.calculateDistance(EARTH_POINT);
//        double distanceToMoon = shellPoint.calculateDistance(MOON_POINT);

        BigDecimal distanceToEarth = shellPoint.calculateDistance(EARTH_POINT);
        BigDecimal distanceToMoon = shellPoint.calculateDistance(MOON_POINT);



        BigDecimal earthForce = getForce(distanceToEarth);
        BigDecimal moonForce = getForce(distanceToMoon);

        printGreatestForce(earthForce, moonForce);



    }

    private static void printGreatestForce(BigDecimal earthForce, BigDecimal moonForce) {
        switch (earthForce.compareTo(moonForce)) {
            case 1 -> System.out.println("Earth");
            case -1 -> System.out.println("Moon");
            case 0 -> System.out.println("Equal");
        }
    }


    private static BigDecimal getForce(BigDecimal distance) {

        BigDecimal squareDistance = distance.pow( 2, CONTEXT);
        return (GRAVITATIONAL_CONSTANT.multiply(EARTH_MASS).multiply(MOON_MASS))
                .divide(squareDistance, CONTEXT);
    }

//    private static double getForce(double distance) {
//        return (gravitationalConstant * EARTH_MASS * MOON_MASS) /
//                Math.pow(distance, 2);
//
//        return force;
//    }

    static class Point {
        private final int x;
        private final int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        private BigDecimal calculateDistance(Point other) {
//            double xDiffPow = Math.pow((other.x - this.x), 2);
//            double yDiffPow = Math.pow((other.y - this.y), 2);


            BigDecimal xDiffPow = BigDecimal.valueOf(other.x).subtract(BigDecimal.valueOf(this.x)).pow(2, CONTEXT);
            BigDecimal yDiffPow = BigDecimal.valueOf(other.y).subtract(BigDecimal.valueOf(this.y)).pow(2, CONTEXT);

            return xDiffPow.add(yDiffPow).sqrt(CONTEXT);
//            return Math.sqrt(xDiffPow + yDiffPow);
        }


//        private double calculateDistance(Point other) {
//            double xDiffPow = Math.pow((other.x - this.x), 2);
//            double yDiffPow = Math.pow((other.y - this.y), 2);
//            return Math.sqrt(xDiffPow + yDiffPow);
//        }

    }

}
