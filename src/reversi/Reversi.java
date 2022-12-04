package reversi;

import reversi.enums.Color;
import reversi.enums.GameMode;
import reversi.interactors.MenuInteractor;
import reversi.players.Human;
import reversi.players.Player;

public class Reversi {

    public static void start() {
        Game game = new Game();
        while(true) {
            GameMode mode = MenuInteractor.enterMode();
            Player whitePlayer = new Human(Color.WHITE, "Player 1");
            Player blackPlayer = new Human(Color.BLACK, "Player 2");
            game.setup(
                    whitePlayer,
                    blackPlayer
            );
            game.start();
            MenuInteractor.printResult(whitePlayer, blackPlayer);
        }
    }
}
