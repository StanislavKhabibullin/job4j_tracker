package ru.job4j.stream;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class ProfileTest {
    private List<Profile> profiles = new ArrayList<>();

    @Before
    public void setUp() {
       profiles.add(new Profile("City3", "Lenina", 10, 15));
        profiles.add(new Profile("City2", "Lenina56", 1, 14));
        profiles.add(new Profile("City3", "Lenin14a", 120, 25));
        profiles.add(new Profile("City4", "Lenin7a", 610, 155));
        profiles.add(new Profile("City5", "Leni8na", 710, 44));
    }

    @Test
    public void collect() {
        Profile first = new Profile();
   List<Adress> exp = new ArrayList<>();
   exp.add(new Adress("City3", "Lenina", 10, 15));
   exp.add(new Adress("City2", "Lenina56", 1, 14));
   exp.add(new Adress("City3", "Lenin14a", 120, 25));
   exp.add(new Adress("City4", "Lenin7a", 610, 155));
   exp.add(new Adress("City5", "Leni8na", 710, 44));
   List<Adress> rezult = first.collect(profiles);
   assertThat(rezult, is(exp));

    }

    @Test
    public void sortick() {
        Profile first = new Profile();
        List<Adress> exp = new ArrayList<>();
        exp.add(new Adress("City2", "Lenina56", 1, 14));
        exp.add(new Adress("City3", "Lenina", 10, 15));
        exp.add(new Adress("City3", "Lenin14a", 120, 25));
        exp.add(new Adress("City4", "Lenin7a", 610, 155));
        exp.add(new Adress("City5", "Leni8na", 710, 44));
        List<Adress> rezult = first.sortick(profiles);
        assertThat(rezult, is(exp));

    }
}