package exceptions;

import java.io.FileReader;
import java.util.*;

class SimpleCalculator {
    public static void main(String[] args) throws Exception {
        FileReader fr = new FileReader("src\\exceptions\\input.txt");
        Scanner sc = new Scanner(fr);
        String[] array = sc.nextLine().split(" ");
        try {
            double num1 = Double.parseDouble(array[0]), num2 = Double.parseDouble(array[2]);
            switch (array[1]) {
                case "-":
                    System.out.println(num1 - num2);
                    break;
                case "+":
                    System.out.println(num1 + num2);
                    break;
                case "*":
                    System.out.println(num1 * num2);
                    break;
                case "/":
                    if (num2 == 0) {
                        throw new ArithmeticException();
                    }
                    else {
                        System.out.println(num1 / num2);
                        break;
                    }
                default:
                    throw new UnsupportedOperationException();
            }
        } catch (NumberFormatException ex) {
            System.out.println("Error! Not number");
        } catch (UnsupportedOperationException exception) {
            System.out.println("Operation Error!");
        } catch (ArithmeticException e) {
            System.out.println("Error! Division by zero");
        }
    }
}
