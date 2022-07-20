package tuc.isse.projekt;

import tuc.isse.projekt.Token.Color;

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
