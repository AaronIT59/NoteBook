package dao;

import java.util.List;
import entity.tbl_profile;

public interface DAO {
	public boolean checkLogin(String u , String p);
	public boolean SignIn(tbl_profile pro) ;
	public boolean checkEmail(String email);
	public tbl_profile getProfile(String email, String pass);
	public List<tbl_profile> getConnectFriend(tbl_profile tpro);
	public boolean UpdateProfile(tbl_profile pro,int ids);
}
