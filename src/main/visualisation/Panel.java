package main.visualisation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel extends JPanel implements ActionListener {

    private int width;
    private int height;

    public Panel(int width, int height){
        this.height = height;
        this.width = width;
        // this.timer = new Timer(delay, this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);

        graphics.setColor(Color.GRAY);
        graphics.fillRect(0, 0, width, height);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        repaint();
    }
}
