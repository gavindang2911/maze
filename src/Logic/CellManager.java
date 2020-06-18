package Logic;

import Logic.Cell;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class CellManager implements Iterable<Cell> {
    private List<Cell> mazeList = new ArrayList<>();
    private int size;

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
        this.size++;
    }

    public void remove(Cell cell) {
        mazeList.remove(cell);
    }

    public Cell get(int index) {
        return mazeList.get(index);
    }

    @Override
    public Iterator<Cell> iterator() {
        return mazeList.iterator();
    }

}
