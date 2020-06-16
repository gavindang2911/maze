package com.cmpt213.assignment2;

import java.util.ArrayList;

public class Grid {
    private int xHeight;
    private int yHeight;
    private String fullMaze[][];
    private String gameMaze[][];
    private Symbol gameSymbol;


    public Grid(int xHeight, int yHeight) {
        this.xHeight = xHeight;
        this.yHeight = yHeight;
        this.fullMaze = new String[xHeight][yHeight];
        this.gameMaze = new String[xHeight][yHeight];
        this.gameSymbol = new Symbol();

    }

    public void initGrid() {
        int x, y;
        if (xHeight % 2 == 0) {
            x = (xHeight - 1) / 2;
        } else {
            x = xHeight / 2;
        }
        if (yHeight % 2 == 0) {
            y = (yHeight - 1) / 2;
        } else {
            y = yHeight / 2;
        }

        Maze maze = new Maze(x, y);
        maze.generateMaze();
        maze.displayMaze();
        String[][] actualMaze = maze.getActualMaze();
        for (int i = 0; i < xHeight; ++i) {
            for (int j = 0; j < yHeight; ++j) {
                this.fullMaze[i][j] = actualMaze[i][j];
            }
        }
    }

    public int getXHeight() {
        return xHeight;
    }

    public int getYHeight() {
        return yHeight;
    }

    public void initPartial() {
        for (int i = 1; i < yHeight - 2; ++i) {
            gameMaze[0][i] = gameSymbol.getWallSymbol();
        }
        for (int i = 1; i < yHeight - 2; ++i) {
            gameMaze[14][i] = gameSymbol.getWallSymbol();
        }
        for (int i = 0; i < xHeight; ++i) {
            gameMaze[i][0] = gameSymbol.getWallSymbol();
        }
        for (int i = 0; i < yHeight; ++i) {
            gameMaze[i][19] = gameSymbol.getWallSymbol();
        }
        for (int i = 1; i < xHeight - 1; ++i) {
            for (int j = 1; j < yHeight - 1; ++j) {
                gameMaze[i][j] = gameSymbol.getSpaceSymbol();
            }
        }
    }

    public void drawMonster(ArrayList<Position> positions) {
        for (Position position : positions) {
            gameMaze[position.getX()][position.getY()] = gameSymbol.getMonsterSymbol();
        }
    }

    public void drawHero(Position position) {
        gameMaze[position.getX() - 1][position.getY()] = fullMaze[position.getX() - 1][position.getY()];
        gameMaze[position.getX() + 1][position.getY()] = fullMaze[position.getX() + 1][position.getY()];
        gameMaze[position.getX()][position.getY() + 1] = fullMaze[position.getX()][position.getY() + 1];
        gameMaze[position.getX()][position.getY() - 1] = fullMaze[position.getX()][position.getY() - 1];
        gameMaze[position.getX() - 1][position.getY() - 1] = fullMaze[position.getX() - 1][position.getY() - 1];
        gameMaze[position.getX() - 1][position.getY() + 1] = fullMaze[position.getX() - 1][position.getY() + 1];
        gameMaze[position.getX() + 1][position.getY() - 1] = fullMaze[position.getX() + 1][position.getY() - 1];
        gameMaze[position.getX() + 1][position.getY() + 1] = fullMaze[position.getX() + 1][position.getY() + 1];
        gameMaze[position.getX()][position.getY()] = gameSymbol.getHeroSymbol();
    }

    public void drawPower(ArrayList<Position> positions) {
        gameMaze[positions.get(0).getX()][positions.get(0).getY()] = gameSymbol.getPowerSymbol();
    }

    public void drawGame(GamePlay game) {
        drawHero(game.getHero().getPosition());
        drawMonster(game.getMonster().getMonsterPosition());
        drawPower(game.getPower().getPowerPosition());
        for (int i = 0; i < xHeight; ++i) {
            for (int j = 0; j < yHeight; ++i) {
                System.out.print(gameMaze[i][j]);
            }
            System.out.println();
        }
    }

    public ArrayList<Position> getPossibleMove(Position current) {
        ArrayList<Position> listOfMove = new ArrayList<>();
        int currentX = current.getX();
        int currentY = current.getY();
        if (fullMaze[currentX - 1][currentY] == " ") {
            Position up = new Position(currentX - 1, currentY);
            listOfMove.add(up);
        }
            if (fullMaze[currentX + 1][currentY] == " ") {
                Position down = new Position(currentX + 1, currentY);
                listOfMove.add(down);
            }
            if (fullMaze[currentX][currentY - 1] == " ") {
                Position left = new Position(currentX, currentY - 1);
                listOfMove.add(left);
            }
            if (fullMaze[currentX][currentY + 1] == " ") {
                Position right = new Position(currentX, currentY + 1);
                listOfMove.add(right);
            }
            return listOfMove;

    }



    public boolean isCurrentWall(Position current) {
        return fullMaze[current.getX()][current.getY()].equals(gameSymbol.getWallSymbol());
    }

    public ArrayList<Position> getWall(Position current) {
        ArrayList<Position> walls = new ArrayList<>();
        int currentX = current.getX();
        int currentY = current.getY();
        if (fullMaze[currentX - 1][currentY].equals(gameSymbol.getWallSymbol())) {
            Position upperWall = new Position(currentX - 1, currentY);
            walls.add(upperWall);
        }
        if (fullMaze[currentX + 1][currentY].equals(gameSymbol.getWallSymbol())) {
            Position lowerWall = new Position(currentX + 1, currentY);
            walls.add(lowerWall);
        }
        if (fullMaze[currentX][currentY + 1].equals(gameSymbol.getWallSymbol())) {
            Position rightWall = new Position(currentX, currentY + 1);
            walls.add(rightWall);
        }
        if (fullMaze[currentX][currentY - 1].equals(gameSymbol.getWallSymbol())) {
            Position leftWall = new Position(currentX, currentY - 1);
            walls.add(leftWall);
        }
        return walls;
    }

    public static void main(String[] args) {
        final int height = 15;
        final int width = 20;

        Grid grid = new Grid(height, width);
        grid.initGrid();

    }
}
