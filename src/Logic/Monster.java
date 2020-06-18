package Logic;

import java.util.ArrayList;
import java.util.Random;

public class Monster {
    private Cell currentPosition;
    private Cell nextMove;
    private String monsterString;

    public Monster(Cell currentPosition, String monster) {
        this.currentPosition = currentPosition;
        this.monsterString = monster;
    }

    public Cell getCurrentPosition() {
        return currentPosition;
    }

    public String getMonsterString() {
        return monsterString;
    }

    public Cell getNextMove() {
        return nextMove;
    }

    public void setCurrentPosition(Cell currentPosition) {
        this.currentPosition = currentPosition;
    }

    public void setNextMove(Cell nextMove) {
        this.nextMove = nextMove;
    }

    public void setMonsterString(String monsterString) {
        this.monsterString = monsterString;
    }

    public void randomMove() {
        Random random = new Random();
        CellManager availableMoves = currentPosition.getAvailableMoves(currentPosition);
        int ran = random.nextInt(availableMoves.getSize());
        nextMove = availableMoves.get(ran);
    }
}
