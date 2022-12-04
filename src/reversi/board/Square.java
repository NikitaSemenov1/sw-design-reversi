package reversi.board;

import reversi.Config;
import reversi.entities.Coordinate;
import reversi.enums.Color;

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

    public void reverseColor() {
        color = Color.getOppositeColor(color);
    }
}
