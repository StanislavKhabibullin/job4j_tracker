package ru.job4j.collection;

import java.util.HashSet;

public class UniqueText {
    public static boolean isEquals(String originText, String duplicateText) {
        boolean rsl = true;
        String[] origin = originText.split(" ");
        String[] duplicate = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        for (String schet:origin
             ) {
            check.add(schet);
        }
        for (String schet:duplicate
             ) {
            if (!check.contains(schet)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }

}
