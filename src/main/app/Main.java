package main.app;

import main.map.Board;
import main.visualisation.Frame;

public class Main {

    public static void main(String args[]){
        Board board = new Board();
        Frame frame = new Frame(board);
    }
}
