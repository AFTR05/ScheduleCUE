package co.edu.cue.nucleo.nuclearProyect.infrastructure.utils.Validation;

public class MaximumValidator {
    public static Boolean validateMaximumDay(Integer hoursInDay){
        return hoursInDay >= 9;
    }
}
