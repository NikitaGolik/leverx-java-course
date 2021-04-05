package by.golik.tictactoe.view;

import java.util.Scanner;

import static by.golik.tictactoe.entity.Field.aiLevel;
import static by.golik.tictactoe.service.PLayerVsComputerMode.modeAgainstAI;
import static by.golik.tictactoe.service.PvPMode.modeTwoPlayers;

/**
 * @author Nikita Golik
 */
public class Menu {

    public static void aiLevel() {
        System.out.println("Выберите сложность компьютера: ");
        System.out.println("1. Простой.");
        System.out.println("2. Продвинутый.");
        System.out.println("3. Сложный.");
        System.out.println("4. Вернуться в предыдущее меню.");
        System.out.println("5. Выход.");
        int i = 0;
        Scanner sc = new Scanner(System.in);
        i = sc.nextInt();
        switch (i) {
            case 1: {
                aiLevel = 0;
                modeAgainstAI();
                break;
            }
            case 2: {
                aiLevel = 1;
                modeAgainstAI();
                break;
            }
            case 3: {
                aiLevel = 2;
                modeAgainstAI();
                break;
            }
            case 4: {
                mainMenu();
                break;
            }
            case 5: {
                System.exit(0);
                break;
            }
            default: {
                System.out.println("Было введено неверное значение!");
            }
        }
    }

    public static void mainMenu() {
        System.out.println("Выберите режим игры: ");
        System.out.println("1. Игра против компьютера.");
        System.out.println("2. 2 игрока.");
        System.out.println("3. Выход.");
        int i = 0;
        Scanner sc = new Scanner(System.in);
        i = sc.nextInt();
        switch (i) {
            case 1: {
                aiLevel();
                break;
            }
            case 2: {
                modeTwoPlayers();
                break;
            }
            case 3: {
                System.exit(0);
                break;
            }
            default: {
                System.out.println("Было введено неверное значение!");
            }
        }
    }
}
