package no.finntech.pairing21;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class Hand {
    public List<Card> cards;

    public Hand(Card first, Card second) {
        cards = new ArrayList<>();
        cards.add(first);
        cards.add(second);
    }

    public void addCard(Card card) {
        cards.add(card);
    }


    public Integer score() {
        return cards.stream().mapToInt(card -> card.rank.getScore()).sum();
    }

    public boolean blackjack() {
        return cards.size() == 2 && score() == 21;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(cards.stream().map(Card::toString).collect(joining(",")));
        return sb.toString();
    }

    public boolean busted() {
        return score() > 21;
    }
}
