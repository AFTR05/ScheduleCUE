package co.edu.cue.nucleo.nuclearProyect.infrastructure.constrains.functional;
@FunctionalInterface
public interface Supplier<T> {
    Supplier<T> generate();

}
