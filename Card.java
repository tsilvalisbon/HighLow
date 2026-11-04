// Mariana Rosa a22608340
// Martim Pires a22610371
// Tomás Silva a22608276

package highLow;

public class Card {

    private int value;
    private String suit;
    
    public Card(int value, String suit){
        this.value = value;
        this.suit = suit;
    }

    public int getValue(){
        return value;
    }

    public String getSuit(){
        return suit;
    }

    @Override
    public String toString(){
        return "Valor da carta: " + value + " Naipe: " + suit;
    }
}