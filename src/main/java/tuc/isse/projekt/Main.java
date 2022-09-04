package tuc.isse.projekt;

import tuc.isse.projekt.model.ObservableBoard;
import tuc.isse.projekt.model.Token.Color;
import tuc.isse.projekt.view.ConnectFourFrame;

/**
 * @author Youssef Fayed
 * @author Ghiath Al Akad
 */

public class Main {
    public static void main(String[] args) throws Exception {
        // Hier wird nur getestet.
        ObservableBoard board = new ObservableBoard();
        board.dropToken(board.getToken(Color.YELLOW), 6);
        board.dropToken(board.getToken(Color.YELLOW), 6);
        board.dropToken(board.getToken(Color.YELLOW), 6);
        board.dropToken(board.getToken(Color.YELLOW), 5);
        board.dropToken(board.getToken(Color.RED), 5);
        board.dropToken(board.getToken(Color.YELLOW), 4);
        board.dropToken(board.getToken(Color.RED), 4);
        board.dropToken(board.getToken(Color.RED), 4);
        board.dropToken(board.getToken(Color.RED), 4);
        board.dropToken(board.getToken(Color.RED), 3);
        board.dropToken(board.getToken(Color.YELLOW), 2);
        board.dropToken(board.getToken(Color.RED), 2);
        board.dropToken(board.getToken(Color.RED), 1);
        board.dropToken(board.getToken(Color.YELLOW), 0);
        //board.dropToken(board.getToken(Color.RED), 4);
        System.out.println(board);
        board.testVictory();


        new ConnectFourFrame(board);
    }

}
