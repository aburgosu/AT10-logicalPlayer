/**
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.fundation.logic.Database;

/**
 * Implements insert in a table .
 *
 * @author Andres Burgos
 * @version 1.0
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Query {

    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:at10-player.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void insertCriteria(String name, String date, String json) {
        String sql = "INSERT INTO criterias(name, date, json) VALUES(?,?,?)";

        try {
            Connection connection = this.connect();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, date);
            statement.setString(3, json);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void selectAllCriterias() {
        String sql = "SELECT * FROM criterias";
        try {
            Connection conn = this.connect();
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            // loop through the result set
            while (result.next()) {
                System.out.println(result.getInt("id") + "\t" + result.getString("name") + "\t" + result.getDouble("capacity"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
