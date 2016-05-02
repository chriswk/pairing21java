package no.finntech.pairing21;

import java.util.function.BiFunction;

public class PlayerRules {
    public static BiFunction<Hand, Hand, Boolean> sam = (hand, opponentHand) -> hand.score() < 17;
    public static BiFunction<Hand, Hand, Boolean> dealer = (hand, opponentHand) -> hand.score() <= opponentHand.score();

}
