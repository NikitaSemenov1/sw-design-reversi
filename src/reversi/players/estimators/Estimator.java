package reversi.players.estimators;

import reversi.entities.Coordinate;
import reversi.enums.Color;

public interface Estimator {
    double estimate(Coordinate move, Color color);
}
