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

    private static final Player[] players = new Player[2];
    private static final int FULL_FIELD_SIZE = Field.getFullFieldSize();

    /**
     * This method creates 2 players for game
     */
    public static void createModels() {
        Field.createField();
        players[0] = new Player("Player_1", Figure.X);
        players[1] = new Player("Player_2", Figure.O);
    }

    public static Player[] getPlayers() {
        return players;
    }

    /**
     *
     */
    public static void start() {
        gaming();
    }

    /**
     * This method shows who's step is now
     * @param figure - 'X' or 'O'
     */
    private static void printCurrentPlayerText(Figure figure) {
        if (figure.equals(Figure.X)) {
            System.out.println(players[0].getPlayerName() + " do your move:\n");
        }
        if(figure.equals(Figure.O)) {
            System.out.println(players[1].getPlayerName() + " do your move:\n");
        }
    }

    /**
     * This method adds step of player on field
     * @param playerMove - step of player
     * @param figure - 'X' or 'O'
     */
    private static void addFigureOnField(int playerMove, Figure figure) {
        Field.getField().get(playerMove).setCellFigure(figure);
    }

    /**
     *
     * @param playerMove
     * @param figureOfPlayer
     * @return
     */
    private static boolean addPlayerMoveOnField(int playerMove, Figure figureOfPlayer) {
        try {
            checkingCellEmpty(playerMove);
            addFigureOnField(playerMove, figureOfPlayer);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * This method
     * @param playerFigure - 'X' or 'O'
     * @return 'X' or 'O'
     */
    private static Figure receiveFigureFromTurn(Figure playerFigure) {
        if (playerFigure.equals(Figure.X)) {
            playerFigure = Figure.O;
        } else {
            playerFigure = Figure.X;
        }
        printCurrentPlayerText(playerFigure);
        return playerFigure;
    }


    /**
     *
     * @return
     * @throws Exception
     */
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

    /**
     * This method checks if chosen Cell is empty,
     * @param cellNumb - number of cell from table
     * @throws Exception - if cell is busy
     */
    //  метод проверка "занятости" ячейки
    private static void checkingCellEmpty(int cellNumb) throws Exception {

        if (!Field.getField().get(cellNumb).getCellFigure().equals(Figure.EMPTY)) {
            throw new Exception();
        }
    }

    /**
     * This method checks valid turn of player
     * @return - turn of player
     */
    private static int getCheckedPlayerTurn() {
        boolean isValidTurn;
        int playerTurn = -1;
        do {
            try {
                playerTurn = getPlayerTurn();
                isValidTurn = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                isValidTurn = false;
            }
        } while (!isValidTurn);

        return playerTurn;
    }

    /**
     *
     */
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
        do{
            playerFigure = receiveFigureFromTurn(playerFigure);
            do {
                int playerTurn = getCheckedPlayerTurn();
                isFigureAdded = addPlayerMoveOnField(playerTurn, playerFigure);
            } while (!isFigureAdded);
            Field.printField();
            moveCounter++;
            isHaveWinner = checkWinner(moveCounter, playerFigure);
            isHaveWinner = checkDraw(moveCounter, isHaveWinner);
        } while (!isHaveWinner);

    }

    /**
     * This method
     * @param moveCounter
     * @param isHaveWinner
     * @return
     */
    private static boolean checkDraw(int moveCounter, boolean isHaveWinner) {
        if (!isHaveWinner & moveCounter == 9) {
            System.out.println("Draw! We haven't winner ");
            return true;
        } else return isHaveWinner;

    }

    /**
     *
     * @param moveCounter
     * @param figure
     * @return
     */
    public static boolean checkWinner(int moveCounter, Figure figure) {
        //        5 - min moves for check winner
        if (moveCounter >= 5 & checkWinnerCombination()) {
            String winPlayerName = receiveWinPlayerName(figure);
            System.out.println("Congratulation!" + winPlayerName + " is WIN!");
            return true;
        } else return false;
    }

    /**
     * This method checks combinations
     * @return if combination wins
     */
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

    /**
     * This method checks if combination of player is winning
     * @param fCell
     * @param sCell
     * @param tCell
     * @param figureList
     * @return
     */
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

    /**
     * This method defines a winner
     * @param figure - figure of player
     * @return - name of winner
     */
    private static String receiveWinPlayerName(Figure figure) {
        String winPlayerName = null;

        if (figure.equals(Figure.X)) {
            winPlayerName = players[0].getPlayerName();
        } else if (figure.equals(Figure.O)) {
            winPlayerName = players[1].getPlayerName();
        }
        return winPlayerName;
    }
}
