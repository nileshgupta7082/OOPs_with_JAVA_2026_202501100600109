abstract class Shape {

    abstract double area();

    void displayArea() {
        System.out.println("Area = " + area());
    }
}


class Circle extends Shape {

    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }
}


class Rectangle extends Shape {

    double length;
    double width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double area() {
        return length * width;
    }
}


public class ShapeTest {

    public static void main(String[] args) {

        Shape[] shapes = new Shape[2];

        shapes[0] = new Circle(5.0);
        shapes[1] = new Rectangle(4.0, 6.0);

        for (Shape s : shapes) {
            s.displayArea();
        }
    }
}

