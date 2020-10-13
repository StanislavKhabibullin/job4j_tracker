package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Analyze {
    public static double averageScore(Stream<Pupil> stream) {
        Double result = 0.0;
        final int[] i = {0};
        List<Subject> rsl = new ArrayList<>();
      long count = 0;
        var count1 = 0;
        var collect = stream.flatMap(pupil -> {
          return   pupil.getSubjects().stream();
        }).map(subject -> {
            i[0]++;
            return subject.getScore();
        })
                .reduce((x, y) -> x + y);
        count = collect.get();
        if (collect.isPresent()) {
            var l = count / i[0];
            return l;
        }
       return 0.0;
    }
}
