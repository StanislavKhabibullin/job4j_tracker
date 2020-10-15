package ru.job4j.stream;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import java.util.List;

@SuppressWarnings("checkstyle:EmptyLineSeparator")
public class AnalyzeTest {

    @Test
    public void averageScore() {
        double average = Analyze.averageScore(
                List.of(
                        new Pupil("Ivanov", List.of(new Subject("Math", 100))),
                        new  Pupil("Ivanov", List.of(new Subject("Math", 50)))
                ).stream()
        );
        assertThat(average, is(75D));
    }

    @Test
    public void whenListOfPupilAverage() {
        List<Tupil> average = Analyze.averageScoreBySubject(
                List.of(
                        new Pupil("Ivanov", List.of(new Subject("Math", 100), new Subject("Lang", 100))),
                        new Pupil("Petrov", List.of(new Subject("Math", 60), new Subject("Lang", 60)))
                ).stream()
        );
        assertThat(average, is(List.of(
                new Tupil("Ivanov", 100D),
                new Tupil("Petrov", 60D)
        )));
    }

    @Test
    public void whenBestPupil() {
        Tupil best = Analyze.bestStudent(
                List.of(
                        new Pupil("Ivanov", List.of(new Subject("Math", 100), new Subject("Lang", 100))),
                        new Pupil("Petrov", List.of(new Subject("Math", 60), new Subject("Lang", 60)))
                ).stream()
        );
        assertThat(best, is(new Tupil("Ivanov", 200D)));
    }

    @Test
    public void whenListOfSubjectAverage() {
        List<Tupil> average = Analyze.averageScoreByPupil(
                List.of(
                        new Pupil("Ivanov", List.of(new Subject("Math", 100), new Subject("Lang", 100))),
                        new Pupil("Petrov", List.of(new Subject("Math", 60), new Subject("Lang", 60)))
                ).stream()
        );
        assertThat(average, is(List.of(
                new Tupil("Lang", 80D),
                new Tupil("Math", 80D)
        )));
    }

    @Test
    public void whenBestSubject() {
        Tupil best = Analyze.bestSubject(
                List.of(
                        new Pupil("Ivanov", List.of(new Subject("Math", 100), new Subject("Lang", 40))),
                        new Pupil("Petrov", List.of(new Subject("Math", 60), new Subject("Lang", 60)))
                ).stream()
        );
        assertThat(best, is(new Tupil("Math", 160D)));
    }

}