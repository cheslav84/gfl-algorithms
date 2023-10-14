package geometry.geometry;


public class TwoPointsLine {
    private final Point a;
    private final Point b;

    public TwoPointsLine(Point a, Point b) {
        this.a = a;
        this.b = b;
    }

    public Point getA() {
        return a;
    }

    public Point getB() {
        return b;
    }
}
