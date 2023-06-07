package co.edu.cue.nucleo.nuclearProyect.infrastructure.constrains.functional.impl.predicateTwoParameterImp;

import co.edu.cue.nucleo.nuclearProyect.infrastructure.constrains.functional.PredicateTwoParameter;

public class SameStringImp implements PredicateTwoParameter<String,String> {
    @Override
    public Boolean test(String value1, String value2) {
        return value1.equals(value2);
    }
}
