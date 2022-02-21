package exceptions;

import java.io.File;
import java.io.FileReader;
import java.util.*;

class SimpleCalculator {
    public static void main(String[] args) throws Exception {
        FileReader fr = new FileReader("src\\exceptions\\input.txt");
        Scanner sc = new Scanner(fr);
        String[] array = sc.nextLine().split(" ");
        try {
            double num1 = Double.parseDouble(array[0]), num2 = Double.parseDouble(array[2]);
            operation(array[1]);
            divisionByZero(num2);
            if (array[1].equals("+"))
                System.out.println(num1 + num2);
            else if (array[1].equals("*"))
                System.out.println(num1 * num2);
            else if (array[1].equals("/"))
                System.out.println(num1 / num2);
            else if (array[1].equals("-"))
                System.out.println(num1 - num2);
        } catch (NumberFormatException ex) {
            System.out.println("Error! Not number");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    static void divisionByZero(double num) throws Exception {
        if (num == 0) throw new Exception("Error! Division by zero");
    }

    static void operation(String text) throws Exception {
        if (!text.equals("+") && !text.equals("/") && !text.equals("-") && !text.equals("*"))
            throw new Exception("Operation Error!");
    }
}
