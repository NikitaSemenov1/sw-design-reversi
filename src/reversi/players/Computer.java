package reversi.players;

import reversi.board.Board;
import reversi.board.BoardSingleton;
import reversi.entities.Coordinate;
import reversi.enums.Color;
import reversi.players.estimators.Estimator;
import reversi.players.estimators.WeakEstimator;

import java.util.HashSet;

public class Computer extends Player {
    private final Estimator estimator = new WeakEstimator();
    public Computer(Color color, String name) {
        super(color, name);
    }

    @Override
    public Coordinate getMove(HashSet<Coordinate> possibleMoves) {
        double maxValue = -1;
        Coordinate move = null;
        for (var possibleMove : possibleMoves) {
            double currentValue = estimator.estimate(possibleMove, color);
            if (maxValue < currentValue) {
                maxValue = currentValue;
                move = possibleMove;
            }
        }
        return move;
    }
}
