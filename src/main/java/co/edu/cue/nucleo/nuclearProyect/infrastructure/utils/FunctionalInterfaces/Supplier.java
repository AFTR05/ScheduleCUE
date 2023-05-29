package co.edu.cue.nucleo.nuclearProyect.infrastructure.utils.FunctionalInterfaces;
@FunctionalInterface
public interface Supplier<T> {
    Supplier<T> generate();

}
