package com.cmpt213.assignment2;

import java.util.ArrayList;
import java.util.Random;

public class Monster {
    private int monsterNum;
    private ArrayList<Position> monsterPosition;
    private boolean monsterWin;




    public Monster(int monsterNum) {

        this.monsterNum = monsterNum;


        this.monsterWin = false;
    }

    public void initMonster(ArrayList<Position> positions) {
        monsterPosition = new ArrayList<>(positions);
    }


    public int getMonsterNum() {
        return monsterNum;
    }

    public void setMonsterNum() {
        this.monsterNum = monsterNum;
    }

    public ArrayList<Position> getMonsterPosition() {
        return monsterPosition;
    }

    public boolean isMonsterWin() {
        return monsterWin;
    }

    public void monsterMove (GamePlay game) {
        Grid map = game.getMap();
        for (int i = 0; i < monsterPosition.size(); ++i) {
            int currentX = monsterPosition.get(i).getX();
            int currentY = monsterPosition.get(i).getY();
            Position up = new Position(currentX - 1, currentY);
            Position down = new Position(currentX + 1, currentY);
            Position right = new Position(currentX, currentY + 1);
            Position left = new Position(currentX, currentY - 1);
            if (!map.isCurrentWall(up)) {
                monsterPosition.get(i).setX(currentX - 1);
                monsterPosition.get(i).setY(currentY);
            } else if (!map.isCurrentWall(down)) {
                monsterPosition.get(i).setX(currentX + 1);
                monsterPosition.get(i).setY(currentY);
            } else if (!map.isCurrentWall(right)) {
                monsterPosition.get(i).setX(currentX);
                monsterPosition.get(i).setY(currentY + 1);
            } else if (!map.isCurrentWall(left)) {
                monsterPosition.get(i).setX(currentX);
                monsterPosition.get(i).setY(currentY - 1);
            }
         }
    }


}
