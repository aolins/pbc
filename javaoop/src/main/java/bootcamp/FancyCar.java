package bootcamp;

public class FancyCar extends Car {

    // Default constructor
    public FancyCar() {}

    // Full constructor
    public FancyCar(String brand, String model, int year, String fuelType,
               int horsepower, double accelerationTime) {
        super(brand, model, year, fuelType, horsepower, accelerationTime);
    }

    // Prints out the speed of the car. If clutch is pressed, the speed is 0
    public void printSpeed() {
        String message;
        if (isClutchPressed) {
            message = "* Fancy Car's " + this.brand + " " + this.model + " current speed is 0 km/h *";
        } else {
            message = "* Fancy Car's " + this.brand + " " + this.model + " current speed is " + this.speed + " km/h *";
        }
        printFancyFrame(message.length());
        System.out.println(message);
        printFancyFrame(message.length());
    }

    // Creates a string of '*' to use for a fancy frame around the message
    private void printFancyFrame (int neededStars) {
        // If number of needed '*' is positive
        if (neededStars > 0) {
            System.out.print("*");
            // Recursively calls the function with decremented number of needed '*'
            printFancyFrame(neededStars - 1);
        // If no more '*' are needed
        } else if (neededStars == 0) {
            System.out.println();
        }
    }
}