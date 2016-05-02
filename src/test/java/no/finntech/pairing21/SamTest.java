package no.finntech.pairing21;

import org.junit.Test;

import static no.finntech.pairing21.Rank.*;
import static no.finntech.pairing21.Suit.*
import static org.assertj.core.api.Assertions.assertThat;

public class SamTest {

    @Test
    public void samHitsOnSixteen() {
        Hand sixteen = new Hand(new Card(Clubs, Jack), new Card(Spades, Six));
        Sam sam = new Sam(sixteen);
        assertThat(sam.hitMe()).isTrue();
    }

/*
    @Test
    public void samStandsOnTwenty() {
        Hand twenty = new Hand(new Card(Clubs, Jack), new Card(Spades, King));
        assertThat()
    }
*/
}
