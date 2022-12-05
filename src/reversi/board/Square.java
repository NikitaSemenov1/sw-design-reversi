package reversi.board;

import reversi.entities.Coordinate;
import reversi.enums.Color;

/**
 * Class containing coordinates and a color of the square
 */
public class Square {
    Color color = Color.NONE;
    final Coordinate coordinate;

    public Square(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Square(Coordinate coordinate, Color color) {
        this(coordinate);
        this.color = color;
    }

    /**
     * Reverse color of the square
     */
    public void reverseColor() {
        color = Color.getOppositeColor(color);
    }
}
