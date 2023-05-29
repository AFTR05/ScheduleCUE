package co.edu.cue.nucleo.nuclearProyect.infrastructure.utils.FunctionalInterfaces.impl.functionImp;

import co.edu.cue.nucleo.nuclearProyect.infrastructure.utils.FunctionalInterfaces.Function;


public class SquareImp implements Function<Integer> {
    @Override
    public void transform(Integer value) {
        value*=value;
    }
}
