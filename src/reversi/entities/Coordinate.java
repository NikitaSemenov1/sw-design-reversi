package reversi.entities;

import reversi.Config;

public class Coordinate {
    public final int x, y;
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (getClass() != object.getClass()) {
            return false;
        }
        Coordinate coordinate = (Coordinate) object;
        return x == coordinate.x && y == coordinate.y;
    }

    @Override
    public int hashCode() {
        return x * Config.BOARD_SIZE + y;
    }
}
