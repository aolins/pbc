package bootcamp;

import java.util.UUID;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Threads {

    private static String[] arrayOfNumbers = {"1", "2", "3", "4", "5"};
    private static String[] arrayOfLetters = {"A", "B", "C", "D", "E"};

    public static void main(String[] args) {

        System.out.println("Let's list random mixed numbers and letters in two threads!");

        // Random number picker
        Random rand = new Random();

        // Creating a first thread with a task containing only numbers
        Thread threadOne = new Thread(() -> {

            synchronized (arrayOfNumbers) {
                System.out.println("Thread One: Holding arrayOfNumbers...");

                timeConsuming(3);
                System.out.println("Random number from arrayOfNumbers: " + arrayOfNumbers[rand.nextInt(5)]);

                System.out.println("Thread One: Waiting for arrayOfLetters...");

                synchronized (arrayOfLetters) {
                    System.out.println("Thread One: Holding arrayOfNumbers & arrayOfLetters...");
                }
            }
        });

        // Creating a second thread with a task containing only letters
        Thread threadTwo = new Thread(() ->{

            synchronized (arrayOfLetters) {
                System.out.println("Thread Two: Holding arrayOfLetters...");

                timeConsuming(3);
                System.out.println("Random letter from arrayOfLetters: " + arrayOfLetters[rand.nextInt(5)]);

                System.out.println("Thread Two: Waiting for arrayOfNumbers...");

                synchronized (arrayOfNumbers) {
                    System.out.println("Thread Two: Holding arrayOfNumbers & arrayOfLetters...");
                }
            }
        });

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
}