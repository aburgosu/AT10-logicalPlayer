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
/**
 * Implements insert in a table .
 *
 * @author Andres Burgos, Jesus Menacho
 * @version 1.0
 */
public class Query {

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

    public void selectAllCriterias() {
        String sql = "SELECT * FROM criterias";
        try {
            Connection conn = DBConnection.initConnection();
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                System.out.println(result.getInt("name") + "\t" + result.getString("date") + "\t" + result.getDouble("json"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void main(String arg[]){
        Query query=new Query();
        query.selectAllCriterias();
    }
}