package co.edu.cue.nucleo.nuclearProyect.infrastructure.constrains.functional.impl.functionImp;

import co.edu.cue.nucleo.nuclearProyect.infrastructure.constrains.functional.Function;

public class SubtractionImp implements Function<Integer,Integer> {
    @Override
    public void transform(Integer value1, Integer value2) {
        value1=value1-value2;
    }
}
