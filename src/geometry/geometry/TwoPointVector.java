package geometry.geometry;


public class TwoPointVector {
    private final Point start;
    private final Point end;
    private Direction direction;

    public TwoPointVector(Point start, Point end) {
        if (start == null || end == null) throw new IllegalArgumentException();
        this.start = start;
        this.end = end;
        if (start.equals(end)) throw new IllegalArgumentException();
        initDirection(start, end);

    }

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    public Direction getDirection() {
        return direction;
    }
    private void initDirection(Point start, Point end) {
        if (start.getX() == end.getX() && start.getY() < end.getY()) direction = Direction.N;
        if (start.getX() == end.getX() && start.getY() > end.getY()) direction = Direction.S;
        if (start.getY() == end.getY() && start.getX() < end.getX()) direction = Direction.E;
        if (start.getY() == end.getY() && start.getX() > end.getX()) direction = Direction.W;

        if (start.getX() < end.getX() && start.getY() < end.getY()) direction = Direction.NE;
        if (start.getX() > end.getX() && start.getY() < end.getY()) direction = Direction.NW;
        if (start.getX() > end.getX() && start.getY() > end.getY()) direction = Direction.SW;
        if (start.getX() < end.getX() && start.getY() > end.getY()) direction = Direction.SE;
    }

    public enum Direction {N, W, E, S, NW, NE, SW, SE}

}
