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
    public void wenValidInput() {
        Output out = new StubOutPut();
        Input in = new StubInput(
                new String[]{"1","6"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Зачем здесь вообще что то писать?");
        assertThat(selected, is(1));
    }
    @Test
    public void wenValidOutput() {
        Output out = new StubOutPut();
        Input in = new StubInput(
                new String[]{"one", "6"}
        );
        ValidateInput input = new ValidateInput(out, in);
        input.askInt("QUESTION");

        assertThat(out.toString(), is("Please enter validate data again.\r\n"));
    }
}