package com.cmpt213.Logic;

public class Map {
    private final int height;
    private final int width;
    private final String[][] fullMaze;

    public Map(int height, int width) {
        this.height = height;
        this.width = width;
        this.fullMaze = new String[height][width];
    }

    public void initGrid() {
        MazeGenerator maze = new MazeGenerator(height, width);
        String[][] actualMaze = maze.getFullMaze();
        for (int i = 0; i < height; ++i) {
            if (width >= 0) {
                System.arraycopy(actualMaze[i], 0, this.fullMaze[i], 0, width);
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public boolean isCurrentWall(Cell current) {
        String wall = "#";
        return fullMaze[current.getX()][current.getY()].equals(wall);
    }

    public String[][] getFullMaze() {
        return fullMaze;
    }
}
