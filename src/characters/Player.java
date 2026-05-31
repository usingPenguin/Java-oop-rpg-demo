package characters;

import abilities.Attackable;
import abilities.Damageable;
import abilities.Healable;

import java.util.Random;

public class Player implements Attackable, Damageable, Healable {
    private final double maxHealth;
    private double currentHealth;
    private final double attackDamage;
    private double defense;

    public Player(double attackDamage, double maxHealth) {
        this.attackDamage = attackDamage;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
    }

    @Override
    public void attack(Damageable target) {
        Random rand = new Random();

        // Falls zufällig 3 generiert wird gibt es einen kritischen Angriff.
        if(rand.nextInt(6) == 3) {
            target.takeDamage(attackDamage * 2.5);
        } else {
            target.takeDamage(attackDamage);
        }
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
    public void die() {
        System.out.println("Game Over");
    }

    @Override
    public void heal(double amount) {
        this.currentHealth += amount;
        if (currentHealth > maxHealth) currentHealth = maxHealth;
    }
}
