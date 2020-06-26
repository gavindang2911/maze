package com.cmpt213.Logic;



import com.cmpt213.Logic.Cell;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

/**
 * A class CellManager, which is the array list of all cells in the maze that we can use method to get size.
 *
 * @author Gavin Dang (301368907) + Peter Luong (301355418)
 */
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


    public void add(Cell cell) {
        listOfCells.add(cell);
        this.size++;
    }

    public Cell get(int index) {
        return listOfCells.get(index);
    }

    @Override
    public Iterator<Cell> iterator() {
        return listOfCells.iterator();
    }
}
