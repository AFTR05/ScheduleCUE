package co.edu.cue.nucleo.nuclearProyect.infrastructure.constrains.validation;

import co.edu.cue.nucleo.nuclearProyect.infrastructure.constrains.functional.functionalEnums.PredicateOneEnum;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.constrains.functional.functionalEnums.PredicateTwoEnum;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.utils.OperationFactory;

public class MaximumValidator {
    public static Boolean validateMaximumDay(Integer hoursInDay){
        return OperationFactory.getPredicateOneParameter(PredicateOneEnum.MAXIMUMDAY).test(hoursInDay);
        //hoursInDay >= 9;
    }
}

