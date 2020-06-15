import java.util.Random;
import java.util.Stack;
import java.util.ArrayList;
import java.util.List;


public class MazeGenerator {
    private int height;
    private int width;
    private Cell[][] maze;

    public MazeGenerator(int height, int width) {
        this.height = height;
        this.width = width;
        maze = new Cell[height][width];
        generateOutSideMaze();
        setInnerMaze();
        generateMaze();
        wallAtCorners();
        addWallAndEmptyTo2x2();
        removeInnerWalls();
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Cell[][] getMaze() {
        return maze;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setMaze(Cell[][] maze) {
        this.maze = maze;
    }

    private void generateOutSideMaze() {
        for (int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                // Fill outside wall with "#"
                if (i == 0 || j == 0 || (i == height - 1) || (j == width - 1)) {
                    Cell cell = new Cell(i, j, "#", "#");
                    maze[i][j] = cell;
                }
                // Inside with "."
                else {
                    Cell cell = new Cell(i, j, "#", ".");
                    maze[i][j] = cell;
                }
            }
        }
    }

    // Inside of maze
    private void setInnerMaze() {
        for (int i = 1; i < height - 1; i++) {
            for(int j = 1; j < width - 1; j++) {
                Cell north = maze[i+1][j];
                Cell south = maze[i-1][j];
                Cell west = maze[i][j-1];
                Cell east = maze[i][j+1];
                maze[i][j].getNeighboursOfCell().add(north);
                maze[i][j].getNeighboursOfCell().add(south);
                maze[i][j].getNeighboursOfCell().add(west);
                maze[i][j].getNeighboursOfCell().add(east);
            }
        }
    }

    // https://stackoverflow.com/questions/33847859/maze-path-searching-dfs-java REFERENCE
    // https://hurna.io/academy/algorithms/maze_generator/dfs.html REFERENCE
    // Depth first search
    public void generateMaze() {
        Stack<Cell> stack = new Stack<>();
        CellManager visited = new CellManager();
        Cell start = maze[1][1];

        stack.push(start);
        visited.add(start);
        while (!stack.isEmpty()) {
            // Handle the cell at the top of the stack:
            Cell temp = stack.pop(); // Current cell
            // CellManager nextMovesList = new CellManager(); // List of possible moves
            Random random = new Random();

//            for (Cell neighborCell : temp.getNeighboursOfCell()) { // Access the neighbors of the current cell
//                if (neighborCell.getDotSymbol().equals(".") && !visited.getMazeList().contains(neighborCell)) {
//                    nextMovesList.add(neighborCell);
//                }
//            }
            CellManager availableMovesList = getAvailableNeighbors(visited, temp);
            if (availableMovesList.getSize() == 0) {
                continue;
            }
            else {
                stack.push(temp);

                // Randomly select a cell to be processed
                int ran = random.nextInt(availableMovesList.getSize());
                Cell nextMove = availableMovesList.get(ran);

                // Mark cell as visited and push it into the stack. Set the symbol for visited cell " "
                stack.push(nextMove);
                visited.add(nextMove);
                temp.setActualSymbol(" ");
            }
        }
    }

    // Get available neighbors from bottom, left, right, top and unvisited
    public CellManager getAvailableNeighbors(CellManager visit, Cell cell) {
        CellManager availableMoves = new CellManager();
        for (Cell neighbor:cell.getNeighboursOfCell()) {
            if (neighbor.getDotSymbol().equals(".") && !visit.getMazeList().contains(neighbor)) {
                availableMoves.add(neighbor);
            }
        }

        return availableMoves;
    }

    public void displayMaze(MazeGenerator mazeBoard) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(mazeBoard.getMaze()[i][j].getActualSymbol());
            }
            System.out.println();
        }
    }

    //  Requirements:
    //  Not have a wall in each of the 4 corners
    public void wallAtCorners() {
        for (int i = 1; i < height - 1;  i++) {
            for (int j = 1; j < width - 1; j++) {
                if ((i == 1 && j == 1) || ((i == height - 2) && (j == 1)) || ((i == 1) && (j == width - 2)) || ((i == height - 2) && (j == width-2))) {
                    maze[i][j].setActualSymbol(" ");
                }
            }
        }
    }

    // Remove some of the inner walls
    public void removeInnerWalls() {
        for (int i = 1; i < height - 1; i++) {
            for (int j = 1; j < width - 1; j++) {
//                Random r = new Random();
//                int ran = r.nextInt(2);
//                if (ran == 0) {
//                    maze[i][j].setAtualSymbol(" ");
//                    if (check2x2Constraint()) {
//                        maze[i][j].setAtualSymbol("#");
//                    }
//                }
                if (maze[i][j].getActualSymbol().equals("#")) {
                    maze[i][j].setActualSymbol(" ");
                    if (check2x2Constraint()) {
                        maze[i][j].setActualSymbol("#");
                    }
                }
            }
        }
    }

    //  2 x 2 square constraint:
    public boolean check2x2Constraint() {
        for (int i = 1; i < height - 2; i++) {
            for (int j = 1; j < width - 2; j++) {
                String currentCell = maze[i][j].getActualSymbol();
                String rightCell = maze[i][j + 1].getActualSymbol();
                String bottomCell = maze[i + 1][j].getActualSymbol();
                String bottomRightCell = maze[i + 1][j + 1].getActualSymbol();

                // Check 2 x 2 square of open cells
                if (currentCell.equals(" ") && rightCell.equals(" ") && bottomCell.equals(" ") && bottomRightCell.equals(" ")) {
                    return true;
                }

                // Check 2 x 2 square of wall cells
                if (currentCell.equals("#") && rightCell.equals("#") && bottomCell.equals("#") && bottomRightCell.equals("#")) {
                    return true;
                }
            }
        }
        return false;
    }

    public void addWallAndEmptyTo2x2() {
        for (int i = 1; i < height - 2; i++) {
            for (int j = 1; j < width - 2; j++) {
                String currentCell = maze[i][j].getActualSymbol();
                String rightCell = maze[i][j + 1].getActualSymbol();
                String bottomCell = maze[i + 1][j].getActualSymbol();
                String bottomRightCell = maze[i + 1][j + 1].getActualSymbol();

                Random ran = new Random();
                int randomPick = ran.nextInt(4);

                // Adding wall to fix 2x2 square
                if (currentCell.equals(" ") && rightCell.equals(" ") && bottomCell.equals(" ") && bottomRightCell.equals(" ")) {
                    if (randomPick == 0) {
                        maze[i][j].setActualSymbol("#");
                    }
                    else if (randomPick == 1) {
                        maze[i][j+1].setActualSymbol("#");
                    }
                    else if (randomPick == 2) {
                        maze[i+1][j].setActualSymbol("#");
                    }
                    else {
                        maze[i+1][j+1].setActualSymbol("#");
                    }
                }

                // Adding empty space to fix 2x2 square
                if (currentCell.equals("#") && rightCell.equals("#") && bottomCell.equals("#") && bottomRightCell.equals("#")) {
                    if (randomPick == 0) {
                        maze[i][j].setActualSymbol(" ");
                    }
                    else if (randomPick == 1) {
                        maze[i][j+1].setActualSymbol(" ");
                    }
                    else if (randomPick == 2) {
                        maze[i+1][j].setActualSymbol(" ");
                    }
                    else {
                        maze[i+1][j+1].setActualSymbol(" ");
                    }
                }
            }
        }
    }


}











