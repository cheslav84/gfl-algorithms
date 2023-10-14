package geometry;

import geometry.geometry.Point;
import geometry.geometry.StandardFormLine;
import geometry.geometry.TwoPointsLine;
import geometry.geometry.util.Lines;

import java.util.Scanner;

public class MLineEquationFromTwoPoints {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double xA = in.nextInt();
        double yA = in.nextInt();
        double xB = in.nextInt();
        double yB = in.nextInt();

        Point a = new Point(xA, yA);
        Point b = new Point(xB, yB);

        TwoPointsLine line = new TwoPointsLine(a, b);
        StandardFormLine sfLine = Lines.toStandardForm(line);

        System.out.println(sfLine.getA() + " " + sfLine.getB() + " " + sfLine.getC());

    }
}
