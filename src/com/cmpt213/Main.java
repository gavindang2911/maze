package com.cmpt213;

import com.cmpt213.Logic.*;
import com.cmpt213.UI.DisplayGraphic;

import java.util.Scanner;

/**
 * A class Main is where user plays the game. It takes user input and interact with other class
 * to run the game.
 *
 * @author Gavin Dang (301368907) + Peter Luong (301355418)
 */

public class Main {
    public static void main(String[] args) {
        final int height = 15;
        final int width = 20;
        int monsterNum = 3;

        Monster monster = new Monster(monsterNum);
        Hero hero = new Hero(1, 1);
        Power power = new Power();
        Map map = new Map(height, width);
        GamePlay game = new GamePlay(hero, monster, power, map);

        map.createMaze();
        DisplayGraphic display = new DisplayGraphic(height, width, map);
        display.initDisplay();
        game.initGameState();
        display.menu();
        System.out.println("Maze:");
        display.drawGame(game);

        while (!monster.isMonsterWin() && !hero.isHeroWin()) {
            if (game.getCheatCode()) {
                System.out.println("Total number of monsters to be killed: 1");
            } else {
                System.out.println("Total number of monsters to be killed: " + game.getMonster().getMonsterNum());
            }

            System.out.println("Number of powers currently in possession: " + game.getHero().getNumberOfPowerPossess());
            System.out.println("Number of monsters alive: " + game.getMonster().getMonsterNum());
            System.out.print("Press [wsad] to move hero: ");
            Scanner gamerInput = new Scanner(System.in);
            String moveInput = gamerInput.nextLine();

            if (moveInput.equals("m")) {
                display.displayFullMap(game);
            } else if (moveInput.equals("?")) {
                display.menu();
            } else {
                if (moveInput.equals("c")) {
                    game.setCheatCode();
                    System.out.print("Press [wsad] to move hero: ");
                    moveInput = gamerInput.nextLine();
                }
                while (!moveInput.equals("w") && !moveInput.equals("s") && !moveInput.equals("a") && !moveInput.equals("d")) {
                    System.out.print("Please enter valid move [wsad]: ");
                    moveInput = gamerInput.nextLine();
                }
                game.heroAction(moveInput);
                while (game.isInvalidMove()) {
                    System.out.print("Hero cannot go through wall. Enter again [wsad]: ");
                    moveInput = gamerInput.nextLine();
                    game.heroAction(moveInput);
                }
                if (game.getMonster().getMonsterNum() > 0 && !game.getHero().isHeroWin() && !game.getMonster().isMonsterWin()) {
                    game.monsterAction();
                    game.heroVsMonster();
                }
            }

            System.out.println("Maze:");
            display.drawGame(game);
        }
        if (monster.isMonsterWin()) {
            System.out.println("I'm sorry, you have been eaten!\n");
        } else {
            System.out.println("You won!\n");
        }
    }
}
