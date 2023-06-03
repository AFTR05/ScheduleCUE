package co.edu.cue.nucleo.nuclearProyect.infrastructure.constrains.functional.impl.predicateImp;

import co.edu.cue.nucleo.nuclearProyect.infrastructure.constrains.functional.Predicate;


public class BeginNImpl implements Predicate<String> {


    @Override
    public boolean test(String value) {
        return value.startsWith("n");
    }
}
