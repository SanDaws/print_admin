package com.printadmin.persistance.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbcontext {
    //jdbc:mysql://HOST:PORT/DATABASE_NAME
    private static final String URL="jdbc:mysql://bvnqfza1h7mjqp1cboja-mysql.services.clever-cloud.com:3306/bvnqfza1h7mjqp1cboja";
    private static final String USER="ucp1werio5sstnfj";
    private static final String PASSWORD="oZkQQoAp2AcpDGHz19VN";
    
    private Dbcontext(){}

    public static Connection  getConeection() throws SQLException{
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

}
