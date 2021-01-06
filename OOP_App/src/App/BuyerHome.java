package App;

import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.ArrayList;

import javax.swing.*;

class BuyerHome extends JPanel {
	
	JLabel menuBar = new JLabel();
	JButton home = new JButton("Home");
	JButton LetsShop = new JButton("Let's Shop");
	JButton cart = new JButton("Cart");
	JLabel info = new JLabel();
	Color bg = new Color(221,221,221);
	JLabel profile = new JLabel();
	JLabel history = new JLabel();
	JLabel historyTitle = new JLabel("Shopping History");
	BuyerAccount currentUser;
	JLabel profileName = new JLabel("");
	JLabel customerName = new JLabel("");
	JLabel itemsInCart = new JLabel("Total items in cart: 0");
	JLabel cartTotal = new JLabel("Shopping Total: 0");
	JLabel orderDisplay = new JLabel();
	ArrayList<PastOrderView> order = new ArrayList<PastOrderView>();
	
	
	public BuyerHome(JFrame frame, int width, int height, Color backGround) {
		
		

		this.setBounds(width/8, 1, width-width/4, height);



		
		
		menuBar.setBounds(0, 0, width-width/4, 100);
		menuBar.setBackground(backGround);
		menuBar.setOpaque(true);
		menuBar.setBorder(BorderFactory.createLineBorder(Color.black));
		
		this.add(menuBar);
		
		//Home label
		home.setBounds(0, 0, 200, 100);
		home.setBorder(BorderFactory.createLineBorder(Color.black));
		home.setLayout(null);
		home.setHorizontalAlignment(JTextField.CENTER);
		
		home.setFont(new Font("Arial", Font.BOLD, 35));
		home.setBackground(backGround);
		home.setOpaque(true);
		home.setForeground(Color.white);
		
		menuBar.add(home);

		//Let's Shop
		LetsShop.setBounds(200, 0, 200, 100);
		LetsShop.setBorder(BorderFactory.createLineBorder(Color.black));
		LetsShop.setLayout(null);
		LetsShop.setHorizontalAlignment(JLabel.CENTER);
		
		LetsShop.setFont(new Font("Arial", Font.BOLD, 35));
		LetsShop.setBackground(backGround);
		LetsShop.setOpaque(true);
		LetsShop.setForeground(Color.white);
		

		menuBar.add(LetsShop);

		
		//Shopping Cart
		cart.setBounds(width-width/4-200, 0, 200, 100);
		cart.setBorder(BorderFactory.createLineBorder(Color.black));
		cart.setLayout(null);
		cart.setHorizontalAlignment(JTextField.CENTER);
		
		cart.setFont(new Font("Arial", Font.BOLD, 35));
		cart.setBackground(backGround);
		cart.setOpaque(true);
		cart.setForeground(Color.white);

		menuBar.add(cart);
		
		//Profile information
		info.setBounds(0, 100, width-width/4, height-100);
		info.setBackground(bg);
		info.setOpaque(true);
		info.setBorder(BorderFactory.createLineBorder(Color.black));
		
		this.add(info);
		
		//Profile section
		profile.setBounds(20, 70, (width-width/4)/2-30, height-300);
		profile.setBorder(BorderFactory.createLineBorder(Color.black));
		profile.setLayout(null);
		profile.setBackground(backGround);
		profile.setOpaque(true);
		
		info.add(profile);
		
		//Profile name
		profileName.setBounds(0, 0, (width-width/4)/2-30, 40);
		profileName.setBorder(BorderFactory.createLineBorder(Color.black));
		profileName.setHorizontalAlignment(JTextField.CENTER);
		profileName.setBackground(backGround);
		profileName.setOpaque(true);
		
		profileName.setFont(new Font("Arial", Font.BOLD, 35));
		profileName.setForeground(Color.white);
		
		profile.add(profileName);
		
		
		
			
		//First and last Name
		customerName.setBounds(10, 50, (width-width/4)/2-30, 50);
		customerName.setHorizontalAlignment(JTextField.CENTER);
		customerName.setFont(new Font("Arial", Font.BOLD, 20));
	
		profile.add(customerName);
		
		//Total items in cart
		itemsInCart.setBounds(10, 120, 500, 50);
		itemsInCart.setFont(new Font("Arial", Font.BOLD, 20));
		
		profile.add(itemsInCart);
		
		//Total items in cart
		cartTotal.setBounds(10, 190, 500, 50);
		cartTotal.setFont(new Font("Arial", Font.BOLD, 20));
		
		profile.add(cartTotal);
	
		
		
		//Purchase History
		history.setBounds((width-width/4)/2 + 10, 70, (width-width/4)/2-30, height-300);
		history.setBorder(BorderFactory.createLineBorder(Color.black));
		history.setLayout(null);
		history.setBackground(backGround);
		history.setOpaque(true);
			
		
		info.add(history);
		
		//Purchase History Label
		historyTitle.setBounds(0, 0, (width-width/4)/2-30, 40);
		historyTitle.setBorder(BorderFactory.createLineBorder(Color.black));
		historyTitle.setHorizontalAlignment(JTextField.CENTER);
		historyTitle.setBackground(backGround);
		historyTitle.setOpaque(true);
		
		historyTitle.setFont(new Font("Arial", Font.BOLD, 35));
		historyTitle.setForeground(Color.white);
		
		history.add(historyTitle);
		
		
		
		//Order Panels
		orderDisplay.setBounds(0, 40, (width-width/4)/2-30-20, height*2);
		orderDisplay.setBorder(BorderFactory.createLineBorder(Color.black));
		orderDisplay.setHorizontalAlignment(JTextField.CENTER);
		orderDisplay.setBackground(backGround);
		orderDisplay.setOpaque(true);
		
		orderDisplay.setFont(new Font("Arial", Font.BOLD, 35));
		orderDisplay.setForeground(Color.white);
		
		history.add(orderDisplay);
		
		
		//scroll bar
		JScrollBar s = new JScrollBar(JScrollBar.VERTICAL, 0, 50, 0, height);
		s.setBounds( (width-width/4)/2-30-20, 40, 20, height-340);
		
		//Action listener for scroll bar
		s.addAdjustmentListener(new AdjustmentListener() {  
			public void adjustmentValueChanged(AdjustmentEvent e) {  
				orderDisplay.setLocation((0), (int) -s.getValue()*2+40);

				frame.repaint();
			}  
		});  
		 
		
		
		history.add(s);
		
		
		
		this.setBackground(bg);
		this.setOpaque(true);
		
		this.setLayout(null);
	}
	
	
	public void updateHome(ShoppingCart shopping) {
		profileName.setText(currentUser.userName);
		customerName.setText("Welcome " + currentUser.firstName + " " + currentUser.lastName);
		
		int temp = 0; 
		if(shopping.equals(null)) {
			
		}else {
			for(int i =0; i < shopping.shoppingCart.size(); i++) {
				temp = temp + shopping.shoppingCart.get(i).quantity;
			}
			itemsInCart.setText("Total items in cart: " + Integer.toString(temp));
			cartTotal.setText("Shopping Total: " + String.format("%.2f", shopping.total));
	
		}
		

	}
	
	
	
	public void updateOrderHistory(int width, Color backGround) {
		
		for(int i = 0; i < order.size(); i++) {
			orderDisplay.remove(0);
		}
		
		order.clear();
		
		
		for(int i = 0; i < currentUser.orderHistory.size(); i++) {
			order.add(new PastOrderView(currentUser.orderHistory.get(i), i*60, width, backGround));
			
			orderDisplay.add(order.get(i));
			
			
		}
		
		history.add(orderDisplay);
		orderDisplay.repaint();
		history.repaint();
	}
	
}
