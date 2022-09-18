package client;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Scanner;

public class RPCClient {
    public static void main(String[] args) throws MalformedURLException, XmlRpcException {
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("http://localhost:1200"));
        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);
        Scanner key = new Scanner(System.in);
        key.useDelimiter("\n");
        System.out.print("Select one exercise (1-4): ");
        int exercise = key.nextInt();
        switch (exercise) {
            case 1:
                String name;
                double weight, height;

                System.out.println("~ Exercise 1");
                System.out.println("Name: ");
                name = key.next();
                System.out.println("Weight: ");
                weight = key.nextDouble();
                System.out.println("Height: ");
                height = key.nextDouble();

                Object[] data = {name, height, weight};
                Object response = client.execute("Methods.calculateImc", data);
                System.out.println("Result -> " + response);
                break;
            case 2:
                double num1, num2, num3, num4;

                System.out.println("~ Exercise 2");
                System.out.print("Number 1: ");
                num1 = key.nextDouble();
                System.out.print("Number 2: ");
                num2 = key.nextDouble();
                System.out.print("Number 3: ");
                num3 = key.nextDouble();
                System.out.print("Number 4: ");
                num4 = key.nextDouble();

                Object[] numbers = {num1, num2, num3, num4};
                Object responseTwo = client.execute("Methods.calculator", numbers);
                System.out.println("Result -> " + responseTwo);
                break;
            case 3:
                int number1, number2;

                System.out.println("~ Exercise 3");
                System.out.print("Number 1: ");
                number1 = key.nextInt();
                System.out.print("Number 2: ");
                number2 = key.nextInt();

                Object[] twoNumbers = {number1, number2};
                Object responseThree = client.execute("Methods.betweenTwoNumbers", twoNumbers);
                System.out.println("Result -> " + responseThree);
                break;
            case 4:
                int[] array = new int[5];
                System.out.print("The numbers in the array are: ");
                System.out.print("[");
                for (int i = 0; i < array.length; i++){
                    array[i] = (int) (Math.random() * 100);
                    if (i < 4){
                        System.out.print(array[i]+", ");
                    }else {
                        System.out.print(array[i]);
                    }
                }
                System.out.print("]");
                int n1 = array[0],
                n2 = array[1],
                n3 = array[2],
                n4 = array[3],
                n5 = array[4];

                Object[] sortArray = {n1, n2, n3, n4, n5};
                Object orderedArray = client.execute("Methods.sortArray", sortArray);
                System.out.println(orderedArray);
                break;
            default:
                break;
        }
    }
}
