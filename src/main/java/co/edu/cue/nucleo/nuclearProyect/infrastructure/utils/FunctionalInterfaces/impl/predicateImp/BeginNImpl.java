package co.edu.cue.nucleo.nuclearProyect.infrastructure.utils.FunctionalInterfaces.impl.predicateImp;

import co.edu.cue.nucleo.nuclearProyect.infrastructure.utils.FunctionalInterfaces.Predicate;


public class BeginNImpl implements Predicate<String> {


    @Override
    public boolean test(String value) {
        return value.startsWith("n");
    }
}
