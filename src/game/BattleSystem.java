package game;

import abilities.Healable;
import characters.Enemy;
import characters.Player;
import enemies.Witch;

import java.util.ArrayList;
import java.util.Random;

public class BattleSystem {

    public LevelResult startBattle(Player player, ArrayList<Enemy> enemies) {
        System.out.println("Das Battle beginnt!");

        while (player.isAlive()) {
            playerTurn(player, enemies);

            if (Enemy.getLivingEnemies() <= 0) break;

            enemyTurn(player, enemies);
        }

        if (player.isAlive()) {
            System.out.println("Der Spieler hat alle Monster bezwungen!");
            return LevelResult.LEVEL_CLEARED;
        } else {
            return LevelResult.GAME_OVER;
        }
    }

    private void playerTurn(Player player, ArrayList<Enemy> enemies) {
        Enemy chosenEnemy = getRandomEnemy(enemies);

        System.out.println("Der Spieler greift " + chosenEnemy.getName() + " an!");

        player.attack(chosenEnemy);
        if (!chosenEnemy.isAlive()) {
            System.out.println("Der Spieler hat " + chosenEnemy.getName() + " besiegt!");
            chosenEnemy.die();
            enemies.remove(chosenEnemy);
        } else {
            System.out.println(chosenEnemy.getName() + " hat mit " + chosenEnemy.getCurrentHealth() + " Leben überlebt!");
        }

        System.out.println("\n");
    }

    private void enemyTurn(Player player, ArrayList<Enemy> enemies) {
        Enemy chosenEnemy = getRandomEnemy(enemies);

        chosenEnemy.attack(player);

        if(player.isAlive()) {
            System.out.printf(
                    "%s hat den Spieler angegriffen, er hat jetzt noch: %.2f Leben.%n",
                    chosenEnemy.getName(),
                    player.getCurrentHealth()
            );
        } else {
            System.out.println(chosenEnemy.getName() + " hat den Spieler bezwungen!");
        }

        if (!(chosenEnemy instanceof Witch witch)) return;
        performRandomHealingSpell(witch, enemies);

        System.out.println("\n");
    }

    private void performRandomHealingSpell(Witch witch, ArrayList<Enemy> enemies) {
        Random rand = new Random();
        int luckyNumber = rand.nextInt(10);

        switch (luckyNumber) {
            // Jackpot -> Heilt alle Monster und sich selbst massiv
            case 7: {
                System.out.println("Eine Hexe hat den Jackpot geknackt! Heilung für alle Monster!");
                healAllMonsters(witch, enemies);
            }
            // Gut -> Heilt sich und wenn möglich ein Monster
            case 3: {
                System.out.println("Eine Hexe versucht ein Monster zu heilen!");
                tryHealOne(witch, getRandomEnemy(enemies));
            }
            // Okay -> Heilt sich selst
            case 0: {
                System.out.println("Die Hexe hat sich selbst geheilt!");
                witch.castHealing(null);
            }
        }
    }

    private Enemy getRandomEnemy(ArrayList<Enemy> enemies) {
        Random rand = new Random();

        // Sucht zufällig einen Gegner aus der ArrayList aus.
        int idx = rand.nextInt(enemies.size());
        return enemies.get(idx);
    }

    private void healAllMonsters(Witch witch, ArrayList<Enemy> enemies) {
        for (Enemy enemy : enemies) {
            if (enemy instanceof Healable) {
                witch.castHealing((Enemy & Healable) enemy);
            }
        }
    }

    private void tryHealOne(Witch witch, Enemy enemy) {
        if (enemy instanceof Healable monster) {
            witch.castHealing((Enemy & Healable) monster);
        } else {
            witch.castHealing(null);
        }
    }
}
