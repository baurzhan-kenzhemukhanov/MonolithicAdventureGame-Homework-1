package managers;

import java.util.ArrayList;
import java.util.List;
import interfaces.*;
import rivals.*;
import items.*;

public class LevelManager {
    private int currentLevel;
    private List<Rival> rivals;
    private List<IItem> items;

    public LevelManager() {
        this.currentLevel = 1;
        this.rivals = new ArrayList<>();
        this.items = new ArrayList<>();
        initializeLevel();
    }

    public void initializeLevel() {
        rivals.clear();
        items.clear();

        switch (currentLevel) {
            case 1:
                rivals.add(new Orcs());
                rivals.add(new Dwarfs());
                items.add(new GoldCoin());
                items.add(new HealthElixir());
                break;
            case 2:
                enemies.add(new Elves());
                items.add(new MagicScroll());
                break;
            case 3:
                enemies.add(new Elves());
                enemies.add(new Dwarfs());
                items.add(new HealthElixir());
                items.add(new GoldCoin());
                break;
        }
    }

    public boolean advanceLevel() {
        if (currentLevel < 3) {
            currentLevel++;
            initializeLevel();
            System.out.println("Advanced to level " + currentLevel);
            return true;
        }
        return false;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public List<Rival> getRivals() {
        return new ArrayList<>(rivals);
    }

    public List<IItem> getItems() {
        return new ArrayList<>(items);
    }

    public void removeRival(Rival rival) {
        rival.remove(rival);
    }

    public void removeItem(IItem item) {
        items.remove(item);
    }

    public boolean isLevelComplete() {
        return enemies.isEmpty() && items.isEmpty();
    }
} 
