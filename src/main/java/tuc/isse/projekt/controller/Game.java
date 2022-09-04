package tuc.isse.projekt.controller;

import java.io.IOException;

import tuc.isse.projekt.model.Board;

public abstract class Game {
    protected Board board;
    protected Player player1;
    protected Player player2;
    protected Player current;

    public Game(Board board) {
      this.board = board;
    }

    protected void swapPlayer() {
      if (current == player1) {
          current = player2;
      } else {current = player1;}
    }

    public abstract void doGame(Player player1, Player player2) throws ColumnFullException, IllegalMoveException, NumberFormatException, IOException;
}
