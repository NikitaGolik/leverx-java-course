package by.golik.tictactoe.view;

import by.golik.tictactoe.exception.FieldOutOfBoundsException;

import java.util.Scanner;

import static by.golik.tictactoe.service.PLayerVsComputerMode.modeAgainstComputer;
import static by.golik.tictactoe.service.PvPMode.modeTwoPlayers;

/**
 * Class shows menu of game
 * @author Nikita Golik
 */
public class Menu {

    public static void mainMenu() throws FieldOutOfBoundsException {
        System.out.println("Choose mode of game: ");
        System.out.println("1 - Play against computer");
        System.out.println("2 - Player vs Player");
        System.out.println("3 - Exit");
        int i = 0;
        Scanner sc = new Scanner(System.in);
        i = sc.nextInt();
        switch (i) {
            case 1: {
                modeAgainstComputer();;
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
                System.out.println("Unexpected value");
            }
        }
    }
}
