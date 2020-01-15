package main.visualisation;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    private Panel panel;
    private int blockSize = 60;
    private int lineSize = 10;

    public Frame(){
        this.setTitle("2048");
        this.setBounds(10, 10, 5*blockSize+4*lineSize, 6*blockSize+5*lineSize);
        this.setBackground(Color.WHITE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.panel = new Panel(5*blockSize+4*lineSize, 6*blockSize+5*lineSize);
        this.panel.setFocusable(true);
        this.add(panel);

        //setVisible must be on the end!
        this.setVisible(true);
    }
}
