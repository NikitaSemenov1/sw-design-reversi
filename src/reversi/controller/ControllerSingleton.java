package reversi.controller;

public class ControllerSingleton {
    private static final Controller instance = new Controller();
    public static Controller getInstance() {
        return instance;
    }
}
