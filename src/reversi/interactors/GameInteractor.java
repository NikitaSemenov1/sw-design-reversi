package reversi.interactors;

import reversi.controller.ControllerSingleton;
import reversi.entities.Coordinate;
import reversi.enums.Color;
import reversi.interactors.validators.MoveValidator;
import reversi.players.Player;

import java.util.HashSet;

public class GameInteractor {
    protected GameInteractor() {}

    public void printState(Color color) {
        System.out.println(ControllerSingleton.getInstance().serializeBoard(color));
        System.out.print(GameInteractorStrings.BOARD_ANNOTATION);
    }

    public Coordinate enterMove(Player player, HashSet<Coordinate> possibleMoves) {
        System.out.print(GameInteractorStrings.MOVE_ANNOTATION);
        if (player.color == Color.WHITE) {
            System.out.print(GameInteractorStrings.WHITE_MOVES);
        } else {
            System.out.print(GameInteractorStrings.BLACK_MOVES);
        }
        String input;
        MoveValidator moveValidator = new MoveValidator(possibleMoves);
        while (!moveValidator.validate(input = IO.getScanner().nextLine())) {
            System.out.println(Strings.INVALID_INPUT);
        }
        if ("-".equals(input)) {
            return null;
        }
        return new Coordinate(input.charAt(2) - '1', input.charAt(0) - 'a');
    }
}
