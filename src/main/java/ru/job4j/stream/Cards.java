package ru.job4j.stream;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;

public class Cards {
    private Suit suit;
    private Value value;

    public Cards() {
    }

    public Cards(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    @SuppressWarnings("checkstyle:EmptyLineSeparator")
    @Override
    public String toString() {
        return "Card - "
                + suit.toString()
                + " value: "
                + value.toString()
                + "\n";
    }
}
