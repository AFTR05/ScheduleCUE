package co.edu.cue.nucleo.nuclearProyect.infrastructure.utils;

import co.edu.cue.nucleo.nuclearProyect.infrastructure.constrains.functional.Function;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.constrains.functional.PredicateOneParameter;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.constrains.functional.PredicateTwoParameter;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.constrains.functional.functionalEnums.FunctionEnum;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.constrains.functional.functionalEnums.PredicateOneEnum;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.constrains.functional.functionalEnums.PredicateTwoEnum;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.constrains.functional.impl.functionImp.SubtractionImp;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.constrains.functional.impl.predicateOneParameterImp.MaximumDayImp;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.constrains.functional.impl.predicateOneParameterImp.More0Imp;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.constrains.functional.impl.predicateOneParameterImp.MoreEqual3Imp;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.constrains.functional.impl.predicateTwoParameterImp.*;

public class OperationFactory {
    public static PredicateOneParameter getPredicateOneParameter(PredicateOneEnum predicateOneEnum){
        return switch (predicateOneEnum){
            case MAXIMUMDAY ->new MaximumDayImp();
            case MORE0 -> new More0Imp();
            case MOREEQUAL3 -> new MoreEqual3Imp();
        };
    }

    public static PredicateTwoParameter getPredicateTwoParameter(PredicateTwoEnum predicateTwoEnum){
        return switch (predicateTwoEnum){
            case AFTERTIME -> new AfterTimeImp();
            case LESSEQUAL -> new LessEqualTimeImp();
            case MOREEQUAL -> new MoreEqualTimeImp();
            case BEFORETIME -> new BeforeTimeImp();
            case SAMENUMBER -> new SameNumberImp();
            case SAMESTRING -> new SameStringImp();
            case DIFFERENTSTRING -> new DifferentStringImp();
        };
    }

    public static Function getFunction(FunctionEnum functionEnum){
        return switch (functionEnum){
            case SUBTRACTION -> new SubtractionImp();
        };
    }
}
