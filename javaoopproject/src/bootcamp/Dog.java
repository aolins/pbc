package bootcamp;

public class Dog implements Printable{

    // Breed of a dog
    public String breed;
    // Origins of the breed
    public String origins;
    // Weight limits of a dog breed measured in kilograms (kg)
    public String weightLimit;
    // Possible colors of a dog breed
    public String colors;
    // Life span of a dog breed measured in years
    public String lifeSpan;
    // Place in the top by popularity
    public String placeInTop;

    // Default constructor
    public Dog() {}

    // Full constructor
    public Dog(String breed, String origins, String weightLimit,
               String colors, String lifeSpan, String placeInTop) {
        this.breed = breed;
        this.origins = origins;
        this.weightLimit = weightLimit;
        this.colors = colors;
        this.lifeSpan = lifeSpan;
        this.placeInTop = placeInTop;
    }

    // Prints an essential information of a dog
    public void print() {
        System.out.println("Dog");
        System.out.println("BREED: " + this.breed);
        System.out.println("ORIGIN: " + this.origins);
        System.out.println("PLACE BY POPULARITY: " + this.placeInTop);
        System.out.println();
    }
}