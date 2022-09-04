package tuc.isse.projekt;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import tuc.isse.projekt.controller.ColumnFullException;
import tuc.isse.projekt.controller.ConsoleGame;
import tuc.isse.projekt.controller.Game;
import tuc.isse.projekt.controller.IllegalMoveException;
import tuc.isse.projekt.controller.MocPlayer;
import tuc.isse.projekt.controller.Player;
import tuc.isse.projekt.model.BoardObserver;
import tuc.isse.projekt.model.ObservableBoard;
import tuc.isse.projekt.model.GameObject.Winner;
import tuc.isse.projekt.model.Token.Color;

public class MocGameTest implements BoardObserver{
    @Test
    public void testDoGame() throws ColumnFullException, IllegalMoveException, NumberFormatException, IOException {
        ObservableBoard board = new ObservableBoard();
        Player player1 = new MocPlayer(Color.RED, board, 3);
        Player player2 = new MocPlayer(Color.YELLOW, board, 5);
        Game game = new ConsoleGame(board);
        game.doGame(player1, player2);
        board.toString();

        assertEquals(Winner.RED, board.testVictory());
    }

    @Override
    public void update(ObservableBoard board) {

      String s = "[ ][ ][ ][ ][ ][ ][ ]\n"
                + "[ ][ ][ ][ ][ ][ ][ ]\n"
                + "[ ][ ][ ][ ][ ][ ][ ]\n"
                + "[ ][ ][ ][ ][ ][ ][ ]\n"
                + "[ ][ ][ ][ ][ ][ ][ ]\n"
                + "[ ][ ][O][ ][ ][ ][ ]\n";

      assertEquals(s, board.toString());
    }
}
