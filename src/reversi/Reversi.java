package reversi;

import reversi.enums.Color;
import reversi.enums.GameMode;
import reversi.interactors.MenuInteractor;
import reversi.players.Computer;
import reversi.players.Human;
import reversi.players.Player;

public class Reversi {

    public static void start() {
        Game game = new Game();
        while(true) {
            GameMode mode = MenuInteractor.enterMode();
            if (mode == null) {
                break;
            }
            Player whitePlayer, blackPlayer;
            if (mode == GameMode.VS_HUMAN) {
                whitePlayer = new Human(Color.WHITE, "Player1");
                blackPlayer = new Human(Color.BLACK, "Player2");
            } else {
                whitePlayer = new Human(Color.WHITE, "Player");
                blackPlayer = new Computer(Color.BLACK, "Computer");
            }
            game.setup(
                    whitePlayer,
                    blackPlayer
            );
            game.start();
            MenuInteractor.printResult(whitePlayer, blackPlayer);
        }
    }
}
