package ru.job4j.api;

import javax.sql.rowset.Predicate;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class Job4jStream {

    // добавляется лишний map чтобы привести Object к требуемому типу в коде
    static Stream<Object> of(Object e1, Object e2, Object e3, Object e4) {
        List<Object> objects = List.of(e1, e2, e3, e4);
        return objects.stream();
    }
}
