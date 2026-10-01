import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PreDefinedException {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            int[] arr = {1, 2, 3, 4, 5};

            int i, b;

            FileReader fr = new FileReader("test.txt");

            i = sc.nextInt();
            b = sc.nextInt();

            System.out.println(arr[i]);

            System.out.println("Division: " + (arr[i] / b));

        } catch (ArithmeticException e) {

            System.out.println("Arithmetic Exception: " + e.getMessage());

        } catch (ArrayIndexOutOfBoundsException e) {

            System.out.println("Array Index Out Of Bounds Exception: " + e.getMessage());

        } catch (FileNotFoundException e) {

            System.out.println("File Not Found Exception: " + e.getMessage());
        }

        sc.close();
    }
}



//user defined exception

// for checked exception we need to extend Exception class, or run time expeption class we neeed to extend RuntimeException class
// DEFINE THAT USER DEFINED EXCEPTION CLASS BY CREATING ITS PARAMETERIZED CONSTRUCTOR AND CALLING THE SUPER CLASS CONSTRUCTOR
// WITH THE MESSAGE PASSED TO IT 