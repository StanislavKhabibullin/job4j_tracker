package ru.job4j.oop;

public class Story2 {
    public static void main(String[] args) {
        Ball ball = new Ball();
        Hare hare = new Hare();
        Wolf2 wolf = new Wolf2();
        Fox fox = new Fox();
        ball.runToHare(hare);
        hare.notEat(ball);
        ball.runToWolf2(wolf);
        wolf.notEat(ball);
        ball.runToFox(fox);
        fox.eat(ball);
    }
}
