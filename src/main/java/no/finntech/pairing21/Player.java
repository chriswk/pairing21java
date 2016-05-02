package no.finntech.pairing21;

import java.util.function.BiFunction;

class Player {
    private final String name;
    private final Hand hand;
    private final BiFunction<Hand, Hand, Boolean> hitMe;

    Player(String name, BiFunction<Hand, Hand, Boolean> hitMe) {
        this.name = name;
        this.hitMe = hitMe;
        this.hand = new Hand();
    }

    String getName() {
        return name;
    }

    Hand getHand() { return hand; }

    Integer score() {
        return hand.score();
    }

    Boolean blackjack() { return hand.blackjack(); }

    Boolean busted() { return hand.busted(); }

    boolean hitMe(Hand opponentHand) {
        return hitMe.apply(hand, opponentHand);
    }

    void addCard(Card card) {
        hand.addCard(card);
    }

    @Override
    public String toString() {
        StringBuilder player = new StringBuilder(name)
                .append(":")
                .append(hand.toString())
                .append(",")
                .append(" score: ")
                .append(score());
        if (hand.busted()) {
            player.append(" (BUSTED)");
        }
        return player.toString();
    }

    int handSize() {
        return hand.cards.size();
    }
}
