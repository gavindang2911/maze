package com.cmpt213.assignment2;

import java.util.ArrayList;

public class Hero {
    private boolean heroWin;
    private Position position;

    public Hero (int heroX, int heroY) {
        this.heroWin = false;
        position = new Position(heroX, heroY);
    }


    public boolean isHeroWin() {
        return heroWin;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }


}
