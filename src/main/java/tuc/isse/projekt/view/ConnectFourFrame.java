package tuc.isse.projekt.view;

import javax.swing.*;

import java.awt.event.ActionListener;

import tuc.isse.projekt.model.BoardObserver;
import tuc.isse.projekt.model.ObservableBoard;

public class ConnectFourFrame implements BoardObserver{
  private JButton[] btns;
  private JPanel btnPanel;
  private Canvas canvas;
  JFrame frame;

  ObservableBoard board;

  public ConnectFourFrame(ObservableBoard board) {
    this.board = board;
    btns = new JButton[7];
    frame = new JFrame("Connect Four");
    canvas = new Canvas(board);
    btnPanel = new JPanel();

    btns[0] = new JButton("0");
    btns[1] = new JButton("1");
    btns[2] = new JButton("2");
    btns[3] = new JButton("3");
    btns[4] = new JButton("4");
    btns[5] = new JButton("5");
    btns[6] = new JButton("6");

    for (int i = 0; i < btns.length; i++) {
      btns[i].setActionCommand(String.valueOf(i));
    }

    //btnPanel.setLayout(new GridLayout(1, 7));

    for (int i = 0; i < btns.length; i++) {
      btnPanel.add(btns[i]);
    }

    btnPanel.setSize(855, 40);
    frame.add(btnPanel);
    frame.add(canvas);

    frame.setSize(855, 798);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  public void addButtonListener(ActionListener listener) {
    for (int i = 0; i < btns.length; i++) {
      btns[i].addActionListener(listener);
    }
  }

  public void removeButtonListener(ActionListener listener) {
    for (int i = 0; i < btns.length; i++) {
      btns[i].removeActionListener(listener);
    }
  }

  public void deactivateButtons() {
    for (int i = 0; i < btns.length; i++) {
      btns[i].setEnabled(false);
    }
  }

  public void deactivateFullColumn() {
    for (int i = 0; i < 7; i++) {
      if (!board.canDrop(i)) {
        btns[i].setEnabled(false);
        System.out.println("BUTTON DEACTIVATED");
      }
    }
  }

  @Override
  public void update(ObservableBoard board) {
    canvas.revalidate();
    canvas.repaint();
  }
  
}
