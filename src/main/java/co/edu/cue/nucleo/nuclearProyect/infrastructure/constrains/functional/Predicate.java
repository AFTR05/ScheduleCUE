package co.edu.cue.nucleo.nuclearProyect.infrastructure.constrains.functional;
@FunctionalInterface
public interface Predicate<T> {
    public boolean test(T value);
}
