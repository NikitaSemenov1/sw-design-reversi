package reversi.controller;

/**
 * Store a singleton of the Controller class instance
 */
public class ControllerSingleton {
    private static final Controller instance = new Controller();
    public static Controller getInstance() {
        return instance;
    }
}
