package bootcamp;

public class FancyCar extends Car {

    // Default constructor
    public FancyCar() {}

    // Full constructor
    public FancyCar(String brand, String model, int year, String fuelType,
               int horsepower, double accelerationTime) {
        super(brand, model, year, fuelType, horsepower, accelerationTime);
    }

    // Prints out the speed of the fancy car. If clutch is pressed, the speed is 0
    public void printSpeed() {
        printFancyFrame(50);
        super.printSpeed();
        printFancyFrame(50);
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