package ru.job4j.oop;

public class DummyDic {
    public String engToRus(String eng) {
        String word = "Unknown word " + eng;
        return word;
    }

    public static void main(String[] args) {
        DummyDic obj = new DummyDic();
        String exp = obj.engToRus("text");
        System.out.println(exp);
    }
}
