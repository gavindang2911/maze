package Logic;

import java.util.ArrayList;
import java.util.List;

public class PowerManager {
    private List<Power> powerList = new ArrayList<>();
    private int size;

    public PowerManager() {
        this.size = 0;
    }

    public List<Power> getPowerList() {
        return powerList;
    }

    public int getSize() {
        return size;
    }
    public void add(Power power) {
        powerList.add(power);
        this.size++;
        return;
    }
    public void remove(Power power) {
       powerList.remove(power);
       return;
    }
}
