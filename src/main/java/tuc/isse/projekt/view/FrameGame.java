package tuc.isse.projekt.view;

import java.io.IOException;
import java.util.Random;

import javax.swing.JOptionPane;

import tuc.isse.projekt.controller.ColumnFullException;
import tuc.isse.projekt.controller.Game;
import tuc.isse.projekt.controller.IllegalMoveException;
import tuc.isse.projekt.controller.Player;
import tuc.isse.projekt.model.BoardObserver;
import tuc.isse.projekt.model.ObservableBoard;

public class FrameGame extends Game implements BoardObserver{
  ConnectFourFrame frame;

  public FrameGame(ObservableBoard board, ConnectFourFrame frame) {
    super(board);
    this.frame = frame;
    board.addObserver(this);
  }

  public void askTurn() {
    if (current == player1) {
      JOptionPane.showInternalMessageDialog(null, "Your Turn, Red", 
      "What's Your Next Move?", JOptionPane.PLAIN_MESSAGE);
    } else {
      JOptionPane.showInternalMessageDialog(null, "Your Turn, Yellow", 
      "What's Your Next Move?", JOptionPane.PLAIN_MESSAGE);
    }
  }

  @Override
  public void update(ObservableBoard board)  {
    frame.update(board);

    if (board.testVictory() == null) {
      swapPlayer();
      askTurn();
      try {
        current.doTurn();
      } catch (NumberFormatException | IOException | ColumnFullException | IllegalMoveException e) {
        e.printStackTrace();
        frame.deactivateFullColumn();
      }
    } else {
      frame.deactivateButtons();
    }

    switch (board.testVictory()) {
      case RED:
        JOptionPane.showInternalMessageDialog(null, "Red Wins!", "Game Ended", 
          JOptionPane.PLAIN_MESSAGE);
        break;
      case YELLOW:
        JOptionPane.showInternalMessageDialog(null, "Yellow Wins!", "Game Ended", 
          JOptionPane.PLAIN_MESSAGE);
        break;
      case TIE:
        JOptionPane.showInternalMessageDialog(null, "Draw!", "Game Ended", 
          JOptionPane.PLAIN_MESSAGE);
        break;
      default:
        break;
    }
  }

  @Override
  public void doGame(Player player1, Player player2)
      throws ColumnFullException, IllegalMoveException, NumberFormatException, IOException {
        
    this.player1 = player1;
    this.player2 = player2;

    Random rand = new Random();
    int x = rand.nextInt(2);
    if (x == 0) {
      this.current = player1;
    } else {
      this.current = player2;
    }

    askTurn();
    current.doTurn();
  }
}
