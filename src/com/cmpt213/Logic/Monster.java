package com.cmpt213.Logic;

import com.cmpt213.UI.DisplayGraphic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

public class Monster {
    private int monsterNum;
    private ArrayList<Cell> monsterPosition;
    private boolean monsterWin;
    private ArrayList<Cell> pastPosition;


    public Monster(int monsterNum) {
        this.monsterNum = monsterNum;
        this.monsterWin = false;
    }

    public void initMonster(ArrayList<Cell> positions) {
        monsterPosition = new ArrayList<>(positions);
    }
    public void initPastPosition(ArrayList<Cell> positions) {
        pastPosition = new ArrayList<>(positions);
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

    public List<Cell> getPastPosition() {
        return pastPosition;
    }

    public void setMonsterWin() {
        monsterWin = true;
    }

    public boolean isMonsterWin() {
        return monsterWin;
    }



    public static void main(String[] args) {

    }


}
