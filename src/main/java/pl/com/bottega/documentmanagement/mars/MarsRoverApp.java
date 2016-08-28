package pl.com.bottega.documentmanagement.mars;

import java.util.Scanner;

/**
 * Created by bernard.boguszewski on 28.08.2016.
 */
public class MarsRoverApp {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        MarsRover marsRover = new MarsRover();
        Position position = new Position(10, 10);
        Rotation rotation = new Rotation(Direction.W);

        while (true){
            System.out.println("Enter command: (m, rl, rr): ");
            String cmd = getCommand();
            if (cmd.equals("quit"))
                return;
            if(cmd.equals("m"))
                marsRover.move(position, rotation);
            if(cmd.equals("rl"))
                marsRover.rotateLeft(rotation);
            if(cmd.equals("rr"))
                marsRover.rotateRight(rotation);
            System.out.println(position);
        }
    }

    public static String getCommand(){
        return scanner.nextLine();
    }
}
