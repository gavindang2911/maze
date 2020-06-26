package com.cmpt213.UI;


/**
 * A class Symbol which contains all text symbol of game objects and their states such as
 * hero, monster, power, wall, space and unexplored area.
 *
 * @author Gavin Dang (301368907) + Peter Luong (301355418)
 */
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
