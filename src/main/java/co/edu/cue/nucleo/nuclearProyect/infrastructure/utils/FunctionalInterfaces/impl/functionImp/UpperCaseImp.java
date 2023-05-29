package co.edu.cue.nucleo.nuclearProyect.infrastructure.utils.FunctionalInterfaces.impl.functionImp;


import co.edu.cue.nucleo.nuclearProyect.infrastructure.utils.FunctionalInterfaces.Function;

public class UpperCaseImp implements Function<String> {


    @Override
    public void transform(String s) {
        s.toUpperCase();
    }
}
