package by.golik.tictactoe.exception;

/**
 * @author Nikita Golik
 */
public class BusyCellException extends Exception {

    @Override
    public String getMessage() {
        return "Cell is busy. Try another moves";
    }
}
