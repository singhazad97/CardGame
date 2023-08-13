import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random; 

/**
 * A class that handle the username and password. Moreover, this class add card to player's hand.  
 * @author Harjot, 2023
*/


public class Player {
    private String username;
    private String password;
    private List<Card> hand;

    public Player(String username, String password) {
        this.username = username;
        this.password = password;
        this.hand = new ArrayList<>();
    }

    public void addCardToHand(Card card) {
        hand.add(card);
    }

    public int getHandValue() {
        int value = 0;
        boolean hasAce = false;
        for (Card card : hand) {
            value += card.getValue();
            if (card.getValue() == 11) {
                hasAce = true;
            }
        }
        if (hasAce && value > 21) {
            value -= 10; // Convert an Ace from 11 to 1
        }
        return value;
    }

    public void clearHand() {
        hand.clear();
    }

    @Override
    public String toString() {
        return username;
    }
}