package util;

public class Validate {

	public boolean checkFirstName(String name) {
		return name.matches("[\\p{L}\\s]{3,50}");
	}
	
	public boolean checkLastName(String name) {
		return name.matches("[\\p{L}\\s]{3,50}");
	}
	
	public  boolean checkEmailOrPhone(String emailOrPhone) {
		if(!emailOrPhone.matches("\\w+@\\w+[.]\\w"))
		{
			if(!emailOrPhone.matches("\\d{10,11}")) 
			{
				return false;
			}
		}
		return true;
	}
	
	public boolean checkPass(String pass) {
		return pass.matches("\\w{4,30}");
	}
}
