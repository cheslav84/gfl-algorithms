package geometry;

import geometry.geometry.Point;
import geometry.geometry.StandardFormLine;
import geometry.geometry.util.Lines;

import java.util.Scanner;

public class GPointOrientationToTheLine {
    private static final double EPS = 0.1;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double xA = in.nextInt();
        double yA = in.nextInt();
        double xB = in.nextInt();
        double yB = in.nextInt();

        double a = in.nextInt();
        double b = in.nextInt();
        double c = in.nextInt();

        Point pointA = new Point(xA, yA);
        Point pointB = new Point(xB, yB);
        StandardFormLine line = new StandardFormLine(a, b, c);

        if (Lines.isTwoPointOnTheSameSideOfLine(line, pointA, pointB, EPS)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }


}
