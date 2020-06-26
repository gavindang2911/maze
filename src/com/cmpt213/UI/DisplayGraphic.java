package com.cmpt213.UI;

import com.cmpt213.Logic.*;

import java.util.List;

/**
 * A class DisplayGraphic which displays hero, monster, power, maze and help menu while playing game.
 *
 * @author Gavin Dang (301368907) + Peter Luong (301355418)
 */
public class DisplayGraphic {
    private final int height;
    private final int width;
    private final String[][] fullMaze;
    private final String[][] gameMaze;
    private final Symbol gameSymbol;
    private final Map maze;

    public DisplayGraphic(int height, int width, Map map) {
        this.height = height;
        this.width = width;
        this.fullMaze = new String[height][width];
        this.gameMaze = new String[height][width];
        this.gameSymbol = new Symbol();
        this.maze = map;

    }

    public void initDisplay() {
        String[][] fullMaze = maze.getFullMaze();
        for (int i = 0; i < height; ++i) {
            if (width >= 0) {
                System.arraycopy(fullMaze[i], 0, this.fullMaze[i], 0, width);
            }
        }
        for (int i = 1; i < width - 1; ++i) {
            gameMaze[0][i] = gameSymbol.getWallSymbol();
        }
        for (int i = 1; i < width - 1; ++i) {
            gameMaze[14][i] = gameSymbol.getWallSymbol();
        }
        for (int i = 0; i < height; ++i) {
            gameMaze[i][0] = gameSymbol.getWallSymbol();
        }
        for (int i = 0; i < height; ++i) {
            gameMaze[i][19] = gameSymbol.getWallSymbol();
        }
        for (int i = 1; i < height - 1; ++i) {
            for (int j = 1; j < width - 1; ++j) {
                gameMaze[i][j] = gameSymbol.getUnknownSymbol();
            }
        }
    }

    public void drawMonster(List<Cell> positions, List<Cell> pastPositions, Cell powerPosition, Cell heroPosition) {
        for (Cell position : pastPositions) {
            int pastX = position.getX();
            int pastY = position.getY();
            if (powerPosition.getX() == pastX && powerPosition.getY() == pastY) {
                gameMaze[pastX][pastY] = gameSymbol.getPowerSymbol();
                continue;
            }
            if (heroPosition.getX() == pastX && heroPosition.getY() == pastY) {
                gameMaze[pastX][pastY] = gameSymbol.getHeroSymbol();
            } else {
                gameMaze[pastX][pastY] = gameSymbol.getSpaceSymbol();
            }
        }
        for (Cell position : positions) {
            int currentX = position.getX();
            int currentY = position.getY();
            gameMaze[currentX][currentY] = gameSymbol.getMonsterSymbol();
        }

    }

    public void drawHero(Cell position) {
        gameMaze[position.getX() - 1][position.getY()] = fullMaze[position.getX() - 1][position.getY()];
        gameMaze[position.getX() + 1][position.getY()] = fullMaze[position.getX() + 1][position.getY()];
        gameMaze[position.getX()][position.getY() + 1] = fullMaze[position.getX()][position.getY() + 1];
        gameMaze[position.getX()][position.getY() - 1] = fullMaze[position.getX()][position.getY() - 1];
        gameMaze[position.getX() - 1][position.getY() - 1] = fullMaze[position.getX() - 1][position.getY() - 1];
        gameMaze[position.getX() - 1][position.getY() + 1] = fullMaze[position.getX() - 1][position.getY() + 1];
        gameMaze[position.getX() + 1][position.getY() - 1] = fullMaze[position.getX() + 1][position.getY() - 1];
        gameMaze[position.getX() + 1][position.getY() + 1] = fullMaze[position.getX() + 1][position.getY() + 1];
        gameMaze[position.getX()][position.getY()] = gameSymbol.getHeroSymbol();
    }

    public void drawPower(Cell position, Cell pastPosition) {
        gameMaze[pastPosition.getX()][pastPosition.getY()] = gameSymbol.getSpaceSymbol();
        gameMaze[position.getX()][position.getY()] = gameSymbol.getPowerSymbol();
        fullMaze[pastPosition.getX()][pastPosition.getY()] = gameSymbol.getSpaceSymbol();
        fullMaze[position.getX()][position.getY()] = gameSymbol.getPowerSymbol();
    }

    public void drawGame(GamePlay game) {
        drawPower(game.getPower().getPowerPosition(), game.getPower().getLastPowerPosition());
        drawHero(game.getHero().getHeroPosition());
        drawMonster(game.getMonster().getMonsterPosition(), game.getMonster().getLastPosition(),
                game.getPower().getPowerPosition(), game.getHero().getHeroPosition());
        if (!game.getHero().isHeroWin() && game.getMonster().isMonsterWin()) {
            gameMaze[game.getHero().getHeroPosition().getX()][game.getHero().getHeroPosition().getY()] = gameSymbol.getHeroDieSymbol();
        }
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                System.out.print(gameMaze[i][j]);
            }
            System.out.println();
        }
    }

    public void displayAllMonster(List<Cell> positions) {
        for (Cell position : positions) {
            int currentX = position.getX();
            int currentY = position.getY();
            fullMaze[currentX][currentY] = gameSymbol.getMonsterSymbol();
        }
    }

    public void displayHero(Cell position) {
        fullMaze[position.getX()][position.getY()] = gameSymbol.getHeroSymbol();
    }

    public void displayPower(Cell position) {
        fullMaze[position.getX()][position.getY()] = gameSymbol.getPowerSymbol();
    }

    public void displayFullMap(GamePlay game) {
        displayPower(game.getPower().getPowerPosition());
        displayHero(game.getHero().getHeroPosition());
        displayAllMonster(game.getMonster().getMonsterPosition());
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                System.out.print(fullMaze[i][j]);
            }
            System.out.println();
        }
        fullMaze[game.getHero().getHeroPosition().getX()][game.getHero().getHeroPosition().getY()] = gameSymbol.getSpaceSymbol();
        for (Cell position : game.getMonster().getMonsterPosition()) {
            int currentX = position.getX();
            int currentY = position.getY();
            fullMaze[currentX][currentY] = gameSymbol.getSpaceSymbol();
        }
    }

    public void menu() {
        final String helpMenu = "DIRECTIONS:\n" +
                "Kill 3 Monsters!\n" +
                "LEGEND:\n" +
                "#: Wall\n" +
                "@: You (a hero)\n" +
                "!: Monster\n" +
                "$: Power\n" +
                ".: Unexplored space\n" +
                "MOVES:\n" +
                "Use W (up), A (left), S (down) and D (right) to move.\n" +
                "(You must press enter after each move).\n" +
                "1.Press c to use cheat code.\n2.Press m to display full map.\n" +
                "3.Press any key and enter to play.\n";
        System.out.print(helpMenu);
    }
}

