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
 * Diese Klasse ist die abstrakte obere Klasse
 * @author Youssef Fayed
 * @author Ghiath Al Akad
 */

public abstract class GameObject {
    public enum Winner{RED, YELLOW, TIE};
    
    //Abstrakte Methode ohne Körper, wandelt den Inhalt der Klasse zu einer String um.
    public abstract String toString();
}
