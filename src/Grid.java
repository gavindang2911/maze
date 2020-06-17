public class Grid {
    public static void main(String[] args) {
        MazeGenerator mazeBoard = new MazeGenerator(15, 20);

        mazeBoard.displayMaze();
        mazeBoard.displayMazeString();
    }
}
