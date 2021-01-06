package App;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;

public class ShoppingCartView extends JPanel{

	
	JLabel menuBar = new JLabel();
	JButton home = new JButton("Home");
	JButton LetsShop = new JButton("Let's Shop");
	JLabel info = new JLabel();
	Color backGround;
	Color bg = new Color(221,221,221);
	JButton checkout = new JButton("Checkout");
	Font fn= new Font("Arial", WIDTH, 25);
	JLabel totalCost = new JLabel("Shopping Total: ");
	JButton cancelShopping = new JButton("Cancel");
	JButton confirmShopping = new JButton("Confirm");
	JButton cancelShopping1 = new JButton("Cancel");
	JButton confirmShopping1 = new JButton("Confirm");
	JLabel totalQuantity = new JLabel("Total Items: ");
	
	
	
	public ShoppingCartView(int width, int height, Color abackGround, Inventory inv, JFrame frame) {
		
		
		this.setBounds(width/8, 1, width-width/4, height);
		
		
		backGround = abackGround;
		
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
		
		
		//checkout label
		checkout.setBounds(width-width/4-200, 0, 200, 100);
		checkout.setBorder(BorderFactory.createLineBorder(Color.black));
		checkout.setLayout(null);
		checkout.setHorizontalAlignment(JTextField.CENTER);
		
		checkout.setFont(new Font("Arial", Font.BOLD, 35));
		checkout.setBackground(backGround);
		checkout.setOpaque(true);
		checkout.setForeground(Color.white);
		
		
		
		menuBar.add(checkout);
		
		JLabel summary = new JLabel();
		summary.setBounds(0, 100, width-width/4-20, 100);
		summary.setBackground(bg);
		summary.setOpaque(true);
		
		
		
		//displays total cost
		totalCost.setBounds(0, 0,(width-width/4-20)/2, 50);
		totalCost.setAlignmentX(CENTER_ALIGNMENT);
		
		totalCost.setFont(fn);
		
		summary.add(totalCost);
		
		
		//displays total quantity
		totalQuantity.setBounds((width-width/4-20)/2, 0, (width-width/4-20)/2, 50);
		totalQuantity.setAlignmentX(CENTER_ALIGNMENT);
		totalQuantity.setFont(fn);
		
		summary.add(totalQuantity);
		
		this.add(summary);
		
		//Profile information
		info.setBounds(0, 200, width-width/4-20, height*2);
		info.setBackground(bg);
		info.setOpaque(true);
			
		
		this.add(info);	
		
		//scroll bar
		JScrollBar s = new JScrollBar(JScrollBar.VERTICAL, 0, 50, 0, height);
		s.setBounds(width-width/4-20, 200, 20, height-200);
		
		//Action listener for scroll bar
		s.addAdjustmentListener(new AdjustmentListener() {  
			public void adjustmentValueChanged(AdjustmentEvent e) {  
				info.setLocation((0), (int) -s.getValue()*2+200);

				frame.repaint();
			}  
		});  
		 
		
		
		this.add(s);
		
		
		this.setBackground(bg);
		this.setOpaque(true);
		
		this.setLayout(null);
	}
	
	public void getSummary(ShoppingCart shopping) {
		
		
		totalCost.setText("Shopping Total: " + String.format("%.2f", shopping.total));
		int temp = 0; 
		for(int i =0; i < shopping.shoppingCart.size(); i++) {
			temp = temp + shopping.shoppingCart.get(i).quantity;
		}
		totalQuantity.setText("Total items: " + Integer.toString(temp));
		
	}
	
	public void editConfirmation(ShoppingCart shopping, Inventory inventory,int width, int i, Color backGround, JFrame frame) {
		
		//JFrame popup to edit item
		JFrame qcon = new JFrame();
		JPanel confirmShoppingAdd = new JPanel();
		JLabel titleAdd = new JLabel("How many would you like?");
		Font fn= new Font("Arial", WIDTH, 25);
		Font fn1= new Font("Arial", WIDTH, 20);		
		//Title for user to edit Product
        titleAdd.setBounds(0, 0, 600, 100);
        titleAdd.setFont(fn);
        titleAdd.setHorizontalAlignment(JTextField.CENTER);
        titleAdd.setVerticalAlignment(JTextField.CENTER);
		
        confirmShoppingAdd.add(titleAdd);
		
        //label to describe quantity field
        JLabel quantity = new JLabel("Quantity:");
        quantity.setBounds(0, 100, 100, 30);
        quantity.setFont(fn1);
        
        confirmShoppingAdd.add(quantity);
        
        //Text field for quantity, defualt to 1
        JTextField quantityEnter = new JTextField("1");
        quantityEnter.setFont(fn1);
        quantityEnter.setBounds(100, 100, 100, 30);
        
        confirmShoppingAdd.add(quantityEnter);
		
        cancelShopping.setBounds(200, 200, 90, 25);
        confirmShoppingAdd.add(cancelShopping);
        
        confirmShopping.setBounds(300, 200, 90, 25);
        confirmShoppingAdd.add(confirmShopping);

        //cancelShoppings add and returns to lets shop screen
        cancelShopping.addActionListener(e ->{
        	qcon.setVisible(false);
        	cancelShopping.removeActionListener((ActionListener) e);
        });
        
        //Adds product to shopping cart
        confirmShopping.addActionListener(e ->{
        	shopping.edit(shopping.shoppingCart.get(i),  inventory.inv.get(i), quantityEnter.getText(), i);
        	qcon.setVisible(false);
        	shopping.removeInv(info);
			shopping.displayShopping(info, backGround, width-width/4-20);
			getSummary(shopping);
			frame.repaint();
        	confirmShopping.addActionListener((ActionListener) e);
        });
        
				
		confirmShoppingAdd.setBounds(0,0,600,300);
		confirmShoppingAdd.setBackground(bg);
		confirmShoppingAdd.setOpaque(true);
		confirmShoppingAdd.setLayout(null);
		confirmShoppingAdd.setBackground(backGround);
		qcon.add(confirmShoppingAdd);
		qcon.setLayout(null);
		qcon.pack();
		qcon.setSize(600, 300);
		qcon.setLocationRelativeTo(null);
		qcon.setVisible(true);		
				
		
	}
		
	public void deleteConfirmation(ShoppingCart shopping, Inventory inventory,int width, int i, Color backGround, JFrame frame) {
		
		//JFrame popup to edit item
		JFrame deleteCon = new JFrame();
		JPanel confirmShoppingAdd = new JPanel();
		JLabel titleAdd = new JLabel("Confirm removing product cart?");
		Font fn= new Font("Arial", WIDTH, 25);
			
		//Title for user to edit Product
	    titleAdd.setBounds(0, 0, 600, 100);
	    titleAdd.setFont(fn);
	    titleAdd.setHorizontalAlignment(JTextField.CENTER);
	    titleAdd.setVerticalAlignment(JTextField.CENTER);
		
	    confirmShoppingAdd.add(titleAdd);
		
		
	    cancelShopping1.setBounds(200, 200, 90, 25);
	    confirmShoppingAdd.add(cancelShopping1);
	    
	    confirmShopping1.setBounds(300, 200, 90, 25);
	    confirmShoppingAdd.add(confirmShopping1);
	
	    //cancelShoppings add and returns to lets shop screen
	    cancelShopping1.addActionListener(e ->{
	    	deleteCon.setVisible(false);
	    	cancelShopping1.removeActionListener((ActionListener) e);
	    });
	    
	    //Adds product to shopping cart
	    confirmShopping1.addActionListener(e ->{
	    	shopping.delete(i);
	    	deleteCon.setVisible(false);
	    	shopping.removeInv(info);
			shopping.displayShopping(info, backGround, width-width/4-20);
			getSummary(shopping);
			frame.repaint();
	    	confirmShopping1.removeActionListener((ActionListener) e);
	    });
	    
				
		confirmShoppingAdd.setBounds(0,0,600,300);
		confirmShoppingAdd.setBackground(bg);
		confirmShoppingAdd.setOpaque(true);
		confirmShoppingAdd.setLayout(null);
		confirmShoppingAdd.setBackground(backGround);
		deleteCon.add(confirmShoppingAdd);
		deleteCon.setLayout(null);
		deleteCon.pack();
		deleteCon.setSize(600, 300);
		deleteCon.setLocationRelativeTo(null);
		deleteCon.setVisible(true);		
				
		
	}



}


