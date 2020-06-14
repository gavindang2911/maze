package com.cmpt213.assignment2;

public class Cell {
    private int x;
    private int y;
    private String actualSymbol;
    private String dotSymbol;
    private CellManager neighboursOfCell = new CellManager();
    private CellManager nextMoves = new CellManager();

    public Cell(int x, int y, String actualSymbol, String dotSymbol) {
        this.x = x;
        this.y = y;
        this.actualSymbol = actualSymbol;
        this.dotSymbol = dotSymbol;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getActualSymbol() {
        return actualSymbol;
    }

    public String getDotSymbol() {
        return dotSymbol;
    }

    public CellManager getNeighboursOfCell() {
        return neighboursOfCell;
    }

    public CellManager getNextMoves() {
        return nextMoves;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setaAtualSymbol(String actualSymbol) {
        this.actualSymbol = actualSymbol;
    }

    public void setDotSymbol(String dotSymbol) {
        this.dotSymbol = dotSymbol;
    }

    public void setNeighboursOfCell(CellManager neighbours) {
        this.neighboursOfCell = neighbours;
    }

    public void setNextMoves(CellManager nextMoves) {
        this.nextMoves = nextMoves;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "actualSymbol='" + actualSymbol + '\'' +
                '}';
    }
}
