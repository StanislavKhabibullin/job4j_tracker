package ru.job4j.api;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DogsBreedBuiderExam {

    private String breed;
    private String color;
    private Integer age;

    public String getBreed() {
        return breed;
    }

    public String getColor() {
        return color;
    }

    public Integer getAge() {
        return age;
    }

    private DogsBreedBuiderExam(Builder builder) {
        this.breed = builder.breed;
        this.color = builder.color;
        this.age = builder.age;
    }

    public static class Builder {
        private String breed;
        private String color;
        private Integer age;

        public Builder(String breed) {
            this.breed = breed;
        }

        public Builder setColor(String color) {
            this.color = color;
            return this;
        }

        public Builder setAge(Integer age) {
            this.age = age;
            return this;
        }

        public DogsBreedBuiderExam builderExam() {
            return new DogsBreedBuiderExam(this);
        }
    }

    public static void main(String[] args) {
        //jStream.of(....).filter(...).map(...).collect(...)
        DogsBreedBuiderExam first = new Builder("shepherd")
                .setColor("black")
                .setAge(7).builderExam();
        DogsBreedBuiderExam second = new Builder("dog")
                .setColor("white")
                .setAge(7).builderExam();
        DogsBreedBuiderExam third = new Builder("dog")
                .setColor("white")
                .setAge(1).builderExam();
        DogsBreedBuiderExam fourth = new Builder("shepherd")
                .setColor("black")
                .setAge(3).builderExam();
        List<String> expect = Stream.of(first, second, third, fourth)
                .filter(x -> x.getAge() > 3)
                .map((x) -> "породы с возрастом более трех лет: " + (x.getBreed()) + "\n")
                .collect(Collectors.toList());
        System.out.println(expect);
    }
}
