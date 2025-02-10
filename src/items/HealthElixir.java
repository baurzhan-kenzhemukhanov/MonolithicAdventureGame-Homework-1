package items;

import interfaces.*;

public class HealthElixir implements IItem {
    @Override
    public String getName() {
        return "Health Elixir";
    }

    @Override
    public IEntityType.EntityType getType() {
        return IEntityType.EntityType.ITEM;
    }

    @Override
    public IItemType.ItemType getItemType() {
        return IItemType.ItemType.HEALTH_POTION;
    }

    @Override
    public void use(ICombatant target) {
        target.setHealth(target.getHealth() + 20);
    }
} 
