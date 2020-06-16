package com.cmpt213.assignment2;

import java.util.ArrayList;
import java.util.Random;

public class GamePlay {
    private Monster monster;
    private Hero hero;
    private Power power;
    private Grid map;

    public GamePlay(Hero hero, Monster monster, Power power, Grid map) {
        this.hero = hero;
        this.monster = monster;
        this.power = power;
        this.map = map;
    }

    public boolean gameResult() {
        return hero.isHeroWin();

    }

    public Hero getHero() {
        return hero;
    }

    public Monster getMonster() {
        return monster;
    }

    public Power getPower() {
        return power;
    }

    public Grid getMap() {
        return map;
    }

    public void initGameState() {
        // init monster state
        Random randomInt = new Random();
        ArrayList<Position> initMonsterPos = new ArrayList<>();
        while (initMonsterPos.size() != monster.getMonsterNum()) {
            int randomX = randomInt.nextInt(map.getXHeight() - 2) + 8;
            for (int i = 1; i < map.getYHeight() - 2; ++i) {
                Position position = new Position(randomX, i);
                if (map.isCurrentWall(position) == false) {
                    initMonsterPos.add(position);
                }
            }
        }
        monster.initMonster(initMonsterPos);
        //init power state
        ArrayList<Position> initPowerPos = new ArrayList<>();
        while (initPowerPos.size() != power.getPowerNum()) {
            int randomX = randomInt.nextInt(map.getXHeight() - 2) + 2;
            for (int i = 1; i < map.getYHeight() - 2; ++i) {
                Position position = new Position(randomX, i);
                if (map.isCurrentWall(position) == false) {
                    initMonsterPos.add(position);
                }
            }
        }
        power.initPower(initMonsterPos);

    }


    public static void main(String[] args) {
        final int height = 15;
        final int width = 20;
        Random randomInt = new Random();
        Monster monster = new Monster(3);
        Hero hero = new Hero(1, 1);
        Power power = new Power(3);
        Grid map = new Grid(height, width);
        GamePlay game = new GamePlay(hero, monster, power, map);

    }



}
