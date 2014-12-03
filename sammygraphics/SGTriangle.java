package sammygraphics;

public class SGTriangle extends SGShape {
    protected SGPoint3 base;
    protected SGVector3 u;
    protected SGVector3 v;

    protected SGColor color;

    public SGSurface getSurface() {
        return new SGLambertianSurface(normal(), color);
    }

    public SGVector3 normal() {
        return u.cross(v);
    }

    public double intersect(SGRay r) {
        return -1.0;
    }
}
