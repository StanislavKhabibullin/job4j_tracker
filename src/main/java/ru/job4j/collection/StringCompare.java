package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
       /* char[] o1mas = o1.toCharArray();
        char[] o2mas = o2.toCharArray();
        int i = 0;
        for (char rsl:o1mas
             ) {
            Integer rslint = Character.getNumericValue(rsl);
            if (i < o2mas.length) {
                Integer o2masint = Character.getNumericValue(o2mas[i]);
                if (rslint.compareTo(o2masint) != 0) {
                    return rslint.compareTo(o2masint);
                }
                if (i == (o2mas.length - 1) && rslint.compareTo(o2masint) == 0) {
                    return 0;
                }
            } else {
                return 1;
            }
            i++;
        }
        return -1; */
        for (int i = 0; i < Math.min(o1.length(), o2.length()); i++) {
            int rsl = Character.compare(o1.charAt(i), o2.charAt(i));
            if (rsl != 0) {
                return rsl;
            }
        }
        return Integer.compare(o1.length(), o2.length());
    }
}
