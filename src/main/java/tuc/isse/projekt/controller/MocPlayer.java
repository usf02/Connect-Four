package tuc.isse.projekt.controller;

import java.io.IOException;

import tuc.isse.projekt.model.ObservableBoard;
import tuc.isse.projekt.model.Token.Color;

public class MocPlayer extends Player{
    int move;

    public MocPlayer(Color color, ObservableBoard board, int move) {
        super(color, board);
        this.move = move;
    }

    public void doTurn() throws NumberFormatException, ColumnFullException, IllegalMoveException, IOException {
        super.doDrop(move);
    }
    
}
