package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class ConnectionFactory {
    private static Connection connection = null;

    //A String db representa o banco de dados que será usado na conexão
    public static Connection getConnection(String db) {
        try {
            if (connection != null) {
                closeConnection(connection);
            }

            Properties properties = loadProperties();
            String url = properties.getProperty("dburl");
            connection = DriverManager.getConnection(url, properties);
            useDataBase(db);

            return connection;
        } catch (SQLException throwables) {
            throw new DBException(throwables.getMessage());
        }
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throw new DBException(throwables.getMessage());
            }
        }
    }

    public static void closeStatement(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException throwables) {
                throw new DBException(throwables.getMessage());
            }
        }
    }

    public static void closeResultSet(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throw new DBException(throwables.getMessage());
            }
        }
    }

    private static void useDataBase(String db) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.execute("USE " + db);
        } catch (SQLException throwables) {
            throw new DBException(throwables.getMessage());
        } finally {
            closeStatement(statement);
        }
    }

    private static Properties loadProperties() {
        try(FileInputStream fs = new FileInputStream("src/db.properties")){
            Properties properties = new Properties();
            properties.load(fs);
            return properties;
        } catch (IOException e) {
            throw new DBException(e.getMessage());
        }
    }
}
