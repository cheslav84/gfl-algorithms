package geometry;

import geometry.geometry.Point;
import geometry.geometry.Segment;
import geometry.geometry.util.Segments;

import java.util.Scanner;

public class FBelongingPointToASegment {
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

        if (Segments.belongsToSegment(segment, point, 0.1)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}
