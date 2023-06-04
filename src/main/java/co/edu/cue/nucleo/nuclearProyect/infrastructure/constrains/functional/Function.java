package co.edu.cue.nucleo.nuclearProyect.infrastructure.constrains.functional;
@FunctionalInterface
public interface Function<R> {
    void transform(R value);
}
