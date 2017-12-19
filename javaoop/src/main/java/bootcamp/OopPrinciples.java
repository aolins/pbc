package bootcamp;

public class OopPrinciples{

  public static void main(String[] args){

    // Creating all printable objects in one array of printables
    final Printable[] arrayOfPrintables = {
            new Person("Sterling B. Rosario", "612-388-9263", "December 30, 1992", "Public affairs specialist", "2011 Bentley Continental GTC", "158.8 pounds (72.2 kilograms)"),
            new Person("Amber M. Doss", "276-859-0345", "February 5, 1968", "Tour escort", "2011 Alpina B5", "139.5 pounds (63.4 kilograms)"),
            new Person("Erik M. Robinson", "609-546-2522", "July 3, 1993", "Logistician", "2004 Lincoln Town Car", "172.7 pounds (78.5 kilograms)"),
            new Person("Eugene L. Johnson", "850-941-3589", "March 2, 1987", "Systems software engineer", "2010 Toyota Aygo", "191.6 pounds (87.1 kilograms)"),
            new Car("Audi", "A3", 2017, "Premium Gasoline", 186, 6.0),
            new Car("BMW", "X6", 2016, "Premium Gasoline", 567, 5.2),
            new Car("SAAB", "9-7X", 2009, "Regular Gasoline", 285, 7.2),
            new Car("CADILLAC", "XT5", 2017, "Regular Gasoline", 310, 6.6),
            new Plane("Boeing", "737", "85-215 seats", 10204, "1966-present", 36.0, 11300),
            new Plane("Boeing", "787", "210-330 seats", 14800, "2007-present", 60.12, 13100),
            new Plane("Airbus", "A380", "544 seats", 15200, "2005-present", 80.0, 13100),
            new Plane("Airbus", "A330", "406 seats", 13450, "1992-present", 60.3, 12500),
            new Ship("Oasis of the Seas", "Caribbean", 41.9, 5400, 361.6, 225282),
            new Ship("Royal Princess", "Various", 40.7, 3600, 330.0, 142714),
            new Ship("Carnival Vista", "Caribbean", 43.0, 3936, 324.0, 133500),
            new Ship("Norwegian Escape", "Various", 43.0, 4266, 325.9, 165300),
            new Dog("Labrador", "United Kingdom & Canada", "25-36 kg", "Black, chocolate, yellow", "12-13 years", "1st (2016)"),
            new Dog("English Beagle", "England", "9.1-11.3 kg", "Tricolor", "12-15 years", "5th (2016)"),
            new Dog("British Bulldog", "England", "23-25 kg", "Red, fawn, white, brindle, piebald", "8-10 years", "4th (2016)"),
            new Dog("Great Dane", "Germany", "50-82 kg", "Fawn, blue, brindle, black", "8-10 years", "14th (2016)"),
            new CryptoCurrency("Bitcoin", "XBT", "Digital gold", "21 million" , 2009, "Satoshi Nakamoto"),
            new CryptoCurrency("Litecoin", "LTC", "Faster Bitcoin", "84 million" , 2011, "Charlie Lee"),
            new CryptoCurrency("Ethereum", "ETH", "Programmable contracts and money", "100 million", 2013, "Vitalik Buterin"),
            new CryptoCurrency("Ripple", "XRP", "Enterprise payment settlement network", "100 billion", 2012, "Arthur Britto, David Schwartz, Ryan Fugger")};

    // Printing out data in arrayOfPrintables
    for (int i = 0; i < 24; i++) {
      // For each object the corresponding print() method will be used
      arrayOfPrintables[i].print();
    }
  }
}

