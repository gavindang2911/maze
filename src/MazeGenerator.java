public class MazeGenerator {
    private int height;
    private int width;
    private Cell[][] grid;

    public MazeGenerator(int height, int width) {
        this.height = height;
        this.width = width;
        grid = new Cell[height][width];
        generateGrid();
        setNeighboursCellInside();
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Cell[][] getGrid() {
        return grid;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setGrid(Cell[][] grid) {
        this.grid = grid;
    }

    private void generateGrid() {
        for (int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                if (i == 0 || j == 0 || (i == height - 1) || (j == width - 1)) {
                    Cell cell = new Cell(i, j, "#", "#");
                    grid[i][j] = cell;
                }
                else {
                    Cell cell = new Cell(i, j, "#", ".");
                    grid[i][j] = new Cell(i,j, "#", ".");
                }
            }
        }
    }

    // Inside of grid
    private void setNeighboursCellInside() {
        for (int i = 1; i < height - 1; i++) {
            for(int j = 1; j < width - 1; j++) {
                Cell north = grid[i+1][j];
                Cell south = grid[i-1][j];
                Cell west = grid[i][j-1];
                Cell east = grid[i][j+1];
                grid[i][j].getNeighboursOfCell().add[north];
            }
        }
    }
}
