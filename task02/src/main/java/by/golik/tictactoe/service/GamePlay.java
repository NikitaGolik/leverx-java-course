package by.golik.tictactoe.service;

import by.golik.tictactoe.entity.Field;
import by.golik.tictactoe.entity.Figure;
import by.golik.tictactoe.entity.Player;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Nikita Golik
 */
public class GamePlay {
    private static Player[] players;
    private static int FULL_FIELD_SIZE = Field.getFullFieldSize();

    public static void gaming() {
        boolean isHaveWinner;
        boolean isFigureAdded;
        int moveCounter = 0;
        Figure playerFigure = Figure.O;

//        1. Receive X or O from turn of moves;
//        2. Get move from player;
//        3. Add player move on board;
//        4. check for win after 5 moves;
//        5. check for draw;

        Field.printFieldWithNumbersOfCells();

    }
    private static Figure receiveFigureFromTurn(Figure playerFigure) {
        if (playerFigure.equals(Figure.X)) {
            playerFigure = Figure.O;
        } else {
            playerFigure = Figure.X;
        }
        printCurrentPlayerText(playerFigure);
        return playerFigure;
    }

    private static void printCurrentPlayerText(Figure figure) {
        if (figure.equals(Figure.X)) {
            System.out.println(players[0].getPlayerName() + " do your move:\n");
        }
        if(figure.equals(Figure.X)) {
            System.out.println(players[1].getPlayerName() + " do your move:\n");
        }
    }

    private static int getPlayerTurn() throws Exception {
        int playerTurn = -1;
        boolean isValidTurn;
        do {
            try {
                Scanner scanner = new Scanner(System.in);
                playerTurn = scanner.nextInt();
                isValidTurn = true;
            } catch (Exception e) {
                System.out.println("Wrong format! Your turn should be from 0 to 8");
                isValidTurn = false;
            }
        } while (!isValidTurn);
        if (!(playerTurn == 0 | playerTurn == 1 | playerTurn == 2
            |playerTurn == 3 | playerTurn == 4 | playerTurn == 5
            |playerTurn == 6 | playerTurn == 7 | playerTurn == 8)) {
            throw new Exception();
        }
        return playerTurn;
    }
    private static boolean checkDraw(int moveCounter, boolean isHaveWinner) {
        if (!isHaveWinner & moveCounter == 9) {
            System.out.println("Draw! We haven't winner ");
            return true;
        } else return isHaveWinner;

    }

    public static boolean checkWinner(int moveCounter, Figure figure) {
        //        5 - min moves for check winner
        if (moveCounter >= 5 & checkWinnerCombination()) {
            String winPlayerName = receiveWinPlayerName(figure);
            System.out.println("Congratulation!" + winPlayerName + " is WIN!");
            return true;
        } else return false;
    }
    private static boolean checkWinnerCombination() {
        boolean isHaveWinner = false;

//      выйгрышные комбинации
        int[][] winVar = {{0, 1, 2}, {0, 3, 6}, {0, 4, 8}, {1, 4, 7}, {2, 4, 6}, {2, 5, 8}, {3, 4, 5}, {6, 7, 8}};

        ArrayList<Figure> figureList = new ArrayList<>();

//      создание списка текущих фигур
        for (int i = 0; i < FULL_FIELD_SIZE; i++) {
            figureList.add(Field.getField().get(i).getCellFigure());
        }

        for (int i = 0; i < 8; i++) {
            int fNumb = winVar[i][0];
            int sNumb = winVar[i][1];
            int tNumb = winVar[i][2];

            if (checkWinnerComb(fNumb, sNumb, tNumb, figureList)) {
                isHaveWinner = true;
                break;
            }
        }

        return isHaveWinner;
    }

    //  метод проверки комбинации
    private static boolean checkWinnerComb(int fCell, int sCell, int tCell, ArrayList<Figure> figureList) {

        boolean haveWinnerHelp = false;

        if (figureList.get(fCell).equals(figureList.get(sCell))
                && figureList.get(sCell).equals(figureList.get(tCell))
                && !figureList.get(fCell).equals(Figure.EMPTY)) {
            haveWinnerHelp = true;
        }

        return haveWinnerHelp;
    }

    private static String receiveWinPlayerName(Figure figure) {
        String winPlayerName = null;

        if (figure.equals(Figure.X)) {
            winPlayerName = players[0].getPlayerName();
        } else if (figure.equals(Figure.O)) {
            winPlayerName = players[1].getPlayerName();
        }
        return winPlayerName;
    }

    private static int getCheckedPlayerTurn() {
        boolean isValidTurn;
        int playerTurn = -1;

    }
}
