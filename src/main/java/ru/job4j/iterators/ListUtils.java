package ru.job4j.iterators;

import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.function.Predicate;

public class ListUtils {

    public static <T> void addBefore(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> iterator = list.listIterator();
        while (iterator.hasNext()) {
            if (iterator.nextIndex() == index) {
                iterator.add(value);
                break;
            }
            iterator.next();
        }
    }

    public static <T> void addAfter(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (listIterator.previousIndex() == index) {
                listIterator.add(value);
                break;
            }
            listIterator.next();
        }
    }

    public static <T> List<T> femoveIf(List<T> list, Predicate<T> filter) {

        ListIterator<T> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            T value = listIterator.next();
            if (filter.test(value)) {
                listIterator.remove();
            }
        }
        return list;
    }

    public static <T> List<T> replaceIf(List<T> list, Predicate<T> filter, T value) {
        ListIterator<T> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            T rsl = listIterator.next();
            if (filter.test(rsl)) {
                listIterator.remove();
                listIterator.add(value);
            }
        }
        return list;
    }

    public static <T> List<T> removeAll(List<T> list, List<T> elements) {
        ListIterator<T> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            T value = listIterator.next();
            ListIterator<T> empt = elements.listIterator();
            while (empt.hasNext()) {
                T checkVal = empt.next();
                if (value == checkVal) {
                    listIterator.remove();
                    break;
                }
            }
        }
        return list;
    }
}
