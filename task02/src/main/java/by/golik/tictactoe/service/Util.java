package by.golik.tictactoe.service;

import static by.golik.tictactoe.entity.Field.*;

/**
 * This class - is helper for gaming process.
 * @author Nikita Golik
 */
public class Util {

    /**
     * This method checks if chosen cell is busy.
     * @param coordinateX - coordinate Ox.
     * @param coordinateY - coordinate Oy.
     * @return - boolean if is busy.
     */
    public static boolean isCellBusy(int coordinateX, int coordinateY) {

        if (coordinateX < 0 || coordinateY < 0 || coordinateX > Size - 1 || coordinateY > Size - 1) {
            return false;
        }
        return !field[coordinateX][coordinateY].equals(NOT_BUSY);
    }

    /**
     * This method checks winning combinations.
     * @param figure - figure of player.
     * @return - boolean result of checking combinations.
     */
    public static boolean checkWin(String figure) {
        return checkWinHorizontal(figure) ||
                checkWinVertical(figure) ||
                checkWinDiagonals(figure);
    }

    /**
     * This method checks combinations on horizontal for victory
     * @param figure - figure of player ('X' or 'O')
     * @return  - boolean result of checking combinations
     */
    private static boolean checkWinHorizontal(String figure) {
        for (int i = 0; i < field.length; i++) {
            if ((field[i][0] == figure && field[i][1] == figure &&
                    field[i][2] == figure)) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method checks combinations on vertical for victory
     * @param figure - figure of player ('X' or 'O')
     * @return  - boolean result of checking combinations
     */
    private static boolean checkWinVertical(String figure) {
        for (int i = 0; i < field.length; i++) {
            if ((field[0][i] == figure && field[1][i] == figure &&
                    field[2][i] == figure)) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method checks combinations on both diagonals for victory
     * @param figure - figure of player ('X' or 'O')
     * @return  - boolean result of checking combinations
     */
    private static boolean checkWinDiagonals(String figure) {
        if ((field[0][0] == figure && field[1][1] == figure &&
                field[2][2] == figure) ||
                (field[2][0] == figure && field[1][1] == figure &&
                        field[0][2] == figure))
            return true;
        return false;
    }

    /**
     * This method checks is there any empty cells
     * @return - boolean result of checking field
     */
    public static boolean isFieldFull() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (field[i][j].equals(NOT_BUSY)) return false;
            }
        }
        return true;
    }
}
