package com.cmpt213.Logic;

import java.util.ArrayList;
import java.util.List;


/**
 * A class Monster which contains number of monsters, all monsters current positions, their last positions
 * and the result of the game (monster win).
 *
 * @author Gavin Dang (301368907) + Peter Luong (301355418)
 */
public class Monster {
    private int monsterNum;
    private ArrayList<Cell> monsterPosition;
    private boolean monsterWin;
    private ArrayList<Cell> lastPosition;


    public Monster(int monsterNum) {
        this.monsterNum = monsterNum;
        this.monsterWin = false;
    }

    public void initMonster(ArrayList<Cell> positions) {
        monsterPosition = new ArrayList<>(positions);
    }

    public void initLastPosition(ArrayList<Cell> positions) {
        lastPosition = new ArrayList<>(positions);
    }

    public int getMonsterNum() {
        return monsterNum;
    }

    public void setMonsterNum(int monsterNum) {
        this.monsterNum = monsterNum;
    }

    public List<Cell> getMonsterPosition() {
        return monsterPosition;
    }

    public List<Cell> getLastPosition() {
        return lastPosition;
    }

    public void setMonsterWin() {
        monsterWin = true;
    }

    public boolean isMonsterWin() {
        return monsterWin;
    }

}
