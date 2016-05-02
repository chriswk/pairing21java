package no.finntech.pairing21;

import java.util.function.BiFunction;

public class Player {
    final String name;
    Hand hand;
    final BiFunction<Hand, Hand, Boolean> hitMe;

    public Player(String name, BiFunction<Hand, Hand, Boolean> hitMe) {
        this.name = name;
        this.hitMe = hitMe;
        this.hand = new Hand();
    }

    public String getName() {
        return name;
    }

    public Integer score() {
        return hand.score();
    }

    public boolean hitMe(Hand oppenentHand) {
        return hitMe.apply(hand, oppenentHand);
    }

    public void addCard(Card card) {
        this.hand.addCard(card);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(name);
        return sb.append(":")
          .append(hand.toString())
          .append(",")
          .append(" score: ")
          .append(score())
          .toString();
    }
}
