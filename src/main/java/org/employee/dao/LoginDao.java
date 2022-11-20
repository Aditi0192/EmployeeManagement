package org.employee.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {
	
	public static boolean validate(String uname,String upass){  
		 boolean status=false;  
		  try{  
		   Class.forName("com.mysql.jdbc.Driver");  
		   Connection con=DriverManager.getConnection(  
		   "jdbc:mysql://localhost/newemployee?useSSL=false", "root", "sqlroot");  
		     
		   PreparedStatement ps=con.prepareStatement(  
		     "select * from employee where emp_name=? and passwords=?");  
		   ps.setString(1,uname);  
		   ps.setString(2,upass);  
		   ResultSet rs=ps.executeQuery();  
		   status=rs.next();  
		  }catch(Exception e){e.printStackTrace();}  
		 return status;  
		}  

}
