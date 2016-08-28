package pl.com.bottega.documentmanagement.mars;

/**
 * Created by bernard.boguszewski on 28.08.2016.
 */
public class Rotation {

    Direction direction;

    public Rotation(Direction position) {
        this.direction = position;
    }

    public Direction direction() {
        return direction;
    }

    public void changeToSouth(){
        direction = Direction.S;
    }

    public void changeToSouthEast(){
        direction = Direction.SE;
    }

    public void changeToNorthEast(){
        direction = Direction.NE;
    }

    public void changeToEast(){
        direction = Direction.E;
    }

    public void changeToNorthWest(){
        direction = Direction.NW;
    }

    public void changeToSouthWest(){
        direction = Direction.SW;
    }

    public void changeToWest(){
        direction = Direction.W;
    }

    public void changeToNorth(){
        direction = Direction.N;
    }


}
