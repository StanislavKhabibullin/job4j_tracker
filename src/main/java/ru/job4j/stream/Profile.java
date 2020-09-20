package ru.job4j.stream;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Profile {
    private Adress adress;

    public Profile() {
    }

    public Profile(String city, String street, int i, int i1) {
        this.adress = new Adress(city, street, i, i1);
    }

    public List<Adress> collect(List<Profile> profiles) {
        return profiles.stream().map(adres -> adres.adress).collect(Collectors.toList());
    }
}
