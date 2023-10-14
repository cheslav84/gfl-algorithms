package geometry;

import geometry.geometry.Point;
import geometry.geometry.Segment;
import geometry.geometry.util.Segments;

import java.text.DecimalFormat;
import java.util.Scanner;

public class LDistanceBetweenSegments {
    private static double EPS = 0.0000001;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double xA = in.nextInt();
        double yA = in.nextInt();
        double xB = in.nextInt();
        double yB = in.nextInt();
        double xC = in.nextInt();
        double yC = in.nextInt();
        double xD = in.nextInt();
        double yD = in.nextInt();

        Point a = new Point(xA, yA);
        Point b = new Point(xB, yB);
        Point c = new Point(xC, yC);
        Point d = new Point(xD, yD);

        Segment segmentAB = new Segment(a, b);
        Segment segmentCD = new Segment(c, d);

        double distance = Segments.getDistance(segmentAB, segmentCD, EPS);


        System.out.println(new DecimalFormat( "###.######" ).format(distance));

    }
}

