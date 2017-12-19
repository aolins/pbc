package bootcamp;

public class Person implements Printable{

    // Name of a person
    private String name;
    // Phone number of a person
    private String phoneNumber;
    // Date of birth of a person
    private String dateOfBirth;
    // Occupation / job title of a person
    private String occupation;
    // Vehicle owned by a person
    private String vehicle;
    // Weight of a person
    private String weight;

    // Default constructor
    public Person() {}

    // Full constructor
    public Person(String name, String phoneNumber, String dateOfBirth,
                  String occupation, String vehicle, String weight) {
        this.setName(name);
        this.setPhoneNumber(phoneNumber);
        this.setDateOfBirth(dateOfBirth);
        this.setOccupation(occupation);
        this.setVehicle(vehicle);
        this.setWeight(weight);
    }

    // Prints an essential information of a person
    public void print() {
        System.out.println("Person");
        System.out.println("NAME: " + this.getName());
        System.out.println("DATE OF BIRTH: " + this.getDateOfBirth());
        System.out.println("OCCUPATION: " + this.getOccupation());
        System.out.println("VEHICLE: " + this.getVehicle());
        System.out.println();
    }

    // Returns the name of a person
    public String getName() {
        return name;
    }

    // Sets the name of a person
    public void setName(String name) {
        this.name = name;
    }

    // Returns the phone number of a person
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Sets the phone number of a person
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Returns the date of birth of a person
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    // Sets the date of birth of a person
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    // Returns the occupation of a person
    public String getOccupation() {
        return occupation;
    }

    // Sets the occupation of a person
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    // Returns the vehicle owned by a person
    public String getVehicle() {
        return vehicle;
    }

    // Sets the vehicle owned by a person
    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    // Returns the weight of a person
    public String getWeight() {
        return weight;
    }

    // Sets the weight of a person
    public void setWeight(String weight) {
        this.weight = weight;
    }
}