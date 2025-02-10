package enemies;

import interfaces.*;

public abstract class Enemy implements ICombatant {
    protected String name;
    protected int health;
    protected int experience;
    protected int baseDamage;

    protected Enemy(String name, int health, int experience, int baseDamage) {
        this.name = name;
        this.health = health;
        this.experience = experience;
        this.baseDamage = baseDamage;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public IEntityType.EntityType getType() {
        return IEntityType.EntityType.ENEMY;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public void setHealth(int health) {
        this.health = Math.max(0, health);
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
        return baseDamage;
    }

    public boolean isAlive() {
        return health > 0;
    }
} 
