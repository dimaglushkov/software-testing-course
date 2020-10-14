package main.lab2;

public class Expansion{
    public static double calculate(double x, double eps){
        return (x > 0)? func1(x, eps) : func2(x, eps);
    }

    private static double func1(double x, double eps) {
        double log2 = LogarithmExpression.log(x, eps, 2);
        double log5 = LogarithmExpression.log(x, eps, 5);
        double log10 = LogarithmExpression.log(x, eps, 10);
        double ln = NaturalLogarithmExpansion.ln(x, eps);
        if ((log5 - ln) == 0 || (log10 * log5) == 0)
            return Double.NaN;

        return (((((ln * log2) * log10) + ln) + (log10 / (Math.pow((log5 - ln), 2)))) / (Math.pow((log10 * log5), 2)));
    }

    private static double func2(double x, double eps) {
        double sin = SinExpansion.sin(x, eps);
        double cos = TrigonometryExpression.cos(x, eps);
        double sec = TrigonometryExpression.sec(x, eps);
        double csc = TrigonometryExpression.csc(x, eps);
        double cot = TrigonometryExpression.cot(x, eps);
        if (cot == 0 || sin == 0)
            return Double.NaN;

        return (((((cos / sin) + sec) - sec) / (cot * sin)) - (csc + cos));
    }

}
