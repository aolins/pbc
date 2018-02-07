package bootcamp;

public class OopPrinciples {

  public static void main(String[] args){

    // Creating an array of SpeedSupported
    SpeedSupport[] arrayOfSpeedSupported = {
      new Car("BMW", "X6", 2016, "Premium Gasoline", 567, 5.2 ),
      new FancyCar("Mazda", "MX-5 Miata", 2016, "Gas", 155, 7.2)
    };

    // Increase the speed of both cars
    ((Car) arrayOfSpeedSupported[0]).speed = 20;
    ((Car) arrayOfSpeedSupported[1]).speed = 25;

    // Print out the speed of speedSupported objects in array
    for (SpeedSupport car : arrayOfSpeedSupported) {
      car.printSpeed();
    }
  }
}
