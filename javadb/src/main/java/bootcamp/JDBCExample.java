package bootcamp;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *  JDBCExample works with a database, which contains a table created by script below:
 *
 *  CREATE TABLE people (
 *    fullname varchar (45) NOT NULL,
 *    occupation varchar (45) NOT NULL,
 *    vehicle varchar (45) NOT NULL,
 *    weight decimal (6,3) NOT NULL,
 *    updated_last date NOT NULL,
 *    PRIMARY KEY (fullname)
 *    );
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

        // Specify the URL to database for PostgreSQL
        // String dbURL = "jdbc:postgresql://localhost:PORT/DATABASE_NAME?useSSL=false";

        // Specify the user and password to connect to database
        String username = "USERNAME";
        String password = "PASSWORD";

        try {
            // Load and register JDBC driver for MySQL
            Class.forName("com.mysql.jdbc.Driver");

            // Load and register JDBC driver for PostgreSQL
            // Class.forName("org.postgresql.Driver");

            // Establish the connection with database
            Connection connection = openConnection(dbURL, username, password);

            // Insert couple of entries
            insert(connection, "Sterling B. Rosario", "Public affairs specialist", "2011 Bentley Continental GTC", 72.2f);
            insert(connection, "Amber M. Doss", "Tour escort", "2011 Alpina B5", 63.4f);
            insert(connection, "Erik M. Robinson", "Logistician", "2004 Lincoln Town Car", 78.5f);
            insert(connection, "Eugene L. Johnson", "Systems software engineer", "2010 Toyota Aygo", 87.1f);

            // Display the contents of database table
            select(connection);

            // Update one of the entries by fullname
            update(connection, "Eugene L. Johnson", "Systems software engineer (senior)", "2010 Toyota Aygo", 87.1f);

            // Display the contents of database table
            select(connection);

            // Delete entries
            delete(connection, "Sterling B. Rosario");
            delete(connection, "Amber M. Doss");
            delete(connection, "Erik M. Robinson");
            delete(connection, "Eugene L. Johnson");

            // Display the contents and see that its empty
            select(connection);

            // Close the connection with database
            closeConnection(connection);

        } catch (SQLException ex) {
            // SQLException can be thrown while working with Connection and Statement/PreparedStatement
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            // ClassNotFoundException is thrown if driver is not properly loaded
            e.printStackTrace();
        }
    }

    /**
     * Established the connection with given dbURL
     * @param dbURL - string containing the URL to database
     * @param username - string containing the username
     * @param password - string containing the password for a username
     * @return Connection - an established database connection (session)
     * @throws SQLException
     */
    public static Connection openConnection(String dbURL, String username, String password) throws SQLException {
        Connection connection = DriverManager.getConnection(dbURL, username, password);
        if (connection != null) {
            System.out.println("Connection established.");
        }
        return connection;
    }

    /**
     * Closes the connection with database
     * @param connection - an established database connection (session)
     * @throws SQLException
     */
    public static void closeConnection(Connection connection) throws SQLException {
        connection.close();
        if (connection.isClosed()) {
            System.out.println("Connection closed.");
        }
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
    public static void insert(Connection connection, String fullname, String occupation, String vehicle, float weight) throws SQLException {
        // String that includes insert SQL script with '?' placeholders which will be replaced by PreparedStatement methods
        String sql = "INSERT INTO people (fullname, occupation, vehicle, weight, updated_last) VALUES (?, ?, ?, ?, ?)";

        // Create a SQL date using java.util.date
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date updatedLast = new java.sql.Date(utilDate.getTime());

        // Prepare the SQL script, replacing all '?' placeholders
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, fullname);
        statement.setString(2, occupation);
        statement.setString(3, vehicle);
        statement.setFloat(4, weight);
        statement.setDate(5, updatedLast);

        // executeUpdate() returns the number of rows affected by the script. 1 row for each updated entry is expected
        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("A new entry was inserted successfully!");
        } else {
            System.out.println("Failure during an insert of an entry!");
        }
    }

    /**
     * Selects and displays all data from table 'people'
     * @param connection - session with database
     * @throws SQLException
     */
    public static void select(Connection connection) throws SQLException {
        // String that includes SQL script for select all entries (* - wildcard/all)
        String sql = "SELECT * FROM people";

        // As this SQL script is hardcoded and no input from the user is possible, we can use Statement instead of Prepared statement
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sql);

        int count = 0;

        System.out.println("Executing 'SELECT * FROM people'. Result: ");

        // If SELECT returns nothing, inform about it
        if (!result.isBeforeFirst()) {
            System.out.println("No data was return during this SELECT!");
        }

        // If SELECT returns a result, display information on every entry
        while (result.next()){
            String fullname = result.getString(2);
            String occupation = result.getString(3);
            String vehicle = result.getString("vehicle");
            float weight = result.getFloat("weight");
            java.sql.Date updatedLast = result.getDate("updated_last");

            // Prepare the String with placeholders '%d' for numeric value and '%s' for a String value
            String output = " - Person #%d: %s - %s - %s - %s (Updated last on %s)";
            // Format the String 'output', replacing placeholders with values
            System.out.println(String.format(output, ++count, fullname, occupation, vehicle, weight, updatedLast));
        }
    }

    /**
     * Updates entry of table 'people' selecting by fullname
     * @param connection - session with database
     * @param name - name of the person, which entry must be updated
     * @param occupation - occupation of the person
     * @param vehicle - vehicle of the person
     * @param weight - weight of the person in kg
     * @throws SQLException
     */
    public static void update(Connection connection, String fullname, String occupation, String vehicle, float weight) throws SQLException {
        // String that includes update SQL script with '?' placeholders which will be replaced by PreparedStatement methods
        String sql = "UPDATE people SET occupation=?, vehicle=?, weight=?, updated_last=? WHERE fullname=?";

        // Create a SQL date using java.util.date
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date updatedLast = new java.sql.Date(utilDate.getTime());

        // Prepare the SQL script, replacing all '?' placeholders
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, occupation);
        statement.setString(2, vehicle);
        statement.setFloat(3, weight);
        statement.setDate(4, updatedLast);
        statement.setString(5, fullname);

        // executeUpdate() returns the number of rows affected by the script. 1 row for each updated entry is expected
        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("An existing entry for " + fullname + " was updated successfully!");
        } else {
            System.out.println("Failure during an update of an existing entry!");
        }
    }

    /**
     * Deletes entry of table 'people' selecting by fullname
     * @param connection - session with database
     * @param fullname - fullname of the person which entry must be deleted
     * @throws SQLException
     */
    public static void delete(Connection connection, String fullname) throws SQLException {
        // String that includes delete SQL script with '?' placeholder which will be replaced by PreparedStatement methods
        String sql = "DELETE FROM people WHERE fullname=?";

        // Prepare the SQL script, replacing '?' placeholder
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, fullname);

        // executeUpdate() returns the number of rows affected by the script. 1 row for each updated entry is expected
        int rowsDeleted = statement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("An entry was deleted successfully!");
        } else {
            System.out.println("Failure while deleting an entry!");
        }
    }
}