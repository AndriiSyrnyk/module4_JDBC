package javadeveloper.module4;

import java.sql.*;

public class Database {
    private static final Database INSTANCE = new Database();
    private Connection connection;
    private Database()  {
        String connectionUrl = "jdbc:h2:./megasoft";
        try {
            connection = DriverManager.getConnection(connectionUrl, "sa", "");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Database getInstance() {
        return INSTANCE;
    }

    public Connection getConnection() {
        return connection;
    }

    public int executeUpdate(String sql) {
        try {
            Statement st = connection.createStatement();
            return st.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet executeQuery(String sql) {
        try {
            Statement st = connection.createStatement();
            return st.executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}