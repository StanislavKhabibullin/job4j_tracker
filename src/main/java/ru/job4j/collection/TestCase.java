package ru.job4j.collection;


import java.util.ArrayList;

public class TestCase {
    @SuppressWarnings({"checkstyle:LeftCurly", "checkstyle:RightCurly"})
    public static void main(String[] args) {
        boolean rsl = true;
        String first = "Hello";
        String second = "Hlloe";
        char[] firstChar = first.toCharArray();
        char[] secondChar = second.toCharArray();
        ArrayList<Character> obertka = new ArrayList<>();
        ArrayList<Character> obertkaLast = new ArrayList<>();
        for (int i = 0; i < first.length(); i++) {
            obertka.add(firstChar[i]);
            obertkaLast.add(secondChar[i]);
        }
        for (int i = 0; i < first.length(); i++) {
            if (obertkaLast.contains(obertka.get(i))) {
                obertkaLast.remove(obertka.get(i));
            } else {
                rsl = false;
                break;
        }
            }

        System.out.println(rsl);

    }
}
