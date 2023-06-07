package co.edu.cue.nucleo.nuclearProyect.infrastructure.constrains.functional.impl.predicateOneParameterImp;

import co.edu.cue.nucleo.nuclearProyect.infrastructure.constrains.functional.PredicateOneParameter;

public class MaximumDayImp implements PredicateOneParameter<Integer> {
    @Override
    public boolean test(Integer value) {
        return value>=9;
    }
}
