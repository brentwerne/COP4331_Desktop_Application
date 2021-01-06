package App;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class BuyerAccount extends Account implements Serializable {
	
	ArrayList<PastOrder> orderHistory = new ArrayList<PastOrder>();
		
	public BuyerAccount(String auserName, String apassWord, String afirstName, String alastName) {
		super(auserName, apassWord, afirstName, alastName);
		
	

		
	}

	
}
