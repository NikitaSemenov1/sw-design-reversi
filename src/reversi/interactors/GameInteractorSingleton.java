package reversi.interactors;

public class GameInteractorSingleton {
    private static final GameInteractor instance = new GameInteractor();

    public static GameInteractor getInstance() {
        return instance;
    }
}
