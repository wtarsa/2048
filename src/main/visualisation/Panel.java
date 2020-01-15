package main.visualisation;

import main.map.Board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel extends JPanel implements ActionListener {

    private int width;
    private int height;
    private int blockSize;
    private int lineSize;
    private Board board;

    private ImageIcon number2 = new ImageIcon("src/assets/2.png");
    private ImageIcon number4 = new ImageIcon("src/assets/4.png");
    private ImageIcon number8 = new ImageIcon("src/assets/8.png");
    private ImageIcon number16 = new ImageIcon("src/assets/16.png");
    private ImageIcon number32 = new ImageIcon("src/assets/32.png");
    private ImageIcon number64 = new ImageIcon("src/assets/64.png");
    private ImageIcon number128 = new ImageIcon("src/assets/128.png");
    private ImageIcon number256 = new ImageIcon("src/assets/256.png");
    private ImageIcon number512 = new ImageIcon("src/assets/512.png");
    private ImageIcon number1024 = new ImageIcon("src/assets/1024.png");
    private ImageIcon number2048 = new ImageIcon("src/assets/2048.png");



    public Panel(int width, int height, int blockSize, int lineSize, Board board){
        this.board = board;
        this.height = height;
        this.width = width;
        this.blockSize = blockSize;
        this.lineSize = lineSize;
        // this.timer = new Timer(delay, this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);

        this.paintBackground(graphics);
        this.drawBorders(graphics);
        this.drawElements(graphics);

    }

    private void paintBackground(Graphics graphics){
        graphics.setColor(new Color(250, 248, 239));
        graphics.fillRect(0, 0, width, 180);

        graphics.setColor(new Color(205, 193, 180));
        graphics.fillRect(0, 180, width, height-180);
    }

    private void drawBorders(Graphics graphics){
        for(int i = 180; i < height; i+=blockSize){
            graphics.setColor(new Color(187, 173, 160));
            graphics.fillRect(0, i, width, lineSize);
        }
        for(int i = 0; i < width; i+=blockSize){
            graphics.setColor(new Color(187, 173, 160));
            graphics.fillRect(i, 180,  lineSize,height-180);
        }
    }

    private void drawElements(Graphics graphics){
        for(int i = 0; i < 16; i++){
            if(this.board.isEmpty(i)){
                graphics.setColor(new Color(238, 228, 218));
                paintIconNumber(graphics, i);
            }
        }
    }

    private void paintIconNumber(Graphics graphics, int i){
        switch (this.board.getValue(i)){
            case 2:
                number2.paintIcon(this, graphics, xCoordinate(i), yCoordinate(i));
                break;
            case 4:
                number4.paintIcon(this, graphics, xCoordinate(i), yCoordinate(i));
                break;
            case 8:
                number8.paintIcon(this, graphics, xCoordinate(i), yCoordinate(i));
                break;
            case 16:
                number16.paintIcon(this, graphics, xCoordinate(i), yCoordinate(i));
                break;
            case 32:
                number32.paintIcon(this, graphics, xCoordinate(i), yCoordinate(i));
                break;
            case 64:
                number64.paintIcon(this, graphics, xCoordinate(i), yCoordinate(i));
                break;
            case 128:
                number128.paintIcon(this, graphics, xCoordinate(i), yCoordinate(i));
                break;
            case 256:
                number256.paintIcon(this, graphics, xCoordinate(i), yCoordinate(i));
                break;
            case 512:
                number512.paintIcon(this, graphics, xCoordinate(i), yCoordinate(i));
                break;
            case 1024:
                number1024.paintIcon(this, graphics, xCoordinate(i), yCoordinate(i));
                break;
            case 2048:
                number2048.paintIcon(this, graphics, xCoordinate(i), yCoordinate(i));
                break;
            default:
                //number16.paintIcon(this, graphics, xCoordinate(i), yCoordinate(i));
                break;
        }
    }

    private int xCoordinate(int i){
        return lineSize+(blockSize)*blockCol(i);
    }

    private int yCoordinate(int i){
        return 180+lineSize+(blockSize)*blockRow(i);
    }

    private int blockRow(int id){
        return id/4;
    }

    private int blockCol(int id){
        return id%4;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        repaint();
    }
}
