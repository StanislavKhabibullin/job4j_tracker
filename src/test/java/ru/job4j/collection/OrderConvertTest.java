package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class OrderConvertTest {

    @Test
    public void processTest() {
        List<Order> orders = new ArrayList<>();
        Order first = new Order("123456", "Skhabibullin");
        orders.add(first);
        HashMap<String, Order> table = OrderConvert.process(orders);
        assertThat(table.get("123456"), is(first));

    }
}