package geometry;

import geometry.geometry.Point;
import geometry.geometry.StandardFormLine;
import geometry.geometry.util.Lines;

import java.text.DecimalFormat;
import java.util.Scanner;

public class PDistanceOfThePointToTheALine {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double xP = in.nextInt();
        double yP = in.nextInt();

        double a = in.nextInt();
        double b = in.nextInt();
        double c = in.nextInt();

        Point point = new Point(xP, yP);
        StandardFormLine standardFormLine = new StandardFormLine(a, b, c);

        double distance = Lines.distanceToLine(standardFormLine, point);
        System.out.println(new DecimalFormat( "###.########" ).format(distance));
    }
}
