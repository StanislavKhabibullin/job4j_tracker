package ru.job4j.collection;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class PassportOfficeTest {

    @Test
    public void add() {
        Citizen citizen = new Citizen("6802808327", "Stanoslav Khabibullin");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get("6802808327"), is(citizen));
    }
}