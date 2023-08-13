import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;
 
/**
 * A class that shuffle and draws a card.
 * @author Harjot, 2023
*/
public class GroupOfCards {
    private List<Card> cards;

    public GroupOfCards() {
        cards = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    public void shuffle() {
        Random rand = new Random();
        for (int i = 0; i < cards.size(); i++) {
            int j = rand.nextInt(cards.size());
            Card temp = cards.get(i);
            cards.set(i, cards.get(j));
            cards.set(j, temp);
        }
    }

    public Card drawCard() {
        if (cards.isEmpty()) {
            return null;
        }
        return cards.remove(cards.size() - 1);
    }
}

