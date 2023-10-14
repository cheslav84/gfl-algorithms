package geometry;

import geometry.geometry.Point;
import geometry.geometry.util.Points;

import java.util.Scanner;

public class APolarAngleOfPoint {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double x = in.nextInt();
        double y = in.nextInt();

        Point a = new Point(x, y);

        double polarAngle = Points.getPolarAngle(a);
        System.out.printf("%,.6f", polarAngle);

    }




}
