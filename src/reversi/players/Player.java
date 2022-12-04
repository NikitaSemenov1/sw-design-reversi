package reversi.players;

import reversi.entities.Coordinate;
import reversi.enums.Color;

import java.util.HashSet;

public abstract class Player {
    public final Color color;
    public final String name;

    protected Player(Color color, String name) {
        this.color = color;
        this.name = name;
    }
    public abstract Coordinate getMove(HashSet<Coordinate> possibleMoves);
}
