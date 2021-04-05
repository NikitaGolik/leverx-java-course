package by.golik.tictactoe.view;

import by.golik.tictactoe.entity.Field;
import by.golik.tictactoe.service.GamePlay;

import java.util.Scanner;

/**
 * @author Nikita Golik
 */
public class Menu {

    public static void startMenu() {
        System.out.println("TicTacToe");
        GamePlay.createModels();
        showMainMenu();
    }

    private static void printMenu() {

        System.out.println("1 - start with human\n" +
                           "2 - start with computer\n" +
                           "3 - Exit");
    }

    private static void showMainMenu() {
        Field.clean();
        if (gameProcessWorking()) {
            showMainMenu();
        }
    }
    private static boolean gameProcessWorking() {
        printMenu();
        int menuChoice = getMenuChoice();

        switch (menuChoice) {
            case 1:
                GamePlay.start();
                return false;
            case 2:
                GamePlay.startComputer();
                return false;

            case 3:
                return false;

            default:
                System.out.print(
                        "Choose another menu item!\n");
                return true;
        }
    }

    private static int getMenuChoice() {
        int menuChoice = -1;

        Scanner scanner = new Scanner(System.in);

        try {
            menuChoice = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Wrong menu format! Try again:\n");
            getMenuChoice();
        }

        return menuChoice;
    }
}
