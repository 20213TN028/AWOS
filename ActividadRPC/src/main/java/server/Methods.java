package server;

import java.util.Arrays;

public class Methods {
    public Object calculateImc(String name, double height, double weight){
        double imc = weight / (height * height);
        return "Hello "+ name + " your IMC is "+imc;
    }

    public Object calculator(double num1, double num2, double num3, double num4){
        double product = num1 * num2 * num3 * num4;
        double addition = num1 + num2 + num3 + num4;
        double avg = addition / 4;
        return "Hello, the product is: "+ product+", the addition is: "+ addition+" and the average is: "+avg;
    }

    public Object betweenTwoNumbers(int number1, int number2){
        int total = 0, size = (Math.abs(number1) - Math.abs(number2)), min = (Math.min(number1, number2)) + 1;
        int[] array = new int[Math.abs(size)];
        for (int i = 0; i < array.length - 1; i++){
            array[i] = min++;
            total += array[i];
        }
        return "The addition of the numbers between "+number1+" and "+number2+" is: "+total;
    }

    public Object sortArray(int n1, int n2, int n3, int n4, int n5){
        int[] orderedArray = {n1, n2, n3, n4, n5};
        Arrays.sort(orderedArray);
        return "\nThe ordered array is: "+Arrays.toString(orderedArray);
    }

    /*public static void main(String[] args) {
        int[] array = new int[5];
        System.out.println("The numbers in the array are: ");
        for (int i = 0; i < array.length; i++){
            array[i] = (int) (Math.random() * 100);
            System.out.println(array[i]);
        }
        sortArray(array);
        System.out.println("\nThe ordered array: ");
        for (int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }
    }*/
}
