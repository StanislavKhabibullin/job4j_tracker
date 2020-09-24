package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Profile {
    private Adress adress;

    public Profile() {
    }

    public Profile(String city, String street, int i, int i1) {
        this.adress = new Adress(city, street, i, i1);
    }

    public Adress getAdress() {
        return adress;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Profile profile = (Profile) obj;
        return adress == profile.adress;
    }

    @Override
    public int hashCode() {
        return Objects.hash(adress);
    }

    public List<Adress> collect(List<Profile> profiles) {

                return profiles.stream().map(adres -> adres.getAdress()).collect(Collectors.toList());
    }

    public List<Adress> sortick(List<Profile> profiles) {
        profiles.sort(new AdressCompare());
        List<Adress> result = profiles.stream().
                distinct().
                map(adres -> adres.getAdress()).
                collect(Collectors.toList());
        return result;
    }
}
