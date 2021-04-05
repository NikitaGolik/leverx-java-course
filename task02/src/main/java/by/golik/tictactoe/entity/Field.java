package by.golik.tictactoe.entity;

/**
 * @author Nikita Golik
 */
public class Field {

    public static final String FIRST_USER_FIGURE = "X";
    public static final String SECOND_USER_FIGURE = "O";
    public static final String COMPUTER_FIGURE = "O";
    public static final String NOT_BUSY = "*";
    public static final int Size = 3;
    public static String[][] field = new String[Size][Size];

    public static void initField() {
        for (int i = 0; i < Size; i++) {
            for (int j = 0; j < Size; j++) {
                field[i][j] = NOT_BUSY;
            }
        }
    }

    public static void printField() {
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
