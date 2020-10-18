package com.abhi.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
public class TestJDBC {

	public static void main(String[] args) {
		String jdbcURL = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String user="hbstudent";
		String pass="hbstudent";
		try {
         System.out.println("Connection to database"+jdbcURL);
         Connection  con=DriverManager.getConnection(jdbcURL,user,pass);
          if(con!=null) {
        	  System.out.println("Connection successfully Established");
          }
          else {
        	  System.out.println("Not Established the Connection");
          }
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
