package no.finntech.pairing21;

import org.junit.Before;
import org.junit.Test;

import static no.finntech.pairing21.Rank.Ace;
import static no.finntech.pairing21.Rank.Eight;
import static no.finntech.pairing21.Rank.Four;
import static no.finntech.pairing21.Rank.Queen;
import static no.finntech.pairing21.Rank.Six;
import static no.finntech.pairing21.Rank.Ten;
import static no.finntech.pairing21.Rank.Three;
import static no.finntech.pairing21.Rank.Two;
import static no.finntech.pairing21.Suit.Clubs;
import static no.finntech.pairing21.Suit.Hearts;
import static no.finntech.pairing21.Suit.Spades;
import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {
    Player sam;
    Player dealer;
    Hand emptyHand = new Hand();

    @Before
    public void setUp() {
        sam = new Player("Sam", PlayerRules.sam);
        dealer = new Player("Dealer", PlayerRules.dealer);

    }

    @Test
    public void samStandsOnTwentyRegardlessOfOpponentHand() {
        sam.addCard(new Card(Spades, Queen));
        sam.addCard(new Card(Spades, Ten));

        Hand emptyHand = new Hand();
        Hand twentyOne = new Hand(new Card(Spades, Ace), new Card(Clubs, Queen));
        assertThat(sam.hitMe(emptyHand)).isFalse();
        assertThat(sam.hitMe(twentyOne)).isFalse();

    }

    @Test
    public void samAlwaysHitsWithLessThanSeventeen() {
        sam.addCard(new Card(Spades, Queen));
        sam.addCard(new Card(Spades, Six));

        Hand twentyOne = new Hand(new Card(Spades, Ace), new Card(Clubs, Queen));
        assertThat(sam.hitMe(emptyHand)).isTrue();
        assertThat(sam.hitMe(twentyOne)).isTrue();

    }

    @Test
    public void dealerStandsAsSoonAsHandIsBetterThanOpponent() {
        dealer.addCard(new Card(Spades, Two));
        dealer.addCard(new Card(Spades, Four));

        Hand handOfFive = new Hand(new Card(Clubs, Two), new Card(Spades, Three));
        assertThat(dealer.hitMe(handOfFive)).isFalse();
        assertThat(dealer.hitMe(emptyHand)).isFalse();
    }

    @Test
    public void dealerHitsAsLongAsHandIsWorse() {
        dealer.addCard(new Card(Spades, Eight));
        dealer.addCard(new Card(Clubs, Queen));

        Hand twenty = new Hand(new Card(Spades, Queen), new Card(Hearts, Queen));
        assertThat(dealer.hitMe(twenty)).isTrue();
    }
}
