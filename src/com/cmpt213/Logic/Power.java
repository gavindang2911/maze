package com.cmpt213.Logic;

import java.util.ArrayList;

public class Power {
    private int powerNum;
    private Cell powerPosition;
    private Cell pastPowerPosition;

    public Power(int powerNum) {
        this.powerNum = powerNum;
    }

    public void initPower(Cell position) {
        powerPosition = new Cell(position.getX(), position.getY());
    }

    public void setPastPowerPosition() {
        pastPowerPosition = new Cell(powerPosition.getX(), powerPosition.getY());
    }

    public Cell getPastPowerPosition() {
        return pastPowerPosition;
    }

    public Cell getPowerPosition() {
        return powerPosition;
    }


}
