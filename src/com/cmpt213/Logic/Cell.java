package com.cmpt213.Logic;

public class Cell {
    private int x; // X coordinate
    private int y; // Y coordinate
    private String dotSymbol;
    private String actualSymbol;
    private final CellManager neighboursOfCell = new CellManager();

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getDotSymbol() {
        return dotSymbol;
    }

    public String getActualSymbol() {
        return actualSymbol;
    }

    public CellManager getNeighboursOfCell() {
        return neighboursOfCell;
    }


    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setActualSymbol(String actualSymbol) {
        this.actualSymbol = actualSymbol;
    }

    public void setDotSymbol(String dotSymbol) {
        this.dotSymbol = dotSymbol;
    }

    @Override
    public String toString() {
        return "UI.Cell{" +
                "actualSymbol='" + actualSymbol + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell cell = (Cell) o;

        if (x != cell.x) return false;
        return y == cell.y;
    }

}
