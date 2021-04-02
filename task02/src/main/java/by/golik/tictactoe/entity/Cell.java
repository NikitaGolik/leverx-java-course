package by.golik.tictactoe.entity;

/**
 * This class represents cell of Field
 * @author Nikita Golik
 */
public class Cell {
    /**
     * number of cell
     */
    private final int cellNumber;

    /**
     * Figure that is in cell
     */
    private Figure cellFigure;

    /**
     * constructor
     * @param cellNumber - number of cell
     */
    public Cell(int cellNumber) {
        this.cellNumber = cellNumber;
    }

    public int getCellNumber() {
        return cellNumber;
    }

    public Figure getCellFigure() {
        return cellFigure;
    }

    public void setCellFigure(Figure cellFigure) {
        this.cellFigure = cellFigure;
    }

    /**
     * This method shows on console figure that is in cell
     */
    public void printCell() {
        System.out.println("|" + cellFigure + "|");
    }
}
