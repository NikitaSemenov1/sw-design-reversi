package reversi.board;

/**
 * Store a singleton of the Board class instance
 */
public class BoardSingleton {
    private static final Board instance = new Board();
    public static Board getInstance() {
        return instance;
    }
}
