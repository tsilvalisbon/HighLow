// Mariana Rosa a22608340
// Martim Pires a22610371
// Tomás Silva a22608276

package highLow;

public class Deck {
    
    private int cardsLeft;
    private Card[] cards;

    // Construtor que inicializa o baralho e baralha as cartas
    public Deck(){
        cards = new Card[52];
        createDeck();
        shuffle();
    }

    // Método privado que cria o baralho de cartas
    private void createDeck() {
        String[] suits = {"Espadas", "Copas", "Paus", "Ouros"};

        int suitIndex = 0;
        int cardIndex = 0;
        // Loop para criar as cartas de cada naipe
        while (suitIndex < suits.length) {
            String suit = suits[suitIndex];
            int value = 1;
            // Loop para criar as cartas de cada valor (1 a 13) para o naipe atual
            while (value <= 13) {
                cards[cardIndex] = new Card(value, suit);
                cardIndex++;
                value++;
            }
            // Muda o naipe
            suitIndex++;
        }
    }

    // Método que baralha as cartas
    public void shuffle() {
        int cardIndex = cards.length - 1;

        while (cardIndex > 0) {
            // Gera um índice aleatório entre 0 e cardIndex usando Math.random() para gerar um numero aleatorio multiplicado pelo tamanho do baralho e converte para int
            int randomIndex = (int) (Math.random() * (cardIndex + 1));
            // Troca a carta atual com a carta aleatória
            Card temp = cards[cardIndex];
            // Troca as cartas usando uma variável temporária
            cards[cardIndex] = cards[randomIndex];
            cards[randomIndex] = temp;
            // Decrementa o índice da carta atual
            cardIndex--;
        }
        cardsLeft = cards.length;
    }
    // Método que distribui uma carta do baralho
    public Card dealCard() {
        // Verifica se ainda existem cartas no baralho, se não houver retorna null
        if (cardsLeft == 0)
            return null;
        // Distribui a carta do topo do baralho e decrementa o número de cartas restantes
        cardsLeft--;
        return cards[cardsLeft];
    }
    // Retorna o número de cartas restantes no baralho
    public int getCardsLeft(){
        return cardsLeft;
    }
}