package ru.job4j.oop;

public class Battery {
    private int load;

    public Battery(int value) {
        this.load = value;
    }

    public void exchange(Battery another) {
        this.load = this.load - 17;
        another.load = another.load + 17;
    }

    public static void main(String[] args) {
    Battery first = new Battery(220);
    Battery second = new Battery(380);
        System.out.println("first: " + first.load + ".second: " + second.load);
        first.exchange(second);
        System.out.println("first: " + first.load + ".second: " + second.load);
    }
}
