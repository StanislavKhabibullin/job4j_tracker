package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class SearchAtt {

    public static List<Attachment> filterSize(List<Attachment> list) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (att.getSize() > 100) {
                rsl.add(att);
            }
        }
        return rsl;
    }

    public static List<Attachment> filterName(List<Attachment> list) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (att.getName().contains("bug")) {
                rsl.add(att);
            }
        }
        return rsl;
    }

    public static List<Attachment> loop(List<Attachment> list, Predicate<Attachment> value) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att:list
             ) {
            if (value.test(att)) {
                rsl.add(att);
                }
            }
        return rsl;
    }

    public static List<Attachment> filtSize(List<Attachment> list) {
        Predicate<Attachment> value = new Predicate<Attachment>() {
            @Override
            public boolean test(Attachment attachment) {
                if (attachment.getSize() > 100) {
                    return true;
                }
                return false;
            }
        };
   return loop(list, value);
    }

    public static List<Attachment> filtName(List<Attachment> list) {
        Predicate<Attachment> value = new Predicate<Attachment>() {
            @Override
            public boolean test(Attachment attachment) {
                if (attachment.getName().contains("bug")) {
                    return true;
                }
                return false;
            }
        };
        return loop(list, value);
    }

    public static void main(String[] args) {
        ArrayList<Attachment> list = new ArrayList<>();
        list.add(new Attachment("first", 7));
        list.add(new Attachment("test", 700));
        list.add(new Attachment("bugbug", 700));
        list.add(new Attachment("first2", 1900));
        list.add(new Attachment("first3 bug", 3000));
        list.add(new Attachment("bug", 1));
        System.out.println(list);
        System.out.println("Обычная сортировка: " + '\n' + filterSize(list));
        System.out.println(filterName(list));
        System.out.println("Сортировка через функциональный интерфейс: " + '\n' + filtSize(list));
        System.out.println(filtName(list));
    }
}
