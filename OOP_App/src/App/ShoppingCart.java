package App;

import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JLabel;

public class ShoppingCart {
	
	SerilizationList<Product> shoppingCart;
	double total = 0;
	ArrayList<JButton> editQuantity = new ArrayList<JButton>();
	ArrayList<JButton> removeItem = new ArrayList<JButton>();
	LinkedList<ProductView> t = new LinkedList<ProductView>();
	
	public ShoppingCart() {
		
	}
	
	public void load(String user) {
		shoppingCart = new SerilizationList<Product>(user + "ShoppingCart.ser");
		shoppingCart.load();
		for(int i =0; i < shoppingCart.size(); i++) {
			total = total + shoppingCart.get(i).price*shoppingCart.get(i).quantity;
		}
	}
	
	

	
	//adds product to shopping cart
	public void add(Product prod, String quantity) {
		if(Integer.parseInt(quantity) <= prod.quantity) {
			Product temp = new Product(prod);
			temp.quantity = Integer.parseInt(quantity);
			shoppingCart.add(temp);
			total = total + temp.price*temp.quantity;
			System.out.println(Double.toString(total));
			shoppingCart.save();
		}
	}
	
	//deletes product to shopping cart
	public void delete(Product prod) {
		shoppingCart.remove(prod);
		total = total - prod.price* prod.quantity;
		shoppingCart.save();
	}
	
	
	//display shopping cart for buyer
	public void displayShopping(JLabel label, Color backGround, int width) {
		
		int j = (int) Math.floor(width/280);
		int k;
		int x = 10;
		int y = 20;
		
		
		
		for(int i = 0; i < shoppingCart.size(); i++) {
		
			k = (int) Math.floor(i/j);
			y = 20 + 160*k;
			
			
			x = 10*(i%j+1) + 270*(i%j);
			
			ProductView temp = new ProductView(shoppingCart.get(i), backGround, x, y);
			temp.checkoutAddOn(shoppingCart.get(i));
			
			JButton temp1 = new JButton("Edit Quantity");
			temp1.setBounds(20, 105, 110,25);
			
			JButton temp2 = new JButton("Remove Item");
			temp2.setBounds(150, 105, 110,25);
			
			editQuantity.add(temp1);
			removeItem.add(temp2);
			
			temp.add(editQuantity.get(i));
			temp.add(removeItem.get(i));
			t.add(temp);
		
			
			
		}
		
		for(int i = 0; i < t.size(); i++) {
			label.add(t.get(i));

			
		}
	}
	
	public void edit(Product prod, Product prod1, String quantity, int i) {
		if(Integer.parseInt(quantity) <= prod1.quantity) {
			prod.quantity = Integer.parseInt(quantity);
			shoppingCart.set(i, prod);
			total = 0;
			for(int j = 0; j < shoppingCart.size(); j++) {
				total = total + shoppingCart.get(j).price*shoppingCart.get(j).quantity;
			}
			shoppingCart.save();
		}
		
	}
	
	public void removeInv(JLabel label) {
		
		for(int i = 0; i < t.size(); i++) {
			label.remove(0);
		}
		
		t.clear();
		
		
	}
	
	public void delete(int i) {
		shoppingCart.remove(i);
		total = 0;
		for(int j = 0; j < shoppingCart.size(); j++) {
			total = total + shoppingCart.get(j).price*shoppingCart.get(j).quantity;
		}
		System.out.println(Double.toString(total));
		shoppingCart.save();
		
		
	}
	
	public void removeAllActions() {
		for(int i = 0; i < editQuantity.size(); i++) {
			editQuantity.get(i).removeActionListener(editQuantity.get(i).getAction());
		}
		for(int i = 0; i < removeItem.size(); i++) {
			removeItem.get(i).removeActionListener(removeItem.get(i).getAction());
		}
		editQuantity.clear();
		removeItem.clear();

		
	}
	
	public String getTotal() {
		return String.format("%.2f",total);
	}
	
	public void setTotal() {
		total = 0;
	}
	

	
}
