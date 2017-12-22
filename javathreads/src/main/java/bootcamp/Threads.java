package bootcamp;

import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

public class Threads {

    // Object to indicate the smartphone
    private static Object smartphone = new Object();
    // Object to indicate the USB cable used for charging and file transfer
    private static Object usbCable = new Object();

    public static void main(String[] args) {

        System.out.println("Let's transfer files form smartphone while charging it!");

        // Creating a first thread with a task to put phone on charging
        Thread threadOne = new Thread(() -> {

            synchronized (smartphone) {
                System.out.println("Thread One: Holding the smartphone...");

                timeConsuming(3);

                System.out.println("Thread One: Waiting for USB cable to be available for charging...");

                synchronized (usbCable) {
                    System.out.println("Thread One: Holding smartphone and USB cable...");
                }
            }
        });

        // Creating a second thread with a task to transfer files from smartphone
        Thread threadTwo = new Thread(() ->{

            synchronized (usbCable) {
                System.out.println("Thread Two: Holding USB cable...");

                timeConsuming(3);

                System.out.println("Thread Two: Waiting for smartphone to be available for file transfer...");

                synchronized (smartphone) {
                    System.out.println("Thread Two: Holding smartphone and USB cable...");
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