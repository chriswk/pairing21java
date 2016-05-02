package no.finntech.pairing21;

import org.junit.Test;

import static no.finntech.pairing21.Rank.Ace;
import static no.finntech.pairing21.Rank.Eight;
import static no.finntech.pairing21.Rank.Jack;
import static no.finntech.pairing21.Rank.King;
import static no.finntech.pairing21.Rank.Queen;
import static no.finntech.pairing21.Rank.Seven;
import static no.finntech.pairing21.Suit.Clubs;
import static no.finntech.pairing21.Suit.Diamonds;
import static no.finntech.pairing21.Suit.Hearts;
import static no.finntech.pairing21.Suit.Spades;
import static org.assertj.core.api.Assertions.assertThat;


public class DealerTest {

    @Test
    public void dealerHitsUntilHasHighestScore() {
        Hand seventeen = new Hand(new Card(Clubs, Jack), new Card(Hearts, Seven));
        Hand eighteen = new Hand(new Card(Clubs, Queen), new Card(Spades, Eight));
        Dealer dealer = new Dealer(seventeen);
        assertThat(dealer.hitMe(eighteen));

        Hand twenty = new Hand(new Card(Clubs, King), new Card(Diamonds, Queen));
        Hand twentyOne = new Hand(new Card(Diamonds, Jack), new Card(Spades, Ace));
        Dealer dealerWith20 = new Dealer(twenty);
        assertThat(dealerWith20.hitMe(eighteen)).isFalse();
        assertThat(dealerWith20.hitMe(twentyOne)).isTrue();
    }
}
