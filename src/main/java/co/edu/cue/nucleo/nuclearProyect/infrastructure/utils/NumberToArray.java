package co.edu.cue.nucleo.nuclearProyect.infrastructure.utils;

import java.util.ArrayList;
import java.util.List;

public class NumberToArray {
    public static List<Integer> transformNumber(int number) {
        List<Integer> arr = new ArrayList<>();
        while (number > 0) {
            if (number >= 3) {
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
