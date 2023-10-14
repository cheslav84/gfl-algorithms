package geometry.geometry.util;


import geometry.geometry.*;


public class Segments {

    public static double length(Segment s) {
        return Math.hypot(s.getStart().getX() - s.getEnd().getX(), s.getStart().getY() - s.getEnd().getY());
    }


    public static double getDistance(Segment segmentAB, Segment segmentCD, double eps) {
        double fromABtoStartAnother = getDistance(segmentAB, segmentCD.getStart(), eps);
        double fromABtoEndAnother = getDistance(segmentAB, segmentCD.getEnd(), eps);
        double fromCDtoStartAnother = getDistance(segmentCD, segmentAB.getStart(), eps);
        double fromCDtoEndAnother = getDistance(segmentCD, segmentAB.getEnd(), eps);

        double fromABtoCD = Math.min(fromABtoStartAnother, fromABtoEndAnother);
        double fromCDtoAB = Math.min(fromCDtoStartAnother, fromCDtoEndAnother);

        return Math.min(fromABtoCD, fromCDtoAB);

    }





    public static double getDistance(Segment segment, Point point, double eps) {
        StandardFormLine line = Lines.toStandardFormLine(segment);
        double a = line.getB();
        double b = -line.getA();
        double c = -(a * point.getX() + b * point.getY());
        NormalVector normal = new NormalVector(point, a, b, c);
        Point intersectionPoint = Lines.getIntersectionPoint(line, normal.getLine());
        if (belongsToSegment(segment, intersectionPoint, eps)) {
            return Lines.distanceToLine(line, point);
        } else {
            return Points.getDistanceToNearestPoint(segment.getStart(), segment.getEnd(), point);
        }
    }

    public static boolean belongsToSegment(Segment segment, Point point, double eps) {
        StandardFormLine line = Lines.toStandardFormLine(segment);
        boolean belongsToLine = Lines.belongsToLine(line, point, eps);
        boolean pointInBounds = Points.isPointInBounds(segment.getStart(), segment.getEnd(), point, eps);
        return belongsToLine && pointInBounds;
    }

    public static boolean isCrossed (Segment segmentAB, Segment segmentCD, double eps) {
        StandardFormLine lineAB;
        StandardFormLine lineCD;
        try {
            lineAB = Lines.toStandardFormLine(segmentAB);
            lineCD = Lines.toStandardFormLine(segmentCD);
        } catch (IllegalArgumentException e) {
            return true;
        }

        boolean anySegmentPartBelongsAnother = isAnySegmentPartBelongsAnother(segmentAB, segmentCD, eps);
        if (isLinesParallel(lineAB, lineCD) && !anySegmentPartBelongsAnother) {
            return false;
        }

        boolean abCrossedLine = !Lines.isTwoPointOnTheSameSideOfLine(lineAB, segmentCD.getStart(), segmentCD.getEnd(), eps);
        boolean cdCrossedLine = !Lines.isTwoPointOnTheSameSideOfLine(lineCD, segmentAB.getStart(), segmentAB.getEnd(), eps);


        if (abCrossedLine && cdCrossedLine && onTheSameLine(lineAB, lineCD)) {
            return anySegmentPartBelongsAnother;
        }
        return (abCrossedLine && cdCrossedLine);
    }

    private static boolean onTheSameLine(StandardFormLine lineAB, StandardFormLine lineCD) {
        return lineAB.getA() == lineCD.getA() && lineAB.getB() == lineCD.getB() && lineAB.getC() == lineCD.getC();
    }

    private static boolean isLinesParallel(StandardFormLine lineAB, StandardFormLine lineCD) {
        SlopeInterceptFormLine lineABsi;
        SlopeInterceptFormLine lineCDsi;
        if (lineAB.getB() != 0 && lineCD.getB() != 0) {
            lineABsi = Lines.toSlopeInterceptForm(lineAB);
            lineCDsi = Lines.toSlopeInterceptForm(lineCD);
            if (lineABsi.getK() == lineCDsi.getK()) {
                return true;
            }
        }
        return false;
    }

    private static boolean isAnySegmentPartBelongsAnother(Segment segmentAB, Segment segmentCD, double eps) {
        return Segments.belongsToSegment(segmentAB, segmentCD.getStart(), eps) ||
                Segments.belongsToSegment(segmentAB, segmentCD.getEnd(), eps);

    }







//    private static double getDenominator (Segment segmentAB, Segment segmentCD) {
//        return (segmentAB.getStart().getX() - segmentAB.getEnd().getX()) *
//               (segmentCD.getStart().getY() - segmentCD.getEnd().getY()) -
//               (segmentAB.getStart().getY() - segmentAB.getEnd().getY()) *
//               (segmentCD.getStart().getX() - segmentCD.getEnd().getX());
//
//    }


    //    double length() {
//        return sqrt(pow((end.getX() - start.getX()), 2) + pow((end.getY() - start.getY()), 2));
//    }

//    Point middle() {
//        double x = (start.getX() + end.getX()) / 2;
//        double y = (start.getY() + end.getY()) / 2;
//        return new Point(x, y);
//    }

//    Point intersection(Segment another) {
//
//        double x1 = start.getX();
//        double y1 = start.getY();
//
//        double x2 = end.getX();
//        double y2 = end.getY();
//
//        double x3 = another.start.getX();
//        double y3 = another.start.getY();
//
//        double x4 = another.end.getX();
//        double y4 = another.end.getY();
//
//        Point intersectionPoint = null;
//
//        double denominator = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);
//
//        if (denominator != 0) {
//            double t = ((x1 - x3) * (y3 - y4) - (y1 - y3) * (x3 - x4)) / denominator;
//            double u = ((x1 - x3) * (y1 - y2) - (y1 - y3) * (x1 - x2)) / denominator;
//
//            if (isIntPointLaysOnSegments(t, u)) {
//                double x = x1 + t * (x2 - x1);
//                double y = y1 + t * (y2 - y1);
//                intersectionPoint = new Point(x, y);
//            }
//        }
//        return intersectionPoint;
//    }
}
