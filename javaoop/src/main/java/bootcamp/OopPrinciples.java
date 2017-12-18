package bootcamp;

public class OopPrinciples{

  public static void main(String[] args){

    // Creates an array with 6 columns and 24 rows
    final String[][] arrayWithHeader = {
      {"PERSON", "Sterling B. Rosario", "612-388-9263", "December 30, 1992", "Public affairs specialist", "2011 Bentley Continental GTC", "158.8 pounds (72.2 kilograms)"},
      {"PERSON", "Amber M. Doss", "276-859-0345", "February 5, 1968", "Tour escort", "2011 Alpina B5", "139.5 pounds (63.4 kilograms)"},
      {"PERSON", "Erik M. Robinson", "609-546-2522", "July 3, 1993", "Logistician", "2004 Lincoln Town Car", "172.7 pounds (78.5 kilograms)"},
      {"PERSON", "Eugene L. Johnson", "850-941-3589", "March 2, 1987", "Systems software engineer", "2010 Toyota Aygo", "191.6 pounds (87.1 kilograms)"},
      {"CAR", "Audi", "A3", "2017", "Premium Gasoline", "186 hp", "6.0 sec"},
      {"CAR", "BMW", "X6", "2016", "Premium Gasoline", "567 hp", "5.2 sec"},
      {"CAR", "SAAB", "9-7X", "2009", "Regular Gasoline", "285 hp", "7.2 sec"},
      {"CAR", "CADILLAC", "XT5", "2017", "Regular Gasoline", "310 hp", "6.6 sec"},
      {"PLANE", "Boeing", "737", "85-215 seats", "10204 km", "11300 m", "36 m"},
      {"PLANE", "Boeing", "787", "210-330 seats", "14800 km", "13100 m", "60.12 m"},
      {"PLANE", "Airbus", "A380", "544 seats", "15200 km", "13100 m", "80 m"},
      {"PLANE", "Airbus", "A330", "406 seats", "13450 km", "12500 m", "60.3 m"},
      {"SHIP", "Oasis of the Seas", "Caribbean", "41.9 km/h", "5400 passengers", "361.6 m", "225,282 GT"},
      {"SHIP", "Royal Princess", "Various", "40.7 km/h", "3600 passengers", "330 m", "142,714 GT"},
      {"SHIP", "Carnival Vista", "Caribbean", "43 km/h", "3,936 passengers", "324 m", "133,500 GT"},
      {"SHIP", "Norwegian Escape", "Various", "43 km/h", "4,266 passengers", "325.9 m", "165,300 GT"},
      {"DOG", "Labrador", "United Kingdom & Canada", "25-36 kg", "Black, chocolate, yellow", "12-13 years", "1st (2016)"},
      {"DOG", "English Beagle", "England", "9.1-11.3 kg", "Tricolor", "12-15 years", "5th (2016)"},
      {"DOG", "British Bulldog", "England", "23-25 kg", "Red, fawn, white, brindle, piebald", "8-10 years", "4th (2016)"},
      {"DOG", "Great Dane", "Germany", "50-82 kg", "Fawn, blue, brindle, black", "8-10 years", "14th (2016)"},
      {"CRYPTOCURRENCY", "Bitcoin", "XBT", "Digital gold", "21 million" , "2009", "Satoshi Nakamoto"},
      {"CRYPTOCURRENCY", "Litecoin", "LTC", "Faster Bitcoin", "84 million" , "2011", "Charlie Lee"},
      {"CRYPTOCURRENCY", "Ethereum", "ETH", "Programmable contracts and money", "100 million", "2013", "Vitalik Buterin"},
      {"CRYPTOCURRENCY", "Ripple", "XRP", "Enterprise payment settlement network", "100 billion", "2012", "Arthur Britto, David Schwartz, Ryan Fugger"}};

    // Prints out data by datatype
    for (int i = 0; i < 24; i++) {

      if (arrayWithHeader[i][0].equals("PERSON")) {
        System.out.println(
          String.format("DATA TYPE: %s\nNAME: %s\nDATE OF BIRTH: %s\nOCCUPATION: %s\nVEHICLE: %s\n",
            arrayWithHeader[i][0],
            arrayWithHeader[i][1],
            arrayWithHeader[i][3],
            arrayWithHeader[i][4],
            arrayWithHeader[i][5]));
      } else if (arrayWithHeader[i][0].equals("CAR")) {
        System.out.println(
          String.format("DATA TYPE: %s\nBRAND: %s\nMODEL: %s\nYEAR: %s\nHORSEPOWER: %s\n",
            arrayWithHeader[i][0],
            arrayWithHeader[i][1],
            arrayWithHeader[i][2],
            arrayWithHeader[i][3],
            arrayWithHeader[i][5]));
      } else if (arrayWithHeader[i][0].equals("PLANE")) {
        System.out.println(
          String.format("DATA TYPE: %s\nMANUFACTURER: %s\nMODEL: %s\nCAPACITY: %s\nRANGE: %s\n",
            arrayWithHeader[i][0],
            arrayWithHeader[i][1],
            arrayWithHeader[i][2],
            arrayWithHeader[i][3],
            arrayWithHeader[i][4]));
      } else if (arrayWithHeader[i][0].equals("SHIP")) {
        System.out.println(
          String.format("DATA TYPE: %s\nNAME: %s\nCAPACITY: %s\nLENGTH: %s\nROUTE: %s\n",
            arrayWithHeader[i][0],
            arrayWithHeader[i][1],
            arrayWithHeader[i][4],
            arrayWithHeader[i][5],
            arrayWithHeader[i][2]));
      } else if (arrayWithHeader[i][0].equals("DOG")) {
        System.out.println(
          String.format("DATA TYPE: %s\nBREED: %s\nORIGIN: %s\nPLACE BY POPULARITY: %s\n",
            arrayWithHeader[i][0],
            arrayWithHeader[i][1],
            arrayWithHeader[i][2],
            arrayWithHeader[i][6]));
      } else if (arrayWithHeader[i][0].equals("CRYPTOCURRENCY")) {
        System.out.println(
          String.format("DATA TYPE: %s\nNAME: %s\nCODE: %s\nDESCRIPTION: %s\n",
            arrayWithHeader[i][0],
            arrayWithHeader[i][1],
            arrayWithHeader[i][2],
            arrayWithHeader[i][3]));
      } else {
        System.out.println(String.format("UNSUPPPORTED DATA TYPE: %s\n", arrayWithHeader[i][0]));
      }
    }
  }
}

