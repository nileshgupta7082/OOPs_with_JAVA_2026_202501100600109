public class overridding {
    public static void main(String[] args) {
        Shape obj = new Circle(20);
        obj.area();
        Shape obj2 = new Rectangle(10, 20);
        obj2.area();
    }
}

class Shape {
    void area() {
        System.out.println("Area of shape");
    }
}

class Circle extends Shape {
    private double r;
    Circle(double r) {
        this.r = r;
    }

    void area() {
        System.out.println("Area of circle is " + (22 / 7.0 * r * r));
    }
}

class Rectangle extends Shape {
    private int l, b;
    Rectangle(int l, int b) {
        this.l = l;
        this.b = b;
    }
    void area() {
        System.out.println("Area of rectangle is " + (l * b));
    }
}

