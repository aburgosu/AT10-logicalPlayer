/**
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * (" Confidential Information"). You shall not
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
 * Implements insert in a table .
 *
 * @author Andres Burgos, Jesus Menacho
 * @version 1.0
 */
public class DBConnection {

    private static DBConnection dbcon = new DBConnection();
    private static Connection conn;

    private DBConnection(){
        initConnection();
    }

    private static DBConnection getInstance(){
        if (dbcon == null){
            dbcon = new DBConnection();
        }
        return dbcon;
    }

    public static Connection initConnection(){
        String file="AT10-player.db";
        String url ="jdbc:sqlite:" + file;
        try {
            conn=DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.getMessage();
        }
        String sql =    "CREATE TABLE IF NOT EXISTS criterias (\n"
                +   " id integer PRIMARY KEY,\n"
                +   " name text NOT NULL,\n"
                +   " date datetime NOT NULL,\n"
                +   " json text NOT NULL\n"
                +   ");";

        try {
            Connection connection = conn;
            Statement statement = connection.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            e.getMessage();
        }
        return conn;
    }
}