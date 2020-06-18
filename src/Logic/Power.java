package Logic;

import java.util.Random;

public class Power {
    private Cell currentPosition;
    private Cell nextMove;
    private String powerString;

    public Power(String powerString) {
        this.powerString = powerString;
    }

    public Cell getCurrentPosition() {
        return currentPosition;
    }

    public Cell getNextMove() {
        return nextMove;
    }

    public String getPowerString() {
        return powerString;
    }

    public void randomPlacePowerFirstTime(MazeGenerator maze) {
        Random random = new Random();

        int row;
        int col;
        do{
            row = random.nextInt(maze.getHeight() - 2) + 1;
            col = random.nextInt(maze.getWidth() - 2) + 1;

        } while((row == 1 && col == 1) || (row == 1 && col == maze.getWidth()-2) || (row == 1 && col == maze.getWidth()-2) || (row == maze.getHeight()-2 && col == maze.getWidth()-2) ||
                maze.getMaze()[row][col].getActualSymbol() == "@" || maze.getMaze()[row][col].getActualSymbol() == "#");

        currentPosition = maze.getMaze()[row][col];

        maze.getMaze()[row][col].setActualSymbol(powerString);
        maze.getMaze()[row][col].setDotSymbol(powerString);
    }

    public void randomPlacePower(MazeGenerator maze) {
        Random random = new Random();

        int row;
        int col;
        do{
            row = random.nextInt(maze.getHeight() - 2) + 1;
            col = random.nextInt(maze.getWidth() - 2) + 1;

        } while((row == 1 && col == 1) || (row == 1 && col == maze.getWidth()-2) || (row == 1 && col == maze.getWidth()-2) || (row == maze.getHeight()-2 && col == maze.getWidth()-2) ||
                maze.getMaze()[row][col].getActualSymbol() == "@" || maze.getMaze()[row][col].getActualSymbol() == "#");

        currentPosition = maze.getMaze()[row][col];

        maze.getMaze()[row][col].setActualSymbol(powerString);
//        maze.getMaze()[row][col].setDotSymbol(powerString);
    }
}
