package tuc.isse.projekt.view;

import java.io.IOException;

import tuc.isse.projekt.controller.ColumnFullException;
import tuc.isse.projekt.controller.IllegalMoveException;
import tuc.isse.projekt.model.ObservableBoard;
import tuc.isse.projekt.model.Token.Color;

public class GameMain_Frame {
  public static void main(String[] args) throws NumberFormatException, ColumnFullException, IllegalMoveException, IOException {
    ObservableBoard board = new ObservableBoard();
    ConnectFourFrame frame = new ConnectFourFrame(board);

    FramePlayer player1 = new FramePlayer(Color.RED, board, frame);
    FramePlayer player2 = new FramePlayer(Color.YELLOW, board, frame);

    FrameGame game = new FrameGame(board, frame);
    game.doGame(player1, player2);
  }
}
