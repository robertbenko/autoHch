package com.ibm.autochecker;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class SQLiteJDBC {

    static List<Employee> getAllEmployees() {

        Connection connection = null;
        Statement statement = null;

        try {

            connection = DriverManager.getConnection("jdbc:sqlite:test.db");
            connection.setAutoCommit(false);
            System.out.println("Opened database successfully");
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM COMPANY");

            final List<Employee> allEmployees = new ArrayList<>();

            while (rs.next()) {
                final Employee employee = new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("address"),
                        rs.getFloat("salary")
                );
                allEmployees.add(employee);
            }
            return allEmployees;

        } catch (final SQLException e) {
            throw new RuntimeException("unexpected database error", e);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (final SQLException e) {
                System.err.println(
                        "Error while closing resource: "
                                + e.getClass().getName() + " " + e.getMessage());
            }
        }
    }
}