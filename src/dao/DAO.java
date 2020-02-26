package dao;

import entity.tbl_profile;

public interface DAO {
	public boolean checkLogin(String u , String p);
	public boolean SignIn(tbl_profile pro) ;
}
