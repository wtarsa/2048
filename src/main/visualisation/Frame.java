package main.visualisation;

import main.map.Board;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    private Panel panel;
    private int blockSize = 120;
    private int lineSize = 15;
    private Board board;

    public Frame(Board board){
        this.board = board;
        this.setTitle("2048");
        this.setSize(4*blockSize+5*lineSize-60, 4*blockSize+5*lineSize+60);
        this.setBackground(Color.WHITE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.panel = new Panel(4*blockSize+5*lineSize-60, 4*blockSize+5*lineSize+120, blockSize, lineSize, board);
        this.panel.setFocusable(true);
        this.add(panel);

        this.setVisible(true);
    }
}
