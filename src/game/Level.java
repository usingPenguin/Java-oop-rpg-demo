package game;

import characters.Enemy;
import enemies.Goblin;
import enemies.Undead;
import enemies.Witch;

import java.util.ArrayList;
import java.util.List;

public abstract class Level {
    public static ArrayList<Enemy> startLevelOne() {
        return new ArrayList<>(List.of(
                new Undead(250, 10, "Larry", "Nichts"),
                new Undead(250, 10, "Harry", "Nichts"),
                new Goblin(500, 60, "Goblina", "Speer")
        ));
    }

    public static ArrayList<Enemy> startLevelTwo() {
        return new ArrayList<>(List.of(
                new Undead(250, 10, "Garry", "Knochen"),
                new Goblin(450, 50, "Goblerone", "Nichts"),
                new Witch(400, 30, "Bibi Blocksberg", "Heiltrank", 100)
        ));
    }

    public static ArrayList<Enemy> startLevelThree() {
        return new ArrayList<>(List.of(
                new Goblin(550, 50, "Goblabla", "Nichts"),
                new Witch(400, 40, "Hekate", "Weisheit", 50),
                new Witch(600, 67, "Hermine", "Zauberstab", 150)
        ));
    }
}
