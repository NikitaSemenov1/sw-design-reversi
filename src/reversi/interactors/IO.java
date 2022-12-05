package reversi.interactors;

import java.util.Scanner;

/**
 * Scanner Singleton
 */
public class IO {
    private static final Scanner scanner = new Scanner(System.in);
    public static Scanner getScanner() {
        return scanner;
    }
}
