package org.example.lesson4.util;

import org.example.lesson4.exception.DataProcessingException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class ConnectionUtil {
    private static final String DB_URL = "jdbc:sqlite:mydatabase.db";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(DB_URL);
        } catch (SQLException e) {
            throw new DataProcessingException("Unable get connection to DB", e);
        }
    }

    public static void migration(){
        Connection connect = getConnection();

        String checkTableQuery = "SELECT name FROM sqlite_master WHERE type='table' AND name=?";

        try (PreparedStatement prStatement = connect.prepareStatement(checkTableQuery)) {

            String tableName = "users";
            prStatement.setString(1, tableName);

            String createTableQuery = "CREATE TABLE users (id INTEGER PRIMARY KEY, email VARCHAR(225),phoneNumber VARCHAR(15), password VARCHAR(20), repeatPassword VARCHAR(20))";

            try (ResultSet result = prStatement.executeQuery()) {
                if (!result.next()) {
                    System.out.println("Table " + tableName + " does not exist.");

                    try (PreparedStatement createTableStmt = connect.prepareStatement(createTableQuery)) {
                        createTableStmt.executeQuery();
                        System.out.println("Table " + tableName + " has been created.");
                    } catch (SQLException e) {
                        throw new DataProcessingException("Unable to create table " + tableName, e);
                    }
                }
            } catch (SQLException e) {
                throw new DataProcessingException("Failed execute query", e);
            }

        } catch (SQLException e) {
            throw new DataProcessingException("Unable get connection to DB", e);
        }
    }
}
