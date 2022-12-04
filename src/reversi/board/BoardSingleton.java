package reversi.board;

public class BoardSingleton {
    private static final Board instance = new Board();
    public static Board getInstance() {
        return instance;
    }
}
