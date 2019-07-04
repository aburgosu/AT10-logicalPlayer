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

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Implements insert in a table .
 *
 * @author Andres Burgos, Jesus Menacho
 * @version 1.0
 */
public class Query {
    /**
     * This method inster informations from name and json to Data Base
     */
    public void insertCriteria(String name, String json) {
        String sql = "INSERT INTO criterias(name, date, json) VALUES(?,?,?)";
        try {
            Connection connection =DBConnection.initConnection();
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
     * This method show informations from the table criteria.
     */
    public List showAllCriterias() {
        List<String> infCriterias = new ArrayList<String>();
        String sql = "SELECT * FROM criterias";
        try {
            Connection conn = DBConnection.initConnection();
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                infCriterias.add(result.getInt("id") + "\t" +result.getString("name") + "\t" + result.getDate("date") + "\t" + result.getString("json"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return infCriterias;
    }
    /**
     * This method delete informations acording a id from the table criteria.
     */
    public void deleteByIde(String ID) {
        String sql = "DELETE FROM criterias WHERE id = ?";
        try {
            Connection connection =DBConnection.initConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, ID);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.getMessage();
        }
    }
}
