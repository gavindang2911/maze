package com.cmpt213.UI;

public class Symbol {
    private final String hero;
    private final String monster;
    private final String power;
    private final String wall;
    private final String space;
    private final String unknown;
    private final String heroDie;

    public Symbol() {
        this.hero = "@";
        this.monster = "!";
        this.power = "$";
        this.wall = "#";
        this.space = " ";
        this.unknown = ".";
        this.heroDie = "X";
    }

    public String getHeroSymbol() {
        return hero;
    }

    public String getMonsterSymbol() {
        return monster;
    }

    public String getPowerSymbol() {
        return power;
    }

    public String getSpaceSymbol() {
        return space;
    }

    public String getWallSymbol() {
        return wall;
    }

    public String getUnknownSymbol() {
        return unknown;
    }

    public String getHeroDieSymbol() {
        return heroDie;
    }
}
