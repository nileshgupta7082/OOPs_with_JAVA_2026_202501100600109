import java.util.*;

class Product {
    int id;
    String name;
    double price;

    Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

public class ProductSorting {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Laptop", 60000.00));
        products.add(new Product(2, "Mobile", 60000.00));
        products.add(new Product(3, "Tablet", 30000.00));
        products.add(new Product(4, "Mouse", 2000.00));

        // Sort by price using the PriceComparator
        Collections.sort(products, new PriceComparator());

        System.out.println("Products sorted by price:");
        for (Product product : products) {
            System.out.println(product.id + " " + product.name + " $" + product.price);
        }
    }   
}

class PriceComparator implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2) {
        return Double.compare(p1.price, p2.price); // Sort by price in ascending order
    }
}