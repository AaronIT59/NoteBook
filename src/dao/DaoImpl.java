package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.tbl_profile;

public class DaoImpl {
	
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
			pst.executeUpdate();
			pst.close();			
			return true;
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	
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

	//Lấy thông tin cá nhân
	public tbl_profile getProfile(String email, String pass) {
		tbl_profile pro = null;
		try {
			Connection conn = ConnectDB();
			PreparedStatement pst = conn.prepareStatement("select * from tbl_profile where email_mobile=? and password=?");
			pst.setString(1, email);
			pst.setString(2, pass);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				pro = new tbl_profile(rs.getInt("id"), 
						rs.getString("first_name"), 
						rs.getString("last_name"), 
						rs.getString("email_mobile"),
						rs.getString("password"),
						rs.getString("birthday"), 
						rs.getString("sex"), 
						rs.getString("avatar"));
			}
			
			return pro;
			
		} catch (Exception e) {
			System.out.println("loi ko lay dc profile");
		}
		
		return null;
	}
	
	
	public tbl_profile checklogin(String email,String pass) {
		return getProfile(email, pass);	
	}

	// Lấy danh sách bạn bè
	public List<tbl_profile> getConnectFriend(int ids) {
		List<tbl_profile> listf = new ArrayList<tbl_profile>();		
		try {
			Connection conn = ConnectDB();			
			PreparedStatement pst = conn.prepareStatement("select * from tbl_profile where id = any(select friend_to from tbl_friends where me = ?)");
			pst.setInt(1, ids);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				
				tbl_profile pro = new tbl_profile(rs.getInt("id"), 
						rs.getString("first_name"), 
						rs.getString("last_name"), 
						rs.getString("email_mobile"),
						rs.getString("password"),
						rs.getString("birthday"), 
						rs.getString("sex"), 
						rs.getString("avatar"));
				
				listf.add(pro);		
				
			}
			
			return listf;
			
		} catch (Exception e) {
			System.out.println("loi them list");
		}
			
		return null;
	}
	
	// Lấy danh sách những người chưa kết bạn
	public List<tbl_profile> getFriend(int ids) {
		List<tbl_profile> listf = new ArrayList<tbl_profile>();		
		try {
			Connection conn = ConnectDB();			
			PreparedStatement pst = conn.prepareStatement("select * from tbl_profile where not id = any(select friend_to from tbl_friends where me = ?)");
			pst.setInt(1, ids);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				
				tbl_profile pro = new tbl_profile(rs.getInt("id"), 
						rs.getString("first_name"), 
						rs.getString("last_name"), 
						rs.getString("email_mobile"),
						rs.getString("password"),
						rs.getString("birthday"), 
						rs.getString("sex"), 
						rs.getString("avatar"));
				
				listf.add(pro);		
				
			}
			
			return listf;
			
		} catch (Exception e) {
			System.out.println("loi them list");
		}
			
		return null;
	}
	
	
	// Cập nhật thông tin 
	public boolean UpdateProfile(tbl_profile pro,int ids) {
		
		try {
			Connection conn = ConnectDB();
			PreparedStatement pst = conn.prepareStatement("update tbl_profile set first_name = ?,last_name = ?,email_mobile = ?,password = ?,birthday = ?,sex = ?,avatar=? where  id= ?");		
			pst.setString(1, pro.getFirst_name());
			pst.setString(2, pro.getLast_name());
			pst.setString(3, pro.getEmail_mobile());
			pst.setString(4, pro.getPassword());
			pst.setString(5, pro.getBirthday());
			pst.setString(6, pro.getSex());
			pst.setString(7, pro.getAvatar());
			pst.setInt(8, ids);
			pst.executeUpdate();			
			return true;

		} catch (Exception e) {
			System.out.println("Loi ko update profile");
		}
		return false;
	}

	// Đếm số bạn trong danh sách
	public int CountFriend(int ids) {
		Connection con = ConnectDB();

		try {
			PreparedStatement pst = con.prepareStatement("select count(id) from tbl_profile where id = any(select friend_to from tbl_friends where me =?)");
			pst.setInt(1, ids);
			ResultSet rs =  pst.executeQuery();
			while(rs.next()) {
				return rs.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Loi dem");
		}
		
		return 0;
	}
	
	// Lay Profile thong qua Email
	public tbl_profile getProfileByEmail(String email) {
		tbl_profile pro = null;
		try {
			Connection conn = ConnectDB();
			PreparedStatement pst = conn.prepareStatement("select * from tbl_profile where email_mobile=? ");
			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				pro = new tbl_profile(rs.getInt("id"), 
						rs.getString("first_name"), 
						rs.getString("last_name"), 
						rs.getString("email_mobile"),
						rs.getString("password"),
						rs.getString("birthday"), 
						rs.getString("sex"), 
						rs.getString("avatar"));
			}
			
			return pro;
			
		} catch (Exception e) {
			System.out.println("loi ko lay dc profile");
		}
		
		return null;
	}
	
}
