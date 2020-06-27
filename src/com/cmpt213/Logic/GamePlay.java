
package com.cmpt213.Logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


/**
 * A class GamePlay which contains necessary game rules, determine game state
 * and how object interacts to each other.
 *
 * @author Gavin Dang (301368907) + Peter Luong (301355418)
 */
public class GamePlay {
    private final Monster monster;
    private final Hero hero;
    private final Power power;
    private final Map map;
    private boolean cheatCode = false;
    private boolean invalidMove = false;

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

    public boolean isInvalidMove() {
        return invalidMove;
    }

    public void setInvalidMove(boolean invalidMove) {
        this.invalidMove = invalidMove;
    }

    public boolean getCheatCode() {
        return cheatCode;
    }

    public void setCheatCode() {
        cheatCode = true;
    }

    public void initGameState() {

        ArrayList<Cell> initMonsterPos = new ArrayList<>();
        ArrayList<Cell> initPastMonsterPos = new ArrayList<>();

        Cell monster1 = new Cell(1, 18);
        Cell monster2 = new Cell(13, 1);
        Cell monster3 = new Cell(13, 18);
        Cell pastMonster1 = new Cell(1, 18);
        Cell pastMonster2 = new Cell(13, 1);
        Cell pastMonster3 = new Cell(13, 18);
        initMonsterPos.add(monster1);
        initMonsterPos.add(monster2);
        initMonsterPos.add(monster3);
        initPastMonsterPos.add(pastMonster1);
        initPastMonsterPos.add(pastMonster2);
        initPastMonsterPos.add(pastMonster3);

        monster.initMonster(initMonsterPos);
        monster.initLastPosition(initPastMonsterPos);

        Random randomPower = new Random();
        int randomX = randomPower.nextInt(9) + 2;
        for (int i = 0; i < map.getWidth(); ++i ) {
            Cell powerPosition = new Cell(randomX, i);
            if (!map.isCurrentWall(powerPosition)) {
                power.initPower(powerPosition);
                power.setLastPowerPosition();
                break;
            }
        }
    }

    public void monsterAction() {
        for (int i = 0; i < monster.getMonsterPosition().size(); ++i) {
            Cell current = monster.getMonsterPosition().get(i);
            Cell past = monster.getLastPosition().get(i);
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
    }

    // check if hero and monster in the same cell
    public boolean checkHeroInMonster() {
        for (int i = 0; i < monster.getMonsterPosition().size(); ++i) {
            if (hero.getHeroPosition().getX() == monster.getMonsterPosition().get(i).getX() &&
                    hero.getHeroPosition().getY() == monster.getMonsterPosition().get(i).getY()) {
                return true;
            }
        }
        return false;
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
                if (!checkHeroInMonster()) {
                    heroGrabPower();
                }
            }
            case "s" -> {
                Cell down = new Cell(currentX + 1, currentY);
                if (!map.isCurrentWall(down)) {
                    hero.setPosition(down);
                }
                if (!checkHeroInMonster()) {
                    heroGrabPower();
                }
            }
            case "d" -> {
                Cell right = new Cell(currentX, currentY + 1);
                if (!map.isCurrentWall(right)) {
                    hero.setPosition(right);
                }
                if (!checkHeroInMonster()) {
                    heroGrabPower();
                }
            }
            case "a" -> {
                Cell left = new Cell(currentX, currentY - 1);
                if (!map.isCurrentWall(left)) {
                    hero.setPosition(left);
                }
                if (!checkHeroInMonster()) {
                    heroGrabPower();
                }
            }
            default -> {
                assert false;
            }
        }
        if (currentX == hero.getHeroPosition().getX() && currentY == hero.getHeroPosition().getY()) {
            setInvalidMove(true);
            return;
        } else {
            setInvalidMove(false);
        }
        if (checkHeroInMonster()) {
            heroVsMonster();
        }
    }

    public void generatePower() {
        power.setLastPowerPosition();
        Random randomPower = new Random();
        int randomX = randomPower.nextInt(map.getHeight() - 3) + 1;

        for (int i = 0; i < map.getWidth(); ++i ) {
            Cell powerPosition = new Cell(randomX, i);
            if (!map.isCurrentWall(powerPosition) && randomX != hero.getHeroPosition().getX()
                && i != hero.getHeroPosition().getY()) {
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
            List<Cell> monsterDie = new ArrayList<>();
            for (int i = 0; i < monster.getMonsterPosition().size(); ++i) {
                countMonster[i] = Collections.frequency(monster.getMonsterPosition(), monster.getMonsterPosition().get(i));
                Cell current = monster.getMonsterPosition().get(i);
                if (current.getX() == hero.getHeroPosition().getX() && current.getY() == hero.getHeroPosition().getY()) {
                    if (hero.getNumberOfPowerPossess() >= countMonster[i]) {
                        monsterDie.add(monster.getMonsterPosition().get(i));
                    } else {
                        monster.setMonsterWin();
                        break;
                    }

                }
            }
            hero.decreasePowerNum(monsterDie.size());
            monster.setMonsterNum(monster.getMonsterNum() - monsterDie.size());
            if (monster.getMonsterNum() == 0 && !cheatCode) {
                hero.setHeroWin();
            } else if (cheatCode && monster.getMonsterNum() == 2) {
                hero.setHeroWin();
            }
            monster.getMonsterPosition().removeAll(monsterDie);
        }
    }
}

