package by.golik.tictactoe.service;

import java.util.Random;

import static by.golik.tictactoe.entity.Field.*;
import static by.golik.tictactoe.service.PvPMode.userShot;
import static by.golik.tictactoe.service.Util.checkWin;
import static by.golik.tictactoe.service.Util.isCellBusy;

/**
 * @author Nikita Golik
 */
public class PLayerVsComputerMode {

    public static void aiShot() {
        int x = -1;
        int y = -1;
        boolean ai_win = false;
        boolean user_win = false;
        // Находим выигрышный ход
        if (aiLevel == 2) {
            for (int i = 0; i < DIMENSION; i++) {
                for (int j = 0; j < DIMENSION; j++) {
                    if (!isCellBusy(i, j)) {
                        field[i][j] = AI_SIGN;
                        if (checkWin(AI_SIGN)) {
                            x = i;
                            y = j;
                            ai_win = true;
                        }
                        field[i][j] = NOT_SIGN;
                    }
                }
            }
        }
        // Блокировка хода пользователя, если он побеждает на следующем ходу
        if (aiLevel > 0) {
            if (!ai_win) {
                for (int i = 0; i < DIMENSION; i++) {
                    for (int j = 0; j < DIMENSION; j++) {
                        if (!isCellBusy(i, j)) {
                            field[i][j] = USER_SIGN;
                            if (checkWin(USER_SIGN)) {
                                x = i;
                                y = j;
                                user_win = true;
                            }
                            field[i][j] = NOT_SIGN;
                        }
                    }
                }
            }
        }
        if (!ai_win && !user_win) {
            do {
                Random rnd = new Random();
                x = rnd.nextInt(DIMENSION);
                y = rnd.nextInt(DIMENSION);
            }
            while (isCellBusy(x, y));
        }
        field[x][y] = AI_SIGN;
        System.out.println("x = " + x + "| y = " + y + "| ai_win = " + ai_win + "| user_win = " + user_win);
    }

    public static void modeAgainstAI() {
        int count = 0;
        initField();
        while (true) {
            printField();
            userShot(USER_SIGN, 0);
            count++;
            if (checkWin(USER_SIGN)) {
                System.out.println("USER WIN!!!");
                printField();
                break;
            }
            aiShot();
            count++;
            if (checkWin(AI_SIGN)) {
                System.out.println("AI WIN!!!");
                printField();
                break;
            }
            if (count == Math.pow(DIMENSION, 2)) {
                printField();
                break;
            }
        }
    }
}
