package interfaces;

public interface IItem extends IEntity {

    void use(ICombatant target);

    IItemType.ItemType getItemType();
}

enum ItemType {
    HEALTH_POTION,
    EXPERIENCE_SCROLL,
    GOLD
}
