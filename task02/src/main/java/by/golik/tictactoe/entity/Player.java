package by.golik.tictactoe.entity;

/**
 * This class represents Player entity
 * @author Nikita Golik
 */
public class Player {
    /**
     * Name of player
     */
    private String playerName;
    /**
     * Player-owned figure ('X' or 'O')
     */
    private Figure figure;

    /**
     * Constructor for creation player
     * @param playerName - name of Player
     * @param figure - type of player-owned figure
     */
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

}
