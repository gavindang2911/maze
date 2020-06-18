package Logic;

public class Hero {
    private Cell currentPosition;
    private String heroString;

    public Hero(Cell currentPosition, String hero) {
        this.currentPosition = currentPosition;
        this.heroString = hero;
    }

    public Cell getCurrentPosition() {
        return currentPosition;
    }

    public String getHeroString() {
        return heroString;
    }
}
