package tuc.isse.projekt.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import tuc.isse.projekt.model.Board;
import tuc.isse.projekt.model.Token.Color;

public class ConsolePlayer extends Player{

    public ConsolePlayer(Color color, Board board) {
        super(color, board);
    }

    public void doTurn() throws ColumnFullException, IllegalMoveException, NumberFormatException, IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(consoleReader.readLine());
        super.doDrop(x);
    }
    
}
