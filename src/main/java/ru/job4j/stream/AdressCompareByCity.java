package ru.job4j.stream;

import java.util.Comparator;

public class AdressCompareByCity implements Comparator<Adress> {
    @Override
    public int compare(Adress o1, Adress o2) {
        return o1.getCity().compareTo(o2.getCity());
    }
}
