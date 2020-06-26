package com.cmpt213.Logic;


/**
 * A class Power which contains current power position and its last position in the map.
 *
 * @author Gavin Dang (301368907) + Peter Luong (301355418)
 */
public class Power {
    private Cell powerPosition;
    private Cell lastPowerPosition;

    public void initPower(Cell position) {
        powerPosition = new Cell(position.getX(), position.getY());
    }

    public void setLastPowerPosition() {
        lastPowerPosition = new Cell(powerPosition.getX(), powerPosition.getY());
    }

    public Cell getLastPowerPosition() {
        return lastPowerPosition;
    }

    public Cell getPowerPosition() {
        return powerPosition;
    }
}
