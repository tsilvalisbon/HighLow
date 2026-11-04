// Mariana Rosa a22608340
// Martim Pires a22610371
// Tomás Silva a22608276

package highLow;

import java.util.Scanner;

public class HighLow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deck deck = new Deck();

        int roundsPlayed = 0;
        int totalPoints = 0;
        boolean continuePlaying = true;

        System.out.println("Bem-vindo ao jogo HighLow!");
        System.out.println("O objetivo é adivinhar se a próxima carta tem um valor maior ou menor.");
        System.out.println("Ganhas um ponto por cada opção correta, mas se errares ou as cartas forem do mesmo valor, a ronda termina."); 

        // Cada ronda precisa de pelo menos duas cartas.
        while (continuePlaying && deck.getCardsLeft() >= 2) {
            roundsPlayed++;
            int pointsRound = 0;
            boolean roundActive = true;
            Card currentCard = deck.dealCard();

            System.out.println("\nRONDA " + roundsPlayed);

            // Continuar enquanto o jogador acertar e existirem cartas.
            while (roundActive && deck.getCardsLeft() > 0) {
                System.out.println(currentCard);
                System.out.print("Próxima carta é mais alta (A) ou mais baixa (B)? ");
                String choice = scanner.nextLine().trim().toUpperCase();

                // Validar a escolha.
                while (!choice.equals("A") && !choice.equals("B")) {
                    System.out.print("Escolha inválida. Escreve A ou B: ");
                    choice = scanner.nextLine().trim().toUpperCase();
                }

                Card nextCard = deck.dealCard();

                System.out.println(nextCard);

                int currentValue = currentCard.getValue();
                int nextValue = nextCard.getValue();

                if (nextValue == currentValue) {
                    System.out.println("As cartas são do mesmo valor! Perdeste a ronda.");
                    roundActive = false;
                } else if ((choice.equals("A") && nextValue > currentValue)|| (choice.equals("B") && nextValue < currentValue)) 
                {
                    pointsRound++;
                    System.out.println("Acertaste! Pontuação da ronda: " + pointsRound);
                    // A carta revelada passa a ser a carta atual.
                    currentCard = nextCard;
                } else {
                    System.out.println("Erraste! A ronda terminou.");
                    roundActive = false;
                }
            }
            totalPoints += pointsRound;
            System.out.println("\nPontuação da ronda " + roundsPlayed + ": " + pointsRound);
            System.out.println("Cartas restantes: " + deck.getCardsLeft());

            // Só é possível jogar outra ronda com pelo menos duas cartas.
            if (deck.getCardsLeft() < 2) {
                System.out.println("Não existem cartas suficientes para iniciar outra ronda.");
                continuePlaying = false;
            } else {
                System.out.print("Queres jogar novamente? (S/N): ");
                String answer = scanner.nextLine().trim().toUpperCase();

                // Validar a resposta.
                while (!answer.equals("S") && !answer.equals("N")) {
                    System.out.print("Resposta inválida. Escreve S ou N: ");
                    answer = scanner.nextLine().trim().toUpperCase();
                }
                continuePlaying = answer.equals("S");
            }
        }
        float averagePoints = 0;

        if (roundsPlayed > 0)
            averagePoints = (float) totalPoints / roundsPlayed;

        System.out.println("\nRESULTADO FINAL");
        System.out.println("Rondas jogadas: " + roundsPlayed);
        System.out.println("Pontuação total: " + totalPoints);
        System.out.printf("Pontuação média por ronda: %.2f%n", averagePoints);

        scanner.close();
    }
}