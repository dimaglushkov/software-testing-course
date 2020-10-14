package main.lab2;

public class TrigonometryExpression extends SinExpansion{

    public static double cos(double x, double eps){
        return Math.pow((1 - Math.pow(sin(x, eps), 2)), 0.5);
    }

    public static double sec(double x, double eps){
        double cos = cos(x, eps);
        return cos == 0 ? Double.NaN : 1 / cos;
    }

    public static double csc(double x, double eps){
        double sin = sin(x, eps);
        return sin == 0 ? Double.NaN : 1 / sin;
    }

    public static double cot(double x, double eps){
        double sin = sin(x, eps);
        return sin == 0 || x % Math.PI == 0? Double.NaN : cos(x, eps) / sin;
    }

}
