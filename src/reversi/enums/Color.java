package reversi.enums;

public enum Color {
    NONE, WHITE, BLACK;
    public static Color getOppositeColor(Color color) {
        if (color == WHITE) {
            return BLACK;
        } else if (color == BLACK) {
            return WHITE;
        }
        return NONE;
    }

    @Override
    public String toString() {
        return switch (this) {
            case NONE -> ".";
            case WHITE -> "W";
            case BLACK -> "B";
        };
    }
}
