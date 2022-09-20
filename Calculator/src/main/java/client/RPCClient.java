package client;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import server.BeanOperations;
import server.DaoOperations;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RPCClient {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws MalformedURLException, XmlRpcException {
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("http://localhost:1200"));
        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);
        BeanOperations operations = new BeanOperations();
        DaoOperations op = new DaoOperations();
        String option = "", firstNumber = "", secondNumber = "";
        do {
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Multiplicación");
            System.out.println("4. División");
            System.out.println("5. Exponente");
            System.out.println("6. Raíz");
            System.out.println("7. Consultar historial");
            System.out.println("8. Salir");
            System.out.print("Seleccionar una opción: ");
            option = sc.next();
            if (isNumber(option)) {
                switch (Integer.parseInt(option)) {
                    case 1:
                        System.out.println("SUMA");
                        operations.setOperationType("Suma");

                        firstNumber = fillNumberOne();
                        secondNumber = fillNumberTwo();
                        Object[] dataSum = {firstNumber, secondNumber};

                        operations.setFirstNumber(Double.parseDouble(firstNumber));
                        operations.setSecondNumber(Double.parseDouble(secondNumber));

                        double sum = (double) client.execute("Methods.addition", dataSum);
                        System.out.println("El resultado de la suma es: " + sum);
                        operations.setResult(sum);

                        op.saveOperation(operations);
                        break;
                    case 2:
                        System.out.println("RESTA");
                        operations.setOperationType("Resta");

                        firstNumber = fillNumberOne();
                        secondNumber = fillNumberTwo();
                        Object[] dataSub = {firstNumber, secondNumber};

                        operations.setFirstNumber(Double.parseDouble(firstNumber));
                        operations.setSecondNumber(Double.parseDouble(secondNumber));

                        double sub = (double) client.execute("Methods.subtraction", dataSub);
                        System.out.println("El resultado de la resta es: " + sub);
                        operations.setResult(sub);

                        op.saveOperation(operations);
                        break;
                    case 3:
                        System.out.println("MULTIPLICACIÓN");
                        operations.setOperationType("Multiplicación");

                        firstNumber = fillNumberOne();
                        secondNumber = fillNumberTwo();
                        Object[] dataMul = {firstNumber, secondNumber};

                        operations.setFirstNumber(Double.parseDouble(firstNumber));
                        operations.setSecondNumber(Double.parseDouble(secondNumber));

                        double mul = (double) client.execute("Methods.multiply", dataMul);
                        System.out.println("El resultado de la multiplicación es: " + mul);
                        operations.setResult(mul);

                        op.saveOperation(operations);
                        break;
                    case 4:
                        System.out.println("DIVISIÓN");
                        operations.setOperationType("División");

                        firstNumber = fillNumberOne();

                        do {
                            secondNumber = fillNumberTwo();
                        } while ((Double.parseDouble(secondNumber) == 0));

                        Object[] dataDiv = {firstNumber, secondNumber};

                        operations.setFirstNumber(Double.parseDouble(firstNumber));
                        operations.setSecondNumber(Double.parseDouble(secondNumber));

                        double div = (double) client.execute("Methods.division", dataDiv);
                        System.out.println("El resultado de la división es: " + div);
                        operations.setResult(div);

                        op.saveOperation(operations);
                        break;
                    case 5:
                        System.out.println("EXPONENTE");
                        operations.setOperationType("Exponente");

                        firstNumber = fillNumberOne();
                        secondNumber = fillNumberTwo();
                        Object[] dataExp = {firstNumber, secondNumber};

                        operations.setFirstNumber(Double.parseDouble(firstNumber));
                        operations.setSecondNumber(Double.parseDouble(secondNumber));

                        double exp = (double) client.execute("Methods.exponent", dataExp);
                        System.out.println("El resultado del exponente es: " + exp);
                        operations.setResult(exp);

                        op.saveOperation(operations);
                        break;
                    case 6:
                        System.out.println("RAÍZ CUADRADA");
                        operations.setOperationType("Raíz Cuadrada");

                        do {
                            firstNumber = fillNumberOne();
                        } while ((Double.parseDouble(firstNumber) < 0));

                        Object[] dataSqr = {firstNumber};

                        operations.setFirstNumber(Double.parseDouble(firstNumber));

                        double sqr = (double) client.execute("Methods.squareRoot", dataSqr);
                        System.out.println("El resultado de la raíz es: " + sqr);
                        operations.setResult(sqr);

                        op.saveOperation(operations);
                        break;
                    case 7:
                        System.out.println(op.showHistory().toString());
                        break;
                    case 8:
                        System.err.println("Saliendo...");
                        break;
                    default:
                        System.out.println("No existe esa opción.");
                        break;
                }
            } else {
                System.out.println("La opción es incorrecta. Intente nuevamente.");
            }
        } while (!option.equals("8"));
    }

    public static boolean isNumber(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isDouble(String number) {
        try {
            Double.parseDouble(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static String fillNumberOne() {
        String firstNumber;
        do {
            System.out.print("Número 1: ");
            firstNumber = sc.next();
            if (!isDouble(firstNumber)) {
                System.out.println("Ingrese un número valido.");
            }
        } while (!isDouble(firstNumber));
        return firstNumber;
    }

    public static String fillNumberTwo() {
        String secondNumber;
        do {
            System.out.print("Número 2: ");
            secondNumber = sc.next();
            if (!isDouble(secondNumber)) {
                System.out.println("Ingrese un número valido.");
            }
        } while (!isDouble(secondNumber));
        return secondNumber;
    }
}
