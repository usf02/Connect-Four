package tuc.isse.projekt;

import tuc.isse.projekt.GameObject.Winner;
import tuc.isse.projekt.Token.Color;
/*
* yf69@tu-clausthal.de
* Vorname: Youssef
* Nachname: Fayed
*
* ghiath.al.akad@tu-clausthal.de
* Vorname: Ghiath
* Nachname: Al Akad
*/

/**
 * @author Youssef Fayed
 * @author Ghiath Al Akad
 */

public class Main {
    public static void main(String[] args) throws Exception {
        // Hier wird nur getestet.
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
        System.out.println(board);

        board.testVictory();
    }

}
