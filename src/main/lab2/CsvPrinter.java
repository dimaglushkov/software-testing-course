package main.lab2;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.TreeMap;
import au.com.bytecode.opencsv.CSVWriter;

public class CsvPrinter {

    private static TreeMap<Double, Double> getValues(FunctionalInterface method, double step, double xLength) throws InvocationTargetException, IllegalAccessException {
        TreeMap<Double, Double> values = new TreeMap<>();
        double EPS = 0.0001;
        for (double i = - xLength / 2; i < xLength / 2; i += step){
            double value = (double) method.run(i, EPS);
            values.put(i, value);
        }
        return values;
    }

    public static void print(FunctionalInterface method, double step, double xLength){
        try {
            TreeMap<Double, Double> values = getValues(method, step, xLength);

            File file = new File("./output.csv");
            try {
                FileWriter output = new FileWriter(file);
                CSVWriter write = new CSVWriter(output);
                String[] header = { "x", "y" };
                write.writeNext(header);

                for(Map.Entry<Double, Double> entry : values.entrySet()) {
                    String[] str = { Double.toString(entry.getKey()), Double.toString(entry.getValue()) };
                    write.writeNext(str);
                }

                write.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            System.err.println("Exception occurred while calculating values for given arguments");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        print(SinExpansion::sin, 0.1, 5);
    }

}
