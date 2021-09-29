package database;

import java.sql.*;

public class AccessToDatabase {

    public Connection connection;
    public AccessToDatabase() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/office", "root", "root");
    }
}
