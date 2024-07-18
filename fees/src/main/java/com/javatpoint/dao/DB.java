package com.javatpoint.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
    public static Connection getCon() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fees", "root", "root");
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return con;
    }
}
