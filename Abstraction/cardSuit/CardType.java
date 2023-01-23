package cardSuit;

import java.util.Iterator;

public enum CardType {
    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);

    private int power;

    CardType(int power) {
        this.power = power;
    }

    public int getPower() {
        return power;
    }
}

