package by.golik.tictactoe.entity;

/**
 * This class represents entity of gaming field
 * @author Nikita Golik
 */
public class Field {

    /**
     * Figure of first player.
     */
    public static final String FIRST_USER_FIGURE = "X";

    /**
     * Figure of second player.
     */
    public static final String SECOND_USER_FIGURE = "O";

    /**
     * Figure of computer.
     */
    public static final String COMPUTER_FIGURE = "O";

    /**
     * Cell of field, which is nit busy by any figure.
     */
    public static final String NOT_BUSY = "*";

    /**
     * Size of Field
     */
    public static final int Size = 3;

    /**
     * Empty gaming field with given size
     */
    public static String[][] field = new String[Size][Size];

    /**
     * This method initializes gaming field with given size.
     */
    public static void initField() {
        for (int i = 0; i < Size; i++) {
            for (int j = 0; j < Size; j++) {
                field[i][j] = NOT_BUSY;
            }
        }
    }

    /**
     * This method shows players field in current state.
     */
    public static void showField() {
        for (int i = 0; i <= Size; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < Size; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < Size; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
    }
}
