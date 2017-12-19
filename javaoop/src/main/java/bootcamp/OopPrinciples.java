package bootcamp;

public class OopPrinciples {

  public static void main(String[] args){

    // Creating a new car for gear shifting demontration purposes
    Car manualCar = new Car("Mazda", "MX-5 Miata", 2016, "Gas", 155, 7.2);

    // Try to speed up
    try {
      while (manualCar.speed < 30) {
        manualCar.goFaster();
      }
    } catch (Exception e) {
      System.out.println("Should be able to go faster, clutch pedal is not pressed.");
    }

    // Try to shift gears
    try {
      manualCar.shiftGear(3);
    } catch (Exception e) {
      System.out.println("Could not shift gears, clutch pedal is not pressed!");
    }

    // Press the clutch pedal
    manualCar.isClutchPressed = true;
    System.out.println("Clutch pedal is pressed!");

    // Try to shift gears
    try {
      manualCar.shiftGear(3);
      System.out.println("Gears shifted!");
    } catch (Exception e) {
      System.out.println("Should be able to shift gears, clutch pedal is now pressed.");
    }

    // Release the clutch pedal
    manualCar.isClutchPressed = false;
    System.out.println("Clutch pedal is released!");

    // Try to hit the brakes
    try {
      while (manualCar.speed > 20) {
        manualCar.goSlower();
      }
    } catch (Exception e) {
      System.out.println("Could not go slower, clutch pedal is not pressed!");
    }

    // Press the clutch pedal
    manualCar.isClutchPressed = true;
    System.out.println("Clutch pedal is pressed!");

    // Try to hit the brakes
    try {
      while (manualCar.speed > 20) {
        manualCar.goSlower();
      }
    } catch (Exception e) {
      System.out.println("Should be able to go slower, clutch pedal is now pressed.");
    }

    // Try to speed up
    try {
      while (manualCar.speed < 30) {
        manualCar.goFaster();
      }
    } catch (Exception e) {
      System.out.println("Could not go faster, clutch pedal is now pressed!");
    }

  }
}

