package tuc.isse.projekt.controller;

import java.io.IOException;
import java.util.Random;

import tuc.isse.projekt.model.Board;

public class ConsoleGame extends Game{

    public ConsoleGame(Board board) {
        super(board);
    }

    public void doGame(Player player1, Player player2) throws ColumnFullException, IllegalMoveException, NumberFormatException, IOException {
        Random rand = new Random();
        int x = rand.nextInt(2);
        if (x == 0) {
            this.current = player1;
        } else {this.current = player2;}

        this.player1 = player1;
        this.player2 = player2;

        System.out.println(board);

        while (board.testVictory() == null) {
            if (current == player1) {
                System.out.println("Spieler X, was ist dein nächster Zug?");
            } else {
                System.out.println("Spieler O, was ist dein nächster Zug?");
            }
            this.current.doTurn();

            swapPlayer();
            System.out.println(board);
        }
    }
    
}
