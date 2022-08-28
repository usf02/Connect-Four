package tuc.isse.projekt.model;

import java.util.ArrayList;

import tuc.isse.projekt.controller.ColumnFullException;
import tuc.isse.projekt.controller.IllegalMoveException;

public class ObservableBoard extends Board{
  private ArrayList<BoardObserver> observers = new ArrayList<BoardObserver>();

  public ObservableBoard() {
    super();
  }

  public void addObserver(BoardObserver ob) {
    observers.add(ob);
  }

  public void removeObserver(BoardObserver ob) {
    observers.remove(ob);
  }

  public void notifyObserver() {
    for (BoardObserver ob : observers) {
      ob.update(this);
    }
  }

  public void dropToken(Token token, int columnIndex) throws ColumnFullException, IllegalMoveException {
    super.dropToken(token, columnIndex);
    notifyObserver();
  }
}
