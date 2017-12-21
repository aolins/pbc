package bootcamp;

import java.util.UUID;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Threads {

    public static void main(String[] args) {

        // Check the time at the start of the execution
        long startTime = System.currentTimeMillis();

        System.out.println("Let's list the numbers in one thread!");

        // Calling the procedure in one thread
        System.out.print("1");
        timeConsuming(3);
        System.out.println(" - One");
        timeConsuming(3);
        System.out.print("2");
        timeConsuming(3);
        System.out.println(" - Two");
        timeConsuming(3);
        System.out.print("3");
        timeConsuming(3);
        System.out.println(" - Three");
        timeConsuming(3);
        System.out.print("4");
        timeConsuming(3);
        System.out.println(" - Four");
        timeConsuming(3);
        System.out.print("5");
        timeConsuming(3);
        System.out.println(" - Five");

        // Check the time at the end of the execution
        long stopTime = System.currentTimeMillis();

        // Calculate and print the execution time of main method
        String message = "Execution time of main method: ";
        calculateTime(startTime, stopTime, message);
    }

    /**
     * Procedure that creates a random list of Unique IDs and bubble sorts it.
     * @param repetitionCount - number of times the procedure needs to be executed
     */
    public static final void timeConsuming(int repetitionCount) {

        while (repetitionCount != 0) {

            // Create a list with random Unique IDs
            List<UUID> listOfUniqueIds = new ArrayList<>();
            for (int i = 0; i < 5000; i++) {
                listOfUniqueIds.add(UUID.randomUUID());
            }

            // Bubble sort the array
            listOfUniqueIds = imperativeBubbleSort(listOfUniqueIds);

            // Decrement repetitionCount
            repetitionCount--;
        }
    }

    /**
     * Bubble sort implementation to be used as slowest sorting algorythm
     * @param list - list which needs to be sorted
     * @return sorted list
     */
    public static final List<UUID> imperativeBubbleSort(List<UUID> list) {
        // If list is populated
        if (list != null && !list.isEmpty()) {
            // For every member of the list
            int listLength = list.size();
            for(int i = listLength - 1; i > 0; i--) {
                for(int k = 0; k < i; k++) {
                    // If list member is smaller than it's neighbor
                    if(list.get(k + 1).compareTo(list.get(k)) < 0) {
                        // Swap the members putting smaller one before larger one
                        list.add(k, list.remove(k + 1));
                    }
                }
            }
        }
        return list;
    }

    /**
     * Calculates, formats and prints out the time of the execution.
     * @param startTime - start time of execution
     * @param stopTime - end time of execution
     */
    public static final void calculateTime(final long startTime, final long stopTime, final String message) {
        // Calculate the time of the execution
        long elapsedTime = stopTime - startTime;
        long second = (elapsedTime / 1000) % 60;
        // Prepare the message
        String time = String.format(message + "%02d seconds.", second);
        // Print out the message
        System.out.println(time);
    }
}