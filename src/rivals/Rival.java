package rivals;

import interfaces.*;

public abstract class Rival implements ICombatant {
    private String alias;
    private int healthPoints;
    private int experiencePoints;
    private int attackStrength;

    protected Rival(String alias, int healthPoints, int experiencePoints, int attackStrength) {
        this.alias = alias;
        this.healthPoints = healthPoints;
        this.experiencePoints = experiencePoints;
        this.attackStrength = attackStrength;
    }

    @Override
    public String getName() {
        return alias;
    }

    @Override
    public IEntityType.EntityType getType() {
        return IEntityType.EntityType.RIVAL;
    }

    @Override
    public int getHealth() {
        return healthPoints;
    }

    @Override
    public void setHealth(int healthPoints) {
        this.healthPoints = Math.max(0, healthPoints);
    }

    @Override
    public int getExperience() {
        return experiencePoints;
    }

    @Override
    public void setExperience(int experiencePoints) {
        this.experiencePoints = experiencePoints;
    }

    @Override
    public void takeDamage(int damage) {
        setHealth(this.healthPoints - damage);
    }

    @Override
    public int dealDamage() {
        return attackStrength;
    }

    public boolean isDefeated() {
        return healthPoints <= 0;
    }
}
