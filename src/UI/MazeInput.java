package UI;

import Logic.Cell;
import Logic.MazeGenerator;

import java.util.Scanner;

public class MazeInput {
    private static MazeGenerator mazeBoard;
    private static Cell current;

    public MazeInput(MazeGenerator mazeBoard, Cell cell) {
        this.mazeBoard = mazeBoard;
        this.current = cell;
    }

    public void key() {
        displayHiddenMaze();
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
                displayMaze();
                break;

        }
    }


    public static void displayMaze() {
        for (int i = 0; i < mazeBoard.getHeight(); i++) {
            for (int j = 0; j < mazeBoard.getWidth(); j++) {
                System.out.print(mazeBoard.getMaze()[i][j].getActualSymbol());
            }
            System.out.println();
        }
    }

    public static void displayHiddenMaze() {
        for (int i = 0; i < mazeBoard.getHeight(); i++) {
            for (int j = 0; j < mazeBoard.getWidth(); j++) {
                if ((i == current.getX() + 1 && j == current.getY() - 1) || (i == current.getX() + 1 && j == current.getY()) || (i == current.getX() + 1 && j == current.getY() + 1) ||
                        (i == current.getX() && j == current.getY() - 1) || (i == current.getX() && j == current.getY()) || (i == current.getX() && j == current.getY() + 1) ||
                        (i == current.getX() - 1 && j == current.getY() - 1) || (i == current.getX() - 1 && j == current.getY()) || (i == current.getX() - 1 && j == current.getY() + 1)) {
                    mazeBoard.getMaze()[i][j].setDotSymbol(mazeBoard.getMaze()[i][j].getActualSymbol());
                }
                System.out.print(mazeBoard.getMaze()[i][j].getDotSymbol());
            }
            System.out.println();
        }
    }
}
