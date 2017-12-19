package bootcamp;

public class Car implements Printable{

    // Brand of a car
    public String brand;
    // Model of a car
    public String model;
    // Year of a model
    public int year;
    // Fuel type suitable for a car
    public String fuelType;
    // Horsepower of a car measured in hp
    public int horsepower;
    // Acceleration time needed for a car to go from 1-100 kph, measured in seconds
    public double accelerationTime;

    // Default constructor
    public Car() {}

    // Full constructor
    public Car(String brand, String model, int year,
               String fuelType, int horsepower, double accelerationTime) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.fuelType = fuelType;
        this.horsepower = horsepower;
        this.accelerationTime = accelerationTime;
    }

    // Prints an essential information of a car
    public void print() {
        System.out.println("Car");
        System.out.println("BRAND: " + this.brand);
        System.out.println("MODEL: " + this.model);
        System.out.println("YEAR: " + this.year);
        System.out.println("HORSEPOWER: " + this.horsepower + " hp");
        System.out.println();
    }
}