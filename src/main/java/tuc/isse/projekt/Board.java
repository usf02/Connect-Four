package tuc.isse.projekt;

import java.util.ArrayList;

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

class Board extends GameObject {

    // Erstellen des Zwei-dimensionalen Arrays (das Brett)
    public final int rows = 6;
    public final int columns = 7;
    public Cell[][] cells;
    ArrayList<Token> red = new ArrayList<Token>(21);
    ArrayList<Token> yellow = new ArrayList<Token>(21);

    // Konstruktor
    public Board() {
        this.cells = new Cell[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                cells[i][j] = new Cell();
            }
        }

        for (int i = 0; i < 21; i++) {
            red.add(new Token(Color.RED));
        }
        for (int i = 0; i < 21; i++) {
            yellow.add(new Token(Color.YELLOW));
        }
    }

    public Token getToken(Color color) {
        Token token;

        if (color == Color.RED) {
            token = red.remove(red.size() - 1); 
        } else {
            token = yellow.remove(yellow.size() - 1);
        }
        return token;
    }

    public boolean hasToken(Color color) {
        if (color == Color.RED) {
            if (red.isEmpty()) {
                return false;
            }
            return true;
        } else {
            if (yellow.isEmpty()) {
                return false;
            }
            return true;
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
    public void dropToken(Token token, int columnIndex) throws ColumnFullException, IllegalMoveException {
        if (testVictory() != null) {
            throw new IllegalMoveException();
        }

        if (!canDrop(columnIndex)) {
            throw new ColumnFullException();
        } 

        for (int n = rows - 1; n >= 0; n--) {
            if (cells[n][columnIndex].getAktuelleToken() == null) {
                cells[n][columnIndex].setAktuelleToken(token);
                break;
            }
        }
        
    }

    // Prüft durch Umwandlung zu Strings, ob vier Steine der angegebene Farbe in einer Reihe stehen.
    private Boolean isRowVictory(Color color) {
        String str;

        if (color == Color.RED) {
            str = "[X][X][X][X]";
        } else {
            str = "[O][O][O][O]";
        }
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns - 3; j++) {
                String s1 = cells[i][j].toString();
                String s2 = cells[i][j+1].toString();
                String s3 = cells[i][j+2].toString();
                String s4 = cells[i][j+3].toString();
                String x = s1 + s2 + s3 + s4;

                if (x.equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    //Prüft durch Umwandlung zu Strings, ob vier Steine der angegebene Farbe in einer Spalte stehen. 
    private Boolean isColumnVictory(Color color) {
        String str;

        if (color == Color.RED) {
            str = "[X]\n[X]\n[X]\n[X]";
        } else {
            str = "[O]\n[O]\n[O]\n[O]";
        }

        for (int i = 0; i < rows - 3; i++) {
            for (int j = 0; j < columns; j++) {
                String s1 = cells[i][j].toString();
                String s2 = cells[i+1][j].toString();
                String s3 = cells[i+2][j].toString();
                String s4 = cells[i+3][j].toString();
                String x = s1 + "\n" + s2 + "\n" + s3 + "\n" + s4;

                if (x.equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    // Prüft durch Umwandlung zu Strings, ob vier Steine der angegebene Farbe in einer Diagonalen stehen.
    private Boolean isDiagonalVictory(Color color) {
        String str;

        if (color == Color.RED) {
            str = "[X]\n   [X]\n      [X]\n         [X]";
        } else {
            str = "[O]\n   [O]\n      [O]\n         [O]";
        }

        for (int i = 0; i < rows - 3; i++) {
            for (int j = 0; j < columns - 3; j++) {
                String s1 = cells[i][j].toString();
                String s2 = cells[i+1][j+1].toString();
                String s3 = cells[i+2][j+2].toString();
                String s4 = cells[i+3][j+3].toString();
                String x = s1 + "\n   " + s2 + "\n      " + s3 + "\n         " + s4;

                if (x.equals(str)) {
                    return true;
                }
            }
        }

        if (color == Color.RED) {
            str = "         [X]\n      [X]\n   [X]\n[X]";
        } else {
            str = "         [O]\n      [O]\n   [O]\n[O]";
        }

        for (int i = 0; i < rows - 3; i++) {
            for (int j = 6; j > 2; j--) {
                String s1 = cells[i][j].toString();
                String s2 = cells[i+1][j-1].toString();
                String s3 = cells[i+2][j-2].toString();
                String s4 = cells[i+3][j-3].toString();
                String x = "         " + s1 + "\n      " + s2 + "\n   " + s3 + "\n" + s4;

                if (x.equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    private Boolean isTie() {
        int ct = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (cells[i][j].getAktuelleToken() != null) {
                    ct++;
                }
            }
        }

        if (yellow.isEmpty() && red.isEmpty() && ct == 42) {
            return true;
        }
        return false;
    }

    // Prüft alle drei Siegbedingungen und gibt den Sieger mithilfe von dem Enum "Winner" zurück.
    public Winner testVictory() {
        boolean redWin = isColumnVictory(Color.RED) || isRowVictory(Color.RED) || isDiagonalVictory(Color.RED);
        boolean yellowWin = isColumnVictory(Color.YELLOW) || isRowVictory(Color.YELLOW) || isDiagonalVictory(Color.YELLOW);

        if (redWin) {
            System.out.println("Red Wins!");
            return Winner.RED;
        } else if (yellowWin) {
            System.out.println("Yellow Wins!");
            return Winner.YELLOW;
        } else if (isTie()) {
            System.out.println("Draw!");
            return Winner.TIE;
        } 
        return null;
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
