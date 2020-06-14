package com.cmpt213.assignment2;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class CellManager implements Iterable<Cell> {
    List<Cell> mazeList = new ArrayList<>();
    int size;

    public CellManager() {
        this.size = 0;
    }

    public List<Cell> getMazeList() {
        return mazeList;
    }

    public int getSize() {
        return size;
    }

    public void setMazeList(List<Cell> mazeList) {
        this.mazeList = mazeList;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void add(Cell cell) {
        mazeList.add(cell);
        size++;
    }

    public void remove(Cell cell) {
        mazeList.remove(cell);
    }

    public boolean isFound(Cell cell) {
        return mazeList.contains(cell);
    }

    @Override
    public Iterator<Cell> iterator() {
        return mazeList.iterator();
    }
}
