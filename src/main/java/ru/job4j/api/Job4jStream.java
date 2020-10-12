package ru.job4j.api;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Stream;

public interface Job4jStream extends Stream {

    // добавляется лишний map чтобы привести Object к требуемому типу в коде
    static Stream<Object> of(Object e1, Object e2, Object e3, Object e4) {
        List<Object> objects = List.of(e1, e2, e3, e4);
        return objects.stream();
    }

    @Override
    Stream filter(Predicate predicate);

    @Override
    Stream map(Function mapper);

    @Override
    Object collect(Collector collector);
}
