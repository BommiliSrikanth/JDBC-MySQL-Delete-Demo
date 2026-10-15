// JDBC Demo: Delete a record from MySQL using PreparedStatement with WHERE condition
// Uses try-with-resources for automatic resource management

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCDeleteDemo {

    // Step-2: JDBC connection constants
    // Change these values according to your MySQL setup
    private static final String JDBC_URL  = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USERNAME  = "root";          // your MySQL username
    private static final String PASSWORD  = "password";      // your MySQL password

    public static void main(String[] args) {

        // Step-3: try-with-resources for Connection
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {

            System.out.println("Connected to MySQL database successfully!");

            // Step-4: DELETE query with WHERE condition
            String deleteSQL = "DELETE FROM users WHERE id = ?";

            // Step-5: Create PreparedStatement and set the parameter (id = 2)
            try (PreparedStatement deleteStmt = connection.prepareStatement(deleteSQL)) {
                deleteStmt.setInt(1, 2);   // user ID = 2

                // Step-6: Execute the DELETE and get number of rows affected
                int rowsAffected = deleteStmt.executeUpdate();

                // Step-7: Display appropriate message
                if (rowsAffected > 0) {
                    System.out.println("Row deleted successfully.");
                    System.out.println("Number of rows deleted: " + rowsAffected);
                } else {
                    System.out.println("No rows were deleted.");
                }
            }

        } catch (SQLException e) {
            // Step-8: Handle SQLException
            System.err.println("SQLException occurred!");
            System.err.println("Error Message : " + e.getMessage());
            System.err.println("SQL State     : " + e.getSQLState());
            System.err.println("Error Code    : " + e.getErrorCode());
            e.printStackTrace();
        }
        // Step-9: Resources are automatically closed by try-with-resources
    }
}
