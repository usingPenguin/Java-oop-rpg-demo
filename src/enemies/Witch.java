package enemies;

import abilities.Attackable;
import abilities.Damageable;
import abilities.Healable;
import characters.Enemy;

import java.util.Random;

public class Witch extends Enemy implements Attackable, Healable {
    private final double healingPower;

    public Witch(double maxHealth, double defense, String name, String loot, double healingPower) {
        super(maxHealth, defense, name, loot);
        this.healingPower = healingPower;
    }

    public <T extends Enemy & Healable> void castHealing(T ally) {
        if (ally != null) {
            System.out.println("Die Hexe heilt " + ally.getName() + ".\n");
            System.out.println(ally.getName() + " hat jetzt: " + ally.getCurrentHealth() + " Leben.");
            ally.heal(healingPower);
        }

        heal(healingPower);
    }

    @Override
    public void attack(Damageable target) {
        Random rand = new Random();
        target.takeDamage(rand.nextDouble(getAttackDamage() * 1.5));
    }

    @Override
    public void heal(double amount) {
        currentHealth += amount * 2; // Hexe ist erlaubt zu "overhealen".
    }
}
