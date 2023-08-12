import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random; 
/**
 * A class that represents Suits and rank of cards.
 * @author Harjot, 2023
*/
public class Card {
    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public int getValue() {
        return Math.min(rank.ordinal() + 2, 10); // Values of face cards are 10
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}