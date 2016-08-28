package pl.com.bottega.documentmanagement.mars;



/**
 * Created by bernard.boguszewski on 28.08.2016.
 */
public class MarsRover {



    public MarsRover() {
    }

    public void move(Position position, Rotation rotation){
        switch(rotation.direction){
            case N:
                position.addY();
                break;
            case NW:
                position.addX();
                position.addY();
                break;
            case W:
                position.addX();
                break;
            case SW:
                position.addX();
                position.minusY();
                break;
            case S:
                position.minusY();
                break;
            case SE:
                position.minusX();
                position.minusY();
                break;
            case E:
                position.minusX();
                break;
            case NE:
                position.addY();
                position.minusX();
                break;
        }
    }

    public void rotateRight(Rotation rotation){
        switch (rotation.direction){
            case N:
                rotation.changeToNorthWest();
                break;
            case NW:
                rotation.changeToWest();
                break;
            case W:
                rotation.changeToSouthWest();
                break;
            case SW:
                rotation.changeToSouth();
                break;
            case S:
                rotation.changeToSouthEast();
                break;
            case SE:
                rotation.changeToEast();
                break;
            case E:
                rotation.changeToNorthEast();
                break;
            case NE:
                rotation.changeToNorth();
                break;
        }
    }

    public void rotateLeft(Rotation rotation){
        switch (rotation.direction){
            case N:
                rotation.changeToNorthEast();
                break;
            case NW:
                rotation.changeToNorth();
                break;
            case W:
                rotation.changeToNorthWest();
                break;
            case SW:
                rotation.changeToWest();
                break;
            case S:
                rotation.changeToSouthWest();
                break;
            case SE:
                rotation.changeToSouth();
                break;
            case E:
                rotation.changeToSouthEast();
                break;
            case NE:
                rotation.changeToEast();
                break;
        }
    }

    public Position position(){
        return null;
    }

}
