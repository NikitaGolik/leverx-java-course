package by.golik.tictactoe.view;

import java.util.Scanner;
import static by.golik.tictactoe.service.PLayerVsComputerMode.modeComputerVsPlayer;
import static by.golik.tictactoe.service.PvPMode.modePlayerVsPlayer;

/**
 * Class shows menu of game.
 * @author Nikita Golik
 */
public class Menu {

    /**
     * Method, which shows dialog with user on console.
     */
    public static void mainMenu() {
        System.out.println("Choose mode of game: ");
        System.out.println("1 - Play against computer");
        System.out.println("2 - Player against Player");
        System.out.println("3 - Exit");
        int meniItem = 0;
        Scanner sc = new Scanner(System.in);
        meniItem = sc.nextInt();
        switch (meniItem) {
            case 1: {
                modeComputerVsPlayer();;
                break;
            }
            case 2: {
                modePlayerVsPlayer();
                break;
            }
            case 3: {
                System.exit(0);
                break;
            }
            default: {
                System.out.println("Choose one of given variants of menu!");
                mainMenu();
            }
        }
    }
}
