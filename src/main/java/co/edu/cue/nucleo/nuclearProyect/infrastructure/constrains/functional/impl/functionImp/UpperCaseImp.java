package co.edu.cue.nucleo.nuclearProyect.infrastructure.constrains.functional.impl.functionImp;


import co.edu.cue.nucleo.nuclearProyect.infrastructure.constrains.functional.Function;

public class UpperCaseImp implements Function<String> {


    @Override
    public void transform(String s) {
        s.toUpperCase();
    }
}
