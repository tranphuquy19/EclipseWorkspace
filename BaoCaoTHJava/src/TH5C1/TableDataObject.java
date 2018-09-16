package TH5C1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TableDataObject {
	String connectionUrl = "jdbc:sqlserver://localhost:1433;" +  
	         "integratedSecurity=True";  //databaseName=Master;
	
	      Connection con = null;  
	      Statement stmt = null;  
	      ResultSet rs = null;
	      public TableDataObject()
	      {
	    	  Setup();
	      }
	      public TableDataObject(String databaseName)
	      {
	    	  connectionUrl += ";databaseName="+databaseName;   	  
	    	  Setup();
	      }
	      private void Setup()
	      {
	    	  try {
	    		  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
		          con = DriverManager.getConnection(connectionUrl);  
		          stmt = con.createStatement();  
	    	  }catch(Exception ex)
	    	  {
	    		  ex.printStackTrace();
	    	  }
	      }
	      public ResultSet toResultset(String sql)
	      {
	    	  ResultSet rs2 = null;
	    	  try {
	    		  rs2 = stmt.executeQuery(sql);
	    	  }catch(Exception ex)
	    	  {
	    		  ex.printStackTrace();
	    	  }
	    	  return rs2;
	      }
}
