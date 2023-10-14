package geometry;

import geometry.geometry.Point;
import geometry.geometry.util.Points;

import java.util.Scanner;

public class BVectorAngle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double x1 = in.nextInt();
        double y1 = in.nextInt();
        double x2 = in.nextInt();
        double y2 = in.nextInt();

        Point a = new Point(x1, y1);
        Point b = new Point(x2, y2);

        double polarAngle = Points.getPolarAngleBetween(a, b);

        System.out.printf("%,.5f", polarAngle);


    }
}
