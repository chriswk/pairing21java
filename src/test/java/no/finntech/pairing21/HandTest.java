package no.finntech.pairing21;

import org.junit.Test;

import static no.finntech.pairing21.Rank.*;
import static no.finntech.pairing21.Suit.*;
import static org.assertj.core.api.Assertions.assertThat;


public class HandTest {

    @Test
    public void twoFaceCardsScore20() {
        Hand jackQueen = new Hand(new Card(Clubs, Queen), new Card(Clubs, Jack));
        assertThat(jackQueen.score()).isEqualTo(20);
        assertThat(jackQueen.busted()).isFalse();
    }

    @Test
    public void blackJack() {
        Hand jackAce = new Hand(new Card(Spades, Jack), new Card(Spades, Ace));
        assertThat(jackAce.score()).isEqualTo(21);
        assertThat(jackAce.blackjack()).isTrue();
        assertThat(jackAce.busted()).isFalse();
    }

    @Test
    public void scoreOf21ButWithFourCardsIsNotBlackjack() {
        Hand twentyOne = new Hand(new Card(Spades, Four), new Card(Hearts, Four));
        twentyOne.addCard(new Card(Clubs, Seven));
        twentyOne.addCard(new Card(Clubs, Six));
        assertThat(twentyOne.score()).isEqualTo(21);
        assertThat(twentyOne.blackjack()).isFalse();
        assertThat(twentyOne.busted()).isFalse();
    }

    @Test
    public void scoreOfMoreThan21IsBust() {
        Hand bust = new Hand(new Card(Spades, Queen), new Card(Spades, Seven));
        bust.addCard(new Card(Clubs, Eight));
        assertThat(bust.score()).isEqualTo(25);
        assertThat(bust.busted()).isTrue();
    }

}
