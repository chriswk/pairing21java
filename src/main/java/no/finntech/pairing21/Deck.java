package no.finntech.pairing21;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

public class Deck {
    final List<Card> cards;

    public Deck() {
        this(stream(Suit.values())
             .flatMap(suit ->
                stream(Rank.values())
                    .map(
                      rank -> new Card(suit, rank)
                    )
             ).collect(toList())
        );
    }

    public Deck(List<Card> cards) {
        this.cards = cards;
    }

    public List<Card> getCards() {
        return cards;
    }

    public Integer size() {
        return cards.size();
    }

    public Deck shuffle() {
        List<Card> shuffled = new ArrayList<>();
        Collections.copy(cards, shuffled);
        return new Deck(shuffled);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Deck deck = (Deck) o;

        return cards.equals(deck.cards);

    }

    @Override
    public int hashCode() {
        return cards.hashCode();
    }
}
