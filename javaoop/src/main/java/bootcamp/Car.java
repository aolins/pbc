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
    // State of clutch
    public boolean isClutchPressed;
    // Gear number
    public int gearNumber;


    // Default constructor
    public Car() {}

    // Full constructor
    public Car(String brand, String model, int year, String fuelType,
               int horsepower, double accelerationTime) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.fuelType = fuelType;
        this.horsepower = horsepower;
        this.accelerationTime = accelerationTime;
        this.speed = 0;
        this.isClutchPressed = false;
        this.gearNumber = 0;
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
    public void goFaster() throws Exception {
        // If clutch pedal is not pressed, then the speed can be manually increased
        if (!isClutchPressed) {
            this.speed = this.speed + 1;
            System.out.println("Increased the speed of a car " + this.brand + " " + this.model);
        } else {
            throw new Exception();
        }
    }

    // Decrements the speed of the car by 1 unit
    public void goSlower() throws Exception {
        // If clutch pedal is pressed, then speed can be manually decreesed
        if (isClutchPressed) {
            this.speed = this.speed - 1;
            System.out.println("Decreased the speed of a car " + this.brand + " " + this.model);
        } else {
            throw new Exception();
        }
    }

    // Shifts the gear of a car
    public void shiftGear(int gearNumber) throws Exception {
        if (isClutchPressed) {
            this.gearNumber = gearNumber;
        } else {
            throw new Exception();
        }
    }

    // Prints out the speed of the car
    public void printSpeed() {
        System.out.println("Car's " + this.brand + " " + this.model + " current speed is " + this.speed + " km/h");
    }
}