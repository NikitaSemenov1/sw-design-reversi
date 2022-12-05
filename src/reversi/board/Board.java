package reversi.board;

import reversi.Config;
import reversi.entities.Coordinate;
import reversi.entities.Move;
import reversi.enums.Color;

import java.util.ArrayList;

/**
 * Color setting board behavior.
 */
public class Board {
    private final int size = Config.BOARD_SIZE;
    private final Square[][] field = new Square[size][size];

    protected Board() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                field[row][col] = new Square(new Coordinate(row, col));
            }
        }

        setup();
    }

    /**
     * Clear board. Place initials Squares.
     */
    public void setup() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                field[row][col].color = Color.NONE;
            }
        }

        for (Square initialSquare : Config.INITIAL_SQUARES) {
            int x = initialSquare.coordinate.x;
            int y = initialSquare.coordinate.y;
            field[x][y].color = initialSquare.color;
        }
    }

    /**
     * find, if existed, a minor(locking) coordinate for a given direction and major(move) coordinate
     *
     * @param majorCoordinate  major(move) coordinate
     * @param color  player color
     * @param dx  vertical direction
     * @param dy  horizontal direction
     * @return  minor coordinate if exist
     */
    private Coordinate getMinorCoordinate(Coordinate majorCoordinate, Color color, int dx, int dy) {
        Coordinate minorCoordinate = null;
        for (int x = majorCoordinate.x + dx, y = majorCoordinate.y + dy; 0 <= x && x < size && 0 <= y && y < size; x += dx, y += dy) {
            if (field[x][y].color == color) {
                if (majorCoordinate.x + dx != x || majorCoordinate.y + dy != y) {
                    minorCoordinate = field[x][y].coordinate;
                }
                break;
            } else if (field[x][y].color == Color.NONE) {
                break;
            }
        }
        return minorCoordinate;
    }

    /**
     * Return ArrayList of minor(locking) coordinates for a given major(move) coordinate
     *
     * @param majorCoordinate  major coordinate
     * @param color  player color
     * @return  ArrayList of minor coordinates
     */
    public ArrayList<Coordinate> getMinorCoordinates(Coordinate majorCoordinate, Color color) {
        ArrayList<Coordinate> minorCoordinates = new ArrayList<>();
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if (dx * dx + dy * dy != 0) {
                    Coordinate minorCoordinate = getMinorCoordinate(majorCoordinate, color, dx, dy);
                    if (minorCoordinate != null) {
                        minorCoordinates.add(minorCoordinate);
                    }
                }
            }
        }
        return minorCoordinates;
    }

    /**
     * @return  size of the board
     */
    public int getSize() {
        return size;
    }

    /**
     * @param row  vertical coordinate
     * @param col  horizontal coordinate
     * @return the color of the square located at (row, col) coordinates
     */
    public Color getSquareColor(int row, int col) {
        return field[row][col].color;
    }

    private int getD(int major, int minor) {
        return major == minor ? 0 : (minor - major) / Math.abs(minor - major);
    }

    private void reverseBetween(Coordinate majorCoordinate, Coordinate minorCoordinate) {
        int dx = getD(majorCoordinate.x, minorCoordinate.x);
        int dy = getD(majorCoordinate.y, minorCoordinate.y);
        for (int x = majorCoordinate.x + dx, y = majorCoordinate.y + dy; x != minorCoordinate.x || y != minorCoordinate.y; x += dx, y += dy) {
            field[x][y].reverseColor();
        }
    }

    private void reverse(Coordinate majorCoordinate, ArrayList<Coordinate> minorCoordinates) {
        for (var minorCoordinate : minorCoordinates) {
            reverseBetween(majorCoordinate, minorCoordinate);
        }
    }

    /**
     * Change square colors for the move at the given coordinates
     *
     * @param color  player color
     * @param coordinate  move coordinate
     * @return  Move instance
     */
    public Move move(Color color, Coordinate coordinate) {
        Move move = new Move(color, coordinate, getMinorCoordinates(coordinate, color));

        field[coordinate.x][coordinate.y].color = color;

        reverse(move.majorCoordinate, move.minorCoordinates);

        return move;
    }

    /**
     * change square colors for the given move retracting.
     *
     * @param move  last Move instance
     */
    public void retract(Move move) {
        field[move.majorCoordinate.x][move.majorCoordinate.y].color = Color.NONE;

        reverse(move.majorCoordinate, move.minorCoordinates);
    }

    /**
     * @param color  given color
     * @return  return the number of given color squares
     */
    public int getSquareNumber(Color color) {
        int squareNumber = 0;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (getSquareColor(col, row) == color) {
                    squareNumber++;
                }
            }
        }
        return squareNumber;
    }

    /**
     * @param majorCoordinate  coordinate of the given major(move) square
     * @param minorCoordinate  coordinate of the given minor(locking) square
     * @return  ArrayList of locked squares between minor and major squares
     */
    public ArrayList<Coordinate> getLockedCoordinates(Coordinate majorCoordinate, Coordinate minorCoordinate) {
        ArrayList<Coordinate> lockedCoordinates = new ArrayList<>();
        int dx = getD(majorCoordinate.x, minorCoordinate.x);
        int dy = getD(majorCoordinate.y, minorCoordinate.y);
        for (int x = majorCoordinate.x + dx, y = majorCoordinate.y + dy; x != minorCoordinate.x || y != minorCoordinate.y; x += dx, y += dy) {
            lockedCoordinates.add(field[x][y].coordinate);
        }
        return lockedCoordinates;
    }
}
