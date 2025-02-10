package player;

import interfaces.*;
import java.util.LinkedList;
import java.util.List;

public class Player implements ICombatant {
    private final String name;
    private int health;
    private int experience;
    private final List<IItem> inventory;

    public Player(String name) {
        this.name = name;
        this.health = 100;
        this.experience = 0;
        this.inventory = new LinkedList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public IEntityType.EntityType getType() {
        return IEntityType.EntityType.PLAYER;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public void setHealth(int newHealth) {
        health = Math.max(0, Math.min(100, newHealth));
    }

    @Override
    public int getExperience() {
        return experience;
    }

    @Override
    public void setExperience(int xp) {
        experience = xp;
    }

    @Override
    public void takeDamage(int damage) {
        setHealth(health - damage);
    }

    @Override
    public int dealDamage() {
        return 20 + experience / 10;
    }

    public void addItemToInventory(IItem item) {
        if (item != null) {
            inventory.add(item);
        }
    }

    public List<IItem> retrieveInventory() {
        return new LinkedList<>(inventory);
    }

    public boolean isStillAlive() {
        return health > 0;
    }
}
