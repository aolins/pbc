package bootcamp;

import java.util.UUID;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Threads {


    public static void main(String[] args) {

        // Calling the procedure couple of times
        timeConsuming(5);
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

            // Calculate and print the execution time
            calculateTime(startTime, stopTime);

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
    public static final void calculateTime(final long startTime, final long stopTime) {
        // Calculate the time of the execution
        long elapsedTime = stopTime - startTime;
        long second = (elapsedTime / 1000) % 60;
        // Format the print-out message
        String time = String.format("Time of execution: %02d seconds", second);
        System.out.println(time);
    }
}