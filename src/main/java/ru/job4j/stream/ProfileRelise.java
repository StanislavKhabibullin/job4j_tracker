package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class ProfileRelise {

    public List<Adress> collect(List<Profile> profiles) {

        return profiles.stream().map(adres -> adres.getAdress()).collect(Collectors.toList());
    }

    public List<Adress> sortick(List<Profile> profiles) {
        // сортировка
        List<Adress> result = profiles.stream().
                map(adres -> adres.getAdress()).sorted(new AdressCompareByCity()).
                distinct().collect(Collectors.toList());
        return result;
    }
}
