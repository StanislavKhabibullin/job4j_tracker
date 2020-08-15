package ru.job4j.collection;

import java.util.List;

public class ConvertList2Array {
    public static int[][] toArray(List<Integer> list, int count) {
        int group = (int) Math.ceil(((double) list.size()) / count);
        int[][] array = new int[group][count];
        int schet = 0;
        for (int i = 0; i < group; i++) {
            for (int j = 0; j < count; j++) {
                if (schet < list.size()) {
                    array[i][j] = list.get(schet++);
                }
            }
            System.out.println();
        }
        return array;
    }

    @SuppressWarnings("checkstyle:EmptyLineSeparator")
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7);
        int[][] result = toArray(list, 3);
    }
}
