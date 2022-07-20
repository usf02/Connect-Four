package tuc.isse.projekt;

import java.io.IOException;

import tuc.isse.projekt.Token.Color;

public class GameMain_Console {
    public static void main(String[] args) throws NumberFormatException, ColumnFullException, IllegalMoveException, IOException {
        Board board = new Board();
        Player player1 = new ConsolePlayer(Color.RED, board);
        Player player2 = new ConsolePlayer(Color.YELLOW, board);

        Game game = new ConsoleGame(board);
        game.doGame(player1, player2);
    }
}
