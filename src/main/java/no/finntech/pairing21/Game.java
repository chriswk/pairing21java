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

    public GameResult play() {
        initialDeal();
        if (!checkBlackjack()) {
            samDraws();
            if (!sam.busted()) {
                dealerDraws();
            }
        }
        GameResult state = decideWinner();
        return state;
    }

    private GameResult decideWinner() {
        if (sam.busted()) {
            return new GameResult(dealer, sam);
        }
        if (dealer.busted()) {
            return new GameResult(sam, dealer);
        }
        if (sam.blackjack()) {
            return new GameResult(sam, dealer);
        }
        if (dealer.blackjack()) {
            return new GameResult(dealer, sam);
        }
        if (sam.score() > dealer.score()) {
            return new GameResult(sam, dealer);
        } else if (dealer.score() > sam.score()){
            return new GameResult(dealer, sam);
        }
        return null;
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
