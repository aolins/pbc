package bootcamp;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.io.Console;

/**
 *  JDBCExample works with a database, which contains a table created by script below (beware of unneeded '*' if using copy-paste):
 *
 *  CREATE TABLE people (
 *    fullname varchar (45) NOT NULL,
 *    occupation varchar (45) NOT NULL,
 *    vehicle varchar (45) NOT NULL,
 *    weight decimal (6,3) NOT NULL,
 *    PRIMARY KEY (fullname)
 *  );
 *
 *  Placeholders that need to be replaced:
 *  DATABASE_NAME - name of the database needed to be connect with,
 *  PORT - port to which to connect to database (possbile that MySQL: 3306 and PostgreSQL: 5432),
 *  USERNAME - MySQL/PostgreSQL username (created by you in installation process or left default like MySQL:root and PostgreSQL: postgres),
 *  PASSWORD - MySQL/PostgreSQL password for created user.
 * */

public class JDBCExample {
    public static void main(String[] args){

        // Specify the URL to database for MySQL
        String dbURL = "jdbc:mysql://localhost:PORT/DATABASE_NAME?useSSL=false";

        // Specify the user and password to connect to database
        String username = "USERNAME";
        String password = "PASSWORD";

        try {
            // Load and register JDBC driver for MySQL
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // ClassNotFoundException is thrown if driver is not properly loaded
            e.printStackTrace();
        }

        // Establish the connection with database
        Connection connection = openConnection(dbURL, username, password);

        // Await user input
        interaction(connection);

        // Close the connection with database
        closeConnection(connection);
    }

    /**
     * Established the connection with given dbURL
     * @param dbURL - string containing the URL to database
     * @param username - string containing the username
     * @param password - string containing the password for a username
     * @return Connection - an established database connection (session)
     * @throws SQLException
     */
    public static Connection openConnection(String dbURL, String username, String password) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(dbURL, username, password);
            if (connection != null) {
                System.out.println("Connection established.");
            }
        } catch (SQLException ex) {
            System.out.println(" ! Exception: " + ex.getMessage());
        }

        return connection;
    }

    /**
     * Closes the connection with database
     * @param connection - an established database connection (session)
     * @throws SQLException
     */
    public static void closeConnection(Connection connection) {
        try {
            connection.close();
            if (connection.isClosed()) {
                System.out.println("Connection closed.");
            }
        } catch (SQLException ex) {
            System.out.println(" ! Exception: " + ex.getMessage());
        }
    }

    /**
     * Holds the interaction functionality
     * @param connection - an established database connection (session)
     */
    public static void interaction(Connection connection) {
        // Console object to get user input
        Console console = System.console();
        String input = "";

        // Execute while user does not choose to (5) EXIT action
        while (!input.equals("5")) {
            System.out.println("\n CHOOSE ACTION:");
            System.out.println(" (1) INSERT   (2) SELECT   (3) UPDATE   (4) DELETE   (5) EXIT");

            // Read user input
            input = console.readLine(" > ACTION: ");

            // Switch statement to execute the action choosen by user
            switch (input) {
                case "1" :
                    getInsert(connection);
                    break;
                case "2" :
                    select(connection);
                    break;
                case "3" :
                    getUpdate(connection);
                    break;
                case "4" :
                    getDelete(connection);
                    break;
                case "5" :
                    System.out.println(" * Exiting the programm.\n");
                    break;
                default :
                    System.out.println(" * NOT A VALID ACTION. PLEASE TRY AGAIN.\n");
            }

        }
    }

    /**
     * Gets user input to execute INSERT statement
     * @param connection - an established database connection (session)
     */
    public static void getInsert(Connection connection)  {

        // Get user input for INSERT statement
        Console console = System.console();
        String fullname = console.readLine(" > Fullname: ");

        // Check if entry to insert already exists
        if (entryExists(connection, fullname)) {
            System.out.println(" * Entry by that fullname already exists!");
        } else {
            String occupation = console.readLine(" > Occupation: ");
            String vehicle = console.readLine(" > Vehicle: ");
            String weightStr = console.readLine(" > Weight (numeric): ");

            try {
                // Parse the input string for weight to float
                float weight = Float.parseFloat(weightStr);
                insert(connection, fullname, occupation, vehicle, weight);
            } catch (NumberFormatException ex) {
                // If provided string is not parsable to float, excpetion will occur
                System.out.println(" ! Exception: " + ex.getMessage());
            }
        }
    }

    /**
     * Gets user input to execute UPDATE statement
     * @param connection
     */
    public static void getUpdate(Connection connection)  {

        // Get user input for UPDATE statement
        Console console = System.console();
        String fullname = console.readLine(" > Fullname: ");

        // Check if entry to update exists
        if (!entryExists(connection, fullname)) {
            System.out.println(" * No entry to update!");
        } else {
            // Get user input for UPDATE statement
            String occupation = console.readLine(" > Occupation: ");
            String vehicle = console.readLine(" > Vehicle: ");
            String weightStr = console.readLine(" > Weight (numeric): ");
            try {
                // Parse the input string for weight to float
                float weight = Float.parseFloat(weightStr);
                update(connection, fullname, occupation, vehicle, weight);
            } catch (NumberFormatException ex) {
                // If provided string is not parsable to float, excpetion will occur
                System.out.println(" ! Exception: " + ex.getMessage());
            }
        }

    }

    /**
     * Gets user input to execute DELETE statement
     * @param connection
     */
    public static void getDelete(Connection connection) {

        // Get user input for DELETE statement
        Console console = System.console();
        String fullname = console.readLine(" > Fullname: ");

        delete(connection, fullname);
    }

    /**
     * Adds new entry to database for table 'people'
     * @param connection - session with database
     * @param fullname - name of the person
     * @param occupation - occupation of the person
     * @param vehicle - vehicle of the person
     * @param weight - weight of the person in kg
     * @throws SQLException
     */
    public static void insert(Connection connection, String fullname, String occupation, String vehicle, float weight) {
        try {
            // String that includes insert SQL script with '?' placeholders which will be replaced by PreparedStatement methods
            String sql = "INSERT INTO people (fullname, occupation, vehicle, weight) VALUES (?, ?, ?, ?)";

            // Prepare the SQL script, replacing all '?' placeholders
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, fullname);
            statement.setString(2, occupation);
            statement.setString(3, vehicle);
            statement.setFloat(4, weight);

            // executeUpdate() returns the number of rows affected by the script. 1 row for each updated entry is expected
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println(" * A new entry was inserted successfully!");
            } else {
                System.out.println(" * Failure during an insert of an entry!");
            }

        } catch (SQLException ex) {
                System.out.println(" ! Exception: " + ex.getMessage());
        }
    }

    /**
     * Selects and displays all data from table 'people'
     * @param connection - session with database
     * @throws SQLException
     */
    public static void select(Connection connection) {
        try {
            // String that includes SQL script for select all entries (* - wildcard/all)
            String sql = "SELECT * FROM people";

            // As this SQL script is hardcoded and no input from the user is possible, we can use Statement instead of Prepared statement
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            System.out.println(" * Executing 'SELECT * FROM people'. Result: ");

            // If SELECT returns nothing, inform about it
            if (!result.isBeforeFirst()) {
                System.out.println(" * No data was return during this SELECT!");
            }

            int count = 0;

            // If SELECT returns a result, display information on every entry
            while (result.next()){
                String fullname = result.getString(1);
                String occupation = result.getString(2);
                String vehicle = result.getString("vehicle");
                float weight = result.getFloat("weight");

                // Prepare the String with placeholders '%d' for numeric value and '%s' for a String value
                String output = " - Person #%d: %s - %s - %s - %s";
                // Format the String 'output', replacing placeholders with values
                System.out.println(String.format(output, ++count, fullname, occupation, vehicle, weight));
            }
        } catch (SQLException ex) {
            System.out.println(" ! Exception: " + ex.getMessage());
        }
    }

    /**
     * Updates entry of table 'people' selecting by fullname
     * @param connection - session with database
     * @param full - name of the person, which entry must be updated
     * @param occupation - occupation of the person
     * @param vehicle - vehicle of the person
     * @param weight - weight of the person in kg
     * @throws SQLException
     */
    public static void update(Connection connection, String fullname, String occupation, String vehicle, float weight) {
        try {
            // String that includes update SQL script with '?' placeholders which will be replaced by PreparedStatement methods
            String sql = "UPDATE people SET occupation=?, vehicle=?, weight=? WHERE fullname=?";

            // Prepare the SQL script, replacing all '?' placeholders
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, occupation);
            statement.setString(2, vehicle);
            statement.setFloat(3, weight);
            statement.setString(4, fullname);

            // executeUpdate() returns the number of rows affected by the script. 1 row for each updated entry is expected
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println(" * An existing entry for " + fullname + " was updated successfully!");
            } else {
                System.out.println(" * No entry to update!");
            }
        } catch (SQLException ex) {
            System.out.println(" ! Exception: " + ex.getMessage());
        }
    }

    /**
     * Deletes entry of table 'people' selecting by fullname
     * @param connection - session with database
     * @param fullname - fullname of the person which entry must be deleted
     * @throws SQLException
     */
    public static void delete(Connection connection, String fullname) {
        try {
            // String that includes delete SQL script with '?' placeholder which will be replaced by PreparedStatement methods
            String sql = "DELETE FROM people WHERE fullname=?";

            // Prepare the SQL script, replacing '?' placeholder
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, fullname);

            // executeUpdate() returns the number of rows affected by the script. 1 row for each updated entry is expected
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println(" * An entry was deleted successfully!");
            } else {
                System.out.println(" * No entry to delete!");
            }
        } catch (SQLException ex) {
            System.out.println(" ! Exception: " + ex.getMessage());
        }
    }

    /**
     * Utility function which checks if entry is present in the table 'people'
     * @param connection-  session with database
     * @param fullname - fullname of the person which entry must be looked up
     * @return
     */
    public static boolean entryExists(Connection connection, String fullname) {
        boolean exists = false;
        try {
            String sql = "SELECT * FROM people WHERE fullname=?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, fullname);
            ResultSet result = statement.executeQuery();

            if (!result.isBeforeFirst()) {
                exists = false;
            } else {
                exists = true;
            }
        } catch (SQLException ex) {
            System.out.println(" ! Exception: " + ex.getMessage());
            ex.printStackTrace();
        }
        return exists;
    }
}