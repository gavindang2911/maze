package com.cmpt213.assignment2;

import java.util.Random;
import java.util.Stack;

/*public class RandomMaze {
    private final int x;
    private final int y;
    private String[][] mazeArray;

    public RandomMaze(int x, int y) {
        this.x = x;
        this.y = y;
        this.mazeArray = new String[x][y];
    }

    private static class Cell {
        private final int xIndex;
        private final int yIndex;
        private final int xIndexOpposite;
        private final int yIndexOpposite;

        public Cell (int xIndex, int yIndex, int xIndexOpposite, int yIndexOpposite) {
            this.xIndex = xIndex;
            this.yIndex = yIndex;
            this.xIndexOpposite = xIndexOpposite;
            this.yIndexOpposite = yIndexOpposite;

        }

        public int getXIndex() {
            return xIndex;
        }
        public int getYIndex() {
            return yIndex;
        }
        public int getxIndexOpposite() { return xIndexOpposite; }
        public int getyIndexOpposite() { return yIndexOpposite; }

    }

    public void generateMaze() {
        Stack<Cell> cellStack = new Stack<>();
        Random randomInt = new Random();
        Cell beginCell = new Cell();

        cellStack.push(beginCell);

        while (!cellStack.isEmpty()) {
            Cell currentCell = cellStack.pop();
            for (int i = 0; i < x; ++i) {
                if (mazeArray[i][currentCell.getYIndex()] == null) {
                    mazeArray[i][currentCell.getYIndex()] = "#";
                }
            }
            for (int i = 0; i < y; ++i) {
                if (mazeArray[currentCell.getXIndex()][i] == null) {
                    mazeArray[currentCell.getXIndex()][i] = "#";
                }
            }
            Cell removeWall1 = new Cell(randomInt.nextInt());
        }


    }

    public void displayMaze() {

    }

    public static void main(String[] args) {


    }
}*/
