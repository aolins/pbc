package bootcamp;

public class Person implements Printable{

    // Name of a person
    public String name;
    // Phone number of a person
    public String phoneNumber;
    // Date of birth of a person
    public String dateOfBirth;
    // Occupation / job title of a person
    public String occupation;
    // Vehicle owned by a person
    public String vehicle;
    // Weight of a person
    public String weight;

    // Default constructor
    public Person() {}

    // Full constructor
    public Person(String name, String phoneNumber, String dateOfBirth,
                  String occupation, String vehicle, String weight) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.occupation = occupation;
        this.vehicle = vehicle;
        this.weight = weight;
    }

    // Prints an essential information of a person
    public void print() {
        System.out.println("Person");
        System.out.println("NAME: " + this.name);
        System.out.println("DATE OF BIRTH: " + this.dateOfBirth);
        System.out.println("OCCUPATION: " + this.occupation);
        System.out.println("VEHICLE: " + this.vehicle);
        System.out.println();
    }
}