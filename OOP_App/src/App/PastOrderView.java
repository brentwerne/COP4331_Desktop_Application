package App;

import java.awt.*;
import javax.swing.*;




public class PastOrderView extends JPanel {
	

	public PastOrderView(PastOrder order, int ypos, int width, Color backGround) {
		
		JLabel orderDate = new JLabel("Order placed on: " + order.returnDate());
		
		orderDate.setBounds(10, 0, width-20, 20);
		this.add(orderDate);
		
		JLabel totalItems = new JLabel("Total amount of items: " + order.getQuantity());
		
		totalItems.setBounds(10, 20, width-20, 20);
		this.add(totalItems);
		
		JLabel totalCost = new JLabel("Total cost: " + order.getCost());
		
		totalCost.setBounds(10, 40, width-20, 20);
		this.add(totalCost);
		
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.setBackground(backGround);
		this.setBounds(0,ypos, width, 60);
		
	}
	
	
}
