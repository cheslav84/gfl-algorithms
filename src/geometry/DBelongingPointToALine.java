package geometry;

import geometry.geometry.Point;
import geometry.geometry.StandardFormLine;
import geometry.geometry.util.Lines;

import java.util.Scanner;

public class DBelongingPointToALine {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double x = in.nextInt();
        double y = in.nextInt();
        double a = in.nextInt();
        double b = in.nextInt();
        double c = in.nextInt();

        StandardFormLine line = new StandardFormLine(a, b, c);
        Point point = new Point(x, y);

        if (Lines.belongsToLine(line, point, 0.0000001)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
