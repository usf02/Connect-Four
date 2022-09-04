package tuc.isse.projekt.view;

import tuc.isse.projekt.controller.ColumnFullException;
import tuc.isse.projekt.controller.IllegalMoveException;
import tuc.isse.projekt.controller.Player;
import tuc.isse.projekt.model.ObservableBoard;
import tuc.isse.projekt.model.Token.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class FramePlayer extends Player implements ActionListener{
  ConnectFourFrame frame;

  public FramePlayer(Color color, ObservableBoard board, ConnectFourFrame frame) {
    super(color, board);
    this.frame = frame;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    switch (e.getActionCommand()) {
      case "0":
        try {
          doDrop(0);
        } catch (ColumnFullException | IllegalMoveException | NumberFormatException | IOException e1) {
          e1.printStackTrace();
        }
        break;
      case "1":
        try {
          doDrop(1);
        } catch (ColumnFullException | IllegalMoveException | NumberFormatException | IOException e1) {
          e1.printStackTrace();
        }
        break;
      case "2":
        try {
          doDrop(2);
        } catch (ColumnFullException | IllegalMoveException | NumberFormatException | IOException e1) {
          e1.printStackTrace();
        }
        break;
      case "3":
        try {
          doDrop(3);
        } catch (ColumnFullException | IllegalMoveException | NumberFormatException | IOException e1) {
          e1.printStackTrace();
        }
        break;
      case "4":
        try {
          doDrop(4);
        } catch (ColumnFullException | IllegalMoveException | NumberFormatException | IOException e1) {
          e1.printStackTrace();
        }
        break;
      case "5":
        try {
          doDrop(5);
        } catch (ColumnFullException | IllegalMoveException | NumberFormatException | IOException e1) {
          e1.printStackTrace();
        }
        break;
      case "6":
        try {
          doDrop(6);
        } catch (ColumnFullException | IllegalMoveException | NumberFormatException | IOException e1) {
          e1.printStackTrace();
        }
        break;
    }
    frame.removeButtonListener(this);
  }

  @Override
  public void doTurn() throws ColumnFullException {
    frame.addButtonListener(this);
    for (int i = 0; i < 7; i++) {
      if (!board.canDrop(i)) {
        throw new ColumnFullException();
      }
    }
  }
  
}
