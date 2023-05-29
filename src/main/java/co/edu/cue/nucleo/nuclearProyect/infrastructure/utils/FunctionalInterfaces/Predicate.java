package co.edu.cue.nucleo.nuclearProyect.infrastructure.utils.FunctionalInterfaces;
@FunctionalInterface
public interface Predicate<T> {
    public boolean test(T value);
}
