package ru.job4j.collection;

import java.util.*;

public class Department {

    public static List<String> fillGaps(List<String> deps) {
        ArrayList<String> rsl = new ArrayList<>();
        String[] subStr;
        Set<String> expect = new TreeSet<>();
        for (String schet:deps
             ) {
            subStr = schet.split("/");
            expect.add(subStr[0]);
            String promt = subStr[0];
            for (int i = 1; i < subStr.length; i++) {
                promt = promt + "/" + subStr[i];
                expect.add(promt);

            }
        }
        rsl.addAll(expect);
        return rsl;
    }

    public static List<String> sortAsk(List<String> mas) {
        ArrayList<String> rsl = new ArrayList<>();
        Collections.sort(mas);
        return mas;
    }

    public static List<String> sortDesc(List<String> orgs) {
        Collections.sort(orgs, new SortAskDep());
        return orgs;
    }

    public static void main(String[] args) {
        List<String> test = new ArrayList<>();
        List<String> testX = new ArrayList<>();
        test.add("K1/SK1/SSK1");
       /* test.add("K1/SK1");
        test.add("K1"); */
        test.add("K2/SK1/SSK2");
        testX.addAll(fillGaps(test));
        System.out.println(testX);
        testX = sortAsk(testX);
        System.out.println(testX);
        testX = sortDesc(testX);
        System.out.println(testX);
    }
}
