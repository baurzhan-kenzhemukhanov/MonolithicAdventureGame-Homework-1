package items;

import interfaces.*;

public class MagicScroll implements IItem {
    @Override
    public String getName() {
        return "Magic Scroll";
    }

    @Override
    public IEntityType.EntityType getType() {
        return IEntityType.EntityType.ITEM;
    }

    @Override
    public IItemType.ItemType getItemType() {
        return IItemType.ItemType.EXPERIENCE_SCROLL;
    }

    @Override
    public void use(ICombatant target) {
        target.setExperience(target.getExperience() + 15);
    }
} 
