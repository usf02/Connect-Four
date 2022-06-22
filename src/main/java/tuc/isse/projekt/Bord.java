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

import tuc.isse.projekt.Token.Color;

/**
 * @author Youssef Fayed
 * @author Ghiath Al Akad
 */

class Bord extends GameObject {

    // Erstellen des Zwei-dimensionalen Arrays (das Brett)
    public final int rows = 6;
    public final int columns = 7;
    public Cell[][] cells;

    // Konstruktor
    public Bord() {
        this.cells = new Cell[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    // Diese Methode prüft, ob es Freiplatz in einer gegebenen Spalte gibt 
    public boolean canDrop(int columnIndex) {
        if (cells[0][columnIndex].getAktuelleToken() == null) {
            return true;
        } else {
            return false;
        }
       
    }

    // Diese Methode setzt ein Spielstein von der gewählten Farbe in der untersten freien Zelle einer gegebenen Spalte.
    // Ausnahme ist eine Spalte ohne Freiplatz
    public void dropToken(Color color, int columnIndex) throws ColumnFullException {
        if (!canDrop(columnIndex)) {
            throw new ColumnFullException();
        } 

        for (int n = rows - 1; n >= 0; n--) {
            if (cells[n][columnIndex].getAktuelleToken() == null) {
                cells[n][columnIndex].setAktuelleToken(new Token(color));
                break;
            }
        }
        
    }

    // Wandelt das Objekt in einen String um
    public String toString() {
        String result = "";

        for (Cell[] row : cells) {
            for (Cell cell : row) {
                result += cell.toString();
            }
            result += "\n";
        }
        return result;
    }

}
