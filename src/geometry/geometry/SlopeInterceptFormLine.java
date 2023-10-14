package geometry.geometry;

public class SlopeInterceptFormLine {
    private double k;
    private double b;

    public SlopeInterceptFormLine(double k, double b) {
        this.k = k;
        this.b = b;
    }

    public double getK() {
        return k;
    }

    public double getB() {
        return b;
    }

    @Override
    public String toString() {
        String bSign = (b > 0) ? (" + " + b) : (b < 0) ? (" - " + b) : "";
        return (k == 0) ? ("y = 0") : (k == Double.MAX_VALUE) ? "x = 0" : ("y = " + k + "x" + bSign);
    }
}
