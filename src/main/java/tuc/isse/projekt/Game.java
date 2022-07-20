package tuc.isse.projekt;

import java.io.IOException;

public abstract class Game {
    Board board;
    Player player1;
    Player player2;
    Player current;

    public Game(Board board) {
        this.board = board;
    }

    protected void swapPlayer() {
        if (current == player1) {
            current = player2;
        } else {current = player1;}
    }

    public abstract void doGame(Player player1, Player player2) throws ColumnFullException, IllegalMoveException, NumberFormatException, IOException;
}
