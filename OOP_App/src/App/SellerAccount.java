package App;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class SellerAccount extends Account implements Serializable {

	double monthlyRevenue;
	double monthlyIncome;
	double yearlyRevenue;
	double yearlyIncome;
	public ArrayList<Product> itemsSold = new ArrayList<Product>();
	
	
	public SellerAccount(String auserName, String apassWord, String afirstName, String alastName,
			double amonthlyRevenue, double amonthlyIncome, double ayearlyRevenue, double ayearlyIncome) {
		super(auserName, apassWord, afirstName, alastName);
		
		monthlyRevenue = amonthlyRevenue;
		monthlyIncome = amonthlyIncome;
		yearlyRevenue = ayearlyRevenue;
		yearlyIncome = ayearlyIncome;
		
	}
	
	
	public String totalItemsSold() {
		int temp =0;
		for(int i =0; i < itemsSold.size();i++) {
			temp = temp + itemsSold.get(i).quantity;
		}
		
		return Integer.toString(temp);
	}
	
	public String calculateYearlyRevenue() {
		
		double temp =0;
		Date tempYear = new Date();
		for(int i =0; i < itemsSold.size();i++) {
			
			if(itemsSold.get(i).date.getYear() == tempYear.getYear()) {
				temp = temp + itemsSold.get(i).price*itemsSold.get(i).quantity;
			}
			
		}
		return String.format("%.2f", temp);
	}
	
	public String calculateYearlyIncome() {
		
		double temp =0;
		double temp1 = 0;
		Date tempYear = new Date();
		for(int i =0; i < itemsSold.size();i++) {
			
			if(itemsSold.get(i).date.getYear() == tempYear .getYear()) {
				temp = temp + itemsSold.get(i).price*itemsSold.get(i).quantity;
				temp1 = temp1 + itemsSold.get(i).cost*itemsSold.get(i).quantity;
		
			}
		}
		
		
		return String.format("%.2f", temp-temp1);
	}
	
	public String calculateMonthlyRevenue() {
		
		double temp =0;
		Date tempMonth = new Date();
		for(int i =0; i < itemsSold.size();i++) {
			if(itemsSold.get(i).date.getMonth() == tempMonth.getMonth()) {
				temp = temp + itemsSold.get(i).price*itemsSold.get(i).quantity;
			}
		}
		return String.format("%.2f", temp);
	}
	
	public String calculateMonthlyIncome() {
		
		double temp =0;
		double temp1 = 0;
		Date tempMonth = new Date();
		for(int i =0; i < itemsSold.size();i++) {
			if(itemsSold.get(i).date.getMonth() == tempMonth.getMonth()) {
				
			temp = temp + itemsSold.get(i).price*itemsSold.get(i).quantity;
			temp1 = temp1 + itemsSold.get(i).cost*itemsSold.get(i).quantity;
			}
		}
		
		
		
		return String.format("%.2f", temp-temp1);
	}
	

}
