package by.golik.tictactoe.service;

import by.golik.tictactoe.exception.FieldOutOfBoundsException;

import java.util.Random;

import static by.golik.tictactoe.entity.Field.*;
import static by.golik.tictactoe.service.PvPMode.userTurn;
import static by.golik.tictactoe.service.Util.checkWin;
import static by.golik.tictactoe.service.Util.isCellBusy;

/**
 * @author Nikita Golik
 */
public class PLayerVsComputerMode {

    public static void computerTurn() {
        int x = -1;
        int y = -1;
        boolean ai_win = false;
        boolean user_win = false;
        // Находим выигрышный ход

        // Блокировка хода пользователя, если он побеждает на следующем ходу
            for (int i = 0; i < Size; i++) {
                for (int j = 0; j < Size; j++) {
                    if (!isCellBusy(i, j)) {
                        field[i][j] = FIRST_USER_FIGURE;
                        if (checkWin(FIRST_USER_FIGURE)) {
                            x = i;
                            y = j;
                            user_win = true;
                        }
                        field[i][j] = NOT_BUSY;
                    }
                }
            }
        if (!user_win) {
            do {
                Random rnd = new Random();
                x = rnd.nextInt(Size);
                y = rnd.nextInt(Size);
            }
            while (isCellBusy(x, y));
        }
        field[x][y] = COMPUTER_FIGURE;
    }

    public static void modeAgainstComputer() throws FieldOutOfBoundsException {
        int count = 0;
        initField();
        while (true) {
            printField();
            userTurn(FIRST_USER_FIGURE, 0);
            count++;
            if (checkWin(FIRST_USER_FIGURE)) {
                System.out.println("Player win!");
                printField();
                break;
            }
            computerTurn();
            count++;
            if (checkWin(COMPUTER_FIGURE)) {
                System.out.println("Computer WIN!");
                printField();
                break;
            }
            if (count == Math.pow(Size, 2)) {
                printField();
                break;
            }
        }
    }
}
