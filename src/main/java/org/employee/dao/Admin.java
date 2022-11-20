package org.employee.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Admin {
	
	// method for create connection
		public static Connection getConnection() throws Exception {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				return DriverManager.getConnection("jdbc:mysql://localhost/newemployee?useSSL=false", "root", "sqlroot");
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}

		// method for save user data in database
		public int registerUser(String uname, String uemail, String upass,int sal, String udeg) throws Exception {
			int i = 0;
			try {
				String sql = "INSERT INTO employee VALUES (?,?,?,?,?)";
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setString(1, uname);
				ps.setString(2, uemail);
				ps.setString(3, upass);
				ps.setInt(4,sal);
				ps.setString(5, udeg);
				
				i = ps.executeUpdate();
				return i;
			} catch (Exception e) {
				e.printStackTrace();
				return i;
			} finally {
				if (getConnection() != null) {
					getConnection().close();
				}
			}
		}

		// method for fetch saved user data
		public ResultSet report() throws SQLException, Exception {
			ResultSet rs = null;
			try {
				String sql = "select emp_name,email,passwords, salary, designation from employee;";
				PreparedStatement ps = getConnection().prepareStatement(sql);
				rs = ps.executeQuery();
				return rs;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			} finally {
				if (getConnection() != null) {
					getConnection().close();
				}
			}
		}

		// method for fetch old data to be update
		public ResultSet fetchUserDetails(String uemail) throws SQLException, Exception {
			ResultSet rs = null;
			try {
				String sql = "select emp_name,email,passwords, salary, designation from employee where email = ?;";
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setString(1, uemail);
				rs = ps.executeQuery();
				return rs;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			} finally {
				if (getConnection() != null) {
					getConnection().close();
				}
			}
		}

		// method for update new data in database
		public int updateUserDetails(String uname, String uemail, String upass, String udeg,int sal, String uemailhidden)
				throws SQLException, Exception {
			getConnection().setAutoCommit(false);
			int i = 0;
			try {
				String sql = "UPDATE employee SET emp_name=?,email=?,passwords=?,salary=?,designation=? WHERE email=?";
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setString(1, uname);
				ps.setString(2, uemail);
				ps.setString(3, upass);
				ps.setInt(4, sal);
				ps.setString(5, udeg);
				ps.setString(6, uemailhidden);
				i = ps.executeUpdate();
				return i;
			} catch (Exception e) {
				e.printStackTrace();
				getConnection().rollback();
				return 0;
			} finally {
				if (getConnection() != null) {
					getConnection().close();
				}
			}
		}

		// method for delete the record
		public int deleteUserDetails(String uemail) throws SQLException, Exception {
			getConnection().setAutoCommit(false);
			int i = 0;
			try {
				String sql = "DELETE FROM employee WHERE email=?";
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setString(1, uemail);
				i = ps.executeUpdate();
				return i;
			} catch (Exception e) {
				e.printStackTrace();
				getConnection().rollback();
				return 0;
			} finally {
				if (getConnection() != null) {
					getConnection().close();
				}
			}
		}
	

}
