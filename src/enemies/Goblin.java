package enemies;

import abilities.Attackable;
import abilities.Damageable;
import abilities.Healable;
import characters.Enemy;

public class Goblin extends Enemy implements Attackable, Healable {

    public Goblin(double maxHealth, double defense, String name, String loot) {
        super(maxHealth, defense, name, loot);
    }

    @Override
    public void attack(Damageable target) {
        target.takeDamage(getAttackDamage());
    }

    @Override
    public void heal(double amount) {
        currentHealth += amount;
        if (currentHealth > maxHealth) currentHealth = maxHealth;
    }
}
