package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import static org.junit.Assert.*;

public class ValidateInputTest {

    @Test
    public void wenInvalidInput() {
        Output out = new StubOutPut();
        Input in = new StubInput(
               new String[]{"one", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu");
        assertThat(selected, is(1));
    }

    @Test
    public void askInt() {
    }
}