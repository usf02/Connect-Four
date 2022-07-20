package tuc.isse.projekt;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import tuc.isse.projekt.GameObject.Winner;
import tuc.isse.projekt.Token.Color;

public class MocGameTest {
    @Test
    public void testDoGame() throws ColumnFullException, IllegalMoveException, NumberFormatException, IOException {
        Board board = new Board();
        Player player1 = new MocPlayer(Color.RED, board, 3);
        Player player2 = new MocPlayer(Color.YELLOW, board, 5);
        Game game = new ConsoleGame(board);
        game.doGame(player1, player2);
        board.toString();

        assertEquals(Winner.RED, board.testVictory());
    }
}
