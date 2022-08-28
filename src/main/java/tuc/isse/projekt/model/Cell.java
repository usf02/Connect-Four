package tuc.isse.projekt.model;

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

public class Cell extends GameObject {

    private Token aktuelleToken;

    // Getter und Setter
    public Token getAktuelleToken() {
        return aktuelleToken;
    }

    public void setAktuelleToken(Token token) {
        this.aktuelleToken = token;
    }

    // Wandelt das Objekt in einen String um
    public String toString() {
        if(aktuelleToken == null) {
            return "[ ]";
        } else {
            return aktuelleToken.toString();
        }
    }
}
