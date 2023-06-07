package co.edu.cue.nucleo.nuclearProyect.infrastructure.constrains.functional;
@FunctionalInterface
public interface PredicateTwoParameter<T,E> {
    Boolean test(T value1,E value2);

}
