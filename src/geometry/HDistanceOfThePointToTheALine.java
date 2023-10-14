package geometry;

import geometry.geometry.Point;
import geometry.geometry.StandardFormLine;
import geometry.geometry.TwoPointsLine;
import geometry.geometry.util.Lines;

import java.text.DecimalFormat;
import java.util.Scanner;

public class HDistanceOfThePointToTheALine {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double xP = in.nextInt();
        double yP = in.nextInt();

        double xA = in.nextInt();
        double yA = in.nextInt();

        double xB = in.nextInt();
        double yB = in.nextInt();

        Point point = new Point(xP, yP);
        Point a = new Point(xA, yA);
        Point b = new Point(xB, yB);

        TwoPointsLine line = new TwoPointsLine(a, b);
        StandardFormLine standardFormLine = Lines.toStandardForm(line);

        double distance = Lines.distanceToLine(standardFormLine, point);
        System.out.println(new DecimalFormat( "###.######" ).format(distance));


    }
}
