package co.edu.cue.nucleo.nuclearProyect.infrastructure.constrains.functional.impl.functionImp;

import co.edu.cue.nucleo.nuclearProyect.infrastructure.constrains.functional.Function;


public class SquareImp implements Function<Integer> {
    @Override
    public void transform(Integer value) {
        value*=value;
    }
}
