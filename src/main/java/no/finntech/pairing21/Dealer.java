package no.finntech.pairing21;

public class Dealer {
    Hand hand;

    public Dealer(Hand hand) {
        this.hand = hand;
    }


    public boolean hitMe(Hand opponent) {
        return hand.score() <= opponent.score();
    }
}
