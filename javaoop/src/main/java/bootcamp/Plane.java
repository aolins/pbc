package bootcamp;

public class Plane implements Printable, SpeedSupport {

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
    // Speed of the plane measured in km/h
    public int speed;

    // Default constructor
    public Plane() {}

    // Full constructor
    public Plane(String manufacturer, String model, String capacity, int range,
                 String production, double wingSpan, int ceiling, int speed) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.capacity = capacity;
        this.range = range;
        this.production = production;
        this.wingSpan = wingSpan;
        this.ceiling = ceiling;
        this.speed = speed;
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

    // Increments the speed of the plane by 1 unit
    public void goFaster(){
        this.speed = this.speed + 1;
        System.out.println("Increased the speed of a plane " + this.manufacturer + " " + this.model);
    }

    // Decrements the speed of the plane by 1 unit
    public void goSlower(){
        this.speed = this.speed - 1;
        System.out.println("Decreased the speed of a plane " + this.manufacturer + " " + this.model);
    }

    // Prints out the speed of the plane
    public void printSpeed(){
        System.out.println("Plane's " + this.manufacturer + " " + this.model + " current speed is " + this.speed + " km/h");
    }
}