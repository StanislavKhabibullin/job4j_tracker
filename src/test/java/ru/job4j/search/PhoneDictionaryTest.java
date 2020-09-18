package ru.job4j.search;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import static org.junit.Assert.*;

public class PhoneDictionaryTest {

    @Test
    public void findByName() {
        PhoneDictionary phone = new PhoneDictionary();
        phone.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> rezult = phone.find("Pet");
        assertThat(rezult.get(0).getSurname(), is("Arsentev"));

    }

    @Test
    public void findByNamePredicate() {
        PhoneDictionary phone = new PhoneDictionary();
        phone.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> rezult = phone.findPredicat("Pet");
        assertThat(rezult.get(0).getSurname(), is("Arsentev"));

    }
}