package co.edu.cue.nucleo.nuclearProyect.infrastructure.constrains.functional;
@FunctionalInterface
public interface Function<R,E> {
    void transform(R value1,E value2);
}
