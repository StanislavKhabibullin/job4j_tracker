package ru.job4j.collection;

import java.util.List;

public class ConvertList2Array {
    public static int[][] toArray(List<Integer> list, int count) {
        int group = (int) Math.ceil(((double) list.size()) / count);
        int[][] array = new int[group][count];
        int schet = 0;
        int i = 0;
        int j = 0;
        for (int scketch:list) {
           if (j < count) {
               array[i][j++] = scketch;
           } else {
               i++;
               j = 0;
               array[i][j++] = scketch;
           }
        }
        return array;
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7);
        int[][] result = toArray(list, 3);
    }
}
