package reversi.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

import reversi.board.BoardSingleton;
import reversi.entities.Coordinate;
import reversi.entities.Move;
import reversi.enums.Color;
import reversi.board.Board;

public class Controller {
    private final Stack<Move> moveStack = new Stack<>();

    private final HashSet<Coordinate> whitePossibleMoves = new HashSet<>();
    private final HashSet<Coordinate> blackPossibleMoves = new HashSet<>();
    private final Board board = BoardSingleton.getInstance();

    public void setup() {
        board.setup();
        moveStack.clear();
        updatePossibleMoves();
    }
    public void move(Color color, Coordinate coordinate) {
        moveStack.add(board.move(color, coordinate));
        updatePossibleMoves();
    }

    public void retract() {
        board.retract(moveStack.pop());
        updatePossibleMoves();
    }

    public boolean hasPossibleMove(Color color) {
        return !getPossibleMoves(color).isEmpty();
    }

    private void updatePossibleMoves(Color color, HashSet<Coordinate> possibleMoves) {
        possibleMoves.clear();
        for (int row = 0; row < board.getSize(); row++) {
            for (int col = 0; col < board.getSize(); col++) {
                if (board.getSquareColor(row, col) != Color.NONE) {
                    continue;
                }
                ArrayList<Coordinate> minorCoordinates = board.getMinorCoordinates(new Coordinate(row, col), color);
                if (!minorCoordinates.isEmpty()) {
                    possibleMoves.add(new Coordinate(row, col));
                }
            }
        }
    }

    private void updatePossibleMoves() {
        updatePossibleMoves(Color.WHITE, whitePossibleMoves);
        updatePossibleMoves(Color.BLACK, blackPossibleMoves);
    }

    public HashSet<Coordinate> getPossibleMoves(Color color) {
        if (color == Color.WHITE) {
            return whitePossibleMoves;
        } else {
            return blackPossibleMoves;
        }
    }

    public String serializeBoard(Color color) {
        if (color == Color.NONE) {
            throw new NullPointerException();
        }
        StringBuilder dump = new StringBuilder();
        dump.append("  ");
        for (char col = 'a'; col < 'a' + board.getSize(); ++col) {
            dump.append(col);
            dump.append(' ');
        }
        dump.append('\n');

        for (int row = 0; row < board.getSize(); row++) {
            dump.append(row + 1);
            dump.append(' ');
            for (int col = 0; col < board.getSize(); col++) {
                if (getPossibleMoves(color).contains(new Coordinate(row, col))) {
                    dump.append('+');
                } else {
                    dump.append(board.getSquareColor(row, col));
                }
                dump.append(' ');
            }
            dump.append('\n');
        }
        return dump.toString();
    }
}
