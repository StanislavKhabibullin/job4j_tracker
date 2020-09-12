package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class AttachmentFirst {
    public static void main(String[] args) {
        ArrayList<Attachment> list = new ArrayList<>();
        list.add(new Attachment("first", 7));
        list.add(new Attachment("first1", 7));
        list.add(new Attachment("first2", 19));
        list.add(new Attachment("first3", 3));
        list.add(new Attachment("first4", 1));
        System.out.println(list);
        Collections.sort(list, new ListComp());
        System.out.println(list);
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Attachment left = (Attachment) o1;
                Attachment right = (Attachment) o2;
                return right.getSize() - left.getSize();
            }
        };
        Collections.sort(list, comparator);
        System.out.println(list);

        ArrayList listik = new ArrayList() {
            public boolean add(Object o) {
                System.out.println("Add a new element to list: " + o);
                return super.add(o);
            }
        };
        listik.add(1000500);

        Comparator comparatorName = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Attachment left = (Attachment) o1;
                Attachment right = (Attachment) o2;
                return left.getName().compareTo(right.getName());
            }
        };
        list.sort(comparatorName);
        System.out.println(list);
    }
}
