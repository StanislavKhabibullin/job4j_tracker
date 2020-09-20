package ru.job4j.stream;

import java.util.Objects;

public class Adress {
    private String city;
    private String street;

    private int home;
    private int apartment;

    public Adress(String city, String street, int home, int apartment) {
        this.city = city;
        this.street = street;
        this.home = home;
        this.apartment = apartment;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getHome() {
        return home;
    }

    public int getApartment() {
        return apartment;
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, home, apartment);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (getClass() != obj.getClass() || obj == null) {
            return false;
        }
        Adress adress = (Adress) obj;
        return home == adress.home && apartment == adress.apartment
                && Objects.equals(city, adress.city) && Objects.equals(street, adress.street);
    }

    @Override
    public String toString() {
        return "Adress{"
                + "city=" + city
                + ", street='" + street
                + ", home= " + home
                + ", appartment= " + apartment
                + '\'' + '}';
    }
}
