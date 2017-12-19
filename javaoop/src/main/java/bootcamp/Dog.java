package bootcamp;

public class Dog implements Printable{

    // Breed of a dog
    private String breed;
    // Origins of the breed
    private String origins;
    // Weight limits of a dog breed measured in kilograms (kg)
    private String weightLimit;
    // Possible colors of a dog breed
    private String colors;
    // Life span of a dog breed measured in years
    private String lifeSpan;
    // Place in the top by popularity
    private String placeInTop;

    // Default constructor
    public Dog() {}

    // Full constructor
    public Dog(String breed, String origins, String weightLimit,
               String colors, String lifeSpan, String placeInTop) {
        this.setBreed(breed);
        this.setOrigins(origins);
        this.setWeightLimit(weightLimit);
        this.setColors(colors);
        this.setLifeSpan(lifeSpan);
        this.setPlaceInTop(placeInTop);
    }

    // Prints an essential information of a dog
    public void print() {
        System.out.println("Dog");
        System.out.println("BREED: " + this.breed);
        System.out.println("ORIGIN: " + this.origins);
        System.out.println("PLACE BY POPULARITY: " + this.placeInTop);
        System.out.println();
    }

    // Returns the name of a dog breed
    public String getBreed() {
        return breed;
    }

    // Sets the name of a dog breed
    public void setBreed(String breed) {
        this.breed = breed;
    }

    // Returns the origins of a dog breed
    public String getOrigins() {
        return origins;
    }

    // Sets the origins of a dog breed
    public void setOrigins(String origins) {
        this.origins = origins;
    }

    // Returns the weight limits of a dog
    public String getWeightLimit() {
        return weightLimit;
    }

    // Sets the weight limits of a dog
    public void setWeightLimit(String weightLimit) {
        this.weightLimit = weightLimit;
    }

    // Returns the possible colors of a dog
    public String getColors() {
        return colors;
    }

    // Sets the possible colors of a dog
    public void setColors(String colors) {
        this.colors = colors;
    }

    // Returns the life span of a dog
    public String getLifeSpan() {
        return lifeSpan;
    }

    // Sets the life span of a dog
    public void setLifeSpan(String lifeSpan) {
        this.lifeSpan = lifeSpan;
    }

    // Returns the place the dog breed takes in top by popularity
    public String getPlaceInTop() {
        return placeInTop;
    }

    // Sets the place the dog breed takes in top by popularity
    public void setPlaceInTop(String placeInTop) {
        this.placeInTop = placeInTop;
    }
}