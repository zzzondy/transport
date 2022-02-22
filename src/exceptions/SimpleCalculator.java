package exceptions;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

class SimpleCalculator {
    public static void main(String[] args) throws Exception {
        FileReader fr = new FileReader("src\\exceptions\\input.txt");
        BufferedWriter fw = new BufferedWriter(new FileWriter("src\\exceptions\\output.txt"));
        Scanner sc = new Scanner(fr);
        String[] array = sc.nextLine().split(" ");
        try {
            double num1 = Double.parseDouble(array[0]), num2 = Double.parseDouble(array[2]);
            switch (array[1]) {
                case "-":
                    fw.write(String.valueOf(num1 - num2));
                    break;
                case "+":
                    fw.write(String.valueOf(num1 + num2));
                    break;
                case "*":
                    fw.write(String.valueOf(num1 * num2));
                    break;
                case "/":
                    if (num2 == 0) {
                        throw new ArithmeticException();
                    }
                    else {
                        fw.write(String.valueOf(num1 / num2));
                        break;
                    }
                default:
                    throw new UnsupportedOperationException();
            }
        } catch (NumberFormatException ex) {
            fw.write("Error! Not number");
        } catch (UnsupportedOperationException exception) {
            fw.write("Operation Error!");
        } catch (ArithmeticException e) {
            fw.write("Error! Division by zero");
        }
        fr.close();
        fw.close();
    }
}
