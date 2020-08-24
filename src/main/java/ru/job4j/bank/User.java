package ru.job4j.bank;

import ru.job4j.collection.Citizen;

import java.util.Objects;

public class User {
    private String passport;
    private String userName;

    public User(String passport, String userName) {
        this.passport = passport;
        this.userName = userName;
    }

    public String getPassport() {
        return passport;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        User user = (User) obj;
        return Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
