package tuc.isse.projekt.controller;

import java.io.IOException;

import tuc.isse.projekt.model.ObservableBoard;
import tuc.isse.projekt.model.Token.Color;

public abstract class Player {
    Color color;
    protected ObservableBoard board;

    public Player(Color color, ObservableBoard board) {
        this.color = color;
        this.board = board;
    }

    protected void doDrop(int columnIndex) throws ColumnFullException, IllegalMoveException, NumberFormatException, IOException{
      board.dropToken(board.getToken(this.color), columnIndex);
    }

    public abstract void doTurn() throws NumberFormatException, IOException, ColumnFullException, IllegalMoveException;
}
