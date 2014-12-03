package sammygraphics;

public class SGPoint3 {
    protected double x;
    protected double y;
    protected double z;

    public SGPoint3(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double x() {
        return x;
    }

    public double y() {
        return y;
    }

    public double z() {
        return z;
    }
}
