package sammygraphics;

import java.util.Vector;

public class SGScene {
    protected Vector<SGShape> shapes;

    public SGScene() {
        shapes = new Vector<SGShape>();
    }

    public void add(SGShape shape) {
        shapes.add(shape);
    }

    public SGSurface intersect(SGRay r) {
        double min_t = Double.POSITIVE_INFINITY;
        SGShape min_s = null;

        for (SGShape s : shapes) {
            double t = s.intersect(r);
            if (t > 0 && t < min_t) {
                min_t = t;
                min_s = s;
            }
        }

        return min_s == null ? null : min_s.getSurface();
    }
}
