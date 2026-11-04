package highLow;

public class Deck {
    
    private int cardsLeft;
    private Card[] cards;

    public Deck(){
        cards = new Card[52];
        createDeck();
        shuffle();
    }

    public void createDeck(){

    }

    public void shuffle(){

    }

    public void dealCard(){

    }

    public int cardsLeft(){
        return cards.length;
    }
}