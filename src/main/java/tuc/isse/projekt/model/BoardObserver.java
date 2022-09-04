package tuc.isse.projekt.model;

import java.io.IOException;

import tuc.isse.projekt.controller.ColumnFullException;
import tuc.isse.projekt.controller.IllegalMoveException;

public interface BoardObserver {
  public void update(ObservableBoard board);
}
