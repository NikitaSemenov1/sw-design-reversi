package reversi.entities;

import reversi.enums.Color;

import java.util.ArrayList;

/**
 * Class storing major coordinate, player color and ArrayList of minorCoordinates of the Move
 */
public class Move {
    public final Color color;
    public final Coordinate majorCoordinate;
    public final ArrayList<Coordinate> minorCoordinates;

    public Move(Color color, Coordinate majorCoordinate, ArrayList<Coordinate> minorCoordinate) {
        this.color = color;
        this.majorCoordinate = majorCoordinate;
        this.minorCoordinates = minorCoordinate;
    }
}
