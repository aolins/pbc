package bootcamp;

public class Threads{

  public static void main(String[] args){

      // Creates an array with 6 columns and 20 rows
      final String[][] arrayWithoutHeader = {
          {"Sterling B. Rosario", "Steven G. Cameron", "Amber M. Doss", "Troy D. Lee", "Brenda M. Goldman", "James M. McCracken", "Hope C. Edwards", "James M. Hicks", "Carolyn T. Muniz", "David I. Rojas", "Donald V. McKinnon", "Erik M. Robinson", "Joyce R. Murray", "William R. Levitt", "Eugene L. Johnson", "Jerry E. Dorsey", "Joseph K. Wallace", "Daisy J. Glover", "Debbie C. Allen", "David A. Bryce"},
          {"612-388-9263", "814-577-8878", "276-859-0345", "650-687-9895", "715-469-4937", "239-732-0630", "208-549-2256", "806-794-2570", "815-772-5445", "786-236-8216", "518-701-0696", "609-546-2522", "352-408-6547", "510-927-9462", "850-941-3589", "214-887-9398", "201-326-1372", "646-277-7890", "978-254-0960", "310-312-0940"},
          {"December 30, 1992", "December 23, 1992", "December 23, 1986", "July 6, 1933", "February 5, 1968", "February 2, 1969", "November 6, 1994", "February 24, 1990", "January 25, 1943", "March 11, 1977", "March 7, 1970", "July 3, 1993", "March 1, 1967", "February 8, 1945", "March 2, 1987", "December 22, 1981", "March 30, 1981", "October 21, 1967", "October 4, 1976", "August 6, 1974", "November 7, 1953"},
          {"Landscaping worker", "Banquet manager", "Power lineman", "Pointer", "Tour escort", "Magistrate", "Music instructor", "Police dispatcher", "Medical assistant", "Personnel technician", "Training assistant", "Floor layer", "Public affairs specialist", "Legislator", "Systems software engineer", "Range ecologist", "Telemarketer", "Logistician", "Airport service agent", "Route driver"},
          {"1993 Dodge Viper", "2005 Fiat Doblo", "2009 Daewoo Lacetti", "2008 Honda Civic", "2011 Alpina B5", "2011 Bentley Continental GTC", "2003 Avanti Sport Convertible", "2002 Toyota FCHV 5", "2001 Ginetta G34", "1997 Dodge Caravan", "2010 Toyota Aygo", "2012 Mercedes-Benz GLK", "1996 Nissan Maxima", "2004 Oldsmobile Silhouette", "2006 Volkswagen Passat", "2004 Peugeot 1007", "2002 Honda Mobilio", "2004 Lincoln Town Car", "1998 Volkswagen Golf", "2006 Suzuki Sea Forenza Wagon", "2006 Volkswagen Passat"},
          {"130.9 pounds (59.5 kilograms)", "158.8 pounds (72.2 kilograms)", "106.7 pounds (48.5 kilograms)", "139.5 pounds (63.4 kilograms)", "139.5 pounds (63.4 kilograms)", "171.4 pounds (77.9 kilograms)", "182.4 pounds (82.9 kilograms)", "165.2 pounds (75.1 kilograms)", "206.8 pounds (94.0 kilograms)", "196.0 pounds (89.1 kilograms)", "191.6 pounds (87.1 kilograms)", "213.8 pounds (97.2 kilograms)", "193.4 pounds (87.9 kilograms)", "123.6 pounds (56.2 kilograms)", "197.1 pounds (89.6 kilograms)", "148.5 pounds (67.5 kilograms)", "122.5 pounds (55.7 kilograms)", "172.7 pounds (78.5 kilograms)", "175.1 pounds (79.6 kilograms)", "180.8 pounds (82.2 kilograms)"}};

    // Prints out an array
    for (int i = 0; i < 20; i++) {
      for (int j = 0; j < 6; j++) {
        System.out.print(arrayWithoutHeader[j][i] + "\t");
      }
      System.out.println();
    }
  }
}

