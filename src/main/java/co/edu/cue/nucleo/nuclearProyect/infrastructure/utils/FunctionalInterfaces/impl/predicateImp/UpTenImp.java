package co.edu.cue.nucleo.nuclearProyect.infrastructure.utils.FunctionalInterfaces.impl.predicateImp;

import co.edu.cue.nucleo.nuclearProyect.infrastructure.utils.FunctionalInterfaces.Predicate;

public class UpTenImp implements Predicate<Integer> {


    @Override
    public boolean test(Integer value) {
        return value > 10;
    }
}

