package enemies;

import abilities.Attackable;
import abilities.Damageable;
import characters.Enemy;

public class Undead extends Enemy implements Attackable {
    public Undead(double maxHealth, double defense, String name, String loot) {
        super(maxHealth, defense, name, loot);
    }

    @Override
    public void attack(Damageable target) {
        target.takeDamage(getAttackDamage() * 0.4);
    }
}
