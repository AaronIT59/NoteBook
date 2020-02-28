package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import entity.tbl_profile;

public class DaoImpl implements DAO{
	
	public Connection ConnectDB() {
		String DB_URL = "jdbc:mysql://localhost:3306/NoteBook";
	    String USER_NAME = "root";
	    String PASSWORD = "root";
	    Connection conn = null;
	    try {
	    	Class.forName("com.mysql.cj.jdbc.Driver");
		    conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
	    
		return conn;
	}

	@Override
	public boolean checkLogin(String u, String p) {
		
		try {
			Connection conn = ConnectDB();
			PreparedStatement pst = conn.prepareStatement("select * from tbl_profile where email_mobile=? and password=?");
			pst.setString(1, u);
			pst.setString(2, p);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return false;
	}

	@Override
	public boolean SignIn(tbl_profile pro) {
		
		try {
			Connection conn = ConnectDB();
			PreparedStatement pst = conn.prepareStatement("insert into tbl_profile (first_name,last_name,email_mobile,password,birthday,sex) values (?,?,?,?,?,?) ");		
			pst.setString(1, pro.getFirst_name());
			pst.setString(2, pro.getLast_name());
			pst.setString(3, pro.getEmail_mobile());
			pst.setString(4, pro.getPassword());
			pst.setString(5, pro.getBirthday());
			pst.setString(6, pro.getSex());	
			pst.execute();
			
			return true;
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean checkEmail(String email) {
		try {
			Connection conn = ConnectDB();
			PreparedStatement pst = conn.prepareStatement("select * from tbl_profile where email_mobile= ?");
			pst.setString(1, email);
			
			if(pst.executeQuery().next())
			{
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return false;
	}
}
