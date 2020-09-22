package ru.job4j.stream;

import java.util.Comparator;

public class AdressCompare implements Comparator<Profile> {
    @Override
    public int compare(Profile o1, Profile o2) {
        return o1.getAdress().getCity().compareTo(o2.getAdress().getCity());
    }
}
