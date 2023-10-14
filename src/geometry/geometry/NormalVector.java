package geometry.geometry;


public class NormalVector {
    private Point start;
    private StandardFormLine line;


    public NormalVector(Point start, double a, double b, double c) {
        line = new StandardFormLine(a, b, c);
        this.start = start;
    }

    public Point getStart() {
        return start;
    }

    public StandardFormLine getLine() {
        return line;
    }
}
