package com.cmpt213.Logic;

import com.cmpt213.UI.DisplayGraphic;

import java.util.*;

public class GamePlay {
    private final Monster monster;
    private final Hero hero;
    private final Power power;
    private final Map map;

    public GamePlay(Hero hero, Monster monster, Power power, Map map) {
        this.hero = hero;
        this.monster = monster;
        this.power = power;
        this.map = map;
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

    /*public Map getMap() {
        return map;
    }*/

    public void initGameState() {
        // init monster state
        //Random randomInt = new Random();
        ArrayList<Cell> initMonsterPos = new ArrayList<>();
        ArrayList<Cell> initPastMonsterPos = new ArrayList<>();

        for (int i = 11; i < 11 + monster.getMonsterNum(); ++i) {
            for (int j = 1; j < map.getWidth() - 1; ++j) {
                Cell monsterPos = new Cell(i, j);
                Cell PastMonsterPos = new Cell(i, j);
                if (!map.isCurrentWall(monsterPos)) {
                    initMonsterPos.add(monsterPos);
                    initPastMonsterPos.add(PastMonsterPos);
                    break;
                }
            }
        }
        //initMonsterPos.add(new Position(13, 18));
        /*while (initMonsterPos.size() != monster.getMonsterNum()) {
            int randomX = randomInt.nextInt(6) + 8;
            for (int i = 1; i < map.getYHeight() - 2; ++i) {
                Position position = new Position(randomX, i);
                if (map.isCurrentWall(position) == false) {
                    initMonsterPos.add(position);
                }
            }
        }*/
        monster.initMonster(initMonsterPos);
        monster.initPastPosition(initPastMonsterPos);
        //init power state
        //ArrayList<Cell> initPowerPos = new ArrayList<>();
        /*while (initPowerPos.size() != power.getPowerNum()) {
            int randomX = randomInt.nextInt(12) + 2;
            for (int i = 1; i < map.getYHeight() - 2; ++i) {
                Position position = new Position(randomX, i);
                if (map.isCurrentWall(position) == false) {
                    initMonsterPos.add(position);
                }
            }
        }*/
        Random randomPower = new Random();
        int randomX = randomPower.nextInt(9) + 2;
        for (int i = 0; i < map.getWidth(); ++i ) {
            Cell powerPosition = new Cell(randomX, i);
            if (!map.isCurrentWall(powerPosition)) {
                power.initPower(powerPosition);
                power.setPastPowerPosition();
                break;
            }
        }

    }

    public void monsterAction() {
            for (int i = 0; i < monster.getMonsterPosition().size(); ++i) {

                Cell current = monster.getMonsterPosition().get(i);
                Cell past = monster.getPastPosition().get(i);
                int currentX = current.getX();
                int currentY = current.getY();
                Cell up = new Cell(currentX - 1, currentY);
                Cell down = new Cell(currentX + 1, currentY);
                Cell right = new Cell(currentX, currentY + 1);
                Cell left = new Cell(currentX, currentY - 1);

                if (!map.isCurrentWall(up) && (past.getX() != up.getX())) {
                    current.setX(currentX - 1);
                    current.setY(currentY);
                    past.setX(currentX);
                    past.setY(currentY);
                    continue;
                }
                if (!map.isCurrentWall(down) && (past.getX() != down.getX())) {
                    current.setX(currentX + 1);
                    current.setY(currentY);
                    past.setX(currentX);
                    past.setY(currentY);
                    continue;
                }
                if (!map.isCurrentWall(right) && ( past.getY() != right.getY())) {
                    current.setX(currentX);
                    current.setY(currentY + 1);
                    past.setX(currentX);
                    past.setY(currentY);
                    continue;
                }
                if (!map.isCurrentWall(left) && ( past.getY() != left.getY())) {
                    current.setX(currentX);
                    current.setY(currentY - 1);
                    past.setX(currentX);
                    past.setY(currentY);
                    continue;
                }

                current.setX(past.getX());
                current.setY(past.getY());
                past.setX(currentX);
                past.setY(currentY);
            }
            //heroVsMonster();
    }
    public void heroAction(String keyboardInput) {
        int currentX = hero.getHeroPosition().getX();
        int currentY = hero.getHeroPosition().getY();
        switch (keyboardInput) {
            case "w" -> {
                Cell up = new Cell(currentX - 1, currentY);
                if (!map.isCurrentWall(up)) {
                    hero.setPosition(up);
                }
                heroGrabPower();
            }
            case "s" -> {
                Cell down = new Cell(currentX + 1, currentY);
                if (!map.isCurrentWall(down)) {
                    hero.setPosition(down);
                }
                heroGrabPower();
            }
            case "d" -> {
                Cell right = new Cell(currentX, currentY + 1);
                if (!map.isCurrentWall(right)) {
                    hero.setPosition(right);
                }
                heroGrabPower();
            }
            case "a" -> {
                Cell left = new Cell(currentX, currentY - 1);
                if (!map.isCurrentWall(left)) {
                    hero.setPosition(left);
                }
                heroGrabPower();
            }
        }
    }

    public void generatePower() {
        power.setPastPowerPosition();
        Random randomPower = new Random();
        int randomX = randomPower.nextInt(9) + 2;
        for (int i = 0; i < map.getWidth(); ++i ) {
            Cell powerPosition = new Cell(randomX, i);
            if (!map.isCurrentWall(powerPosition)) {
                power.initPower(powerPosition);
                break;
            }
        }

    }

    public void heroGrabPower() {
        if (hero.getHeroPosition().getX() == power.getPowerPosition().getX() &&
            hero.getHeroPosition().getY() == power.getPowerPosition().getY()) {
            hero.updatePowerNum();
            generatePower();
        }
    }

    public void heroVsMonster() {
        int heroMeetMonster = Collections.frequency(monster.getMonsterPosition(), hero.getHeroPosition());
        if (heroMeetMonster >= 1) {
            int[] countMonster;
            countMonster = new int[monster.getMonsterNum()];
            for (int i = 0; i < monster.getMonsterPosition().size(); ++i) {
                countMonster[i] = Collections.frequency(monster.getMonsterPosition(), monster.getMonsterPosition().get(i));
                Cell current = monster.getMonsterPosition().get(i);
                if (current.getX() == hero.getHeroPosition().getX() && current.getY() == hero.getHeroPosition().getY()) {
                    if (hero.getNumberOfPowerPossess() >= countMonster[i]) {
                        hero.decreasePowerNum();
                        monster.getMonsterPosition().remove(i);
                        monster.setMonsterNum(monster.getMonsterNum() - 1);
                        if (monster.getMonsterNum() == 0) {
                            hero.setHeroWin();
                        }
                    } else {
                        monster.setMonsterWin();
                        break;
                    }
                }
            }
        }
    }


    public static void main(String[] args) {

    }
}
