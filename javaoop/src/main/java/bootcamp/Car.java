package bootcamp;

public class Car implements Printable{

    // Brand of a car
    private String brand;
    // Model of a car
    private String model;
    // Year of a model
    private int year;
    // Fuel type suitable for a car
    private String fuelType;
    // Horsepower of a car measured in hp
    private int horsepower;
    // Acceleration time needed for a car to go from 1-100 kph, measured in seconds
    private double accelerationTime;

    // Default constructor
    public Car() {}

    // Full constructor
    public Car(String brand, String model, int year,
               String fuelType, int horsepower, double accelerationTime) {
        this.setBrand(brand);
        this.setModel(model);
        this.setYear(year);
        this.setFuelType(fuelType);
        this.setHorsepower(horsepower);
        this.setAccelerationTime(accelerationTime);
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

    // Returns the brand of a car
    public String getBrand() {
        return brand;
    }

    // Sets the brand of a car
    public void setBrand(String brand) {
        this.brand = brand;
    }

    // Returns the model of a car
    public String getModel() {
        return model;
    }

    // Sets the model of a car
    public void setModel(String model) {
        this.model = model;
    }

    // Returns the year of a model
    public int getYear() {
        return year;
    }

    // Sets the year of a model
    public void setYear(int year) {
        this.year = year;
    }

    // Returns the fuel type suitable for a car
    public String getFuelType() {
        return fuelType;
    }

    // Sets the fuel type suitable for a car
    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    // Returns the horsepower of a car
    public int getHorsepower() {
        return horsepower;
    }

    // Sets the horsepower of a car
    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    // Returns the acceleration of a car
    public double getAccelerationTime() {
        return accelerationTime;
    }

    // Sets the acceleration of a car
    public void setAccelerationTime(double accelerationTime) {
        this.accelerationTime = accelerationTime;
    }
}