package tuc.isse.projekt.controller;

import java.io.IOException;
import java.util.Random;

import tuc.isse.projekt.model.Board;
import tuc.isse.projekt.model.GameObject.Winner;

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

        while (board.testVictory() == Winner.ONGOING) {
            if (current == player1) {
                System.out.println("Player X, What's your next move?");
            } else {
                System.out.println("Player O, What's your next move?");
            }
            this.current.doTurn();

            swapPlayer();
            System.out.println(board);
        }
    }
    
}
