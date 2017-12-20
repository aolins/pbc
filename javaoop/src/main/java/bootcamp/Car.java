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

    // Increments the speed of the car by 1 unit.
    public void goFaster() throws Exception {
        try {
            // To manually increese the speed of a car, the clutch pedal must not be pressed
            this.isClutchPressed = false;
            // If gear is not 'Reverse' or 'Neutral'
            if (this.gearNumber > 0) {
                // Increasing the speed in positive direction (forward)
                this.speed = this.speed + 1;
                System.out.println("Increased the speed of a car " + this.brand + " " + this.model);
                // If gear is 'Reverse'
            } else if (this.gearNumber == -1) {
                // Increasing the speed in negative direction (backwards)
                this.speed = this.speed - 1;
                System.out.println("Increased the speed of a car " + this.brand + " " + this.model);
                // If gear is 'Neutral'
            } else if (this.gearNumber == 0){
                throw new Exception();
            }
        } finally {
            this.isClutchPressed = false;
        }

    }

    // Decrements the speed of the car by 1 unit
    public void goSlower() {
        // To manually decreese the speed of a car, the clutch pedal must be pressed
        this.isClutchPressed = true;
        // If the speed of the car is 0 km/h
        if (this.speed == 0) {
            System.out.println("Decreasing the speed of a car " + this.brand + " " + this.model + " is not possible - car is standing still.");
        // If the car is moving forward
        } else if (this.speed > 0) {
            // Decreasing the speed of the car from positive direction (forward)
            this.speed = this.speed - 1;
            System.out.println("Decreased the speed of a car " + this.brand + " " + this.model);
        // If the car is moving backwards
        } else if (this.speed < 0) {
            // Decreasing the speed of the car from negative direction (backwards)
            this.speed = this.speed + 1;
            System.out.println("Decreased the speed of a car " + this.brand + " " + this.model);
        }
        this.isClutchPressed = false;
    }

    // Shifts the gear of a car.
    // Gear limitations:
    //    -1 - Reverse
    //     0 - Neutral
    //     1 - First gear
    //     ...
    //     7 - Seventh gear
    public void shiftGear(int gearNumber) throws Exception {
        try {
            // To shift gears of a car, the clutch pedal must be pressed
            this.isClutchPressed = true;
            // If provided gear is 'Neautral'
            if (gearNumber == 0) {
                this.gearNumber = gearNumber;
                // If provided gear is 'Reverse'
            } else if (gearNumber == -1) {
                // If the car is moving forward - we cannot shift to 'Reverse'
                if (this.speed > 0) {
                    throw new Exception();
                } else {
                    this.gearNumber = gearNumber;
                }
                // If provided gear is 1-7
            } else if (gearNumber > 0 && gearNumber <= 7) {
                // If the car is moving backwards - we cannot shift to gear 1-7
                if (this.speed < 0) {
                    throw new Exception();
                } else {
                    this.gearNumber = gearNumber;
                }
                // If provided gear is not in [-1:7]
            } else {
                System.out.println("Provided gear " + gearNumber+ " is not acceptable.");
            }
        } finally {
            this.isClutchPressed = false;
        }
    }

    // Prints out the speed of the car. If clutch is pressed, the speed is 0
    public void printSpeed() {
        System.out.print("Car's " + this.brand + " " + this.model + " current speed is ");
        if (isClutchPressed) {
            System.out.println("0 km/h");
        } else {
            System.out.println(this.speed + " km/h");
        }
    }
}