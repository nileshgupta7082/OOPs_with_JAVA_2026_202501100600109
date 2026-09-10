// (a) Rentable Interface
interface Rentable {
    double calculateRent(int days);
}

// Parent class to hold shared static tracking and constants
abstract class Vehicle implements Rentable {
    public static final double TAX_RATE = 0.05;
    public static int totalVehiclesRented = 0;
}

// (b) & (c) Car Class
class Car extends Vehicle {
    private static final double RATE_PER_DAY = 1500.0;

    @Override
    public double calculateRent(int days) {
        totalVehiclesRented++;
        return RATE_PER_DAY * days;
    }
}

// (b) & (c) Bike Class
class Bike extends Vehicle {
    private static final double RATE_PER_DAY = 500.0;

    @Override
    public double calculateRent(int days) {
        totalVehiclesRented++;
        return RATE_PER_DAY * days;
    }
}

// Driver Class (As provided)
public class RentalTest {
    public static void main(String[] args) {
        Rentable car = new Car();
        Rentable bike = new Bike();

        double carRent = car.calculateRent(3);
        double bikeRent = bike.calculateRent(2);

        System.out.println("Car rent incl. tax: " + (carRent + carRent * Vehicle.TAX_RATE));
        System.out.println("Bike rent incl. tax: " + (bikeRent + bikeRent * Vehicle.TAX_RATE));
        System.out.println("Total vehicles rented: " + Vehicle.totalVehiclesRented);
    }
}
