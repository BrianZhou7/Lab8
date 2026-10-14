
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();

        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(rank, suit));
            }
        }
    }

    public Card draw() {
        if (cards.isEmpty()) {
            return null;
        }

        return cards.remove(0);
    }

    public List<Card> draw(int count) {
        List<Card> drawnCards = new ArrayList<>();

        if (count <= 0) {
            return drawnCards;
        }

        int numToDraw = Math.min(count, cards.size());

        for (int i = 0; i < numToDraw; i++) {
            drawnCards.add(draw());
        }

        return drawnCards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public int size() {
        return cards.size();
    }

    public List<Card> getCardsByRank(Rank rank) {
        List<Card> matchingCards = new ArrayList<>();

        for (Card card : cards) {
            if (card.getRank() == rank) {
                matchingCards.add(card);
            }
        }

        return matchingCards;
    }

    @Override
    public String toString() {
        return cards.toString();
    }
}
