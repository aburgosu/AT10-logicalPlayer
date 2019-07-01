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
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Implements the connection for the Database.
 *
 * @author Andres Burgos
 * @version 1.0
 */
public class DatabaseConnection {
    public static void createNewDatabase(String fileName) {
        String url = "jdbc:sqlite:" + fileName;
        try {
            DriverManager.getConnection(url);
            
        } catch (SQLException e) {
            e.getMessage();
        }
    }
}
