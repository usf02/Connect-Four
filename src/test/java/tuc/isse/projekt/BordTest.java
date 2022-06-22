package tuc.isse.projekt;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import tuc.isse.projekt.Token.Color;

// Die Brette werden mit den gegebenen Spielsteine erstellt und mit der erwarteten Ausgabe (String s) verglichen

public class BordTest {
    @Test
    public void testToString() throws ColumnFullException {
        Bord bord = new Bord();
        bord.dropToken(Color.RED, 6);
        bord.dropToken(Color.RED, 6);
        bord.dropToken(Color.RED, 6);
        bord.dropToken(Color.YELLOW, 6);
        bord.dropToken(Color.YELLOW, 5);
        bord.dropToken(Color.RED, 5);
        bord.dropToken(Color.YELLOW, 4);
        bord.dropToken(Color.YELLOW, 4);
        bord.dropToken(Color.RED, 4);
        bord.dropToken(Color.YELLOW, 3);
        bord.dropToken(Color.YELLOW, 2);
        bord.dropToken(Color.RED, 2);

        String s = "[ ][ ][ ][ ][ ][ ][ ]\n"
                + "[ ][ ][ ][ ][ ][ ][ ]\n"
                + "[ ][ ][ ][ ][ ][ ][O]\n"
                + "[ ][ ][ ][ ][X][ ][X]\n"
                + "[ ][ ][X][ ][O][X][X]\n"
                + "[ ][ ][O][O][O][O][X]\n";

        assertEquals(s, bord.toString());
    }

    @Test
    public void testToString2() throws ColumnFullException {
        Bord bord = new Bord();
        bord.dropToken(Color.YELLOW, 6);
        bord.dropToken(Color.YELLOW, 6);
        bord.dropToken(Color.YELLOW, 6);
        bord.dropToken(Color.YELLOW, 5);
        bord.dropToken(Color.RED, 5);
        bord.dropToken(Color.YELLOW, 4);
        bord.dropToken(Color.RED, 4);
        bord.dropToken(Color.RED, 4);
        bord.dropToken(Color.RED, 4);
        bord.dropToken(Color.RED, 4);
        bord.dropToken(Color.RED, 3);
        bord.dropToken(Color.YELLOW, 2);
        bord.dropToken(Color.RED, 2);
        bord.dropToken(Color.RED, 1);
        bord.dropToken(Color.YELLOW, 0);

        String s = "[ ][ ][ ][ ][ ][ ][ ]\n"
                + "[ ][ ][ ][ ][X][ ][ ]\n"
                + "[ ][ ][ ][ ][X][ ][ ]\n"
                + "[ ][ ][ ][ ][X][ ][O]\n"
                + "[ ][ ][X][ ][X][X][O]\n"
                + "[O][X][O][X][O][O][O]\n";

        assertEquals(s, bord.toString());
    }

    @Test
    public void testToString3() throws ColumnFullException {
        Bord bord = new Bord();
        bord.dropToken(Color.RED, 6);
        bord.dropToken(Color.RED, 6);
        bord.dropToken(Color.RED, 6);
        bord.dropToken(Color.YELLOW, 6);
        bord.dropToken(Color.YELLOW, 5);
        bord.dropToken(Color.RED, 5);
        bord.dropToken(Color.YELLOW, 5);
        bord.dropToken(Color.YELLOW, 4);
        bord.dropToken(Color.YELLOW, 4);
        bord.dropToken(Color.RED, 4);
        bord.dropToken(Color.YELLOW, 3);
        bord.dropToken(Color.YELLOW, 3);
        bord.dropToken(Color.RED, 3);
        bord.dropToken(Color.RED, 3);

        String s = "[ ][ ][ ][ ][ ][ ][ ]\n"
                + "[ ][ ][ ][ ][ ][ ][ ]\n"
                + "[ ][ ][ ][X][ ][ ][O]\n"
                + "[ ][ ][ ][X][X][O][X]\n"
                + "[ ][ ][ ][O][O][X][X]\n"
                + "[ ][ ][ ][O][O][O][X]\n";

        assertEquals(s, bord.toString());
    }
}
