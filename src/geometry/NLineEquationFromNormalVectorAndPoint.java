package geometry;

import geometry.geometry.NormalVector;
import geometry.geometry.Point;
import geometry.geometry.StandardFormLine;
import geometry.geometry.TwoPointsLine;
import geometry.geometry.util.Lines;
import geometry.geometry.util.Vectors;

import java.util.Scanner;

public class NLineEquationFromNormalVectorAndPoint {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double xA = in.nextInt();
        double yA = in.nextInt();
        double xB = in.nextInt();
        double yB = in.nextInt();

        Point a = new Point(xA, yA);
        Point b = new Point(xB, yB);

        TwoPointsLine vectorLine = new TwoPointsLine(a, b);
        StandardFormLine sfLine = Lines.toStandardForm(vectorLine);
        NormalVector normal = Vectors.getNormalVector(a, sfLine);




        System.out.println(normal.getLine().getA() + " " + normal.getLine().getB() + " " + normal.getLine().getC());

    }
}
