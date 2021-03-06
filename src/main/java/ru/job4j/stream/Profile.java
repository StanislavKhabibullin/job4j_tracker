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

    @SuppressWarnings("checkstyle:EmptyLineSeparator")
    @Override
    public int hashCode() {
        return Objects.hash(adress);
    }
}
