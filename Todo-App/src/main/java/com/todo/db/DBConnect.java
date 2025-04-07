package com.todo.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
    public static Connection getConn() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/todo", "root", "Mysqldatabase++");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

}
