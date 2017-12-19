package bootcamp;

public class Car implements Printable, SpeedSupport {

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
    // Acceleration time needed for a car to go from 1-100 km/h, measured in seconds
    public double accelerationTime;
    // Speed of the car measured in km/h
    public int speed;

    // Default constructor
    public Car() {}

    // Full constructor
    public Car(String brand, String model, int year, String fuelType,
               int horsepower, double accelerationTime, int speed) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.fuelType = fuelType;
        this.horsepower = horsepower;
        this.accelerationTime = accelerationTime;
        this.speed = speed;
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

    // Increments the speed of the car by 1 unit
    public void goFaster(){
        this.speed = this.speed + 1;
        System.out.println("Increased the speed of a car " + this.brand + " " + this.model);
    }

    // Decrements the speed of the car by 1 unit
    public void goSlower(){
        this.speed = this.speed - 1;
        System.out.println("Decreased the speed of a car " + this.brand + " " + this.model);
    }

    // Prints out the speed of the car
    public void printSpeed(){
        System.out.println("Car's " + this.brand + " " + this.model + " current speed is " + this.speed + " km/h");
    }
}