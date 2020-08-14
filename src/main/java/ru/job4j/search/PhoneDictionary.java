package ru.job4j.search;

import java.util.ArrayList;

public class PhoneDictionary {
    @SuppressWarnings("checkstyle:Indentation")
    private ArrayList<Person> persons = new ArrayList();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> rezult = new ArrayList<>();
        int i = 0;
        for (Person value:persons
             ) {
            if (value.getName().contains(key)
                    || value.getSurname().contains(key)
                    || value.getAddress().contains(key)
                    || value.getPhone().contains(key)) {
                rezult.add(value);
            }
        }
        return rezult;
    }
}
