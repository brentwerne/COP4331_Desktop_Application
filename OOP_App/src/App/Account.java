package App;

import java.io.Serializable;

public class Account implements Serializable{
	
	public String userName;
	public String passWord;
	public String firstName;
	public String lastName;

	
	public Account(String auserName, String apassWord, String afirstName, String alastName) {
		userName = auserName;
		passWord = apassWord;
		firstName = afirstName;
		lastName = alastName;

		
	}
	
	
	
	
}
