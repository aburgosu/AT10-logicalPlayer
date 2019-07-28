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

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Implements insert in a table.
 *
 * @author Andres Burgos, Jesus Menacho
 * @version 1.0
 */
public class Query {
    /**
     * This method inserts information from name and json to Data Base
     */
    public void insertCriteria(String name, String json) {
        String sql = "INSERT INTO criterias(name, date, json) VALUES(?,?,?)";
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
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
                infCriteria.add(result.getInt("id") + "\t" + result.getString("name") + "\t" + result.getDate("date") + "\t" + result.getString("json"));
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
    public List filterByDates(String firstDate, String secondDate) {
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss zzz yyyy");
        try {
            DateFormat dateFormatStart = new SimpleDateFormat( "EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
            Date date1 = dateFormatStart.parse(firstDate);
            System.out.println(date1);
            DateFormat dateFormatEnd = new SimpleDateFormat( "EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
            Date date2 = dateFormatEnd.parse(secondDate);
            System.out.println(date2);
            List<String> infCriteria = new ArrayList<String>();
            String sql = "SELECT * FROM criterias WHERE date BETWEEN ? AND ?";
            try {
                Connection connection = DBConnection.getInstance().getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setDate(1, new java.sql.Date(date1.getTime()));
                statement.setDate(2, new java.sql.Date(date2.getTime()));
                ResultSet result = statement.executeQuery(sql);
                while (result.next()) {
                    infCriteria.add(result.getInt("id") + "\t" + result.getString("name") + "\t"
                            + result.getDate("date") + "\t" + result.getString("json"));
                }
            } catch (SQLException e) {
                e.getMessage();
            }
            return infCriteria;
        } catch(Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }
}
