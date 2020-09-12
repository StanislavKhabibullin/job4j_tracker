package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Comparator;

public class SortAskDep implements Comparator<String> {

    public int compare(String o1, String o2) {
        int rsl = 0;

        String[] o1list = o1.split("/");
        String[] o2List = o2.split("/");
       /* int i = 0;
        for (String schet:o1.split("/")
             ) {
            o1list[i] = schet;
            i++;
        }
        i = 0;
        for (String schet:o2.split("/")
        ) {
            o2List[i] = schet;
            i++;
        } */
        rsl = o2List[0].compareTo(o1list[0]);
        if (rsl == 0) {
            return o1.compareTo(o2);
        }
        return rsl;
    }
}
