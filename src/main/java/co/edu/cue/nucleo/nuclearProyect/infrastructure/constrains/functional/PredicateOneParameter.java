package co.edu.cue.nucleo.nuclearProyect.infrastructure.constrains.functional;
@FunctionalInterface
public interface PredicateOneParameter<T> {
    public boolean test(T value);
}
