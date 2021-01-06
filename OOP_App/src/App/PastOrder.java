package App;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class PastOrder implements Serializable{

	private Date date;
	private String totalCost;
	private String totalQuantity;
	
	public PastOrder(Date adate, String atotalCost, String atotalQuantity) {
		
		date = adate;
		totalCost = atotalCost;
		totalQuantity = atotalQuantity;
		
	}
	
	public String returnDate() {
        DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
        return dateFormat.format(date);
	}
	
	public String getCost() {
		return totalCost;
	}
	
	public String getQuantity() {
		return totalQuantity;
	}
	
	
}
