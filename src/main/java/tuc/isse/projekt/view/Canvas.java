package tuc.isse.projekt.view;

import javax.swing.*;

import tuc.isse.projekt.model.ObservableBoard;

import java.awt.*;

public class Canvas extends JPanel{
  ObservableBoard board;
  tuc.isse.projekt.model.Token.Color color;

  public Canvas(ObservableBoard board) {
    this.board = board;
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    for (int i = 0; i < 6; i++) {
      for (int j = 0; j < 7; j++) {
        if (board.getTokenColor(i, j) == null) {
          g.setColor(Color.WHITE);
          g.fillOval(j * 120, (i * 120) + 40, 120, 120);
        } else if (board.getTokenColor(i, j) == tuc.isse.projekt.model.Token.Color.RED) {
          g.setColor(Color.RED);
          g.fillOval(j * 120, (i * 120) + 40, 120, 120);
        } else {
          g.setColor(Color.YELLOW);
          g.fillOval(j * 120, (i * 120) + 40, 120, 120);
        }
      }
    }
  }

}
