import java.awt.*;

public class AStarStruct {
    private int x =0;
    private int y=0;
    private Point ParentPoint=null;
    private int f=0;
    private int h=0;
    private int g=0;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Point getParentPoint() {
        return ParentPoint;
    }

    public void setParentPoint(Point parentPoint) {
        ParentPoint = parentPoint;
    }

    public int getF() {
        return f;
    }

    public void setF(int f) {
        this.f = f;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    @Override
    public String toString() {
        return "AStarStruct{" +
                "x=" + x +
                ", y=" + y +
                ", ParentPoint=" + ParentPoint +
                ", f=" + f +
                ", h=" + h +
                ", g=" + g +
                '}';
    }
}
