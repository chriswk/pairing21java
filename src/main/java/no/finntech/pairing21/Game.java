package no.finntech.pairing21;

import java.util.Iterator;
import java.util.List;

import static java.util.Arrays.asList;

public class Game {
    private final Iterator<Card> deck;
    private Player sam;
    private Player dealer;

    List<Player> getPlayers() {
        return asList(sam, dealer);
    }

    Game() {
        this(Deck.shuffled(), new Player("Sam", PlayerRules.sam), new Player("Dealer", PlayerRules.dealer));
    }

    public Game(Deck deck, Player one, Player dealer) {
        this.deck = deck.getCards().iterator();
        this.sam = one;
        this.dealer = dealer;
    }

    public GameState play() {
        initialDeal();
        if (!checkBlackjack()) {
            samDraws();
            if (!sam.busted()) {
                dealerDraws();
            }
        }
        GameState state = decideWinner();
        return state;
    }

    private GameState decideWinner() {
        if (sam.busted()) {
            return GameState.DEALERWINS;
        }
        if (dealer.busted()) {
            return GameState.SAMWINS;
        }
        if (sam.blackjack()) {
            return GameState.SAMWINS;
        }
        if (dealer.blackjack()) {
            return GameState.DEALERWINS;
        }
        if (sam.score() == dealer.score()) {
            System.out.println(sam);
            System.out.println(dealer);
            return GameState.DRAW;
        } else if (sam.score() > dealer.score()) {
            return GameState.SAMWINS;
        } else {
            return GameState.DEALERWINS;
        }
    }

    private void samDraws() {
        while(sam.hitMe(new Hand())) {
            sam.addCard(deck.next());
        }
    }

    private void dealerDraws() {
        while(dealer.hitMe(sam.getHand())) {
            dealer.addCard(deck.next());
        }
    }

    private boolean checkBlackjack() {
        return sam.blackjack() || dealer.blackjack();
    }


    void initialDeal() {
        sam.addCard(deck.next());
        sam.addCard(deck.next());
        dealer.addCard(deck.next());
        dealer.addCard(deck.next());
    }
}
