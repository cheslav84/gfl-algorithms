package geometry;

import geometry.geometry.Point;
import geometry.geometry.StandardFormLine;
import geometry.geometry.util.Lines;

import java.util.Scanner;

public class OLineIntersection {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double aA = in.nextInt();
        double aB = in.nextInt();
        double aC = in.nextInt();
        double bA = in.nextInt();
        double bB = in.nextInt();
        double bC = in.nextInt();

        StandardFormLine firstLine = new StandardFormLine(aA, aB, aC);
        StandardFormLine secondLine = new StandardFormLine(bA, bB, bC);

        Point intersectionPoint = Lines.getIntersectionPoint(firstLine, secondLine);

        System.out.printf("%,.2f %,.2f", intersectionPoint.getX(), intersectionPoint.getY());

    }
}
