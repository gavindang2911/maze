
package com.cmpt213.Logic;


/**
 * A class Hero which contains hero current position, its last position and the result of the game(hero win).
 *
 * @author Gavin Dang (301368907) + Peter Luong (301355418)
 */
public class Hero {
    private boolean heroWin;
    private Cell position;
    private int numberOfPowerPossess;

    public Hero (int heroX, int heroY) {
        this.heroWin = false;
        position = new Cell(heroX, heroY);
        this.numberOfPowerPossess = 0;
    }

    public void setHeroWin() {
        heroWin = true;
    }

    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    public boolean isHeroWin() {
        return heroWin;
    }

    public void setPosition(Cell position) {
        this.position = position;
    }

    public Cell getHeroPosition() {
        return position;
    }

    public int getNumberOfPowerPossess() {
        return numberOfPowerPossess;
    }

    public void updatePowerNum() {
        numberOfPowerPossess += 1;
    }

    public void decreasePowerNum(int num) {
        numberOfPowerPossess -= num;
    }

}

