package characters;

import abilities.Attackable;
import abilities.Damageable;
import abilities.Lootable;

public abstract class Enemy implements Attackable, Damageable, Lootable {
    private static int livingEnemies = 0;

    protected double maxHealth;
    protected double currentHealth;
    protected double defense;
    protected String name;
    protected String loot;

    public Enemy(double maxHealth, double defense, String name, String loot) {
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.defense = defense;
        this.name = name;
        this.loot = loot;

        livingEnemies++;
    }

    public static int getLivingEnemies() {
        return livingEnemies;
    }

    public void die() {
        livingEnemies--;
    }

    public String getName() {
        return name;
    }

    public double getCurrentHealth() {
        return currentHealth;
    }

    @Override
    public void takeDamage(double damage) {
        currentHealth -= damage * ((100-defense) / 100); // Berechnet den Schadenskoeffizienten anhand der Verteidigung
    }

    @Override
    public boolean isAlive() {
        return currentHealth > 0;
    }

    @Override
    public void dropLoot() {
        System.out.println(name + " hat folgendes gedroppt: " + loot);
    }
}
