package by.golik.tictactoe.entity;

/**
 * @author Nikita Golik
 */
public class Player {
    private String playerName;
    private Figure figure;

    public Player(String playerName, Figure figure) {
        this.playerName = playerName;
        this.figure = figure;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Figure getFigure() {
        return figure;
    }

    public void setFigure(Figure figure) {
        this.figure = figure;
    }
}
