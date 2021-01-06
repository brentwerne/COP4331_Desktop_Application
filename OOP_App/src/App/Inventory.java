package App;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;

import javax.swing.*;


public class Inventory {
	
	SerilizationList<Product> inv = new SerilizationList<Product>("InventoryList.ser");
    LinkedList<ProductView> t = new LinkedList<ProductView>();
	ArrayList<JButton> editInv = new ArrayList<JButton>();
	ArrayList<JButton> deleteInv = new ArrayList<JButton>();
	ArrayList<JButton> addInv = new ArrayList<JButton>();
	
	public Inventory() {
    	//Loads inventory into Inventory List
		inv.load();
	}
	
	//display for seller
	public void displayInv(JLabel label, Color backGround, int width, String sellerName) {
		
		int j = (int) Math.floor(width/280);
		int k;
		int x = 10;
		int y = 20;
		int i2 = 0;
		
		//editInv.clear();
		//deleteInv.clear();
		
		for(int i = 0; i < inv.size(); i++) {
			if(inv.get(i).sellerName.equals(sellerName)) {
				
				
				k = (int) Math.floor(i2/j);
				y = 20 + 160*k;
				x = 10*(i2%j+1) + 270*(i2%j);
				
				ProductView temp = new ProductView(inv.get(i), backGround, x, y);
				JButton temp1 = new JButton("Edit");
				JButton temp2 = new JButton("Delete");
				
				temp1.setBounds(30, 105, 90,25);
				temp2.setBounds(130, 105, 90, 25);
				
				
				editInv.add(temp1);
				deleteInv.add(temp2);
				
				
				temp.add(editInv.get(i2));
				temp.add(deleteInv.get(i2));
				
				i2 = i2 +1;
				t.add(temp);

			}
			
		}
		
		for(int i = 0; i < t.size(); i++) {
			label.add(t.get(i));

		}
	}
	
	
	
	public void removeInv(JLabel label) {
		
		for(int i = 0; i < t.size(); i++) {
			try {
				label.remove(0);
			} catch(Exception e) {
				
			}
			
		}
		
		t.clear();
		
		
	}
	
	
	//display inventory for buyer
	public void displayShopping(JLabel label, Color backGround, int width) {
		
		int j = (int) Math.floor(width/280);
		int k;
		int x = 10;
		int y = 20;
		
		
		
		for(int i = 0; i < inv.size(); i++) {
		
			k = (int) Math.floor(i/j);
			y = 20 + 160*k;
			
			
			x = 10*(i%j+1) + 270*(i%j);
			
			ProductView temp = new ProductView(inv.get(i), backGround, x, y);
			JButton temp1 = new JButton("Add Item");
			
			temp1.setBounds(85, 105, 110,25);
			
			addInv.add(temp1);
			
			temp.add(temp1);
			t.add(temp);

			
		}
		
		for(int i = 0; i < t.size(); i++) {
			label.add(t.get(i));

		}
	}
	
	//display for buyer
		public void displaySearch(ShoppingCart shopping, ShoppingView letsShop, JLabel label, Color backGround, int width, String search) {
			int j = (int) Math.floor(width/280);
			int k;
			int x = 10;
			int y = 20;
			int i2 = 0;
			
			
			if(search.equals("")) {
				this.displayShopping(label, backGround, width);
			}else {
				for(int i = 0; i < inv.size(); i++) {
					int n = 0;
					int m = 0;
					while(n+m < inv.get(i).title.length()) {
						if(search.charAt(m) == inv.get(i).title.charAt(n+m)) {
							m = m+1;
							if(m == search.length()) {
								k = (int) Math.floor(i2/j);
								y = 20 + 160*k;
								
								
								x = 10*(i2%j+1) + 270*(i2%j);
								
								ProductView temp = new ProductView(inv.get(i), backGround, x, y);
								JButton temp1 = new JButton("Add Item");
							
								temp1.setBounds(85, 105, 110,25);
								
								addInv.add(temp1);
									
								temp.add(temp1);
								t.add(temp);
								
								final int i3 = i2;
								
								addInv.get(j).addActionListener(e1 ->{
									letsShop.confirmation( this, shopping, i3, backGround);
								});
								
								i2 = i2 + 1;
								m = inv.get(i).title.length() + 1;
							}
						}else {
							m = 0;
							n = n+1;
						}
							

					
					}
				}

				for(int i = 0; i < t.size(); i++) {
					label.add(t.get(i));

				}
						
			}
				

			
			
			

		
		}
		
		public void removeAllActions() {
			for(int i = 0; i < editInv.size(); i++) {
			    editInv.get(i).removeActionListener(editInv.get(i).getAction());
			}
			for(int i = 0; i < deleteInv.size(); i++) {
			    deleteInv.get(i).removeActionListener(deleteInv.get(i).getAction());
			}
			for(int i = 0; i < addInv.size(); i++) {
			    addInv.get(i).removeActionListener(addInv.get(i).getAction());
			}
			editInv.clear();
			deleteInv.clear();
			addInv.clear();
			
		}
		

}
