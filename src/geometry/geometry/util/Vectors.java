package geometry.geometry.util;


import geometry.geometry.TwoPointVector;
import geometry.geometry.NormalVector;
import geometry.geometry.Point;
import geometry.geometry.StandardFormLine;

public class Vectors {

    public static double getDistance(TwoPointVector vector, Point point, double eps) {
        StandardFormLine line = Lines.toStandardFormLine(vector);
        NormalVector normal = getNormalVector(point, line);
        Point intersectionPoint = Lines.getIntersectionPoint(line, normal.getLine());
        if (belongsToVector(vector, intersectionPoint, eps)) {
            return Lines.distanceToLine(line, point);
        } else {
            return Points.getDistanceBetween(point, vector.getStart());
        }
    }

    public static NormalVector getNormalVector(Point point, StandardFormLine line) {
//        double a = line.getB();
//        double b = -line.getA();
//        double c = -(a * point.getX() + b * point.getY());

        double a = line.getB();
        double b = -line.getA();
        double c = -(a * point.getX() + b * point.getY());

        return new NormalVector(point, a, b, c);
    }


    public static boolean belongsToVector(TwoPointVector vector, Point point, double eps) {
        StandardFormLine line = Lines.toStandardFormLine(vector);

        boolean belongsToLine = Lines.belongsToLine(line, point, eps);

        boolean lesThanStartPoint = lessThanStartPoint(vector, point, eps);

        return belongsToLine && lesThanStartPoint;
    }


    private static boolean lessThanStartPoint(TwoPointVector vector, Point point, double eps) {
        TwoPointVector.Direction direction = vector.getDirection();

        if (direction.equals(TwoPointVector.Direction.N)) {
            return point.getY() >= vector.getStart().getY();
        }

        if (direction.equals(TwoPointVector.Direction.W)) {
            return point.getX() <= vector.getStart().getX();
        }

        if (direction.equals(TwoPointVector.Direction.E)) {
            return point.getX() >= vector.getStart().getX();
        }

        if (direction.equals(TwoPointVector.Direction.S)) {
            return point.getY() <= vector.getStart().getY();
        }

        if (direction.equals(TwoPointVector.Direction.NE)) {
            return point.getY() >= vector.getStart().getY() && point.getX() >= vector.getStart().getX();
        }

        if (direction.equals(TwoPointVector.Direction.NW)) {
            return point.getY() >= vector.getStart().getY() && point.getX() <= vector.getStart().getX();
        }

        if (direction.equals(TwoPointVector.Direction.SW)) {
            return point.getY() <= vector.getStart().getY() && point.getX() <= vector.getStart().getX();
        }

        if (direction.equals(TwoPointVector.Direction.SE)) {
            return point.getY() <= vector.getStart().getY() && point.getX() >= vector.getStart().getX();
        }
        return false;
    }



}
