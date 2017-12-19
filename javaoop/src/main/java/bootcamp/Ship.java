package bootcamp;

public class Ship implements Printable{

    // Name of the ship
    private String name;
    // Route of the ship
    private String route;
    // Speed of the ship measured in kilometers per hour (km/h)
    private double speed;
    // Capacity of the ship in passanger seats
    private int capacity;
    // Lenght of the ship measured in meters (m)
    private double lenght;
    // Weight of the ship measured in gross tonnage (GT)
    private int weight;

    // Default constructor
    public Ship() {}

    // Full constructor
    public Ship(String name, String route, double speed,
                int capacity, double lenght, int weight) {
        this.setName(name);
        this.setRoute(route);
        this.setSpeed(speed);
        this.setCapacity(capacity);
        this.setLenght(lenght);
        this.setWeight(weight);
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

    // Returns the name of a ship
    public String getName() {
        return name;
    }

    // Sets the name of a ship
    public void setName(String name) {
        this.name = name;
    }

    // Returns the route of a ship
    public String getRoute() {
        return route;
    }

    // Sets the route of a ship
    public void setRoute(String route) {
        this.route = route;
    }

    // Returns the speed of a ship
    public double getSpeed() {
        return speed;
    }

    // Sets the speed of a ship
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    // Returns the capacity of a ship
    public int getCapacity() {
        return capacity;
    }

    // Sets the capacity of a ship
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    // Returns the lenght of a ship
    public double getLenght() {
        return lenght;
    }

    // Sets the lenght of a ship
    public void setLenght(double lenght) {
        this.lenght = lenght;
    }

    // Returns the weight of a ship
    public int getWeight() {
        return weight;
    }

    // Sets the weight of a ship
    public void setWeight(int weight) {
        this.weight = weight;
    }
}