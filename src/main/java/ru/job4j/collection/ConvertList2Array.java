package ru.job4j.collection;

import java.util.List;

public class ConvertList2Array {
    public static int[][] toArray(List<Integer> list, int count) {
        int group = (int) Math.ceil(((double) list.size()) / count);
        int[][] array = new int[group][count];
        int schet = 0;
        int i = 0;
        int j = 0;
        for (int[] row:array) {
            for (int cell:row) {
                if (schet < list.size()) {
                    cell = list.get(schet++);
                    array[i][j++] = cell;
                }
                if (j == count) {
                    j = 0;
                }
            }
            System.out.println();
            i++;
        }
        return array;
    }

    @SuppressWarnings("checkstyle:EmptyLineSeparator")
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7);
        int[][] result = toArray(list, 3);
    }
}
