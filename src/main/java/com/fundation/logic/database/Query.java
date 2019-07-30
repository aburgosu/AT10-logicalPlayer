/**
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.fundation.logic.database;

import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Implements insert in a table.
 *
 * @author Andres Burgos, Jesus Menacho, Melissa Román
 * @version 1.0
 */
public class Query {
    /**
     * This method inserts information from name and json to Data Base
     */
    public void insertCriteria(String name, String json) {
        String sql = "INSERT INTO criterias(name, date, json) VALUES(?,?,?)";
        try {
            Timestamp current = Timestamp.valueOf(LocalDateTime.now());
            long dateLong = current.getTime();
            System.out.println("date saved: " + dateLong);
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setLong(2, dateLong);
            statement.setString(3, json);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    /**
     * This method allows to get all data from the database.
     */
    public List getAllCriteria() {
        List<String> infCriteria = new ArrayList<String>();
        String sql = "SELECT * FROM criterias";
        try {
            Connection conn = DBConnection.getInstance().getConnection();
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                infCriteria.add(result.getInt("id") + "\t" + result.getString("name") + "\t"
                        + result.getDate("date") + "\t" + result.getString("json"));
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return infCriteria;
    }

    /**
     * This method deletes registers according to id from the table database.
     */
    public void deleteByIde(String ID) {
        String sql = "DELETE FROM criterias WHERE id = ?";
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, ID);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    /**
     * This method filters registers in database that are between two dates.
     */
    public List filterByDates(long firstDate, long secondDate) {
        List<String> infCriteria = new ArrayList<>();
        String sql = "SELECT * FROM criterias WHERE date >= ? AND date <= ?";
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, firstDate);
            statement.setLong(2, secondDate);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                infCriteria.add(result.getInt("id") + "\t" + result.getString("name") + "\t"
                        + result.getDate("date") + "\t" + result.getString("json"));
            }
        } catch (SQLException e) {
                e.getMessage();
        }
        return infCriteria;
    }
}
