package main.lab2;

public class NaturalLogarithmExpansion {
    
    public static double ln(Double x, Double eps) throws IllegalArgumentException{
        if (x.isInfinite() || x.isNaN() || eps.isNaN() || eps.isInfinite() || eps == 0. || x <= 0)
            throw new IllegalArgumentException();

        double previousResult, result = 0;
        int i = 0;
        do {
            previousResult = result;
            result += Math.pow((x - 1) / (x + 1), 2 * i + 1) / (2 * i + 1);
            i++;
        } while(Math.abs(previousResult - result) > eps);

        return 2 * result;
    }
}
