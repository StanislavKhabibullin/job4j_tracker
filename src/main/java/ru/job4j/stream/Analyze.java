package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SuppressWarnings("checkstyle:WhitespaceAround")
public class Analyze {
    public static double averageScore(Stream<Pupil> stream) {
        var collect = stream.flatMap(pupil -> {
          return   pupil.getSubjects().stream();
        }).mapToInt(subject -> {
            return subject.getScore();
        })
                .average();
        if (collect.isPresent()) {
            return collect.getAsDouble();
        }
       return 0.0;
    }

    public static List<Tupil> averageScoreBySubject(Stream<Pupil> stream) {
        var collect = stream.map(pupil -> {
            return new Tupil(pupil.getName(),
                    pupil.getSubjects().stream().mapToInt(Subject::getScore).average().getAsDouble());
        })
                .collect(Collectors.toList());
        return collect;
    }

    public static List<Tupil> averageScoreByPupil(Stream<Pupil> stream) {
            var collect = stream.flatMap(pupil -> {
                return   pupil.getSubjects().stream();
            }).collect(Collectors.groupingBy(Subject::getName,
                    Collectors.averagingDouble(m -> m.getScore())))
                   .entrySet().stream().map(obj -> {
                        return new Tupil(obj.getKey(), obj.getValue());
                            }).collect(Collectors.toList());
            return collect;
        }

   public static Tupil bestStudent(Stream<Pupil> stream) {
       var collect = stream.map(pupil -> {
           return new Tupil(pupil.getName(),
                   pupil.getSubjects().stream().mapToInt(Subject::getScore).sum());
       })
               .max((a, b) -> Double.compare(a.getScore(), b.getScore()))
               .orElse(new Tupil("subject", 1000));
       return collect;
   }

    public static Tupil bestSubject(Stream<Pupil> stream) {
        var collect = stream.flatMap(pupil -> {
            return   pupil.getSubjects().stream();
        }).collect(Collectors.groupingBy(Subject::getName,
                Collectors.summingDouble(m -> m.getScore())))
                .entrySet().stream().map(obj -> {
                    return new Tupil(obj.getKey(), obj.getValue());
                }).max((a, b) -> Double.compare(a.getScore(), b.getScore()))
                .orElse(new Tupil("subject", 1000));
        return collect;
    }
}
