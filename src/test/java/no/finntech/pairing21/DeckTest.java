package no.finntech.pairing21;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DeckTest {

    @Test
    public void aNormalDeckHas52Cards() {
        Deck d = new Deck();
        assertThat(d.size()).isEqualTo(52);
    }

    @Test
    public void twoDecksInitialCardListIsEqual() {
        Deck deck = new Deck();
        Deck deck2 = new Deck();
        assertThat(deck).isEqualTo(deck2);
    }

    @Test
    public void aDeckCanBeShuffled() {
        Deck deck = new Deck();
        Deck shuffledDeck = deck.shuffle();
        assertThat(deck.getCards()).isNotEqualTo(shuffledDeck);
    }

    @Test
    public void twoShufflesAreDifferent() {
        Deck firstShuffle = Deck.shuffled();
        Deck secondShuffle = Deck.shuffled();
        assertThat(firstShuffle).isNotEqualTo(secondShuffle);
    }
}
