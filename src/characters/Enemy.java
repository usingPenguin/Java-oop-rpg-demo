package characters;

import abilities.Damageable;
import abilities.Lootable;

public abstract class Enemy implements Damageable, Lootable {
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
