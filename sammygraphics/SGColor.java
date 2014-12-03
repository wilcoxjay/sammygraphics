package sammygraphics;

public class SGColor {
    protected float r;
    protected float g;
    protected float b;

    public static final SGColor BLACK = new SGColor(0, 0, 0);

    public SGColor(float r, float g, float b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }
}
