package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {

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

    public ArrayList<Person> findPredicat(String key) {
        ArrayList<Person> result = new ArrayList<>();
        Predicate<Person> name = x -> x.getName().contains(key);
        Predicate<Person> surname = x -> x.getSurname().contains(key);
        Predicate<Person> address = x -> x.getAddress().contains(key);
        Predicate<Person> getPhone = x -> x.getPhone().contains(key);
        Predicate<Person> combine = name.or(surname).or(address).or(getPhone);
        for (Person value:persons
        ) {
            if (combine.test(value)) {
                result.add(value);
            }
        }

        return result;
    }
}
