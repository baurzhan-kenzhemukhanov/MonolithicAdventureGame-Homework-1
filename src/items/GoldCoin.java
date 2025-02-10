package items;

import interfaces.*;

public class GoldCoin implements IItem {
    @Override
    public String getName() {
        return "Gold Coin";
    }

    @Override
    public IEntityType.EntityType getType() {
        return IEntityType.EntityType.ITEM;
    }

    @Override
    public IItemType.ItemType getItemType() {
        return IItemType.ItemType.GOLD;
    }

    @Override
    public void use(ICombatant target) {
        target.setExperience(target.getExperience() + 5);
    }
} 
