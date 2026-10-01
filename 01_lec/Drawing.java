// Base interface
interface Drawing {
    void draw();
}

// Child interface inheriting from Drawing
interface Printing extends Drawing {
    void print();
}

// Class implementing the base interface
class Circle implements Drawing {
    public void draw() {
        System.out.println("Drawing circle");
    }
}

// Class implementing the child interface (must define both draw and print)
class Square implements Printing {
    public void draw() {
        System.out.println("Drawing square");
    }

    public void print() {
        System.out.println("Printing square");
    }
}

// Main execution class
class MainClass {
    public static void main(String[] args) {
        Circle c1 = new Circle();
        c1.draw();

        Square s1 = new Square();
        s1.draw();
        s1.print();
    }
}
