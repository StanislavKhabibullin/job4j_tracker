package ru.job4j.stream;

import java.util.Optional;

public class Cards {
    private Suit suit;
    private Value value;

    public Cards() {
    }

    public Cards(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Card - "
                + suit.toString()
                + " value: "
                + value.toString();
    }
}
