package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
}
