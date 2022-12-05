package reversi.interactors;

/**
 * Store a singleton of the GameInteractor class instance
 */
public class GameInteractorSingleton {
    private static final GameInteractor instance = new GameInteractor();

    public static GameInteractor getInstance() {
        return instance;
    }
}
