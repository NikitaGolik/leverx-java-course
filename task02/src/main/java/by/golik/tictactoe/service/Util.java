package by.golik.tictactoe.service;

import static by.golik.tictactoe.entity.Field.*;

/**
 * This class - is helper for gaming process
 * @author Nikita Golik
 */
public class Util {

    /**
     * This method checks if chosen cell is busy
     * @param x - coordinate Ox
     * @param y - coordinate Oy
     * @return - boolean if is busy
     */
    public static boolean isCellBusy(int x, int y) {

        if (x < 0 || y < 0 || x > Size - 1 || y > Size - 1) {
            return false;
        }
        return !field[x][y].equals(NOT_BUSY);
    }

    public static boolean isValidTurn(int x, int y) {

        if (x > 2 || y > 2 ) {
            return false;
        }
        return !field[x][y].equals(NOT_BUSY);
    }

    /**
     *
     * @param start_x
     * @param start_y
     * @param dx
     * @param dy
     * @param sign
     * @return
     */
    public static boolean checkLine(int start_x, int start_y, int dx, int dy, String sign) {
        for (int i = 0; i < Size; i++) {
            if (field[start_x + i * dx][start_y + i * dy] != sign)
                return false;
        }
        return true;
    }

    /**
     * This method checks if combination is winning
     * @param sign - Figure in chosen cell
     * @return - boolean value of winning
     */
    public static boolean checkWin(String sign) {
        for (int i = 0; i < Size; i++) {

            if (checkLine(i, 0, 0, 1, sign)) return true;

            if (checkLine(0, i, 1, 0, sign)) return true;
        }

        if (checkLine(0, 0, 1, 1, sign)) return true;
        if (checkLine(0, Size - 1, 1, -1, sign)) return true;
        return false;
    }
}
