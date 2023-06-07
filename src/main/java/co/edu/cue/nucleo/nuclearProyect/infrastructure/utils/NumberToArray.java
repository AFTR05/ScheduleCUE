package co.edu.cue.nucleo.nuclearProyect.infrastructure.utils;

import co.edu.cue.nucleo.nuclearProyect.infrastructure.constrains.functional.functionalEnums.PredicateOneEnum;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.constrains.functional.functionalEnums.PredicateTwoEnum;

import java.util.ArrayList;
import java.util.List;

public class NumberToArray {
    public static List<Integer> transformNumber(int number) {
        List<Integer> arr = new ArrayList<>();
        while (OperationFactory.getPredicateOneParameter(PredicateOneEnum.MORE0).test(number)){
        //number > 0
            //number >= 3
            if (OperationFactory.getPredicateOneParameter(PredicateOneEnum.MOREEQUAL3).test(number)) {
                arr.add(3);
                number -= 3;
            } else {
                arr.add(2);
                number -= 2;
            }
        }
        return arr;
    }
}
