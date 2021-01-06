package App;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.*;

public class ShoppingView extends JPanel{

	JLabel menuBar = new JLabel();
	JButton home = new JButton("Home");
	JButton LetsShop = new JButton("Let's Shop");
	JButton cart = new JButton("Cart");
	Color bg = new Color(221,221,221);
	JLabel info = new JLabel();
	JButton confirm = new JButton("Confirm");
	JButton cancel = new JButton("Cancel");
	
	
	
	public ShoppingView(JFrame frame, int width, int height, Color backGround, Inventory inventory,ShoppingCart shopping) {
		
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
		
		//Label for search bar
		JLabel search = new JLabel("Search: ");
		search.setBounds(0,100,100,40);
		Font fn = new Font("Arial", WIDTH, 25);
		search.setFont(fn);
		
		
		this.add(search);
		
		//Search Bar
		JTextField searchEnter = new JTextField();
		searchEnter.setBounds(100, 105, 500, 30);
		searchEnter.setFont(fn);
		
		this.add(searchEnter);
		
		//Search button
		JButton searchButton = new JButton("Search");
		searchButton.setBounds(615, 105, 90, 30);
		
		this.add(searchButton);
		
		//while trigger a search based on whats in the TextField
		searchButton.addActionListener(e ->{
			inventory.removeInv(info);
			inventory.displaySearch(shopping, this,info, backGround, width-width/4, searchEnter.getText());
			frame.repaint();
		});
		
		
		//Lowest to Highest Price
		JButton lowest = new JButton("Lowest to Highest");
		lowest.setBounds(735, 105, 140, 30);
		
		this.add(lowest);
		
		//Lowest to highest price
		lowest.addActionListener(e ->{
			LowestPriceFirst low = new LowestPriceFirst();
			inventory.removeInv(info);
			low.execute(frame,this, shopping, info,  width-width/4, backGround, inventory);
			//(JFrame frame, ShoppingView letsShop, ShoppingCart shopping,  JLabel label, int width, Color backGround, Inventory inventory)
		});
		
		
		//Highest to lowest Price
		JButton highest = new JButton("Highest to Lowest");
		highest.setBounds(905, 105, 140, 30);
		
		this.add(highest);
		
		//Highest to lowest price
		highest.addActionListener(e ->{
			HighestPriceFirst high = new HighestPriceFirst();
			inventory.removeInv(info);
			high.execute(frame,this, shopping, info,  width-width/4, backGround, inventory);
		
		});
		
		
		//Profile information
		info.setBounds(0, 150, width-width/4-20, height*2);
		info.setBackground(bg);
		info.setOpaque(true);
		
		this.add(info);
		
		
		//scroll bar
		JScrollBar s = new JScrollBar(JScrollBar.VERTICAL, 0, 50, 0, height);
		s.setBounds(width-width/4-20, 100, 20, height-200);
		
		//Action listener for scroll bar
		s.addAdjustmentListener(new AdjustmentListener() {  
			public void adjustmentValueChanged(AdjustmentEvent e) {  
				info.setLocation((0), (int) -s.getValue()*2+150);

				frame.repaint();
			}  
		});  
		 
		
		
		this.add(s);
		
		
		
		
		this.setBackground(bg);
		this.setOpaque(true);
		
		this.setLayout(null);
	}
	
	
	
	public void confirmation(Inventory inventory, ShoppingCart shopping, int i, Color backGround) {
		
		//JFrame popup to edit item
		JFrame f2 = new JFrame();
		JPanel confirmAdd = new JPanel();
		JLabel titleAdd = new JLabel("Confirm Adding Product To Shopping Cart");
		Font fn= new Font("Arial", WIDTH, 25);
		Font fn1= new Font("Arial", WIDTH, 20);		
		//Title for user to edit Product
        titleAdd.setBounds(0, 0, 600, 100);
        titleAdd.setFont(fn);
        titleAdd.setHorizontalAlignment(JTextField.CENTER);
        titleAdd.setVerticalAlignment(JTextField.CENTER);
		
        confirmAdd.add(titleAdd);
		
        //label to describe quantity field
        JLabel quantity = new JLabel("Quantity:");
        quantity.setBounds(0, 100, 100, 30);
        quantity.setFont(fn1);
        
        confirmAdd.add(quantity);
        
        //Text field for quantity, defualt to 1
        JTextField quantityEnter = new JTextField("1");
        quantityEnter.setFont(fn1);
        quantityEnter.setBounds(100, 100, 100, 30);
        
        confirmAdd.add(quantityEnter);
		
        cancel.setBounds(200, 200, 90, 25);
        confirmAdd.add(cancel);
        
        confirm.setBounds(300, 200, 90, 25);
        confirmAdd.add(confirm);

        //cancels add and returns to lets shop screen
        cancel.addActionListener(e ->{
        	f2.setVisible(false);

        });
        
        //Adds product to shopping cart
        confirm.addActionListener(e ->{
        	shopping.add(inventory.inv.get(i), quantityEnter.getText());
        	System.out.println(inventory.inv.get(i).quantity);
        	System.out.println(shopping.shoppingCart.get(i).quantity);
        	f2.setVisible(false);
        	confirm.removeActionListener((ActionListener) e);
        });
        
				
		confirmAdd.setBounds(0,0,600,300);
		confirmAdd.setBackground(bg);
		confirmAdd.setOpaque(true);
		confirmAdd.setLayout(null);
		confirmAdd.setBackground(backGround);
		f2.add(confirmAdd);
		f2.setLayout(null);
		f2.pack();
		f2.setSize(600, 300);
		f2.setLocationRelativeTo(null);
		f2.setVisible(true);		
				
		
	}

	
	
	
	
	
	
	
	
	
	
	
}
