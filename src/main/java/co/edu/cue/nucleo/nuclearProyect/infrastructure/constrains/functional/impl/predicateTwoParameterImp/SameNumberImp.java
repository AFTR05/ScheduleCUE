package co.edu.cue.nucleo.nuclearProyect.infrastructure.constrains.functional.impl.predicateTwoParameterImp;

import co.edu.cue.nucleo.nuclearProyect.infrastructure.constrains.functional.PredicateTwoParameter;

public class SameNumberImp implements PredicateTwoParameter<Integer,Integer> {
    @Override
    public Boolean test(Integer value1, Integer value2) {
        return value1==value2;
    }
}
