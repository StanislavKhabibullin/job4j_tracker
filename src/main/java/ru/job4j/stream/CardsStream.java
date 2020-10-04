package ru.job4j.stream;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CardsStream {
    @SuppressWarnings("checkstyle:EmptyLineSeparator")
    public static void main(String[] args) {
        ArrayList<Cards> cards = new ArrayList<>();
        System.out.println(cards);
        List<Suit> suits = Stream.of(Suit.values()).collect(Collectors.toList());
        List<Value> values = Stream.of(Value.values()).collect(Collectors.toList());
       /* for (Suit suit : suits) {
            for (Value value: values) {
                cards.add(new Cards(suit, value));
            }
        } */
        Stream.of(Suit.values()).flatMap((su) -> {
            return Stream.of(Value.values()).flatMap(y -> {
               cards.add(new Cards(su, y));
                return null;
            });
        }).collect(Collectors.toList());
        System.out.println(cards);

    }
}
