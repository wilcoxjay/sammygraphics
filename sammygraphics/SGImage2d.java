package sammygraphics;

public class SGImage2d {
    protected SGColor[][] data;

    public SGImage2d(int width, int height) {
        if (width < 1 || height < 1) {
            throw new IllegalArgumentException("width and height must be at least 1");
        }
        data = new SGColor[width][height];
    }

    public int width() {
        return data.length;
    }
    
    public int height() {
        return data[0].length;
    }

    public void add(int i, int j, SGColor c) {
        
    }
}
