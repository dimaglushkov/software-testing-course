package main.lab2;

public class Main {
    public static void main(String[] args) {
        CsvPrinter.print(Expansion::calculate, 0.1, 20);
    }
}
