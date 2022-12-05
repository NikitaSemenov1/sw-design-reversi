package reversi;

import reversi.board.Square;
import reversi.entities.Coordinate;
import reversi.enums.Color;

import java.util.ArrayList;
import java.util.Arrays;

public class Config {
    public static final int BOARD_SIZE = 8;
    public static final ArrayList<Square> INITIAL_SQUARES = new ArrayList<>(Arrays.asList(
            new Square(new Coordinate(BOARD_SIZE / 2 - 1, BOARD_SIZE / 2 - 1), Color.WHITE),
            new Square(new Coordinate(BOARD_SIZE / 2, BOARD_SIZE / 2), Color.WHITE),
            new Square(new Coordinate(BOARD_SIZE / 2 - 1, BOARD_SIZE / 2), Color.BLACK),
            new Square(new Coordinate(BOARD_SIZE / 2, BOARD_SIZE / 2 - 1), Color.BLACK)
            ));
}
