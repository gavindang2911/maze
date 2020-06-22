package com.cmpt213.Logic;

public class Map {
    private int height;
    private int width;
    private final String wall = "#";
    private String fullMaze[][];
    private String gameMaze[][];

    public Map(int height, int width) {
        this.height = height;
        this.width = width;
        this.fullMaze = new String[height][width];
        this.gameMaze = new String[height][width];
    }

    public void initGrid() {
        MazeGenerator maze = new MazeGenerator(height, width);
        String[][] actualMaze = maze.getFullMaze();
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                this.fullMaze[i][j] = actualMaze[i][j];
            }
        }
    }



    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public boolean isCurrentWall(Cell current) {
        return fullMaze[current.getX()][current.getY()].equals(wall);
    }

    public String[][] getFullMaze() {
        return fullMaze;
    }
}
