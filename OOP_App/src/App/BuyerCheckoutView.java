package App;
import java.awt.*;
import java.util.Date;

import javax.swing.*;

import App.BuyerAccount;

public class BuyerCheckoutView {

	JButton summitCheckout = new JButton("Summit");
	
	
	
	public BuyerCheckoutView() {
		
	}
	
	public void checkout(JFrame frame,  ShoppingCartView view, 
			int width, Color backGround, ShoppingCart shopping, Login login, Inventory inventory, BuyerHome bHome) {
		JFrame checkout = new JFrame();
		JPanel checkOut = new JPanel();
		Font title = new Font("Arial", Font.BOLD, 45);
		Font fn = new Font("Arial", Font.BOLD, 25);
		
		
		//Username
		JLabel name = new JLabel(bHome.currentUser.userName);
		name.setBounds(0, 0, 700, 100);
        name.setFont(title);
        name.setHorizontalAlignment(JTextField.CENTER);
        name.setVerticalAlignment(JTextField.CENTER);
		
        checkOut.add(name);
		
        //Cardnumber
		JLabel cardNumber = new JLabel("Card Number");
		cardNumber.setBounds(10, 100, 300, 50);
		cardNumber.setFont(fn);
		
        checkOut.add(cardNumber);
		
		JTextField cardEnter = new JTextField();
		cardEnter.setBounds(10, 150, 300, 25);
		
		checkout.add(cardEnter);
		
		
        //CVC
		JLabel CVC = new JLabel("CVC");
		CVC.setBounds(400, 100, 200, 50);
		CVC.setFont(fn);
		
        checkOut.add(CVC);
		
		JTextField CVCEnter = new JTextField();
		CVCEnter.setBounds(400, 150, 100, 25);
		
		checkout.add(CVCEnter);
		
		
        //Expiration date
		JLabel expiration = new JLabel("Expiration Date");
		expiration.setBounds(10, 200, 300, 50);
		expiration.setFont(fn);
		
        checkOut.add(expiration);
		
		JTextField expirationEnter = new JTextField();
		expirationEnter.setBounds(10, 250, 100, 25);
		
		checkout.add(expirationEnter);
		
        //address
		JLabel address = new JLabel("Address");
		address.setBounds(10, 300, 300, 50);
		address.setFont(fn);
		
        checkOut.add(address);
		
		JTextField addressEnter = new JTextField();
		addressEnter.setBounds(10, 350, 300, 25);
		
		checkout.add(addressEnter);
		
		
        //City/State
		JLabel address2 = new JLabel("City/State");
		address2.setBounds(400, 300, 200, 50);
		address2.setFont(fn);
		
        checkOut.add(address2);
		
		JTextField address2Enter = new JTextField();
		address2Enter.setBounds(400, 350, 200, 25);
		
		checkout.add(address2Enter);
		
		//Display total
		JLabel total = new JLabel("Total: " + shopping.getTotal());
		total.setBounds(10, 500, 300, 25);
		total.setFont(fn);
		
		checkout.add(total);
		
		
		//summit
		summitCheckout.setBounds(400, 500, 90, 25);
		
		checkout.add(summitCheckout);
		
		summitCheckout.addActionListener(e->{
			
			if(cardEnter.getText().equals("") || CVCEnter.getText().equals("") || 
					expirationEnter.getText().equals("") || addressEnter.getText().equals("") || address2Enter.getText().equals("")) {
				
				error(backGround);
				
			}else {
				checkout.setVisible(false);
				
			
				for(int i=0; i < shopping.shoppingCart.size();i++) {
					for( int j = 0; j < inventory.inv.size(); j++) {
						if(shopping.shoppingCart.get(i).title.equals(inventory.inv.get(j).title)) {
							System.out.println(shopping.shoppingCart.get(i).title + " " + inventory.inv.get(j).title);
							System.out.println(shopping.shoppingCart.get(i).quantity + " " + inventory.inv.get(j).quantity);
							if(inventory.inv.get(j).quantity > shopping.shoppingCart.get(i).quantity) {
								
								inventory.inv.get(j).quantity = inventory.inv.get(j).quantity - shopping.shoppingCart.get(i).quantity;
							}else {
								shopping.shoppingCart.get(i).quantity = inventory.inv.get(j).quantity;
								inventory.inv.remove(j);
							}	
							
							for(int k = 0; k < login.sellerList.size(); k++) {
								shopping.shoppingCart.get(i).date = new Date();
								login.sellerList.get(k).itemsSold.add(shopping.shoppingCart.get(i));
								
							}
							
							
							
						}
						
					}
				}
				
				for(int i = 0; i < login.buyerList.size(); i++) {
					if(bHome.currentUser.userName.equals(login.buyerList.get(i).userName)){
						Date temp1 = new Date();
						int temp3 = 0; 
						for(int j =0; j < shopping.shoppingCart.size(); j++) {
							temp3 = temp3 + shopping.shoppingCart.get(j).quantity;
						}
						
						login.buyerList.get(i).orderHistory.add(new PastOrder( temp1, String.format("%.2f", shopping.total), Integer.toString(temp3)));
						
						System.out.println(" in ");
					}
				}
				
				System.out.println(" in ");
				bHome.updateOrderHistory((width-width/4)/2-50, backGround);
				
			
					

				
				shopping.setTotal();
				shopping.shoppingCart.clear();
				shopping.shoppingCart.save();
				shopping.removeInv(view.info);
				shopping.displayShopping(view.info, backGround, width);
				view.getSummary(shopping);
				inventory.inv.save();
				login.sellerList.save();
				login.buyerList.save();
				frame.repaint();
				
			}
		});
		
		
		
		//JPanel
		checkOut.setBounds(0,0,700,700);
		checkOut.setOpaque(true);
		checkOut.setLayout(null);
		checkOut.setBackground(backGround);
		//JFrame
		checkout.add(checkOut);
		checkout.setLayout(null);
		checkout.pack();
		checkout.setSize(700, 700);
		checkout.setLocationRelativeTo(null);
		checkout.setVisible(true);	
		
	}
	
	public void error(Color backGround) {
		JFrame confirm = new JFrame();
		JPanel con = new JPanel();
		Font fn= new Font("Arial", Font.BOLD, 25);
		
		//Message
		JLabel message = new JLabel("Not all fields are filled out.");
		message.setBounds(0, 0, 400, 100);
		message.setFont(fn);
        message.setHorizontalAlignment(JTextField.CENTER);
        message.setVerticalAlignment(JTextField.CENTER);
		
        con.add(message);
		
        
        //Ok button
        JButton ok = new JButton("Ok");
        ok.setBounds(155, 150, 90, 25);
        
        con.add(ok);
        

        
		
		ok.addActionListener(e -> {
			confirm.setVisible(false);
		});
		
		
		
		
		
		//JPanel
		con.setBounds(0,0,400,300);
		con.setOpaque(true);
		con.setLayout(null);
		con.setBackground(backGround);
		//JFrame
		confirm.add(con);
		confirm.setLayout(null);
		confirm.pack();
		confirm.setSize(400, 300);
		confirm.setLocationRelativeTo(null);
		confirm.setVisible(true);	
	}
	
}
