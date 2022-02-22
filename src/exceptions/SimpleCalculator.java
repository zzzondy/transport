package exceptions;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

class SimpleCalculator {
    public static void main(String[] args) throws Exception {
        FileReader fr = new FileReader("src\\exceptions\\input.txt");
        BufferedWriter fw = new BufferedWriter(new FileWriter("src\\exceptions\\output.txt", false));
        Scanner sc = new Scanner(fr);
        while (sc.hasNextLine()) {
            String string = sc.nextLine();
            String[] array = string.split(" ");
            try {
                double num1 = Double.parseDouble(array[0]), num2 = Double.parseDouble(array[2]);
                switch (array[1]) {
                    case "-":
                        fw.write(string + " = " + (num1 - num2) + "\n");
                        break;
                    case "+":
                        fw.write(string + " = " + (num1 + num2) + "\n");
                        break;
                    case "*":
                        fw.write(string + " = " + (num1 * num2) + "\n");
                        break;
                    case "/":
                        if (num2 == 0) {
                            throw new ArithmeticException();
                        } else {
                            fw.write(string + " = " + (num1 / num2) + "\n");
                            break;
                        }
                    default:
                        throw new UnsupportedOperationException();
                }
            } catch (NumberFormatException ex) {
                fw.write(string + " = " + "Error! Not number\n");
            } catch (UnsupportedOperationException exception) {
                fw.write(string + " = " + "Operation Error!\n");
            } catch (ArithmeticException e) {
                fw.write(string + " = " + "Error! Division by zero\n");
            }
        }
        fr.close();
        fw.close();
    }
}
