package player;

import interfaces.*;
import java.util.ArrayList;
import java.util.List;

public class Player implements ICombatant {
    private String name;
    private int health;
    private int experience;
    private List<IItem> inventory;

    public Player(String name) {
        this.name = name;
        this.health = 100;
        this.experience = 0;
        this.inventory = new ArrayList<>();
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
    public void setHealth(int health) {
        this.health = Math.max(0, Math.min(100, health));
    }

    @Override
    public int getExperience() {
        return experience;
    }

    @Override
    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public void takeDamage(int damage) {
        setHealth(health - damage);
    }

    @Override
    public int dealDamage() {
        return 20 + (experience / 10); 
    }

    public void addItem(IItem item) {
        inventory.add(item);
    }

    public List<IItem> getInventory() {
        return new ArrayList<>(inventory);
    }

    public boolean isAlive() {
        return health > 0;
    }
} 
