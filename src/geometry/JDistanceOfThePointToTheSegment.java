package geometry;

import geometry.geometry.Point;
import geometry.geometry.Segment;
import geometry.geometry.util.Segments;

import java.text.DecimalFormat;
import java.util.Scanner;

public class JDistanceOfThePointToTheSegment {
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

        Segment segment = new Segment(a, b);

        double distance = Segments.getDistance(segment, point, 0.0000001);

        System.out.println(new DecimalFormat( "###.######" ).format(distance));

    }
}

