package main.lab2;

public class LogarithmExpression extends NaturalLogarithmExpansion{

    public static double log(double x, double eps, double base){
        double lnI = ln(base, eps);
        return lnI == 0 ? Double.NaN : ln(x, eps) / lnI;
    }

}
