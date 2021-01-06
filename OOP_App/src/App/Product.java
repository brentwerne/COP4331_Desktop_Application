package App;

import java.awt.Color;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.*;

public class Product implements Serializable{
	
	public String sellerName;
	public String path;
	public String title; 
	public Double price;
	public Double cost;
	public int quantity;
	public Date date;
	
	public Product(String asellerName, String apath, String atitle, String aprice, String acost, String aquantity) {
		
		sellerName = asellerName;
		path = "src/App/pic/"+apath;
		title = atitle;
		price = Double.parseDouble(aprice);
		cost = Double.parseDouble(acost);
		quantity = Integer.parseInt(aquantity);
		date = null;
		
	}
	public Product(Product prod) {
		
		sellerName = prod.sellerName;
		path = prod.path;
		title = prod.title;
		price = prod.price;
		cost = prod.cost;
		quantity = prod.quantity;
		date = null;
		
	}

	public void setDate() {
		date = new Date();
	}
	
	public String returnDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
	}
	
	
	
}
