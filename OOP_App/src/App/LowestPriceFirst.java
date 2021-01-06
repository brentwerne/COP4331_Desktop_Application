package App;

import java.awt.Color;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class LowestPriceFirst implements ProductSortingStrategy{
	
	public LowestPriceFirst(){
		
	}

	public LinkedList<Product> sortProductslowest(Inventory inventory){
		LinkedList<Product> temp = new LinkedList<Product>();
		
		for(int i = 0; i < inventory.inv.size();i++) {
			temp.add(inventory.inv.get(i));
		}
		
		for(int i = 0; i < temp.size(); i++) {
			for(int j = 1; j < temp.size(); j++) {
				if(temp.get(j-1).price > temp.get(j).price) {
					Product temp1 = temp.get(j-1);
					temp.set(j-1, temp.get(j));
					temp.set(j, temp1);
				}
			}
		}
		return temp;
	}
	
	public void execute(JFrame frame, ShoppingView letsShop, ShoppingCart shopping,  JLabel label, int width, Color backGround, Inventory inventory){
		
		int j = (int) Math.floor(width/280);
		int k;
		int x = 10;
		int y = 20;
		
		LinkedList<Product> temp = sortProductslowest(inventory);
		
		for(int i = 0; i < temp.size(); i++) {
		
			k = (int) Math.floor(i/j);
			y = 20 + 160*k;
			
			
			x = 10*(i%j+1) + 270*(i%j);
			
			ProductView temp1 = new ProductView(temp.get(i), backGround, x, y);
			JButton temp2 = new JButton("Add Item");
			
			temp2.setBounds(85, 105, 110,25);
			
			inventory.addInv.add(temp2);
			
			temp1.add(temp2);
			inventory.t.add(temp1);
		
			final int i3 = i;
			
			inventory.addInv.get(j).addActionListener(e ->{
				letsShop.confirmation( inventory, shopping, i3, backGround);
			});
			
		}
		
		for(int i = 0; i < inventory.t.size(); i++) {
			label.add(inventory.t.get(i));

		}
		frame.repaint();
	}

}
