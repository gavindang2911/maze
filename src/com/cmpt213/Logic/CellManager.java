package com.cmpt213.Logic;



import com.cmpt213.Logic.Cell;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class CellManager implements Iterable<Cell> {
    private List<Cell> listOfCells = new ArrayList<>();
    private int size;

    public CellManager() {
        this.size = 0;
    }

    public List<Cell> getListOfCells() {
        return listOfCells;
    }

    public int getSize() {
        return size;
    }

    public void setListOfCells(List<Cell> listOfCells) {
        this.listOfCells = listOfCells;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void add(Cell cell) {
        listOfCells.add(cell);
        this.size++;
    }

    public void remove(Cell cell) {
        listOfCells.remove(cell);
    }

    public Cell get(int index) {
        return listOfCells.get(index);
    }

    @Override
    public Iterator<Cell> iterator() {
        return listOfCells.iterator();
    }



}
