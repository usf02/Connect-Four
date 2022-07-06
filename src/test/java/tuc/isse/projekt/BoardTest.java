package tuc.isse.projekt;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import tuc.isse.projekt.GameObject.Winner;
import tuc.isse.projekt.Token.Color;

// Die Brette werden mit den gegebenen Spielsteine erstellt und mit der erwarteten Ausgabe (String s) verglichen
// Dazu werden die Siegbedingungen noch überprüft.

public class BoardTest {
    @Test
    public void testToString() throws ColumnFullException {
        Board board = new Board();
        board.dropToken(Color.RED, 6);
        board.dropToken(Color.RED, 6);
        board.dropToken(Color.RED, 6);
        board.dropToken(Color.YELLOW, 6);
        board.dropToken(Color.YELLOW, 5);
        board.dropToken(Color.RED, 5);
        board.dropToken(Color.YELLOW, 4);
        board.dropToken(Color.YELLOW, 4);
        board.dropToken(Color.RED, 4);
        board.dropToken(Color.YELLOW, 3);
        board.dropToken(Color.YELLOW, 2);
        board.dropToken(Color.RED, 2);

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
    public void testToString2() throws ColumnFullException {
        Board board = new Board();
        board.dropToken(Color.YELLOW, 6);
        board.dropToken(Color.YELLOW, 6);
        board.dropToken(Color.YELLOW, 6);
        board.dropToken(Color.YELLOW, 5);
        board.dropToken(Color.RED, 5);
        board.dropToken(Color.YELLOW, 4);
        board.dropToken(Color.RED, 4);
        board.dropToken(Color.RED, 4);
        board.dropToken(Color.RED, 4);
        board.dropToken(Color.RED, 4);
        board.dropToken(Color.RED, 3);
        board.dropToken(Color.YELLOW, 2);
        board.dropToken(Color.RED, 2);
        board.dropToken(Color.RED, 1);
        board.dropToken(Color.YELLOW, 0);

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
    public void testToString3() throws ColumnFullException {
        Board board = new Board();
        board.dropToken(Color.RED, 6);
        board.dropToken(Color.RED, 6);
        board.dropToken(Color.RED, 6);
        board.dropToken(Color.YELLOW, 6);
        board.dropToken(Color.YELLOW, 5);
        board.dropToken(Color.RED, 5);
        board.dropToken(Color.YELLOW, 5);
        board.dropToken(Color.YELLOW, 4);
        board.dropToken(Color.YELLOW, 4);
        board.dropToken(Color.RED, 4);
        board.dropToken(Color.YELLOW, 3);
        board.dropToken(Color.YELLOW, 3);
        board.dropToken(Color.RED, 3);
        board.dropToken(Color.RED, 3);

        String s = "[ ][ ][ ][ ][ ][ ][ ]\n"
                + "[ ][ ][ ][ ][ ][ ][ ]\n"
                + "[ ][ ][ ][X][ ][ ][O]\n"
                + "[ ][ ][ ][X][X][O][X]\n"
                + "[ ][ ][ ][O][O][X][X]\n"
                + "[ ][ ][ ][O][O][O][X]\n";

        assertEquals(s, board.toString());

        // Obwohl eigentlich beide Farben gewonnen haben (was niemals in einem echten Spiel passieren kann),
        // gibt die Methode Winner.RED zurück, weil es in der Methode erst auf Red überprüft wird.
        assertEquals(Winner.RED, board.testVictory());
    }
}
