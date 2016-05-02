package no.finntech.pairing21;

import org.junit.Test;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;


public class GameTest {

    @Test
    public void aDefaultGameHasSamAndADealer() {
        Game g = new Game();
        assertThat(g.getPlayers().stream().map(p -> p.getName()).collect(toList())).containsSequence("Sam", "Dealer");
    }

    @Test
    public void afterInitialDealAllPlayersHasTwoCards() {
        Game g = new Game();
        g.initialDeal();
        assertThat(g.getPlayers().stream().allMatch(p -> p.hand.cards.size() == 2)).isTrue();
    }

    @Test
    public void blackjackCheckWorks() {
        Game g = new Game()
    }
}
