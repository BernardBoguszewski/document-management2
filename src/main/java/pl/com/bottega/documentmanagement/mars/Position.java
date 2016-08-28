package pl.com.bottega.documentmanagement.mars;

/**
 * Created by bernard.boguszewski on 28.08.2016.
 */
public class Position {

    private int x, y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void addX(){
        this.x += 1;
    }

    public void minusX(){
        this.x -= 1;
    }

    public void addY(){
        this.y += 1;
    }

    public void minusY(){
        this.y -= 1;
    }

    public int x(){
        return x;
    }

    public int y(){
        return y;
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
