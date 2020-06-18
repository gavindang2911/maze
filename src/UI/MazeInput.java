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
        displayHiddenMaze(current, mazeBoard);
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your move [WASD?]: ");
        String nextMove = input.nextLine();
        nextMove = nextMove.toLowerCase();

        int x = current.getX();
        int y = current.getY();

        switch (nextMove) {
            case "c":
                break;
            case "m":

        }
    }
    public static void displayMaze(MazeGenerator maze) {
        for (int i = 0; i < maze.getHeight(); i++) {
            for (int j = 0; j < maze.getWidth(); j++) {
                System.out.print(maze.getMaze()[i][j].getActualSymbol());
            }
            System.out.println();
        }
    }

    public static void displayHiddenMaze(Cell current, MazeGenerator maze) {
        for (int i = 0; i < maze.getHeight(); i++) {
            for (int j = 0; j < maze.getWidth(); j++) {
                if ((i == current.getX() + 1 && j == current.getY() - 1) || (i == current.getX() + 1 && j == current.getY()) || (i == current.getX() + 1 && j == current.getY() + 1) ||
                        (i == current.getX() && j == current.getY() - 1) || (i == current.getX() && j == current.getY()) || (i == current.getX() && j == current.getY() + 1) ||
                        (i == current.getX() - 1 && j == current.getY() - 1) || (i == current.getX() - 1 && j == current.getY()) || (i == current.getX() - 1 && j == current.getY() + 1)) {
                    maze.getMaze()[i][j].setDotSymbol(maze.getMaze()[i][j].getActualSymbol());
                }
                System.out.print(maze.getMaze()[i][j].getDotSymbol());
            }
            System.out.println();
        }
    }
}
