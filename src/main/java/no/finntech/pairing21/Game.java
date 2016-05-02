package no.finntech.pairing21;

import java.util.Iterator;
import java.util.List;

import static java.util.Arrays.asList;
import static no.finntech.pairing21.GameState.DEALERWINS;
import static no.finntech.pairing21.GameState.SAMWINS;

public class Game {
    final Iterator<Card> deck;
    private Player sam;
    private Player dealer;

    public List<Player> getPlayers() {
        return asList(sam, dealer);
    }

    public Game() {
        this(Deck.shuffled(), new Player("Sam", PlayerRules.sam), new Player("Dealer", PlayerRules.dealer));
    }

    private Game(Deck deck, Player one, Player dealer) {
        this.deck = deck.getCards().iterator();
        this.sam = one;
        this.dealer = dealer;
    }

    public GameState play() {
        initialDeal();
        if (!checkBlackjack()) {
            samDraws();
            dealerDraws();
        }
        return decideWinner();
    }

    private GameState decideWinner() {
        System.out.println(sam.toString() +" vs " + dealer.toString());
        if (sam.score() == dealer.score() || (sam.hand.busted() && dealer.hand.busted())) {
            return GameState.DRAW;
        } else if (sam.score() > dealer.score()) {
            return sam.hand.busted() ? DEALERWINS : SAMWINS;
        } else {
            return dealer.hand.busted() ? SAMWINS : DEALERWINS;
        }
    }

    private void samDraws() {
        while(sam.hitMe(dealer.hand)) {
            sam.addCard(deck.next());
        }
    }

    private void dealerDraws() {
        while(dealer.hitMe(sam.hand)) {
            dealer.addCard(deck.next());
        }
    }

    private boolean checkBlackjack() {
        return sam.hand.blackjack() || dealer.hand.blackjack();
    }


    void initialDeal() {
        sam.addCard(deck.next());
        sam.addCard(deck.next());
        dealer.addCard(deck.next());
        dealer.addCard(deck.next());
    }
}
