package main.lab2;


public class SinExpansion {

    public static double sin(Double x, Double eps) throws IllegalArgumentException{
        if (x.isInfinite() || x.isNaN() || eps.isNaN() || eps.isInfinite() || eps == 0.)
            throw new IllegalArgumentException();

        double previousResult, result = 0;
        int i = 0;
        do {
            previousResult = result;
            result += (Math.pow(-1, i) * Math.pow(x, (2 * i + 1))) / factorial(2 * i + 1);
            i++;
        } while(Math.abs(previousResult - result) > eps);

        return result;
    }

    private static double factorial(int x) {
        double val = 1;
        for (int i = 2; i <= x; i++)
            val *= i;
        return val;
    }

}
