package bootcamp;

public class OopPrinciples{

  public static void main(String[] args){

      // Creates an array with 6 columns and 20 rows
      final String[][] arrayWithoutHeader = {
          {"Sterling B. Rosario", "612-388-9263", "December 30, 1992", "Public affairs specialist", "2011 Bentley Continental GTC", "158.8 pounds (72.2 kilograms)"},
          {"Amber M. Doss", "276-859-0345", "February 5, 1968", "Tour escort", "2011 Alpina B5", "139.5 pounds (63.4 kilograms)"},
          {"Erik M. Robinson", "609-546-2522", "July 3, 1993", "Logistician", "2004 Lincoln Town Car", "172.7 pounds (78.5 kilograms)"},
          {"Eugene L. Johnson", "850-941-3589", "March 2, 1987", "Systems software engineer", "2010 Toyota Aygo", "191.6 pounds (87.1 kilograms)"},
          {"Audi", "A3", "2017", "Premium Gasoline", "186 hp", "6.0 sec"},
          {"BMW", "X6", "2016", "Premium Gasoline", "567 hp", "5.2 sec"},
          {"SAAB", "9-7X", "2009", "Regular Gasoline", "285 hp", "7.2 sec"},
          {"CADILLAC", "XT5", "2017", "Regular Gasoline", "310 hp", "6.6 sec"},
          {"Boeing", "737", "85-215 seats", "10204 km", "11300 m", "36 m"},
          {"Boeing", "787", "210-330 seats", "14800 km", "13100 m", "60.12 m"},
          {"Airbus", "A380", "544 seats", "15200 km", "13100 m", "80 m"},
          {"Airbus", "A330", "406 seats", "13450 km", "12500 m", "60.3 m"},
          {"Oasis of the Seas", "Caribbean", "41.9 km/h", "5400 passengers", "361.6 m", "225,282 GT"},
          {"Royal Princess", "Various", "40.7 km/h", "3600 passengers", "330 m", "142,714 GT"},
          {"Carnival Vista", "Caribbean", "43 km/h", "3,936 passengers", "324 m", "133,500 GT"},
          {"Norwegian Escape", "Various", "43 km/h", "4,266 passengers", "325.9 m", "165,300 GT"},
          {"Labrador", "United Kingdom & Canada", "25-36 kg", "Black, chocolate, yellow", "12-13 years", "1st (2016)"},
          {"English Beagle", "England", "9.1-11.3 kg", "Tricolor", "12-15 years", "5th (2016)"},
          {"British Bulldog", "England", "23-25 kg", "Red, fawn, white, brindle, piebald", "8-10 years", "4th (2016)"},
          {"Great Dane", "Germany", "50-82 kg", "Fawn, blue, brindle, black", "8-10 years", "14th (2016)"},
          {"Bitcoin", "XBT", "Digital gold", "21 million" , "2009", "Satoshi Nakamoto"},
          {"Litecoin", "LTC", "Faster Bitcoin", "84 million" , "2011", "Charlie Lee"},
          {"Ethereum", "ETH", "Programmable contracts and money", "100 million", "2013", "Vitalik Buterin"},
          {"Ripple", "XRP", "Enterprise payment settlement network", "100 billion", "2012", "Arthur Britto, David Schwartz, Ryan Fugger"}};

    // Prints out an array
    for (int i = 0; i < 24; i++) {
      for (int j = 0; j < 6; j++) {
        System.out.print(arrayWithoutHeader[i][j] + "\t");
      }
      System.out.println();
    }
  }
}

