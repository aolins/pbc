package bootcamp;

public class OopPrinciples {

  // Demo scenario:
  // - (1)  Car is standing. Trying to goFaster - exception thrown - gear is on 'Neutral'.
  // - (2)  Car is standing. Trying to shift gears to 1-7 - exception thrown - clutch pedal is not pressed.
  // - (3)  Car is standing. Pressing the clutch pedal.
  // - (4)  Car is standing. Trying to shift gears to 1-7 - success.
  // - (5)  Car is standing. Trying to goFaster - exception thrown - clutch pedal is pressed.
  // - (6)  Car is standing. Releasing the clutch pedal.
  // - (7)  Car is standing. Trying to goFaster - success.
  // - (8)  Car is moving forward. Trying to goSlower - exception thrown - clutch pedal is not pressed.
  // - (9)  Car is moving forward. Pressing the clutch pedal.
  // - (10) Car is moving forward. Trying to goSlower - success.
  // - (11) Car is moving forward. Trying to shift to 'Reverse' - exception thrown - car is still moving forward.
  // - (12) Car is moving forward. Trying to goSlower until car stops - success.
  // - (13) Car is standing. Trying to shift to 'Reverse' - success.
  // - (14) Car is standing. Trying to goFaster - exception thrown - clutch pedal is pressed.
  // - (15) Car is standing. Releasing the clutch pedal.
  // - (16) Car is standing. Trying to goFaster - success.
  // - (17) Car is moving backwards. Trying to goSlower - exception thrown - clutch pedal is not pressed.
  // - (18) Car is moving backwards. Pressing the clutch pedal.
  // - (19) Car is moving backwards. Trying to goSlower until car stops - success.

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
   * First part of the demo which includes demo steps 1 to 7 - car starts moving forward.
   * @param manualCar - demo car
   */
  public static void firstPartOfTheDemo(Car manualCar) {
    // (1) Try to speed up
    System.out.println("(1)  Car is standing. Trying to goFaster.");
    speedUp(manualCar, 20, "Could not go faster, car is on 'Neutral.'");

    // (2) Try to shift to 1st gear
    System.out.println("(2)  Car is standing. Trying to shift to 1st gear.");
    shiftGear(manualCar, 1, "Could not shift to 1st gear, clutch pedal is not pressed!");

    // (3) Press the clutch pedal
    System.out.println("(3)  Car is standing. Pressing the clutch pedal.");
    manualCar.isClutchPressed = true;
    System.out.println("Clutch pedal is pressed!");

    // (4) Try to shift to 1st gear
    System.out.println("(4)  Car is standing. Trying to shift to 1st gear.");
    shiftGear(manualCar, 1, "Should be able to shift to 1rd gear, clutch pedal is pressed, car is moving forward and provided gear is in the acceptable range.");

    // (5) Try to speed up
    System.out.println("(5)  Car is standing. Trying to goFaster.");
    speedUp(manualCar, 20, "Could not go faster, clutch pedal is pressed!");

    // (6) Release the clutch pedal
    System.out.println("(6)  Car is standing. Releasing the clutch pedal.");
    manualCar.isClutchPressed = false;
    System.out.println("Clutch pedal is released!");

    // (7) Try to speed up
    System.out.println("(7)  Car is standing. Trying to goFaster.");
    speedUp(manualCar, 20, "Should be able to go faster, clutch pedal is not pressed, car is on 1st gear.");

    // (7.1) See the speed
    manualCar.printSpeed();
  }

  /**
   * Second part of the demo, includes steps 8 to 10 - car slows down.
   * @param manualCar - demo car
   */
  public static void secondPartOfTheDemo(Car manualCar) {
    // (8) Try to hit the brakes
    System.out.println("(8)  Car is moving forward. Trying to goSlower.");
    slowDown(manualCar, 10, "Could not go slower, clutch pedal is not pressed!");

    // (9) Press the clutch pedal
    System.out.println("(9)  Car is moving forward. Pressing the clutch pedal.");
    manualCar.isClutchPressed = true;
    System.out.println("Clutch pedal is pressed!");

    // (10) Try to hit the brakes
    System.out.println("(10) Car is moving forward. Trying to goSlower.");
    slowDown(manualCar, 10, "Should be able to go slower, clutch pedal is pressed and car is moving forward.");

    // (10.1) See the speed
    manualCar.printSpeed();
    manualCar.isClutchPressed = false;
    System.out.println("Clutch pedal is released!");
    manualCar.printSpeed();
    manualCar.isClutchPressed = true;
    System.out.println("Clutch pedal is pressed!");
  }

  /**
   * Third part of the demo, includes steps 11 to 13 - cars shifts to 'Reverse'
   * @param manualCar - demo car
   */
  public static void thirdPartOfTheDemo(Car manualCar) {
    // (11) Try to shift to 'Reverse'
    System.out.println("(11) Car is moving forward. Trying to shift to 'Reverse'.");
    shiftGear(manualCar, -1, "Could not shift to 'Reverse', car is still moving forward.");

    // (12) Try to hit the brakes until car stops
    System.out.println("(12) Car is moving forward. Trying to goSlower until car stops.");
    slowDown(manualCar, 0, "Should be able to go slower, clutch pedal is pressed and car is moving forward.");

    // (12.1) See the speed
    manualCar.printSpeed();
    manualCar.isClutchPressed = false;
    System.out.println("Clutch pedal is released!");
    manualCar.printSpeed();
    manualCar.isClutchPressed = true;
    System.out.println("Clutch pedal is pressed!");

    // (13) Try to shift to 'Reverse'
    System.out.println("(13) Car is standing. Trying to shift to 'Reverse'.");
    shiftGear(manualCar, -1, "Should be able to shift to 'Reverse', clutch pedal is pressed, car is not moving and provided gear is in the acceptable range.");
  }

  /**
   * Forth part of the demo, includes steps 14 to 16 - car starts moving backwards.
   * @param manualCar - demo car
   */
  public static void forthPartOfTheDemo(Car manualCar) {
    // (14) Try to speed up
    System.out.println("(14) Car is standing. Trying to goFaster.");
    speedUp(manualCar, -5, "Could not go faster, clutch pedal is pressed!");

    // (15) Release the clutch pedal
    System.out.println("(15) Car is standing. Releasing the clutch pedal.");
    manualCar.isClutchPressed = false;
    System.out.println("Clutch pedal is released!");

    // (16) Try to speed up
    System.out.println("(16) Car is standing. Trying to goFaster.");
    speedUp(manualCar, -5, "Should be able to go faster, clutch pedal is not pressed, car is on 'Reverse'.");

    // (16.1) See the speed
    manualCar.printSpeed();
  }

  /**
   * Fifth part of the demo, includes steps 17 to 19 - car stops movement.
   * @param manualCar - demo car
   */
  public static void fifthPartOfTheDemo (Car manualCar) {

    // (17) Try to hit the brakes
    System.out.println("(17) Car is moving backwards. Trying to goSlower.");
    slowDown(manualCar, 0, "Could not go slower, clutch pedal is not pressed!");

    // (18) Press the clutch pedal
    System.out.println("(18) Car is moving backwards. Pressing the clutch pedal.");
    manualCar.isClutchPressed = true;
    System.out.println("Clutch pedal is pressed!");

    // (19) Try to hit the brakes
    System.out.println("(19) Car is moving backwards. Trying to goSlower until car stops.");
    slowDown(manualCar, 0, "Should be able to go slower, clutch pedal is pressed and car is moving backwards.");

    // (19.1) See the speed
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
