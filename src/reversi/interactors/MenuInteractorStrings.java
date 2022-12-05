package reversi.interactors;

public class MenuInteractorStrings {
    public static final String EXIT = "EXIT";
    public static final String VS_HUMAN = "1";
    public static final String VS_COMPUTER = "2";
    public static final String ENTER_MODE = String.format(
            """
            Enter the game mode:
            %s - vs Human
            %s - vs Computer
            Enter '%s' to quit the game.
            """,
            VS_HUMAN, VS_COMPUTER, EXIT
    );

    public static final String RESULT =
            """
            %s's score: %d
            %s's score: %d
            """;

    public static final String WINNER =
                    """
                    Winner: %s
                    """;
}
