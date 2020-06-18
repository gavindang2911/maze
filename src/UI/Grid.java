package UI;

import Logic.*;

public class Grid {
    private final static int height = 15;
    private final static int width = 20;
    private static MazeGenerator mazeBoard = new MazeGenerator(height, width);
    private static PowerManager powerList = new PowerManager();
    private static Hero hero;
    private static Monster monster1;
    private static Monster monster2;
    private static Monster monster3;

    private static MazeInput input;


    public static void main(String[] args) {
//        MazeGenerator mazeBoard = new MazeGenerator(height, width);
//        PowerManager powerList = new PowerManager();

        Cell current = mazeBoard.getMaze()[1][1];
        initMaze(mazeBoard);

        //displayMaze(mazeBoard);
        int count = 0;
        while (true) {
            powerList.getPowerList().get(count).getCurrentPosition().setDotSymbol(powerList.getPowerList().get(count).getPowerString());
            displayHiddenMaze(current, mazeBoard);
            System.out.println("ca.cmpt213.as3.Cheese collected: " + count + " of 3");
            input = new MazeInput(mazeBoard, current);
            input.key();
        }



    }

    private static void initMaze(MazeGenerator mazeBoard) {
        for (int i = 0; i < 3; i++) {
            Power power = new Power("$");
            power.randomPlacePower(mazeBoard);
            powerList.add(power);
        }

        Cell startHero = mazeBoard.getMaze()[1][1];
        Cell starMonster1 = mazeBoard.getMaze()[1][width - 2];
        Cell starMonster2 = mazeBoard.getMaze()[height - 2][1];
        Cell starMonster3 = mazeBoard.getMaze()[height - 2][width - 2];

//        Hero hero = new Hero(startHero, "@");
        hero = new Hero(startHero, "@");
//        Monster monster1 = new Monster(starMonster1, "!");
        monster1 = new Monster(starMonster1, "!");
        monster2 = new Monster(starMonster2, "!");
        monster3 = new Monster(starMonster3, "!");

        startHero.setActualSymbol(hero.getHeroString());
        startHero.setDotSymbol(hero.getHeroString());

        starMonster1.setActualSymbol(monster1.getMonsterString());
        starMonster1.setDotSymbol(monster1.getMonsterString());
        monster1.randomMove();

        starMonster2.setActualSymbol(monster2.getMonsterString());
        starMonster2.setDotSymbol(monster2.getMonsterString());
        monster2.randomMove();

        starMonster3.setActualSymbol(monster3.getMonsterString());
        starMonster3.setDotSymbol(monster3.getMonsterString());
        monster3.randomMove();
    }


    public static void displayMaze(MazeGenerator maze) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(maze.getMaze()[i][j].getActualSymbol());
            }
            System.out.println();
        }
    }

    public static void displayHiddenMaze(Cell current, MazeGenerator maze) {
        for (int i = 0; i < maze.getHeight(); i++) {
            for (int j = 0; j < maze.getWidth(); j++) {
                if ((i == current.getX() + 1 && j == current.getY() - 1) || (i == current.getX() + 1 && j == current.getY()) || (i == current.getX() + 1 && j == current.getY() + 1) ||
                        (i == current.getX() && j == current.getY() - 1) || (i == current.getX() && j == current.getY()) || (i == current.getX() && j == current.getY() + 1) ||
                        (i == current.getX() - 1 && j == current.getY() - 1) || (i == current.getX() - 1 && j == current.getY()) || (i == current.getX() - 1 && j == current.getY() + 1)) {
                    maze.getMaze()[i][j].setDotSymbol(maze.getMaze()[i][j].getActualSymbol());
                }
                System.out.print(maze.getMaze()[i][j].getDotSymbol());
            }
            System.out.println();
        }
    }
}


