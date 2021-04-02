package by.golik.tictactoe.entity;

import java.util.ArrayList;

/**
 * This class represents field for TicTacToe
 * @author Nikita Golik
 */
public class Field {
    /**
     * Length of raw and column
     */
    private static int FIELD_SIZE = 3;
    /**
     * Size if field
     */
    private static int FULL_FIELD_SIZE = FIELD_SIZE * FIELD_SIZE;
    private static ArrayList<Cell> field = new ArrayList<>();

    /**
     * This method creates filed for game
     */
    public static void createField() {
        for (int i = 0; i < FULL_FIELD_SIZE; i++) {
            Cell cell = new Cell(i);
            field.add(cell);
        }
    }

    /**
     * This method shows on console full field
     */
    public static void printField() {
        int cellListNumber = 0;
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                field.get(cellListNumber).printCell();
                cellListNumber++;
            }
            System.out.println();
        }
    }

    public static ArrayList<Cell> getField() {
        return field;
    }

}
