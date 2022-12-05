package reversi.interactors;

import reversi.board.BoardSingleton;
import reversi.enums.Color;
import reversi.enums.GameMode;
import reversi.interactors.validators.GameModeValidator;
import reversi.interactors.validators.Validator;
import reversi.players.Player;

import java.util.Scanner;

public class MenuInteractor {
    public static GameMode enterMode() {
        System.out.print(MenuInteractorStrings.ENTER_MODE);

        String input;
        Validator validator = new GameModeValidator();

        while (!validator.validate(input = IO.getScanner().nextLine())) {
            System.out.println(Strings.INVALID_INPUT);
        }

        if (MenuInteractorStrings.VS_COMPUTER.equals(input)) {
            return GameMode.VS_COMPUTER;
        } else if (MenuInteractorStrings.VS_HUMAN.equals(input)) {
            return GameMode.VS_HUMAN;
        }
        return null;
    }

    public static void printResult(Player whitePlayer, Player blackPlayer) {
        int whiteScore = BoardSingleton.getInstance().getSquareNumber(Color.WHITE);
        int blackScore = BoardSingleton.getInstance().getSquareNumber(Color.BLACK);

        System.out.print(String.format(
                MenuInteractorStrings.RESULT, whitePlayer.name, whiteScore, blackPlayer.name, blackScore)
        );
        System.out.print(String.format(
                MenuInteractorStrings.WINNER, (whitePlayer == blackPlayer ? "Tie" :
                        (whiteScore > blackScore ? whitePlayer.name : blackPlayer.name)))
        );
    }
}
