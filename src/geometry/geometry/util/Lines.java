package geometry.geometry.util;

import geometry.geometry.*;


public class Lines {

    public static SlopeInterceptFormLine toSlopeInterceptForm(StandardFormLine line) {
        double a = line.getA();
        double b = line.getB();
        double c = line.getC();
        if (b == 0) {
            throw new IllegalArgumentException("Cannot transform to slope intercept form line. B = 0.");
        }
        return new SlopeInterceptFormLine(-a/b, -c/b);
    }

//    public static SlopeInterceptFormLine toSlopeInterceptForm(TwoPointsLine line) {
//        double xA = line.getA().getX();
//        double yA = line.getA().getY();
//        double xB = line.getB().getX();
//        double yB = line.getB().getY();
//
//        if (xA == xB) {
//            throw new IllegalArgumentException("Cannot transform to slope intercept form line. Xa = Xb.");
//        }
//           double k = (yB - yA) / (xB - xA);
//           double b = yB - k * xB;
//        return new SlopeInterceptFormLine(k, b);
//    }


    public static StandardFormLine toStandardForm(TwoPointsLine line) {
        double xA = line.getA().getX();
        double yA = line.getA().getY();
        double xB = line.getB().getX();
        double yB = line.getB().getY();
        return getStandardFormLine(xA, yA, xB, yB);
    }

    public static StandardFormLine toStandardFormLine(Segment segment) {
        double xA = segment.getStart().getX();
        double yA = segment.getStart().getY();
        double xB = segment.getEnd().getX();
        double yB = segment.getEnd().getY();
        return getStandardFormLine(xA, yA, xB, yB);
    }


    public static StandardFormLine toStandardFormLine(TwoPointVector vector) {
        double xA = vector.getStart().getX();
        double yA = vector.getStart().getY();
        double xB = vector.getEnd().getX();
        double yB = vector.getEnd().getY();
        return getStandardFormLine(xA, yA, xB, yB);
    }

    private static StandardFormLine getStandardFormLine(double xA, double yA, double xB, double yB) {
        double a = yA - yB;
        double b = xB - xA;
        double c = (xA-xB)*yA + (yB-yA)*xA;
        if (a == 0 && b == 0) {
            throw new IllegalArgumentException("That is not the line, but point. Xa = 0 and Xb == 0.");
        }
        return new StandardFormLine(a, b, c);
    }


    public static boolean belongsToLine(StandardFormLine line, Point point, double eps) {
        double x = point.getX();
        double y = point.getY();
        double a = line.getA();
        double b = line.getB();
        double c = line.getC();
        double distance = Math.abs(a*x + b*y + c) / Math.hypot(a, b);
        return distance <= eps;
    }

    public static double distanceToLine(StandardFormLine line, Point point) {
        double x = point.getX();
        double y = point.getY();
        double a = line.getA();
        double b = line.getB();
        double c = line.getC();
        return Math.abs(a*x + b*y + c) / Math.hypot(a, b);
    }

    public static int onRightSideOfTheLine(StandardFormLine line, Point point, double eps) {//todo rename
        double x = point.getX();
        double y = point.getY();
        double a = line.getA();
        double b = line.getB();
        double c = line.getC();
        double distance = (a * x + b * y + c) / Math.hypot(a, b);
        return distance < -eps ? -1 : distance > eps ? 1 : 0;
    }

    public static Point getIntersectionPoint(StandardFormLine line1, StandardFormLine line2) {
        double determinant = line1.getA() * line2.getB() - line2.getA() * line1.getB();
        if (determinant == 0) {
            throw new IllegalArgumentException("The lines are parallel or coincident.");
        }
        double x = (line1.getB() * line2.getC() - line2.getB() * line1.getC()) / determinant;
        double y = (line2.getA() * line1.getC() - line1.getA() * line2.getC()) / determinant;
        return new Point(x, y);
    }

    public static boolean isTwoPointOnTheSameSideOfLine(StandardFormLine line, Point pointA, Point pointB, double eps) {
        return (Lines.onRightSideOfTheLine(line, pointA, eps) > 0  &&
                Lines.onRightSideOfTheLine(line, pointB, eps) > 0) ||
               (Lines.onRightSideOfTheLine(line, pointA, eps) < 0  &&
                Lines.onRightSideOfTheLine(line, pointB, eps) < 0);
    }



    //    public Point intersection(Line other) {
//
//        if (isLinesCoincides(other) || isLinesIntersects(other)) {
//            return null;
//        }
//
//        double x = (other.b - b) / (k - other.k);
//        double y = (k * other.b - other.k * b) / (k - other.k);
//
//        return new Point(x, y);
//    }
//
//    private boolean isLinesIntersects (Line other) {
//        return k == other.k;
//    }
//
//    private boolean isLinesCoincides (Line other) {
//        return k == other.k && b == other.b;
//    }


}
