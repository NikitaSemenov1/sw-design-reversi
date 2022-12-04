package reversi.interactors.validators;

import com.sun.jdi.VMOutOfMemoryException;
import reversi.Config;
import reversi.entities.Coordinate;

import java.util.HashSet;

public class MoveValidator implements Validator {
    HashSet<Coordinate> possibleMoves;
    public MoveValidator(HashSet<Coordinate> possibleMoves) {
        this.possibleMoves = possibleMoves;
    }

    private boolean moveFormatValidate(String input) {
        return input.length() == 3 &&
                'a' <= input.charAt(0) && input.charAt(0) <= 'a' + Config.BOARD_SIZE - 1 &&
                input.charAt(1) == ' ' &&
                '1' <= input.charAt(2) && input.charAt(2) <= '1' + Config.BOARD_SIZE - 1;
    }
    private boolean moveValidate(String input) {
        return moveFormatValidate(input) && possibleMoves.contains(new Coordinate(input.charAt(2) - '1', input.charAt(0) - 'a'));
    }

    private boolean retractValidate(String input) {
        return "-".equals(input);
    }
    @Override
    public boolean validate(String input) {
        return retractValidate(input) || moveValidate(input);
    }
}
