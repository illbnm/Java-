package Bank;

import java.util.Arrays;

public class Bank {
    private BankCard[] cards;
    private int size;
    public Bank(){
        cards = new BankCard[10];
        size = 0;
    }
    private  boolean isFull(){
        return size == cards.length;
    }
    public void add(BankCard card){
        if(isFull()){
            cards = Arrays.copyOf(cards,cards.length*2);
        }
        cards[size] = card;
        size++;
    }
    public int getSize(){
        return size;
    }
    public BankCard[] getCards(){
        return cards;
    }
}
