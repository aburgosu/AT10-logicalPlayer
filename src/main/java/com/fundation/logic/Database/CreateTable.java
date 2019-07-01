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
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Implements the creation of a table .
 *
 * @author Andres Burgos
 * @version 1.0
 */
public class CreateTable {
    public static void createTable(String database) {
        String url = "jdbc:sqlite:"+database;
        // SQL statement for creating a new table
        String sql =    "CREATE TABLE IF NOT EXISTS criterias (\n" 
                    +   " id integer PRIMARY KEY,\n"
                    +   " name text NOT NULL,\n" 
                    +   " date datetime NOT NULL,\n" 
                    +   " json text NOT NULL\n" 
                    +   ");";
        try {
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            statement.execute(sql);
            System.out.println("Table created");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
