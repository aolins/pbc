package bootcamp;

public class CryptoCurrency implements Printable{

    // Name of the crypto currency
    public String name;
    // Code of the crypto currency
    public String code;
    // Short description of the crypto currency
    public String description;
    // Limit of coins of the crypto currency
    public String limitOfCoins;
    // Year of the foundation of the crypto currency
    public int year;
    // Creators of the crypto currency
    public String creators;

    // Default constructor
    public CryptoCurrency() {};

    // Full constructor
    public CryptoCurrency(String name, String code, String description,
                          String limitOfCoins, int year, String creators) {
        this.name = name;
        this.code = code;
        this.description = description;
        this.limitOfCoins = limitOfCoins;
        this.year = year;
        this.creators = creators;
    };

    public void print() {
        System.out.println("Crypto currency");
        System.out.println("NAME: " + this.name);
        System.out.println("CODE: " + this.code);
        System.out.println("DESCRIPTION: " + this.description);
        System.out.println();
    }
}