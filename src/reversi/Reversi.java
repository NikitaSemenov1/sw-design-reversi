package reversi;

import reversi.board.BoardSingleton;
import reversi.enums.Color;
import reversi.enums.GameMode;
import reversi.interactors.MenuInteractor;
import reversi.players.Computer;
import reversi.players.Human;
import reversi.players.Player;

/**
 * Class implementing single session logic
 */
public class Reversi {

    /**
     * Whole session. GameMode choosing logic.
     */
    public static void start() {
        Game game = new Game();

        int bestScoreVsComputer = 0, winsVsComputer = 0;

        while(true) {
            GameMode mode = MenuInteractor.enterMode();
            if (mode == null) {
                MenuInteractor.printBestScoreVsComputer(bestScoreVsComputer, winsVsComputer);
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

            if (mode == GameMode.VS_COMPUTER) {
                int playerScore = BoardSingleton.getInstance().getSquareNumber(Color.WHITE);
                int computerScore = BoardSingleton.getInstance().getSquareNumber(Color.BLACK);

                bestScoreVsComputer = Math.max(bestScoreVsComputer, playerScore);

                if (computerScore < playerScore) {
                    winsVsComputer++;
                }
            }
            MenuInteractor.printResult(whitePlayer, blackPlayer);
        }
    }
}
