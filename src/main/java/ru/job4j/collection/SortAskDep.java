package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Comparator;

public class SortAskDep implements Comparator<String> {

    public int compare(String o1, String o2) {

        ArrayList<String> o1list = new ArrayList<>();
        ArrayList<String> o2List = new ArrayList<>();
        for (String schet:o1.split("/")
             ) {
            o1list.add(schet);
        }
        for (String schet:o2.split("/")
        ) {
            o2List.add(schet);
        }
        if (o1list.get(0).equals(o2List.get(0))) {
            return o1.compareTo(o2);
        }
        return o2.compareTo(o1);
    }
}
