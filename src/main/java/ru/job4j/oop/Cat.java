package ru.job4j.oop;

public class Cat {
    private String food;
    private String name;

    public void show() {
        System.out.println("Cat's name is - " + this.name);
        System.out.println("Cat's food is - " + this.food);
    }

    public void eat(String meat){
        this.food = meat;
    }
    public void giveNick(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Cat gav = new Cat();
        gav.giveNick("GAV");
        gav.eat("Kotleta");
        gav.show();
        Cat black = new Cat();
        black.giveNick("Black");
        black.eat("fish");
        black.show();
    }
}
