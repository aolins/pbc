package bootcamp;

public class OopPrinciples {

  // Demo scenario:
  // - (1)  Car is standing. Trying to goFaster - exception thrown - gear is on 'Neutral'.
  // - (2)  Car is standing. Trying to shift gears to 1-7 - success.
  // - (3)  Car is standing. Trying to goFaster - success.
  // - (4) Car is moving forward. Trying to goSlower - success.
  // - (5) Car is moving forward. Trying to shift to 'Reverse' - exception thrown - car is still moving forward.
  // - (6) Car is moving forward. Trying to goSlower until car stops - success.
  // - (7) Car is standing. Trying to shift to 'Reverse' - success.
  // - (8) Car is standing. Trying to goFaster - success.
  // - (9) Car is moving backwards. Trying to goSlower until car stops - success.

  public static void main(String[] args){

    // Creating a new car for demontration purposes
    Car manualCar = new Car("Mazda", "MX-5 Miata", 2016, "Gas", 155, 7.2);

    firstPartOfTheDemo(manualCar);
    secondPartOfTheDemo(manualCar);
    thirdPartOfTheDemo(manualCar);
    forthPartOfTheDemo(manualCar);
    fifthPartOfTheDemo(manualCar);

    System.out.println("Car is not moving. End of the demo.");
  }

  /**
   * First part of the demo which includes demo steps 1 to 3 - car starts moving forward.
   * @param manualCar - demo car
   */
  public static void firstPartOfTheDemo(Car manualCar) {
    // (1) Try to speed up
    System.out.println("(1)  Car is standing. Trying to goFaster.");
    speedUp(manualCar, 20, "Could not go faster, car is on 'Neutral.'");

    // (2) Try to shift to 1st gear
    System.out.println("(2)  Car is standing. Trying to shift to 1st gear.");
    shiftGear(manualCar, 1, "Should be able to shift to 1rd gear, clutch pedal is pressed, car is moving forward and provided gear is in the acceptable range.");

    // (3) Try to speed up
    System.out.println("(3)  Car is standing. Trying to goFaster.");
    speedUp(manualCar, 20, "Should be able to go faster, clutch pedal is not pressed, car is on 1st gear.");

    // (3.1) See the speed
    manualCar.printSpeed();
  }

  /**
   * Second part of the demo, includes step 4 - car slows down.
   * @param manualCar - demo car
   */
  public static void secondPartOfTheDemo(Car manualCar) {
    // (4) Try to hit the brakes
    System.out.println("(4) Car is moving forward. Trying to goSlower.");
    slowDown(manualCar, 10, "Should be able to go slower, clutch pedal is pressed and car is moving forward.");

    // (4.1) See the speed
    manualCar.printSpeed();
    manualCar.isClutchPressed = false;
    System.out.println("Clutch pedal is released!");
    manualCar.printSpeed();
    manualCar.isClutchPressed = true;
    System.out.println("Clutch pedal is pressed!");
  }

  /**
   * Third part of the demo, includes steps 5 to 7 - cars shifts to 'Reverse'
   * @param manualCar - demo car
   */
  public static void thirdPartOfTheDemo(Car manualCar) {
    // (5) Try to shift to 'Reverse'
    System.out.println("(5) Car is moving forward. Trying to shift to 'Reverse'.");
    shiftGear(manualCar, -1, "Could not shift to 'Reverse', car is still moving forward.");

    // (6) Try to hit the brakes until car stops
    System.out.println("(6) Car is moving forward. Trying to goSlower until car stops.");
    slowDown(manualCar, 0, "Should be able to go slower, clutch pedal is pressed and car is moving forward.");

    // (6.1) See the speed
    manualCar.printSpeed();
    manualCar.isClutchPressed = false;
    System.out.println("Clutch pedal is released!");
    manualCar.printSpeed();
    manualCar.isClutchPressed = true;
    System.out.println("Clutch pedal is pressed!");

    // (7) Try to shift to 'Reverse'
    System.out.println("(7) Car is standing. Trying to shift to 'Reverse'.");
    shiftGear(manualCar, -1, "Should be able to shift to 'Reverse', clutch pedal is pressed, car is not moving and provided gear is in the acceptable range.");
  }

  /**
   * Forth part of the demo, includes step 8 - car starts moving backwards.
   * @param manualCar - demo car
   */
  public static void forthPartOfTheDemo(Car manualCar) {
    // (8) Try to speed up
    System.out.println("(8) Car is standing. Trying to goFaster.");
    speedUp(manualCar, -5, "Should be able to go faster, clutch pedal is not pressed, car is on 'Reverse'.");

    // (8.1) See the speed
    manualCar.printSpeed();
  }

  /**
   * Fifth part of the demo, includes step 9 - car stops movement.
   * @param manualCar - demo car
   */
  public static void fifthPartOfTheDemo (Car manualCar) {
    // (9) Try to hit the brakes
    System.out.println("(9) Car is moving backwards. Trying to goSlower until car stops.");
    slowDown(manualCar, 0, "Should be able to go slower, clutch pedal is pressed and car is moving backwards.");

    // (9.1) See the speed
    manualCar.isClutchPressed = false;
    System.out.println("Clutch pedal is released!");
    manualCar.printSpeed();
  }

  /**
   * Speeds up the car to the target speed and throws the provided message in case of an exception.
   * @param manualCar - demo car
   * @param speedTarget - speed that car must reach
   * @param message - message displayed in case of exception
   */
  public static void speedUp(Car manualCar, int speedTarget, String message) {
    try {
      while (manualCar.speed != speedTarget) {
        manualCar.goFaster();
      }
    } catch (Exception e) {
      System.out.println(message);
    }
  }

  /**
   * Slows down the car to the target speed and throws the provided message in case of an exception.
   * @param manualCar - demo car
   * @param speedTarget - speed that car must reach
   * @param message - message displayed in case of exception
   */
  public static void slowDown(Car manualCar, int speedTarget, String message) {
    try {
      while (manualCar.speed != speedTarget) {
        manualCar.goSlower();
      }
    } catch (Exception e) {
      System.out.println(message);
    }
  }

  /**
   * Shifts gears of the car to the target gear and throws the provided message in case of an exception
   * @param manualCar - demo car
   * @param targetGear - gear that car must shift to
   * @param message - message displayed in case of exception
   */
  public static void shiftGear(Car manualCar, int targetGear, String message){
    try {
      manualCar.shiftGear(targetGear);
      System.out.println("Shifted to gear " + targetGear + "!");
    } catch (Exception e) {
      System.out.println(message);
    }
  }
}
