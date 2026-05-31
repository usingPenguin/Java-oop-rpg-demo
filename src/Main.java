import characters.Player;
import game.Game;

public class Main {
    static void main() {
        Player player = new Player(100, 4000);
        Game game = new Game(player);

        game.startLevel(2);
    }
}
