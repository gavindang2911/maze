package Logic;

public class Cell {
    private int x; // X coordinate
    private int y; // Y coordinate
    private String dotSymbol;
    private String actualSymbol;
    private CellManager neighboursOfCell = new CellManager();
    //private Logic.CellManager nextMoves = new Logic.CellManager();

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

    public String getDotSymbol() {
        return dotSymbol;
    }

    public String getActualSymbol() {
        return actualSymbol;
    }

    public CellManager getNeighboursOfCell() {
        return neighboursOfCell;
    }

    //public Logic.CellManager getNextMoves() {
    //    return nextMoves;
    //}

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

    public void setNeighboursOfCell(CellManager neighbours) {
        this.neighboursOfCell = neighbours;
    }

    //public void setNextMoves(Logic.CellManager nextMoves) {
    //    this.nextMoves = nextMoves;
    //}

    public CellManager getAvailableMoves(Cell cell) {
        CellManager availableMoves = new CellManager();
        for (Cell neighbor : cell.getNeighboursOfCell()) {
            if (!neighbor.getActualSymbol().equals("#")) {
                availableMoves.add(neighbor);
            }
        }
        return availableMoves;
    }

    @Override
    public String toString() {
        return "Logic.Cell{" +
                "actualSymbol='" + actualSymbol + '\'' +
                '}';
    }
}
