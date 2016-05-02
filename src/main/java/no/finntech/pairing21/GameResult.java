package no.finntech.pairing21;

public class GameResult {
    Player winner;
    Player other;

    public GameResult(Player winner, Player other) {
        this.winner = winner;
        this.other = other;
    }

    public Player getWinner() {
        return winner;
    }

    public Player getOther() {
        return other;
    }

    @Override
    public String toString() {
        return new StringBuilder(winner.getName())
                .append(" wins with ")
                .append(winner.score())
                .append(" from this hand: [")
                .append(winner.getHand())
                .append("]")
                .append("\t")
                .append("Beat ")
                .append(other.getName())
                .append(" who had a score of ")
                .append(other.score())
                .append(" from a hand of [")
                .append(other.getHand())
                .append("]")
                .toString();
    }
}
