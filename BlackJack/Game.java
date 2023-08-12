import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random; 

/**
 *A class that handles the whole game and act as a controller.
 * @author Harjot, 2023
*/
 
class Game {
    private GroupOfCards deck;
    private Player player;
    private Player dealer;

    public Game(String username, String password) {
        deck = new GroupOfCards();
        deck.shuffle();
        player = new Player(username, password);
        dealer = new Player("Dealer", "");
    }

    public void startGame() {
        player.clearHand();
        dealer.clearHand();

        player.addCardToHand(deck.drawCard());
        dealer.addCardToHand(deck.drawCard());
        player.addCardToHand(deck.drawCard());
        dealer.addCardToHand(deck.drawCard());

        System.out.println(player + "'s hand: " + player.getHandValue());
        System.out.println("Dealer's hand: " + dealer.getHandValue());
    }

    public void playerTurn(Scanner scanner) {
        while (player.getHandValue() < 21) {
            System.out.println("Do you want to hit or stand? (h/s)");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("h")) {
                player.addCardToHand(deck.drawCard());
                System.out.println(player + "'s hand: " + player.getHandValue());
            } else if (choice.equalsIgnoreCase("s")) {
                break;
            }
        }
    }

    public void dealerTurn() {
        while (dealer.getHandValue() < 17) {
            dealer.addCardToHand(deck.drawCard());
        }
    }

    public void declareWinner() {
        int playerValue = player.getHandValue();
        int dealerValue = dealer.getHandValue();

        System.out.println(player + "'s hand: " + playerValue);
        System.out.println("Dealer's hand: " + "It's secret just guess");

        if (playerValue > 21) {
            System.out.println("Bust! " + player + " loses.");
        } else if (dealerValue > 21) {
            System.out.println("Dealer busts! " + player + " wins!");
        } else if (playerValue > dealerValue) {
            System.out.println(player + " wins!");
        } else if (playerValue < dealerValue) {
            System.out.println("Dealer wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }
}
