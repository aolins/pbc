package bootcamp;

import java.util.UUID;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Threads {

    private static int executionNumber;

    public static void main(String[] args) {

        //Initialising the executionNumber
        executionNumber = 0;

        String message = "Execution time of main method: ";

        // Check the time at the start of the execution
        long startTime = System.currentTimeMillis();

        System.out.println("Let's run the programm without threads!");

        // Calling the procedure 10 times
        timeConsuming(3);
        timeConsuming(3);
        timeConsuming(3);
        timeConsuming(3);
        timeConsuming(3);
        timeConsuming(3);
        timeConsuming(3);
        timeConsuming(3);
        timeConsuming(3);
        timeConsuming(3);

        // Check the time at the end of the execution
        long stopTime = System.currentTimeMillis();

        // Calculate and print the execution time of main method
        calculateTime(startTime, stopTime, message);
    }

    /**
     * Procedure that creates a random list of Unique IDs and bubble sorts it.
     * @param repetitionCount - number of times the procedure needs to be executed
     */
    public static final void timeConsuming(int repetitionCount) {

        while (repetitionCount != 0) {

            // Check the time at the start of the execution
            long startTime = System.currentTimeMillis();

            // Create a list with random Unique IDs
            List<UUID> listOfUniqueIds = new ArrayList<>();
            for (int i = 0; i < 7000; i++) {
                listOfUniqueIds.add(UUID.randomUUID());
            }

            // Bubble sort the array
            listOfUniqueIds = imperativeBubbleSort(listOfUniqueIds);

            // Check the time at the end of the execution
            long stopTime = System.currentTimeMillis();

            // Calculate and print the execution time of procedure
            calculateTime(startTime, stopTime, "Execution time of timeConsuming(): ");

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