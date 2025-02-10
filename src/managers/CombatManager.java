package managers;

import interfaces.ICombatant;

public class CombatManager {
    public void processCombat(ICombatant attacker, ICombatant defender) {
        System.out.println(attacker.getName() + " engages in combat with " + defender.getName() + "!");
        
        int damage = attacker.dealDamage();
        defender.takeDamage(damage);
        
        System.out.println(attacker.getName() + " deals " + damage + " damage to " + defender.getName());
        System.out.println(defender.getName() + " health: " + defender.getHealth());
        
        if (defender.getHealth() > 0) {
            damage = defender.dealDamage();
            attacker.takeDamage(damage);
            System.out.println(defender.getName() + " counter-attacks for " + damage + " damage");
            System.out.println(attacker.getName() + " health: " + attacker.getHealth());
        }
    }
} 
