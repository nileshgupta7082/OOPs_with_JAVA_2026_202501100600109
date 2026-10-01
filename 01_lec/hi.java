import java.util.Scanner;

// Abstract base class
abstract class Abc {
    abstract void sum();
}

// Child class A for integer addition via user input
class A extends Abc {
    @Override
    void sum() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter two numbers:");
        
        int a = sc.nextInt(); // Corrected from sc.parseInt()
        int b = sc.nextInt(); // Corrected from sc.parseInt()
        int sum = a + b;
        
        System.out.println("Sum = " + sum);
        sc.close();
    }
}

// Child class B for float addition with hardcoded values
class B extends Abc {
    @Override
    void sum() {
        float a = 14.87f;
        float b = 25.67f;
        float c = a + b;
        
        System.out.println("Sum = " + c);
    }
}

// Main execution class
class MainClass {
    public static void main(String[] args) {
        A ob1 = new A();
        ob1.sum(); // Triggers user input and prints integer sum
        
        B ob2 = new B();
        ob2.sum(); // Prints predefined float sum
    }
}
