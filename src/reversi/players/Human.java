package reversi.players;

import reversi.entities.Coordinate;
import reversi.enums.Color;

import reversi.interactors.GameInteractorSingleton;

import java.util.HashSet;

/**
 * Class implementing human behaviour
 */
public class Human extends Player {
    public Human(Color color, String name) {
        super(color, name);
    }

    @Override
    public Coordinate getMove(HashSet<Coordinate> possibleMoves) {
        GameInteractorSingleton.getInstance().printState(color);
        return GameInteractorSingleton.getInstance().enterMove(this, possibleMoves);
    }
}
