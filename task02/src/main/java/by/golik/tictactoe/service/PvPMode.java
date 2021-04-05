package by.golik.tictactoe.service;

import java.util.Scanner;

import static by.golik.tictactoe.entity.Field.*;
import static by.golik.tictactoe.service.Util.checkWin;
import static by.golik.tictactoe.service.Util.isCellBusy;

/**
 * @author Nikita Golik
 */
public class PvPMode {

    public static void userShot(String sign, int i) {
        int x = -1;
        int y = -1;
        do {
            if (i == 0) {
                System.out.println("Введите координаты x y (1 - " + DIMENSION + "): ");
            } else {
                System.out.println("Игрок " + i + ". Введите координаты x y (1 - " + DIMENSION + "): ");
            }
            Scanner sc = new Scanner(System.in);
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        }
        while (isCellBusy(x, y));
        field[x][y] = sign;
    }

    public static void modeTwoPlayers() {
        int count = 0;
        initField();
        while (true) {
            printField();
            userShot(USER_SIGN, 1);
            count++;
            if (checkWin(USER_SIGN)) {
                System.out.println("USER 1 WIN!!!");
                printField();
                break;
            }
            userShot(USER_SIGN_SECOND, 2);
            count++;
            if (checkWin(USER_SIGN_SECOND)) {
                System.out.println("USER 2 WIN!!!");
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
