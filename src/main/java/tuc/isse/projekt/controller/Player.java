package tuc.isse.projekt.controller;

import java.io.IOException;

import tuc.isse.projekt.model.Board;
import tuc.isse.projekt.model.Token.Color;

public abstract class Player {
    Color color;
    Board board;

    public Player(Color color, Board board) {
        this.color = color;
        this.board = board;
    }

    protected void doDrop(int columnIndex) throws ColumnFullException, IllegalMoveException{
        board.dropToken(board.getToken(this.color), columnIndex);
    }

    public abstract void doTurn() throws ColumnFullException, IllegalMoveException, NumberFormatException, IOException;
}
