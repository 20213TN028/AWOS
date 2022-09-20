package server;

public class Methods {
    public double addition(String n1, String n2) {
        double add = Double.parseDouble(n1) + Double.parseDouble(n2);
        return add;
    }

    public double subtraction(String n1, String n2) {
        double sub = Double.parseDouble(n1) - Double.parseDouble(n2);
        return sub;
    }

    public double multiply(String n1, String n2) {
        double mul = Double.parseDouble(n1) * Double.parseDouble(n2);
        return mul;
    }

    public double division(String n1, String n2) {
        double div = Double.parseDouble(n1) / Double.parseDouble(n2);
        return div;
    }

    public double exponent(String n1, String n2) {
        double exp = Math.pow(Double.parseDouble(n1), Double.parseDouble(n2));
        return exp;
    }

    public static double squareRoot(String n1, String n2) {
        double sqr = Math.sqrt(Double.parseDouble(n1));
        return sqr;
    }
}
