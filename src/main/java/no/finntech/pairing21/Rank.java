package no.finntech.pairing21;

public enum Rank {
    Ace(11), Two(2), Three(3), Four(4), Five(5), Six(6), Seven(7), Eight(8), Nine(9), Ten(10), Jack(10), Queen(10), King(10);


    private final Integer score;
    public Integer getScore() {
        return score;
    }

    Rank(Integer score) {
        this.score = score;
    }
}
