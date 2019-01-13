package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseConnection {
    final String url="jdbc:mysql://localhost:3306/quiz";
    final String user = "root";
    final String password = "";
    Connection connection = null;

    /**
     * Constructor to establish database connection
     */
    public DatabaseConnection() {
        try {
            connection = connection = DriverManager.getConnection(url, user, password);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to get PreparedStatement
     * @param query
     * @return
     */
    public PreparedStatement getPreparedStatement(String query) {
        PreparedStatement pstm = null;
        try {
            pstm = connection.prepareStatement(query);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return pstm;
    }
}
