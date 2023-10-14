package geometry.geometry;

public class Segment {
    private Point start;
    private Point end;

    public Segment(Point start, Point end) {
        if (start == null || end == null) throw new IllegalArgumentException();
        this.start = start;
        this.end = end;
        if (start.equals(end)) throw new IllegalArgumentException();
    }

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }
}
