package game;

import characters.Enemy;
import characters.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Game {

    private final Player player;
    private final BattleSystem battleSystem;

    public Game(Player player) {
        this.player = player;
        this.battleSystem = new BattleSystem();
    }

    public void startLevel(int level) {
        if (level < 0 || level > 3) return;

        LevelResult result = battleSystem.startBattle(player, getLevel(level));
        if (result == LevelResult.LEVEL_CLEARED) {
            System.out.println("Der Spieler hat gewonnen!");
        } else {
            System.out.println("Der Spieler hat verloren!");
        }
    }

    private ArrayList<Enemy> getLevel(int level) {
        return switch (level) {
            case 1 -> Level.startLevelOne();
            case 2 -> Level.startLevelTwo();
            case 3 -> Level.startLevelThree();
            default -> throw new IllegalStateException("Inbekanntes Level: " + level);
        };
    }
}