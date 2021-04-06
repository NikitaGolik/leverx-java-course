package by.golik.tictactoe.service;

import java.util.Random;
import static by.golik.tictactoe.entity.Field.*;
import static by.golik.tictactoe.service.PvPMode.userTurn;
import static by.golik.tictactoe.service.Util.*;

/**
 * This class represents Game in mode Player against Computer.
 * @author Nikita Golik
 */
public class PLayerVsComputerMode {

    /**
     * This method do move from computer.
     */
    private static void computerTurn() {
        int coordinateX = -1;
        int coordinateY = -1;
        boolean user_win = false;

            for (int i = 0; i < Size; i++) {
                for (int j = 0; j < Size; j++) {
                    if (!isCellBusy(i, j)) {
                        field[i][j] = FIRST_USER_FIGURE;
                        if (checkWin(FIRST_USER_FIGURE)) {
                            coordinateX = i;
                            coordinateY = j;
                            user_win = true;
                        }
                        field[i][j] = NOT_BUSY;
                    }
                }
            }
        if (!user_win) {
            do {
                Random random = new Random();
                coordinateX = random.nextInt(Size);
                coordinateY = random.nextInt(Size);
            }
            while (isCellBusy(coordinateX, coordinateY));
        }
        field[coordinateX][coordinateY] = COMPUTER_FIGURE;
    }

    /**
     * This method take information about who is winner. Game is over, if winner is defined.
     */
    public static void modeComputerVsPlayer() {
        initField();
        while (true) {
            showField();
            userTurn(FIRST_USER_FIGURE, 0);
            if (checkWin(FIRST_USER_FIGURE)) {
                System.out.println("Player win!");
                showField();
                break;
            }
            if (isFieldFull()) {
                System.out.println("Draw!");
                showField();
                break;
            }
            computerTurn();
            if (checkWin(COMPUTER_FIGURE)) {
                System.out.println("Computer win!");
                showField();
                break;
            }
        }
    }
}
