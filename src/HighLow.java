// Mariana Rosa a22608340
// Martim Pires a22610371
// Tomás Silva a22608276

package highLow.src;

import java.util.Scanner;

public class HighLow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Cria o baralho e graças ao construtor Deck() em Deck.java o baralho é baralhado
        Deck deck = new Deck();

        // Variáveis que guardam os resultados do jogo
        int roundsPlayed = 0;
        int totalPoints = 0;
        boolean continuePlaying = true;

        // Instruções do jogo
        System.out.println("Bem-vindo ao jogo HighLow!");
        System.out.println("O objetivo é adivinhar se a próxima carta tem um valor maior ou menor.");
        System.out.println("Ganhas um ponto por cada opção correta, mas se errares ou as cartas forem do mesmo valor, a ronda termina."); 

        // Cada ronda precisa de pelo menos duas cartas para o jogo continuar
        while (continuePlaying && deck.cardsLeft() >= 2) {
            roundsPlayed++; // Aumenta o numero de rondas sempre que começa uma nova
            int pointsRound = 0;
            boolean roundActive = true;
            Card currentCard = deck.dealCard();

            System.out.println("\nRONDA " + roundsPlayed);

            // Continuar a ronda enquanto o jogador acertar e existirem cartas
            while (roundActive && deck.cardsLeft() > 0) {
                System.out.println(currentCard);
                System.out.print("Próxima carta é mais alta (A) ou mais baixa (B)? ");
                // Proteção contra null e EOF
                if (!scanner.hasNextLine()) {
                    System.out.println("Input inválido.");
                    break;
                }
                // Scanner para ler o input do jogador usando trim para remover espaços e toUpperCase para converter o input para maiusculas
                String choice = scanner.nextLine().trim().toUpperCase();

                // Validar a escolha usando o método equals para comparar strings
                while (!choice.equals("A") && !choice.equals("B")) {
                    System.out.print("Escolha inválida. Escreve A ou B: ");
                    // Proteção contra null e EOF
                    if (!scanner.hasNextLine()) {
                        System.out.println("Input inválido.");
                        break;
                    }
                    choice = scanner.nextLine().trim().toUpperCase();
                }

                // Retira a próxima carta
                Card nextCard = deck.dealCard();

                System.out.println(nextCard);

                // Obtem os valores da próxima carta
                int currentValue = currentCard.getValue();
                int nextValue = nextCard.getValue();

                // Verifica se as duas cartas tem o mesmo valor, se forem iguais a ronda acaba
                if (nextValue == currentValue) {
                    System.out.println("As cartas são do mesmo valor! Perdeste a ronda.");
                    roundActive = false;
                //Se a escolha for A significa que a próxima carta deve ser maior, caso contrário deve ser menor
                } else if ((choice.equals("A") && nextValue > currentValue) || (choice.equals("B") && nextValue < currentValue))
                {
                    pointsRound++;
                    System.out.println("Acertaste! Pontuação da ronda: " + pointsRound);
                    // A próxima carta passa a ser a carta atual.
                    currentCard = nextCard;
                } else {
                    // Se a escolha estiver errada, a ronda termina
                    System.out.println("Erraste! A ronda terminou.");
                    roundActive = false;
                }
            }
            // Atualiza a pontuação total, somando os pontos da última ronda
            totalPoints += pointsRound;
            // Apresenta os resultados da ronda e o número de cartas restantes
            System.out.println("\nPontuação da ronda " + roundsPlayed + ": " + pointsRound);
            System.out.println("Cartas restantes: " + deck.cardsLeft());

            // Só é possível jogar outra ronda com pelo menos duas cartas.
            if (deck.cardsLeft() < 2) {
                System.out.println("Não existem cartas suficientes para iniciar outra ronda.");
                continuePlaying = false;
            } 
            else {
                System.out.print("Queres jogar novamente? (S/N): ");
                // Proteção contra null e EOF
                if (!scanner.hasNextLine()) {
                    System.out.println("Input inválido.");
                    break;
                }
                String answer = scanner.nextLine().trim().toUpperCase();

                // Validar a resposta.
                while (!answer.equals("S") && !answer.equals("N")) {
                    System.out.print("Resposta inválida. Escreve S ou N: ");
                    // Proteção contra null e EOF
                    if (!scanner.hasNextLine()) {
                        System.out.println("Input inválido.");
                        break;
                    }
                    answer = scanner.nextLine().trim().toUpperCase();
                }
                // Se a resposta for S o jogo continua, caso contrário, termina.
                continuePlaying = answer.equals("S");
            }
        }
        // Cria a variável para calcular a média
        float averagePoints = 0;

        // Calcula a média
        averagePoints = (float) totalPoints / roundsPlayed;
        
        // Apresenta os resultados finais do jogo
        System.out.println("\nRESULTADO FINAL");
        System.out.println("Rondas jogadas: " + roundsPlayed);
        System.out.println("Pontuação total: " + totalPoints);
        System.out.printf("Pontuação média por ronda: %.2f%n", averagePoints);

        // Fecha o scanner para evitar memory leaks
        scanner.close();
    }
}