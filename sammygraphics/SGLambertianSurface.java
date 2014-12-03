package sammygraphics;

public class SGLambertianSurface extends SGSurface {
    protected SGColor color;
    protected SGVector3 normal;

    public SGLambertianSurface(SGVector3 normal, SGColor color) {
        this.normal = normal;
        this.color = color;
    }

    public SGColor shade(SGVector3 omega_out) {
        return SGColor.BLACK;
    }
}
