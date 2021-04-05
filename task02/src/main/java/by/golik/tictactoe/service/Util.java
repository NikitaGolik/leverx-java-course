package by.golik.tictactoe.service;

import static by.golik.tictactoe.entity.Field.*;

/**
 * @author Nikita Golik
 */
public class Util {

    public static boolean isCellBusy(int x, int y) {
        if (x < 0 || y < 0 || x > DIMENSION - 1 || y > DIMENSION - 1) {
            return false;
        }
        return field[x][y] != NOT_SIGN;
    }

    public static boolean checkLine(int start_x, int start_y, int dx, int dy, String sign) {
        for (int i = 0; i < DIMENSION; i++) {
            if (field[start_x + i * dx][start_y + i * dy] != sign)
                return false;
        }
        return true;
    }

    public static boolean checkWin(String sign) {
        for (int i = 0; i < DIMENSION; i++) {
            // проверяем строки
            if (checkLine(i, 0, 0, 1, sign)) return true;
            // проверяем столбцы
            if (checkLine(0, i, 1, 0, sign)) return true;
        }
        // проверяем диагонали
        if (checkLine(0, 0, 1, 1, sign)) return true;
        if (checkLine(0, DIMENSION - 1, 1, -1, sign)) return true;
        return false;
    }
}
