package reversi;

import reversi.controller.Controller;
import reversi.controller.ControllerSingleton;
import reversi.entities.Coordinate;
import reversi.players.Player;

public class Game {
    private final Controller controller = ControllerSingleton.getInstance();
    private Player player1, player2;

    public void setup(Player player1, Player player2) {
        controller.setup();
        this.player1 = player1;
        this.player2 = player2;
    }

    void start() {
        while (controller.hasPossibleMove(player1.color) || controller.hasPossibleMove(player2.color)) {
            if (controller.hasPossibleMove(player1.color)) {
                Coordinate move = player1.getMove(controller.getPossibleMoves(player1.color));
                if (move == null) {
                    controller.retract();
                } else {
                    controller.move(player1.color, move);
                }
            }
            if (controller.hasPossibleMove(player2.color)) {
                Coordinate move = player2.getMove(controller.getPossibleMoves(player2.color));
                if (move == null) {
                    controller.retract();
                } else {
                    controller.move(player2.color, move);
                }
            }
        }
    }
}
