package by.golik.tictactoe.controller;

import static by.golik.tictactoe.view.Menu.*;

/**
 * @author Nikita Golik
 */
public class Runner {
    public static final String USER_SIGN = "X";
    public static final String USER_SIGN_SECOND = "O";
    public static final String AI_SIGN = "O";
    public static final String NOT_SIGN = "*";
    public static int aiLevel = 0;
    public static final int DIMENSION = 3;
    public static String[][] field = new String[DIMENSION][DIMENSION];

    public static void main(String[] args) {
        mainMenu();
    }
}
