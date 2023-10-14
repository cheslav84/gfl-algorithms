package geometry.geometry.util;

import geometry.geometry.Point;



public class Points {
    public static double getPolarAngle(Point point){
        double x = point.getX();
        double y = point.getY();

        return (y >= 0) ? Math.atan2(y, x) : Math.atan2(y, x) + 2 * Math.PI;
    }

    public static double getPolarAngleBetween(Point pointA, Point pointB){
        double polarAngleA = getPolarAngle(pointA);
        double polarAngleB = getPolarAngle(pointB);

        double polarAngle;
        double diff = (polarAngleA > polarAngleB) ? polarAngleA - polarAngleB : polarAngleB - polarAngleA;
        if (diff <= Math.PI) {
            polarAngle = diff;
        } else {
            if (polarAngleA >= polarAngleB) {
                polarAngle = 2 * Math.PI - polarAngleA + polarAngleB;
            } else {
                polarAngle = 2 * Math.PI - polarAngleB + polarAngleA;
            }
        }
        return polarAngle;
    }


    public static double getDistanceToNearestPoint(Point a, Point b, Point target) {
        double toA = getDistanceBetween(a, target);
        double toB = getDistanceBetween(b, target);
        return Math.min(toA, toB);
    }

    public static boolean isPointInBounds(Point p1, Point p2, Point t, double eps) {
        return
                (Math.abs(t.getX() - Math.min(p1.getX(), p2.getX())) <= eps || Math.min(p1.getX(), p2.getX()) <= t.getX()) &&
                (Math.abs(Math.max(p1.getX(), p2.getX()) - t.getX()) <= eps || Math.max(p1.getX(), p2.getX()) >= t.getX()) &&
                (Math.abs(t.getY() - Math.min(p1.getY(), p2.getY())) <= eps || Math.min(p1.getY(), p2.getY()) <= t.getY()) &&
                (Math.abs(Math.max(p1.getY(), p2.getY()) - t.getY()) <= eps || Math.max(p1.getY(), p2.getY()) >= t.getY());
    }


    public static double getDistanceBetween (Point p1, Point p2) {
        return Math.hypot(p2.getX() - p1.getX(), p2.getY() - p1.getY());
    }


}
