package managers;

import java.util.ArrayList;
import java.util.List;
import interfaces.*;
import enemies.*;
import items.*;

public class LevelManager {
    private int currentLevel;
    private List<Enemy> enemies;
    private List<IItem> items;

    public LevelManager() {
        this.currentLevel = 1;
        this.enemies = new ArrayList<>();
        this.items = new ArrayList<>();
        initializeLevel();
    }

    public void initializeLevel() {
        enemies.clear();
        items.clear();

        switch (currentLevel) {
            case 1:
                enemies.add(new Skeleton());
                enemies.add(new Zombie());
                items.add(new GoldCoin());
                items.add(new HealthElixir());
                break;
            case 2:
                enemies.add(new Vampire());
                items.add(new MagicScroll());
                break;
            case 3:
                enemies.add(new Vampire());
                enemies.add(new Zombie());
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

    public List<Enemy> getEnemies() {
        return new ArrayList<>(enemies);
    }

    public List<IItem> getItems() {
        return new ArrayList<>(items);
    }

    public void removeEnemy(Enemy enemy) {
        enemies.remove(enemy);
    }

    public void removeItem(IItem item) {
        items.remove(item);
    }

    public boolean isLevelComplete() {
        return enemies.isEmpty() && items.isEmpty();
    }
} 
