
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class BlackjackHand {

    private static final int MAX_VALUE = 21;

    private static final Map<Rank, Integer> CARD_VALUES =
            new HashMap<>();

    static {
        CARD_VALUES.put(Rank.TWO, 2);
        CARD_VALUES.put(Rank.THREE, 3);
        CARD_VALUES.put(Rank.FOUR, 4);
        CARD_VALUES.put(Rank.FIVE, 5);
        CARD_VALUES.put(Rank.SIX, 6);
        CARD_VALUES.put(Rank.SEVEN, 7);
        CARD_VALUES.put(Rank.EIGHT, 8);
        CARD_VALUES.put(Rank.NINE, 9);
        CARD_VALUES.put(Rank.TEN, 10);
        CARD_VALUES.put(Rank.JACK, 10);
        CARD_VALUES.put(Rank.QUEEN, 10);
        CARD_VALUES.put(Rank.KING, 10);
        CARD_VALUES.put(Rank.ACE, 11);
    }

    private final List<Card> cards;
    private int value;
    private int numAcesAs11;

    public BlackjackHand(Card first, Card second) {
        cards = new ArrayList<>();
        value = 0;
        numAcesAs11 = 0;

        addCard(first);
        addCard(second);
    }

    public void addCard(Card card) {
        Objects.requireNonNull(card);

        if (value >= MAX_VALUE) {
            return;
        }

        cards.add(card);
        value += CARD_VALUES.get(card.getRank());

        if (card.getRank() == Rank.ACE) {
            numAcesAs11++;
        }

        while (value > MAX_VALUE && numAcesAs11 > 0) {
            value -= 10;
            numAcesAs11--;
        }
    }

    public static Map<Rank, Integer> getCardValues() {
        return new HashMap<>(CARD_VALUES);
    }

    public List<Card> getCards() {
        return new ArrayList<>(cards);
    }

    public int getValue() {
        return value;
    }

    public int size() {
        return cards.size();
    }

    @Override
    public String toString() {
        return cards.toString();
    }
}
