package bootcamp;

public class Plane implements Printable{

    // Name of the manufacturer of the plane
    public String manufacturer;
    // Model of the plane
    public String model;
    // Capacity of the plane - passanger seats
    public String capacity;
    // Range of the plane measured in kilometres (km)
    public int range;
    // Production time (year when production started - year when production stopped)
    public String production;
    // Wing span of the plane measured in metres (m)
    public double wingSpan;
    // Ceiling of the plane measured in metres (m)
    public int ceiling;

    // Default constructor
    public Plane() {}

    // Full constructor
    public Plane(String manufacturer, String model, String capacity,
               int range, String production, double wingSpan, int ceiling) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.capacity = capacity;
        this.range = range;
        this.production = production;
        this.wingSpan = wingSpan;
        this.ceiling = ceiling;
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
}