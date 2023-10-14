package geometry;

import geometry.geometry.Point;
import geometry.geometry.TwoPointVector;
import geometry.geometry.util.Vectors;

import java.util.Scanner;

public class EBelongingPointToAVector {
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

        TwoPointVector vector = new TwoPointVector(a, b);

        if (Vectors.belongsToVector(vector, point, 0.0000001)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}

