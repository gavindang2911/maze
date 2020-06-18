package UI;

import Logic.Cell;
import Logic.MazeGenerator;

import java.util.Scanner;

public class MazeInput {
    private static final String[] KEYS = {"UP", "LEFT", "DOWN", "RIGHT", "?", "M", "c"};
    private MazeGenerator mazeBoard;
    private Cell current;

    public MazeInput(MazeGenerator mazeBoard, Cell cell) {
        this.mazeBoard = mazeBoard;
        this.current = cell;
    }

    public void key() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your move [WASD?]: ");
        String nextMove = input.nextLine();
        nextMove = nextMove.toLowerCase();

        int x = current.getX();
        int y = current.getY();

        switch (nextMove) {
            case "c":
                
        }
    }
}
