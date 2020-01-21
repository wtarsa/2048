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
        this.addBlock();
        this.addBlock();
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
        int blockNumber = this.random.nextInt(16);
        while (!this.isEmpty(blockNumber)) blockNumber = this.random.nextInt(16);
        this.board.set(blockNumber, 2);
    }

    public int getValue(int i){
        return this.board.get(i);
    }

    public boolean moveUp(){
        boolean flag = false;
        for(int k = 0; k < 3; k++){
            for(int i = 4+k*4; i < 16; i++){
                if(!this.board.get(i).equals(0) && this.board.get(i-4).equals(0)) {
                    int j = i;
                    while (j-4 >= 0 && this.board.get(j-4).equals(0)) j -= 4;
                    this.board.set(j, this.board.get(i));
                    this.board.set(i, 0);
                    flag = true;
                }
            }
            for(int i = k*4; i < k*4+4; i++){
                if(!this.board.get(i).equals(0) && this.board.get(i+4).equals(this.board.get(i))){
                    this.board.set(i, this.board.get(i)*2);
                    this.board.set(i+4, 0);
                    flag = true;
                }
            }
        }
        return flag;
    }

    public boolean moveDown(){
        boolean flag = false;
        for(int k = 3; k > 0; k--){
            for(int i = k*4-1; i >= 0; i--){
                if(!this.board.get(i).equals(0) && this.board.get(i+4).equals(0)) {
                    int j = i;
                    while (j+4 < 16 && this.board.get(j+4).equals(0)) j += 4;
                    this.board.set(j, this.board.get(i));
                    this.board.set(i, 0);
                    flag = true;
                }
            }
            for(int i = k*4+3; i >= k*4; i--){
                if(!this.board.get(i).equals(0) && this.board.get(i-4).equals(this.board.get(i))){
                    this.board.set(i, this.board.get(i)*2);
                    this.board.set(i-4, 0);
                    flag = true;
                }
            }
        }
        return flag;
    }

    public boolean moveLeft(){
        boolean flag = false;
        int[] leftMoves = {0, 4, 8, 12, 1, 5, 9, 13, 2, 6, 10, 14, 3, 7, 11, 15};
        for(int k = 0; k < 3; k++){
            for(int l = 4+k*4; l < 16; l++){
                int i = leftMoves[l];
                if(!this.board.get(i).equals(0) && this.board.get(i-1).equals(0)) {
                    int j = i;
                    while (j-1 >= 0 && !(j % 4 == 0) && this.board.get(j-1).equals(0)) j -= 1;
                    this.board.set(j, this.board.get(i));
                    this.board.set(i, 0);
                    flag = true;
                }
            }
            for(int l = k*4; l < k*4+4; l++){
                int i = leftMoves[l];
                if(!this.board.get(i).equals(0) && this.board.get(i+1).equals(this.board.get(i))){
                    this.board.set(i, this.board.get(i)*2);
                    this.board.set(i+1, 0);
                    flag = true;
                }
            }
        }
        return flag;
    }

    public boolean moveRight(){
        boolean flag = false;
        int[] rightMoves = {15, 11, 7, 3, 14, 10, 6, 2, 13, 9, 5, 1, 12, 8, 4, 0};
        for(int k = 0; k < 3; k++){
            for(int l = 4+k*4; l < 16; l++){
                int i = rightMoves[l];
                if(!this.board.get(i).equals(0) && this.board.get(i+1).equals(0)) {
                    int j = i;
                    while (j+1 >= 0 && !(j % 4 == 3) && this.board.get(j+1).equals(0)) j += 1;
                    this.board.set(j, this.board.get(i));
                    this.board.set(i, 0);
                    flag = true;
                }
            }
            for(int l = k*4; l < k*4+4; l++){
                int i = rightMoves[l];
                if(!this.board.get(i).equals(0) && this.board.get(i-1).equals(this.board.get(i))){
                    this.board.set(i, this.board.get(i)*2);
                    this.board.set(i-1, 0);
                    flag = true;
                }
            }
        }
        return flag;
    }

    public boolean can_move(){
        if(this.freePlaces() > 0) return true;
        else if(this.freePlaces() == 0){
            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 4; j++){
                    int current = i*4+j;
                    int bottom = current + 4;
                    int top = current - 4;
                    int left = current - 1;
                    int right = current + 1;
                    if(bottom < 16 && this.getValue(current) == this.getValue(bottom)) return true;
                    if(top > 0 && this.getValue(current) == this.getValue(top)) return true;
                    if(left > 0 && left % 4 != 3 && this.getValue(current) == this.getValue(left)) return true;
                    if(right % 4 != 0 && this.getValue(current) == this.getValue(right)) return true;
                }
            }
        }
        return false;
    }

    public boolean win(){
        for(int i = 0; i < 16; i++){
            if(getValue(i)==2048) return true;
        }
        return false;
    }

    public void new_game(){
        this.board.clear();
        this.fillWithZeros();
        this.addBlock();
        this.addBlock();
    }
}
