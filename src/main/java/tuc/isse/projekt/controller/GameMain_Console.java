package tuc.isse.projekt.controller;

import java.io.IOException;

import tuc.isse.projekt.model.ObservableBoard;
import tuc.isse.projekt.model.Token.Color;

public class GameMain_Console {
    public static void main(String[] args) throws NumberFormatException, ColumnFullException, IllegalMoveException, IOException {
        ObservableBoard board = new ObservableBoard();
        Player player1 = new ConsolePlayer(Color.RED, board);
        Player player2 = new ConsolePlayer(Color.YELLOW, board);

        Game game = new ConsoleGame(board);
        game.doGame(player1, player2);
    }
}
