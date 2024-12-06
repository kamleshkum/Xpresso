package com.xpresso.qa.pages.services.careInsurance;

import java.sql.*;

public class DbClass {

  private static final String DB_URL = "jdbc:sqlserver://103.231.41.61;databaseName=XPRESSO_UAT;encrypt=false";
  private static final String USER = "sa";
  private static final String PASS = "UAT_R0INET_SQL";
  private Connection connection;

  public DbClass() {
      try {
          System.out.println("Attempting to connect to the database...");
          connection = DriverManager.getConnection(DB_URL, USER, PASS);

          if (connection != null) {
              System.out.println("Connection established successfully.");
          } else {
              System.out.println("Connection failed. Connection object is null.");
          }
      } catch (SQLException e) {
          System.out.println("Error establishing connection: " + e.getMessage());
          System.out.println("SQL State: " + e.getSQLState());
          e.printStackTrace();
      }
  }


  public ResultSet executeQuery(String query) {
      ResultSet resultSet = null;
      
      if (connection == null) {
	        System.out.println("Error: Database connection is null. Cannot create Statement.");
	        return null;
	    }

    
    try {
      Statement stmt = connection.createStatement();
      resultSet = stmt.executeQuery(query);
    } catch (SQLException e) {
	System.out.println("Error creating statement or executing query: " + e.getMessage());
        System.out.println("SQL State: " + e.getSQLState());      e.printStackTrace();
    }
    return resultSet;
  }

  public int executeUpdate(String query, Object... params) {
    int result = 0;
    try (PreparedStatement pstmt = connection.prepareStatement(query)) {
      for (int i = 0; i < params.length; i++) {
        pstmt.setObject(i + 1, params[i]);
      }
      result = pstmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return result;
  }

  public ResultSet executePreparedQuery(String query, Object... params) {
    ResultSet resultSet = null;
    try {
      PreparedStatement pstmt = connection.prepareStatement(query);
      for (int i = 0; i < params.length; i++) {
        pstmt.setObject(i + 1, params[i]);
      }
      resultSet = pstmt.executeQuery();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return resultSet;
  }

}
