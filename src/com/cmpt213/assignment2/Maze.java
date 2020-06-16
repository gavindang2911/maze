package com.cmpt213.assignment2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Maze {
    private final int x;
    private final int y;
    private final int height = 15;
    private final int width = 20;
    private final Cell[][] mazeArray;
    private final String[][] actualMaze;


    public Maze(int x, int y) {
        this.x = x;
        this.y = y;
        this.mazeArray = new Cell[x][y];
        this.actualMaze = new String[height][width];

    }

    public ArrayList<Cell> getNeighbors(int currentX, int currentY) {
        ArrayList<Cell> neighbors = new ArrayList<>();
        if (currentY - 1 >= 0) {
            Cell leftCell = new Cell(currentX, currentY - 1, "l");
            neighbors.add(leftCell);
        }
        if (currentY + 1 < y) {
            Cell rightCell = new Cell(currentX, currentY + 1, "r");
            neighbors.add(rightCell);
        }
        if (currentX - 1 >= 0 ) {
            Cell upCell = new Cell(currentX - 1, currentY, "u");
            neighbors.add(upCell);
        }
        if (currentX + 1 < x) {
            Cell downCell = new Cell(currentX + 1, currentY, "d");
            neighbors.add(downCell);
        }
        return neighbors;
    }

    public void displayMaze() {
        Symbol gameSymbol = new Symbol();
        for (int i = 0; i < x; i++) {
            // draw the north edge
            for (int j = 0; j < y; j++) {
                if (mazeArray[i][j].getDirections().get("U") == 0) {
                    actualMaze[i * 2][j * 2] = gameSymbol.getWallSymbol();
                    actualMaze[i * 2][j * 2 + 1] = gameSymbol.getWallSymbol();
                } else {
                    actualMaze[i * 2][j * 2] = gameSymbol.getWallSymbol();
                    actualMaze[i * 2][j * 2 + 1] = gameSymbol.getSpaceSymbol();
                }
            }
            actualMaze[i * 2][y * 2] = gameSymbol.getWallSymbol();

            // draw the west edge
            for (int j = 0; j < y; j++) {
                if (mazeArray[i][j].getDirections().get("L") == 0) {
                    actualMaze[i * 2 + 1][j * 2] = gameSymbol.getWallSymbol();
                } else {
                    actualMaze[i * 2 + 1][j * 2] = gameSymbol.getSpaceSymbol();
                }
                actualMaze[i * 2 + 1][j * 2 + 1] = gameSymbol.getSpaceSymbol();
            }
            actualMaze[i * 2 + 1][y * 2] = gameSymbol.getWallSymbol();
        }
        // draw the bottom line
        for (int j = 0; j < y; j++) {
            actualMaze[x * 2][j * 2] = gameSymbol.getWallSymbol();
            actualMaze[x * 2][j * 2 + 1] = gameSymbol.getWallSymbol();
        }
        actualMaze[x * 2][y * 2] = gameSymbol.getWallSymbol();

        // fill walls into all the cells left
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                if (actualMaze[i][j] == null) {
                    actualMaze[i][j] = gameSymbol.getWallSymbol();
                }
            }
        }

        if (width % 2 == 0) {
            for (int i = 0; i < height; ++i) {
                if (i % 2 == 1) {
                    actualMaze[i][width - 2] = gameSymbol.getSpaceSymbol();
                }
            }
        }

        if (height % 2 == 0) {
            for (int i = 0; i < width; ++i) {
                if (i % 2 == 1) {
                    actualMaze[height - 2][i] = gameSymbol.getSpaceSymbol();
                }
            }
        }

        for (int i = 1; i < height - 1; ++i) {
            for (int j = 1; j < width - 1; ++j) {
                if (actualMaze[i][j - 1].equals(gameSymbol.getWallSymbol()) && actualMaze[i][j + 1].equals(gameSymbol.getWallSymbol())) {
                    actualMaze[i][j] = gameSymbol.getSpaceSymbol();
                }
            }
        }

        //print maze to screen
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                System.out.print(actualMaze[i][j]);
            }
            System.out.println();
        }

    }

    public String[][] getActualMaze() {
        return actualMaze;
    }
    public void generateMaze() {
        Stack<Cell> cellStack = new Stack<>();
        Cell beginCell = new Cell(0, 0, "");
        cellStack.push(beginCell);
        while (!cellStack.isEmpty()) {
            Cell currentCell = cellStack.pop();
            ArrayList<Cell> neighbors = new ArrayList<>(getNeighbors(currentCell.getXIndex(), currentCell.getYIndex()));
            Collections.shuffle(neighbors);
            for (Cell cell : neighbors) {
                int cellX = cell.getXIndex();
                int cellY = cell.getYIndex();
                if (mazeArray[cellX][cellY] == null) {
                    mazeArray[cellX][cellY] = new Cell(cellX, cellY, "");
                    if (mazeArray[currentCell.getXIndex()][currentCell.getYIndex()]  == null) {
                        mazeArray[currentCell.getXIndex()][currentCell.getYIndex()] = new Cell(currentCell.getXIndex(),
                                currentCell.getYIndex(), "");
                    }
                    cellStack.push(currentCell);
                    String direction = cell.getCellType();
                    switch (direction) {
                        case "l" -> {
                            mazeArray[currentCell.getXIndex()][currentCell.getYIndex()].updateDirection("l");
                            mazeArray[cellX][cellY].updateDirection("r");
                        }
                        case "r" -> {
                            mazeArray[currentCell.getXIndex()][currentCell.getYIndex()].updateDirection("r");
                            mazeArray[cellX][cellY].updateDirection("l");
                        }
                        case "u" -> {
                            mazeArray[currentCell.getXIndex()][currentCell.getYIndex()].updateDirection("u");
                            mazeArray[cellX][cellY].updateDirection("d");
                        }
                        default -> {
                            mazeArray[currentCell.getXIndex()][currentCell.getYIndex()].updateDirection("d");
                            mazeArray[cellX][cellY].updateDirection("u");
                        }
                    }
                    cellStack.push(cell);
                    break;
                }
            }
        }

    }

}
