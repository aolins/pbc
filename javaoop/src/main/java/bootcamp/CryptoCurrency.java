package bootcamp;

public class CryptoCurrency implements Printable{

    // Name of the crypto currency
    private String name;
    // Code of the crypto currency
    private String code;
    // Short description of the crypto currency
    private String description;
    // Limit of coins of the crypto currency
    private String limitOfCoins;
    // Year of the foundation of the crypto currency
    private int year;
    // Creators of the crypto currency
    private String creators;

    // Default constructor
    public CryptoCurrency() {};

    // Full constructor
    public CryptoCurrency(String name, String code, String description,
                          String limitOfCoins, int year, String creators) {
        this.setName(name);
        this.setCode(code);
        this.setDescription(description);
        this.setLimitOfCoins(limitOfCoins);
        this.setYear(year);
        this.setCreators(creators);
    };

    public void print() {
        System.out.println("Crypto currency");
        System.out.println("NAME: " + this.name);
        System.out.println("CODE: " + this.code);
        System.out.println("DESCRIPTION: " + this.description);
        System.out.println();
    }

    // Returns the name of the  crypto currency
    public String getName() {
        return name;
    }

    // Sets the name of the  crypto currency
    public void setName(String name) {
        this.name = name;
    }

    // Returns the code of the crypto currency
    public String getCode() {
        return code;
    }

    // Sets the code of the crypto currency
    public void setCode(String code) {
        this.code = code;
    }

    // Returns the descriptions of the crypto currency
    public String getDescription() {
        return description;
    }

    // Sets the description of the crypto currency
    public void setDescription(String description) {
        this.description = description;
    }

    // Returns the limit of coins of the crypto currency
    public String getLimitOfCoins() {
        return limitOfCoins;
    }

    // Sets the limit of coins of the crypto currency
    public void setLimitOfCoins(String limitOfCoins) {
        this.limitOfCoins = limitOfCoins;
    }

    // Returns the year of the foundation of the crypto currency
    public int getYear() {
        return year;
    }

    // Sets the year of the foundation of the crypto currency
    public void setYear(int year) {
        this.year = year;
    }

    // Returns the creators of the crypto currency
    public String getCreators() {
        return creators;
    }

    // Sets the creators of the crypto currency
    public void setCreators(String creators) {
        this.creators = creators;
    }
}