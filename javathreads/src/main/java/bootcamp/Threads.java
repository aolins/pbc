package bootcamp;

import java.util.UUID;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Threads {

    public static void main(String[] args) {

        // Check the time at the start of the execution
        long startTime = System.currentTimeMillis();

        System.out.println("Let's list the numbers and letters in two threads!");

        // Creating a task for the first thread - only numbers
        Runnable taskForThreadOne = () -> {
            timeConsuming(3);
            System.out.println("1");
            timeConsuming(5);
            System.out.println("2");
            timeConsuming(3);
            System.out.println("3");
            timeConsuming(3);
            System.out.println("4");
            timeConsuming(3);
            System.out.println("5");

            // Check the time at the end of the execution of the first thread
            long stopTime = System.currentTimeMillis();

            // Calculate and print the execution time of the first thread
            String message = "Execution time of the first thread: ";
            calculateTime(startTime, stopTime, message);
        };

        // Creating a task for the second thread - only letters
        Runnable taskForThreadTwo = () -> {
            timeConsuming(3);
            System.out.println("A");
            timeConsuming(2);
            System.out.println("B");
            timeConsuming(3);
            System.out.println("C");
            timeConsuming(4);
            System.out.println("D");
            timeConsuming(3);
            System.out.println("E");

            // Check the time at the end of the execution of the second thread
            long stopTime = System.currentTimeMillis();

            // Calculate and print the execution time of the second thread
            String message = "Execution time of the second thread: ";
            calculateTime(startTime, stopTime, message);
        };

        // Creating threads
        Thread threadOne = new Thread(taskForThreadOne);
        Thread threadTwo = new Thread(taskForThreadTwo);

        // Running tasks on seperate threads
        threadOne.start();
        threadTwo.start();
    }

    /**
     * Procedure that creates a random list of Unique IDs and bubble sorts it.
     * @param repetitionCount - number of times the procedure needs to be executed
     */
    public static final void timeConsuming(int repetitionCount) {

        for (int i = 0; i < repetitionCount; i++) {

            // Create a list with random Unique IDs
            List<UUID> listOfUniqueIds = new ArrayList<>();
            for (int j = 0; j < 3000; j++) {
                listOfUniqueIds.add(UUID.randomUUID());
            }

            // Bubble sort the array
            listOfUniqueIds = imperativeBubbleSort(listOfUniqueIds);
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