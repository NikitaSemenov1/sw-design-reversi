package reversi.players.estimators;

import reversi.Config;
import reversi.board.Board;
import reversi.board.BoardSingleton;
import reversi.entities.Coordinate;
import reversi.entities.Move;
import reversi.enums.Color;

import java.util.ArrayList;

/**
 * Class estimating value of the move. Implements Estimator interface
 */
public class WeakEstimator implements Estimator {

    private final Board board = BoardSingleton.getInstance();

    private double getMajorValue(Coordinate majorCoordinate) {
        int minCoordinate = Math.min(majorCoordinate.x, majorCoordinate.y);
        int maxCoordinate = Math.max(majorCoordinate.x, majorCoordinate.y);
        if (maxCoordinate == 0 || minCoordinate == Config.BOARD_SIZE - 1 || minCoordinate == 0 && maxCoordinate == Config.BOARD_SIZE - 1) {
            return WeakEstimatorConstants.CORNER_MAJOR_VALUE;
        } else if (minCoordinate == 0 || maxCoordinate == Config.BOARD_SIZE - 1) {
            return WeakEstimatorConstants.SIDE_MAJOR_VALUE;
        }
        return WeakEstimatorConstants.INNER_MAJOR_VALUE;
    }

    private double getLockedValue(Coordinate lockedCoordinate) {
        int minCoordinate = Math.min(lockedCoordinate.x, lockedCoordinate.y);
        int maxCoordinate = Math.max(lockedCoordinate.x, lockedCoordinate.y);
        if (minCoordinate == 0 || maxCoordinate == Config.BOARD_SIZE - 1) {
            return WeakEstimatorConstants.SIDE_LOCKED_VALUE;
        }
        return WeakEstimatorConstants.INNER_LOCKED_VALUE;
    }
    @Override
    public double estimate(Coordinate majorCoordinate, Color color) {
        double value = getMajorValue(majorCoordinate);
        Move move = new Move(color, majorCoordinate, board.getMinorCoordinates(majorCoordinate, color));
        for (var minorCoordinate : move.minorCoordinates) {
            ArrayList<Coordinate> lockedCoordinates = board.getLockedCoordinates(majorCoordinate, minorCoordinate);
            for (var lockedCoordinate : lockedCoordinates) {
                value += getLockedValue(lockedCoordinate);
            }
        }
        return value;
    }
}
