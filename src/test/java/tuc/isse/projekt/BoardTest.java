package tuc.isse.projekt;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import tuc.isse.projekt.controller.ColumnFullException;
import tuc.isse.projekt.controller.IllegalMoveException;
import tuc.isse.projekt.model.Board;
import tuc.isse.projekt.model.GameObject.Winner;
import tuc.isse.projekt.model.Token.Color;

// Die Brette werden mit den gegebenen Spielsteine erstellt und mit der erwarteten Ausgabe (String s) verglichen
// Dazu werden die Siegbedingungen noch überprüft.

public class BoardTest {
    @Test
    public void testToString() throws ColumnFullException, IllegalMoveException {
        Board board = new Board();
        board.dropToken(board.getToken(Color.RED), 6);
        board.dropToken(board.getToken(Color.RED), 6);
        board.dropToken(board.getToken(Color.RED), 6);
        board.dropToken(board.getToken(Color.YELLOW), 6);
        board.dropToken(board.getToken(Color.YELLOW), 5);
        board.dropToken(board.getToken(Color.RED), 5);
        board.dropToken(board.getToken(Color.YELLOW), 4);
        board.dropToken(board.getToken(Color.YELLOW), 4);
        board.dropToken(board.getToken(Color.RED), 4);
        board.dropToken(board.getToken(Color.YELLOW), 2);
        board.dropToken(board.getToken(Color.RED), 2);
        board.dropToken(board.getToken(Color.YELLOW), 3);

        String s = "[ ][ ][ ][ ][ ][ ][ ]\n"
                + "[ ][ ][ ][ ][ ][ ][ ]\n"
                + "[ ][ ][ ][ ][ ][ ][O]\n"
                + "[ ][ ][ ][ ][X][ ][X]\n"
                + "[ ][ ][X][ ][O][X][X]\n"
                + "[ ][ ][O][O][O][O][X]\n";

        assertEquals(s, board.toString());

        assertEquals(Winner.YELLOW, board.testVictory());
    }

    @Test
    public void testToString2() throws ColumnFullException, IllegalMoveException {
        Board board = new Board();
        board.dropToken(board.getToken(Color.YELLOW), 6);
        board.dropToken(board.getToken(Color.YELLOW), 6);
        board.dropToken(board.getToken(Color.YELLOW), 6);
        board.dropToken(board.getToken(Color.YELLOW), 5);
        board.dropToken(board.getToken(Color.RED), 5);
        board.dropToken(board.getToken(Color.YELLOW), 4);
        board.dropToken(board.getToken(Color.RED), 3);
        board.dropToken(board.getToken(Color.YELLOW), 2);
        board.dropToken(board.getToken(Color.RED), 2);
        board.dropToken(board.getToken(Color.RED), 1);
        board.dropToken(board.getToken(Color.YELLOW), 0);
        board.dropToken(board.getToken(Color.RED), 4);
        board.dropToken(board.getToken(Color.RED), 4);
        board.dropToken(board.getToken(Color.RED), 4);
        board.dropToken(board.getToken(Color.RED), 4);

        String s = "[ ][ ][ ][ ][ ][ ][ ]\n"
                + "[ ][ ][ ][ ][X][ ][ ]\n"
                + "[ ][ ][ ][ ][X][ ][ ]\n"
                + "[ ][ ][ ][ ][X][ ][O]\n"
                + "[ ][ ][X][ ][X][X][O]\n"
                + "[O][X][O][X][O][O][O]\n";

        assertEquals(s, board.toString());

        assertEquals(Winner.RED, board.testVictory());
    }

    @Test
    public void testToString3() throws ColumnFullException, IllegalMoveException {
        Board board = new Board();
        board.dropToken(board.getToken(Color.RED), 6);
        board.dropToken(board.getToken(Color.RED), 6);
        board.dropToken(board.getToken(Color.RED), 6);
        board.dropToken(board.getToken(Color.YELLOW), 5);
        board.dropToken(board.getToken(Color.RED), 5);
        board.dropToken(board.getToken(Color.YELLOW), 5);
        board.dropToken(board.getToken(Color.YELLOW), 4);
        board.dropToken(board.getToken(Color.YELLOW), 4);
        board.dropToken(board.getToken(Color.RED), 4);
        board.dropToken(board.getToken(Color.YELLOW), 3);
        board.dropToken(board.getToken(Color.YELLOW), 3);
        board.dropToken(board.getToken(Color.RED), 3);
        board.dropToken(board.getToken(Color.RED), 3);

        String s = "[ ][ ][ ][ ][ ][ ][ ]\n"
                + "[ ][ ][ ][ ][ ][ ][ ]\n"
                + "[ ][ ][ ][X][ ][ ][ ]\n"
                + "[ ][ ][ ][X][X][O][X]\n"
                + "[ ][ ][ ][O][O][X][X]\n"
                + "[ ][ ][ ][O][O][O][X]\n";

        assertEquals(s, board.toString());
        assertEquals(Winner.RED, board.testVictory());
    }

    @Test
    public void testToString4() throws ColumnFullException, IllegalMoveException {
        Board board = new Board();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.dropToken(board.getToken(Color.RED), i);
                board.dropToken(board.getToken(Color.YELLOW), i);
            }
        }
        for (int i = 0; i < 3; i++) {
            board.dropToken(board.getToken(Color.YELLOW), 3);
            board.dropToken(board.getToken(Color.RED), 3);
        }
        for (int i = 4; i < 7; i++) {
            for (int j = 0; j < 3; j++) {
                board.dropToken(board.getToken(Color.RED), i);
                board.dropToken(board.getToken(Color.YELLOW), i);
            }
        }

        String s = "[O][O][O][X][O][O][O]\n"
                + "[X][X][X][O][X][X][X]\n"
                + "[O][O][O][X][O][O][O]\n"
                + "[X][X][X][O][X][X][X]\n"
                + "[O][O][O][X][O][O][O]\n"
                + "[X][X][X][O][X][X][X]\n";
        
        assertEquals(s, board.toString());
        assertEquals(Winner.TIE, board.testVictory());
    }
}
