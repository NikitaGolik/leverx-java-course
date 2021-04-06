package by.golik.tictactoe.service;

import java.util.Scanner;
import static by.golik.tictactoe.entity.Field.*;
import static by.golik.tictactoe.service.Util.*;

/**
 * This class describes gaming process in Player vs Player mode.
 * @author Nikita Golik
 */
public class PvPMode {

    /**
     * This method do valid step of player.
     * @param figure - figure of player.
     * @param numberOfPlayer - number of player.
     */
    protected static void userTurn(String figure, int numberOfPlayer) {

        int coordinateX = -1;
        int coordinateY = -1;
        do {
            if (numberOfPlayer == 0) {
                System.out.println("Enter coordinateX and coordinateY of your turn:");
            } else {
                System.out.println("Player " + numberOfPlayer + ", enter coordinateX and coordinateY of your turn:");
            }
            Scanner sc = new Scanner(System.in);

                coordinateX = sc.nextInt() - 1;
                coordinateY = sc.nextInt() - 1;

        } while  (isCellBusy(coordinateX, coordinateY));
            if(coordinateX > field.length - 1 || coordinateY > field.length - 1) {
                userTurn(figure, numberOfPlayer);
            } else {
                field[coordinateX][coordinateY] = figure;
            }
    }

    /**
     * This method take information about who is winner. Game is over, if winner is defined.
     */
    public static void modePlayerVsPlayer() {
        initField();
        while (true) {
            showField();
            userTurn(FIRST_USER_FIGURE, 1);
            if (checkWin(FIRST_USER_FIGURE)) {
                System.out.println("Player1 win");
                showField();
                break;
            }
            if (isFieldFull()) {
                System.out.println("Draw!");
                showField();
                break;
            }
            showField();
            userTurn(SECOND_USER_FIGURE, 2);
            if (checkWin(SECOND_USER_FIGURE)) {
                System.out.println("Player2 win!");
                showField();
                break;
            }
        }
    }
}
