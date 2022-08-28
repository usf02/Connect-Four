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

public class Token extends GameObject{
    public enum Color{RED, YELLOW};

    private Color color;

    // Konstruktor 
    public Token(Color color) {
        this.color = color;
    }

    // Getter und Setter
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    // Wandelt das Objekt in einen String um
    public String toString() {
        return color == Color.RED? "[X]":"[O]";
    }
    
}
