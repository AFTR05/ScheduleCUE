package co.edu.cue.nucleo.nuclearProyect.infrastructure.constrains.validation;

public class MaximumValidator {
    public static Boolean validateMaximumDay(Integer hoursInDay){
        return hoursInDay >= 9;
    }
}
