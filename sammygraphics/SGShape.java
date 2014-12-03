package sammygraphics;

public abstract class SGShape {

    public abstract SGSurface getSurface();

    public abstract double intersect(SGRay r);
}

