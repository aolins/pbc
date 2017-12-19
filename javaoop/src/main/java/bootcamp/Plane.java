package bootcamp;

public class Plane implements Printable{

    // Name of the manufacturer of the plane
    private String manufacturer;
    // Model of the plane
    private String model;
    // Capacity of the plane - passanger seats
    private String capacity;
    // Range of the plane measured in kilometres (km)
    private int range;
    // Production time (year when production started - year when production stopped)
    private String production;
    // Wing span of the plane measured in metres (m)
    private double wingSpan;
    // Ceiling of the plane measured in metres (m)
    private int ceiling;

    // Default constructor
    public Plane() {}

    // Full constructor
    public Plane(String manufacturer, String model, String capacity,
               int range, String production, double wingSpan, int ceiling) {
        this.setManufacturer(manufacturer);
        this.setModel(model);
        this.setCapacity(capacity);
        this.setRange(range);
        this.setProduction(production);
        this.setWingSpan(wingSpan);
        this.setCeiling(ceiling);
    }

    // Prints an essential information of a plane
    public void print() {
        System.out.println("Plane");
        System.out.println("MANUFACTURER: " + this.manufacturer);
        System.out.println("MODEL: " + this.model);
        System.out.println("CAPACITY: " + this.capacity);
        System.out.println("RANGE: " + this.range + " km");
        System.out.println("CEILING: " + this.ceiling + " m");
        System.out.println();
    }

    // Returns the name of manufacturer of a plane
    public String getManufacturer() {
        return manufacturer;
    }

    // Sets the name of manufacturer of a plane
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    // Returns the model of a plane
    public String getModel() {
        return model;
    }

    // Sets the model of a plane
    public void setModel(String model) {
        this.model = model;
    }

    // Returns the capacity of a plane
    public String getCapacity() {
        return capacity;
    }

    // Sets the capacity of a plane
    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    // Returns the range of a plane
    public int getRange() {
        return range;
    }

    // Sets the range of a plane
    public void setRange(int range) {
        this.range = range;
    }

    // Returns the production years of a plane
    public String getProduction() {
        return production;
    }

    // Sets the production years of a plane
    public void setProduction(String production) {
        this.production = production;
    }

    // Returns the wing span of a plane
    public double getWingSpan() {
        return wingSpan;
    }

    // Sets the wing span of a plane
    public void setWingSpan(double wingSpan) {
        this.wingSpan = wingSpan;
    }

    // Returns the ceiling of a plane
    public int getCeiling() {
        return ceiling;
    }

    // Sets the ceiling of a plane
    public void setCeiling(int ceiling) {
        this.ceiling = ceiling;
    }
}