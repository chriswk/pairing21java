package no.finntech.pairing21;

import java.util.function.BiFunction;

class PlayerRules {
    static BiFunction<Hand, Hand, Boolean> sam = (hand, opponentHand) -> hand.score() < 17;
    static BiFunction<Hand, Hand, Boolean> dealer = (hand, opponentHand) -> hand.score() <= opponentHand.score();

}
