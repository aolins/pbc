package bootcamp;

public class Ship implements Printable, SpeedSupport {

    // Name of the ship
    public String name;
    // Route of the ship
    public String route;
    // Speed of the ship measured in kilometers per hour (km/h)
    public double speed;
    // Capacity of the ship in passanger seats
    public int capacity;
    // Lenght of the ship measured in meters (m)
    public double lenght;
    // Weight of the ship measured in gross tonnage (GT)
    public int weight;

    // Default constructor
    public Ship() {}

    // Full constructor
    public Ship(String name, String route, double speed,
                int capacity, double lenght, int weight) {
        this.name = name;
        this.route = route;
        this.speed = speed;
        this.capacity = capacity;
        this.lenght = lenght;
        this.weight = weight;
    }

    // Prints an essential information of a ship
    public void print() {
        System.out.println("Ship");
        System.out.println("NAME: " + this.name);
        System.out.println("CAPACITY: " + this.capacity + "passangers");
        System.out.println("LENGTH: " + this.lenght + " m");
        System.out.println("ROUTE: " + this.route);
        System.out.println();
    }

    // Increments the speed of the ship by 1 unit
    public void goFaster(){
        this.speed = this.speed + 1.0;
        System.out.println("Increased the speed of a ship " + this.name);
    }

    // Decrements the speed of the ship by 1 unit
    public void goSlower(){
        this.speed = this.speed - 1.0;
        System.out.println("Decreased the speed of a ship " + this.name);
    }

    // Prints out the speed of the ship
    public void printSpeed(){
        System.out.println("Ship's " + this.name + " current speed is " + this.speed + " km/h");
    }
}