package main.lab2;
import static main.lab2.NaturalLogarithmExpansion.*;

public class LogarithmExpression{

    public static double log(double x, double eps, double base){
        double lnI = ln(base, eps);
        return lnI == 0 ? Double.NaN : ln(x, eps) / lnI;
    }

}
