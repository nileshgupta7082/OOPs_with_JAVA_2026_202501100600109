public class poly {
    static class addition {
        void sum() {
            System.out.println("Addition");
        }
        void sum(int a, int b) {
            System.out.println("Addition " + (a + b));
        }

        void sum(double a, double b) {
            System.out.println("Addition: " + (a + b));
        }
    }
    public static void main(String[] args) {

        addition obj1 = new addition();
        obj1.sum();
        obj1.sum(10, 4);
        obj1.sum(10.1, 12.30);
    }
}