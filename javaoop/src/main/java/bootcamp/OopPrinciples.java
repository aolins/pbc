package bootcamp;

public class OopPrinciples {

  public static void main(String[] args){

    // Creating all printable objects in one array of printables
    final SpeedSupport[] arrayOfSpeedSupported = {
            new Car("Audi", "A3", 2017, "Premium Gasoline", 186, 6.0, 45),
            new Plane("Boeing", "737", "85-215 seats", 10204, "1966-present", 36.0, 11300, 880),
            new Ship("Oasis of the Seas", "Caribbean", 41.9, 5400, 361.6, 225282)};

    // Printing out the speed of objects in arrayOfSpeedSupported
    for (int i = 0; i < 3; i++) {
      // For each object the corresponding printSpeed() method will be used
      arrayOfSpeedSupported[i].printSpeed();
    }

    // Creating a new car
    Car car = new Car("Bentley", "Azure", 2003, "Premium Gasoline", 552, 6.1, 57);
    System.out.println();
    car.printSpeed();

    // Modifying the speed of a car by 2 units
    car.goFaster();
    car.goFaster();

    // Checking the speed - we expect it to be 59 km/h as we increased the cars speed by 2 units
    assert (car.speed == 59) : "The speed of the car is not as expected! Expected 59, but was " + car.speed;
    car.printSpeed();

    // Modifying the speed of a car by 2 units
    car.goFaster();
    car.goFaster();
    car.speed = 57;

    // Checking the speed - we expect it to be 61 km/h as we increased the cars speed by 2 units
    assert (car.speed == 61) : "The speed of the car is not as expected! Expected 61, but was " + car.speed;
  }
}

