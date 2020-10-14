package main.lab2;

import java.util.stream.LongStream;

public class SinExpansion {

    public static double sin(Double x, Double eps) throws IllegalArgumentException{
        if (x.isInfinite() || x.isNaN() || eps.isNaN() || eps.isInfinite() || eps == 0.)
            throw new IllegalArgumentException();

        double previousResult, result = 0;
        int i = 0;
        do {
            previousResult = result;
            result += (Math.pow(-1, i) * Math.pow(x, (2 * i + 1))) / (LongStream.rangeClosed(1, 2*i).reduce(1, (a, b) -> (a + 1) * b));
            i++;
        } while(Math.abs(previousResult - result) > eps);

        return result;
    }

}
