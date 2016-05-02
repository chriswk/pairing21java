package no.finntech.pairing21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Hand {
    public List<Card> cards;

    public Hand() {
        this.cards = new ArrayList<>();
    }
    public Hand(Card... cards) {
        this.cards = Arrays.stream(cards).collect(toList());
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
