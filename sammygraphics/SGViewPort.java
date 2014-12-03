package sammygraphics;

public class SGViewPort {
    protected int width;
    protected int height;
    protected SGPoint3 ul;
    protected SGPoint3 br;

    public SGViewPort(int width, int height, SGPoint3 ul, SGPoint3 br) {
        this.width = width;
        this.height = height;
        this.ul = ul;
        this.br = br;
    }

    public int width() {
        return width;
    }

    public int height() {
        return height;
    }

    public SGPoint3 pos(int i, int j) {
        return null;
    }
}
