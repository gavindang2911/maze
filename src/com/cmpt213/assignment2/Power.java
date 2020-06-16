package com.cmpt213.assignment2;

import java.util.ArrayList;
import java.util.Random;

public class Power {
    private int powerNum;
    private ArrayList<Position> powerPosition;
    public Power(int powerNum) {
        this.powerNum = powerNum;
    }

    public void initPower(ArrayList<Position> positions) {
        powerPosition = new ArrayList<>(positions);
    }

    public ArrayList<Position> getPowerPosition() {
        return powerPosition;
    }

    public int getPowerNum() {
        return powerNum;
    }

}
