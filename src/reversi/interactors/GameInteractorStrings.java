package reversi.interactors;

public class GameInteractorStrings {
    public static final String BOARD_ANNOTATION =
            """
            B - black squares
            W - white squares
            + - possible moves
            . - empty squares
            """;
    public static final String MOVE_ANNOTATION = """
            You can retract your last move by entering '-'.
            Enter a letter signifying a column firstly, and enter a number signifying a row secondly.
            For example: b 3
            """;
    public static final String WHITE_MOVES = "White:\n";
    public static final String BLACK_MOVES = "Black:\n";
}
