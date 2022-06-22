package tuc.isse.projekt;

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

import tuc.isse.projekt.Token.Color;

public class Main {
    public static void main(String[] args) throws Exception {
        Bord bord1 = new Bord();
        bord1.dropToken(Color.RED, 6);
        bord1.dropToken(Color.RED, 6);
        bord1.dropToken(Color.RED, 6);
        bord1.dropToken(Color.YELLOW, 6);
        bord1.dropToken(Color.YELLOW, 5);
        bord1.dropToken(Color.RED, 5);
        bord1.dropToken(Color.YELLOW, 4);
        bord1.dropToken(Color.YELLOW, 4);
        bord1.dropToken(Color.RED, 4);
        bord1.dropToken(Color.YELLOW, 3);
        bord1.dropToken(Color.YELLOW, 2);
        bord1.dropToken(Color.RED, 2);
        System.out.println(bord1);
    }

}
