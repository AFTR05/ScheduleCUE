package co.edu.cue.nucleo.nuclearProyect.infrastructure.constrains.functional.impl.predicateImp;

import co.edu.cue.nucleo.nuclearProyect.infrastructure.constrains.functional.Predicate;

public class UpTenImp implements Predicate<Integer> {


    @Override
    public boolean test(Integer value) {
        return value > 10;
    }
}

