package by.golik.tictactoe.service;

import by.golik.tictactoe.exception.FieldOutOfBoundsException;

import java.util.Scanner;

import static by.golik.tictactoe.entity.Field.*;
import static by.golik.tictactoe.service.Util.*;

/**
 * This class describes gaming process in Player vs Player mode
 * @author Nikita Golik
 */
public class PvPMode {

    /**
     * This method
     * @param figure - figure of player
     * @param i - number of player
     */
    public static void userTurn(String figure, int i) {
        boolean validPlayerMove;
        int x = -1;
        int y = -1;
        do {
            if (i == 0) {
                System.out.println("Enter x y (1 - " + Size + "): ");
            } else {
                System.out.println("Player " + i + ", do move x y (1 - " + Size + "): ");
            }
            Scanner sc = new Scanner(System.in);

                x = sc.nextInt() - 1;
                y = sc.nextInt() - 1;

        } while  (isCellBusy(x, y));
                field[x][y] = figure;
    }

    /**
     *
     * @throws FieldOutOfBoundsException
     */
    public static void modeTwoPlayers() throws FieldOutOfBoundsException {
        int count = 0;
        initField();
        while (true) {
            printField();
            userTurn(FIRST_USER_FIGURE, 1);
            count++;
            if (checkWin(FIRST_USER_FIGURE)) {
                System.out.println("Player1 win");
                printField();
                break;
            }
            userTurn(SECOND_USER_FIGURE, 2);
            count++;
            if (checkWin(SECOND_USER_FIGURE)) {
                System.out.println("Player2 win!");
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
