package bootcamp;

public class OopPrinciples {

  public static void main(String[] args){

    // Demo scenario:
    // - (1)  Car is standing. Trying to goSlower - no result - car is not moving.
    // - (2)  Car is standing. Trying to goFaster - exception thrown - gear is on 'Neutral'.
    // - (3)  Car is standing. Trying to shift gears to 1-7 - exception thrown - clutch pedal is not pressed.
    // - (4)  Car is standing. Pressing the clutch pedal.
    // - (5)  Car is standing. Trying to shift gears to 1-7 - success.
    // - (6)  Car is standing. Trying to goFaster - exception thrown - clutch pedal is pressed.
    // - (7)  Car is standing. Releasing the clutch pedal.
    // - (8)  Car is standing. Trying to goFaster - success.
    // - (9)  Car is moving forward. Trying to goSlower - exception thrown - clutch pedal is not pressed.
    // - (10) Car is moving forward. Pressing the clutch pedal.
    // - (11) Car is moving forward. Trying to goSlower - success.
    // - (12) Car is moving forward. Trying to shift to 'Reverse' - exception thrown - car is still moving forward.
    // - (13) Car is moving forward. Trying to goSlower until car stops - success.
    // - (14) Car is standing. Trying to shift to 'Reverse' - success.
    // - (15) Car is standing. Trying to goFaster - exception thrown - clutch pedal is pressed.
    // - (16) Car is standing. Releasing the clutch pedal.
    // - (17) Car is standing. Trying to goFaster - success.
    // - (18) Car is moving backwards. Trying to goSlower - exception thrown - clutch pedal is not pressed.
    // - (19) Car is moving backwards. Pressing the clutch pedal.
    // - (20) Car is moving backwards. Trying to goSlower until car stops - success.

    // Creating a new car for demontration purposes
    Car manualCar = new Car("Mazda", "MX-5 Miata", 2016, "Gas", 155, 7.2);

    // (1) Try to hit brakes
    System.out.println("(1)  Car is standing. Trying to goSlower.");
    try {
      manualCar.goSlower();
    } catch (Exception e) {
      System.out.println("Could not go slower, clutch pedal is not pressed and car is not moving.");
    }

    // (2) Try to speed up
    System.out.println("(2)  Car is standing. Trying to goFaster.");
    try {
      while (manualCar.speed < 20) {
        manualCar.goFaster();
      }
    } catch (Exception e) {
      System.out.println("Could not go faster, car is on 'Neutral.'");
    }

    // (3) Try to shift to 1st gear
    System.out.println("(3)  Car is standing. Trying to shift to 1st gear.");
    try {
      manualCar.shiftGear(1);
    } catch (Exception e) {
      System.out.println("Could not shift to 1st gear, clutch pedal is not pressed!");
    }

    // (4) Press the clutch pedal
    System.out.println("(3)  Car is standing. Pressing the clutch pedal.");
    manualCar.isClutchPressed = true;
    System.out.println("Clutch pedal is pressed!");

    // (5) Try to shift to 1st gear
    System.out.println("(5)  Car is standing. Trying to shift to 1st gear.");
    try {
      manualCar.shiftGear(1);
      System.out.println("Shifted to 1st gear!");
    } catch (Exception e) {
      System.out.println("Should be able to shift to 1rd gear, clutch pedal is pressed, car is moving forward and provided gear is in the acceptable range.");
    }

    // (6) Try to speed up
    System.out.println("(6)  Car is standing. Trying to goFaster.");
    try {
      while (manualCar.speed < 20) {
        manualCar.goFaster();
      }
    } catch (Exception e) {
      System.out.println("Could not go faster, clutch pedal is pressed!");
    }

    // (7) Release the clutch pedal
    System.out.println("(7)  Car is standing. Releasing the clutch pedal.");
    manualCar.isClutchPressed = false;
    System.out.println("Clutch pedal is released!");

    // (8) Try to speed up
    System.out.println("(8)  Car is standing. Trying to goFaster.");
    try {
      while (manualCar.speed < 20) {
        manualCar.goFaster();
      }
    } catch (Exception e) {
      System.out.println("Should be able to go faster, clutch pedal is not pressed, car is on 1st gear.");
    }

    // (8.1) See the speed
    manualCar.printSpeed();

    // (9) Try to hit the brakes
    System.out.println("(9)  Car is moving forward. Trying to goSlower.");
    try {
      while (manualCar.speed > 10) {
        manualCar.goSlower();
      }
    } catch (Exception e) {
      System.out.println("Could not go slower, clutch pedal is not pressed!");
    }

    // (10) Press the clutch pedal
    System.out.println("(10) Car is moving forward. Pressing the clutch pedal.");
    manualCar.isClutchPressed = true;
    System.out.println("Clutch pedal is pressed!");

    // (11) Try to hit the brakes
    System.out.println("(11) Car is moving forward. Trying to goSlower.");
    try {
      while (manualCar.speed > 10) {
        manualCar.goSlower();
      }
    } catch (Exception e) {
      System.out.println("Should be able to go slower, clutch pedal is pressed and car is moving forward.");
    }

    // (11.1) See the speed
    manualCar.printSpeed();
    manualCar.isClutchPressed = false;
    System.out.println("Clutch pedal is released!");
    manualCar.printSpeed();
    manualCar.isClutchPressed = true;
    System.out.println("Clutch pedal is pressed!");

    // (12) Try to shift to 'Reverse'
    System.out.println("(12) Car is moving forward. Trying to shift to 'Reverse'.");
    try {
      manualCar.shiftGear(-1);
    } catch (Exception e) {
      System.out.println("Could not shift to 'Reverse', car is still moving forward.");
    }

    // (13) Try to hit the brakes until car stops
    System.out.println("(13) Car is moving forward. Trying to goSlower until car stops.");
    try {
      while (manualCar.speed != 0) {
        manualCar.goSlower();
      }
    } catch (Exception e) {
      System.out.println("Should be able to go slower, clutch pedal is pressed and car is moving forward.");
    }

    // (13.1) See the speed
    manualCar.printSpeed();
    manualCar.isClutchPressed = false;
    System.out.println("Clutch pedal is released!");
    manualCar.printSpeed();
    manualCar.isClutchPressed = true;
    System.out.println("Clutch pedal is pressed!");

    // (14) Try to shift to 'Reverse'
    System.out.println("(14) Car is standing. Trying to shift to 'Reverse'.");
    try {
      manualCar.shiftGear(-1);
      System.out.println("Shifted to 'Reverse'!");
    } catch (Exception e) {
      System.out.println("Should be able to shift to 'Reverse', clutch pedal is pressed, car is not moving and provided gear is in the acceptable range.");
    }

    // (15) Try to speed up
    System.out.println("(15) Car is standing. Trying to goFaster.");
    try {
      while (manualCar.speed > -5) {
        manualCar.goFaster();
      }
    } catch (Exception e) {
      System.out.println("Could not go faster, clutch pedal is pressed!");
    }

    // (16) Release the clutch pedal
    System.out.println("(16) Car is standing. Releasing the clutch pedal.");
    manualCar.isClutchPressed = false;
    System.out.println("Clutch pedal is released!");

    // (17) Try to speed up
    System.out.println("(17) Car is standing. Trying to goFaster.");
    try {
      while (manualCar.speed > -5) {
        manualCar.goFaster();
      }
    } catch (Exception e) {
      System.out.println("Should be able to go faster, clutch pedal is not pressed, car is on 'Reverse'.");
    }

    // (17.1) See the speed
    manualCar.printSpeed();

    // (18) Try to hit the brakes
    System.out.println("(18) Car is moving backwards. Trying to goSlower.");
    try {
      while (manualCar.speed != 0) {
        manualCar.goSlower();
      }
    } catch (Exception e) {
      System.out.println("Could not go slower, clutch pedal is not pressed!");
    }

    // (19) Press the clutch pedal
    System.out.println("(19) Car is moving backwards. Pressing the clutch pedal.");
    manualCar.isClutchPressed = true;
    System.out.println("Clutch pedal is pressed!");

    // (20) Try to hit the brakes
    System.out.println("(20) Car is moving backwards. Trying to goSlower until car stops.");
    try {
      while (manualCar.speed != 0) {
        manualCar.goSlower();
      }
    } catch (Exception e) {
      System.out.println("Should be able to go slower, clutch pedal is pressed and car is moving backwards.");
    }

    // (20.1) See the speed
    manualCar.isClutchPressed = false;
    System.out.println("Clutch pedal is released!");
    manualCar.printSpeed();

    System.out.println("Car is not moving. End of the demo.");
  }
}

