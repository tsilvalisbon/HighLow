package highLow;

public class Deck {
    
    private int cardsLeft;
    private Card[] cards;

    public Deck(){
        cards = new Card[52];
        createDeck();
        shuffle();
    }

    private void createDeck() {
        String[] suits = {"Espadas", "Copas", "Paus", "Ouros"};

        int suitIndex = 0;
        int cardIndex = 0;

        while (suitIndex < suits.length) {
            String suit = suits[suitIndex];
            int value = 1;

            while (value <= 13) {
                cards[cardIndex] = new Card(value, suit);

                cardIndex++;
                value++;
            }
            suitIndex++;
        }
    }

    public void shuffle() {
        int cardIndex = cards.length - 1;

        while (cardIndex > 0) {
            int randomIndex = (int) (Math.random() * (cardIndex + 1));

            Card temp = cards[cardIndex];
            cards[cardIndex] = cards[randomIndex];
            cards[randomIndex] = temp;
            cardIndex--;
        }
        cardsLeft = cards.length;
    }

    public Card dealCard() {
        if (cardsLeft == 0)
            return null;
        cardsLeft--;
        return cards[cardsLeft];
    }

    public int getCardsLeft(){
        return cardsLeft;
    }
}