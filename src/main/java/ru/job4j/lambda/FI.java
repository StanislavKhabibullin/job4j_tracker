package ru.job4j.lambda;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FI {
    public static void main(String[] args) {
        Attachment[] atts = {
                new Attachment("image 101", 20),
                new Attachment("image 30", 120),
                new Attachment("image 20", 23)
        };
        Comparator<Attachment> comparator = new Comparator<Attachment>() {
            @Override
            public int compare(Attachment o1, Attachment o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };

        Comparator<Attachment> comparatorName = (left, right) -> {
           return Integer.valueOf(left.getName().length()).compareTo(Integer.valueOf(right.getName().length()));
        };

        Comparator<Attachment> cmpDescSize = (left, right) -> {
            System.out.println("compare - " + left.getName() + " : " + right.getName());
            return right.getName().length() - left.getName().length();
        };

        Arrays.sort(atts, comparatorName);
        for (Attachment schet:atts
        ) {
            System.out.println("Сортироовка через лябда выражение - " + schet);
        }

        Arrays.sort(atts, cmpDescSize);
        for (Attachment schet:atts
        ) {
            System.out.println("Сортироовка через лябда выражение down  " + schet);
        }

        Arrays.sort(atts, comparator);
        for (Attachment schet:atts
             ) {
            System.out.println(schet);
        }
    }

    public static void raw(List<Attachment> list, Function<Attachment, InputStream> func) {
        for (Attachment att:list
             ) {
            func.apply(att);
        }
    }
}
