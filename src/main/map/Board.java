package main.map;

import java.util.LinkedList;
import java.util.Random;

public class Board {

    private LinkedList<Integer> board;
    private Random random;

    public Board(){
        this.board = new LinkedList<Integer>();
        this.fillWithZeros();
        this.random = new Random();
    }

    private void fillWithZeros(){
        for(int i = 0; i < 16; i++){
            this.board.add(0);
        }
    }

    public boolean isEmpty(int blockNumber){
        Integer value = this.board.get(blockNumber);
        return value.equals(0);
    }

    private int freePlaces(){
        int result = 0;
        for(int i = 0; i < 16; i++){
            if(this.board.get(i).equals(0)) result++;
        }
        return result;
    }

    public void addBlock(){
        int places = this.freePlaces();
        int blockNumber = this.random.nextInt(16);
        while (!this.isEmpty(blockNumber)) blockNumber = this.random.nextInt(16);
        this.board.set(blockNumber, 2);
    }

    public int getValue(int i){
        return this.board.get(i);
    }


}
