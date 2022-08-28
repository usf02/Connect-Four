package tuc.isse.projekt.controller;

import tuc.isse.projekt.model.Board;
import tuc.isse.projekt.model.Token.Color;

public class MocPlayer extends Player{
    int move;

    public MocPlayer(Color color, Board board, int move) {
        super(color, board);
        this.move = move;
    }

    public void doTurn() throws ColumnFullException, IllegalMoveException {
        super.doDrop(move);
    }
    
}
