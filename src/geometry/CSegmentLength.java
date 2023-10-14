package geometry;

import geometry.geometry.util.Segments;
import geometry.geometry.Point;
import geometry.geometry.Segment;

import java.text.DecimalFormat;
import java.util.Scanner;


public class CSegmentLength {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        double x1 = in.nextInt();
        double y1 = in.nextInt();
        double x2 = in.nextInt();
        double y2 = in.nextInt();

        Point a = new Point(x1, y1);
        Point b = new Point(x2, y2);

        Segment segment = new Segment(a, b);

        double length = Segments.length(segment);

        System.out.println(new DecimalFormat( "###.######" ).format(length));


    }
}
