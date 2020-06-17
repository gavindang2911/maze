public class Grid {
    public static void main(String[] args) {
        MazeGenerator mazeBoard = new MazeGenerator(15, 20);

        mazeBoard.createMaze();
        mazeBoard.displayMaze();
        mazeBoard.displayMazeString();
    }
}
