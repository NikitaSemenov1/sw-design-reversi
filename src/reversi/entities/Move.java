package reversi.entities;

import reversi.enums.Color;

import java.util.ArrayList;

public class Move {
    public final Color color;
    public final Coordinate majorCoordinate;
    public final ArrayList<Coordinate> minorCoordinate;

    public Move(Color color, Coordinate majorCoordinate, ArrayList<Coordinate> minorCoordinate) {
        this.color = color;
        this.majorCoordinate = majorCoordinate;
        this.minorCoordinate = minorCoordinate;
    }
}
