package App;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.io.*;

import javax.swing.*;

class App {
	
	

    public static void main(String[] args) {
    	//backGround
    	Color backGround = new Color(151, 186, 255);
    	
    	// java - get screen size using the Toolkit class
    	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    	
    	// the screen width
    	int width = (int)screenSize.getWidth();
    	
    	// the screen height
    	int height = (int)screenSize.getHeight();
    	
    	
    	
    	Inventory inventory = new Inventory();
        
        Login l = new Login(width, height, backGround);
        
        //Seller Home
        SellerHome sHome = new SellerHome(width, height, backGround);
       
        
    	ShoppingCart shopping  = new ShoppingCart();
    	
        
        JFrame f = new JFrame();
        
        // Buyer Home
        BuyerHome bHome = new BuyerHome(f, width, height, backGround);
        
        SignUp SU = new SignUp(width, height, backGround);
        
        f.getContentPane().setBackground(Color.white);
        
        ShoppingCartView checkout = new ShoppingCartView(width, height, backGround, inventory, f); 
		
        BuyerCheckoutView checkoutConfirm = new BuyerCheckoutView();
        
        f.add(l);
        
        // EditInvetory 
        EditInventory eInv = new EditInventory(width, height, backGround, inventory, f);
        
        // Shopping view
        ShoppingView letsShop = new ShoppingView(f, width, height, backGround, inventory, shopping);
        
        
        
		//login displays buyer or seller page if username and password are correct.
		l.login.addActionListener(e1 ->{
	    	String username = l.userenter.getText();
	    	String password = l.passenter.getText();
	    		    	
	    
	    		//Iterates through buyerList
	    	for(int i = 0; i < l.buyerList.size(); i++) {
		    		//Checks to see if username and password are correct
		    		if(l.buyerList.get(i).userName.equals(username) && l.buyerList.get(i).passWord.equals(password)) {
		    			
		    			//Sets current user
		    			bHome.currentUser = l.buyerList.get(i);
		    			
		    			
		    			
		    			//Sets shopping cart to current user
		    			shopping.load(bHome.currentUser.firstName);
		    			
		    			//updates JLabel after currentUser was set
		    			bHome.updateHome(shopping);
		    			
		    			//displays order history
		    			bHome.updateOrderHistory((width-width/4)/2-50, backGround);
		    			
		    			
		    			//Removes login JPanel
		    			f.remove(l);
		    			//Adds Buyer Home JPanel
		    			f.add(bHome);
		    			//Repaints JFrame
		    			f.repaint();
		    			
		    			return;
		    		}
		    	}
	    	
	    	//Iterates through sellerList
		   	for(int i = 0; i < l.sellerList.size(); i++) {
		    	//Checks to see if username and password are correct
		    	if(l.sellerList.get(i).userName.equals(username) && l.sellerList.get(i).passWord.equals(password)) {
		    		
		    		//Sets current user
		    		sHome.currentUser = l.sellerList.get(i);
		    		sHome.updateSellerHome();
		    		
		    		//Removes login JPanel
		    		f.remove(l);
		    		//Adds Seller Home JPanel
		    		f.add(sHome);
		    		//Repaints JFrame
		    		f.repaint();
		    		
		    	}
		    }
	    			    	
		});

		

  		//Sing up page is displayed
		l.signUp.addActionListener(e1 ->{
	    	
	    	f.remove(l);
	    	//SU is signUp page
	    	f.add(SU);
	    	f.repaint();
	    	
		});
		
		

        
       
		// Buy or sell toggle for sign up
		SU.toggle.addActionListener(e1 ->{
	    	
			if(SU.tog.equals("Buyer")) {
				SU.tog = "Seller";
			} else {
				SU.tog = "Buyer";
			}
			SU.toggle.setText(SU.tog);
	        f.repaint();
			
	    	
		});
		
        //Back button for signup page
    	SU.back.addActionListener(e1 ->{
    		f.remove(SU);
    		f.add(l);
    		f.repaint();
    	});
		
		
		//Submit button on signup page
		SU.submit.addActionListener(e1 ->{
			
			if(SU.checkInformation()) {
				
				//Creates account
				if(SU.tog.equals("Buyer")) {
					//Creates temp for BuyerAccount class
					BuyerAccount temp = new BuyerAccount(SU.userEnter.getText(), SU.passEnter.getText(), SU.fNameEnter.getText(), SU.lNameEnter.getText());
					
					Boolean usernameChecker = false;
					
					//Add temp to BuyerAccount
					for(int i = 0; i > l.buyerList.size(); i++) {
						BuyerAccount temp2 = l.buyerList.get(i);
						if(temp2.userName.equals(temp.userName)) {
							usernameChecker = true;
						}
					}
					
					// Adds account to buyerList
					if(usernameChecker == false) {
						l.buyerList.add(temp);
					}
					
					l.buyerList.save();
					
				} else if(SU.tog.equals("Seller")){
					//Creates temp for SellerAccount class
					SellerAccount temp = new SellerAccount(SU.userEnter.getText(), SU.passEnter.getText(), SU.fNameEnter.getText(), SU.lNameEnter.getText(), 
						0, 0, 0, 0);
					
					Boolean usernameChecker = false;
					
					//Add temp to SellerAccount
					for(int i = 0; i > l.buyerList.size(); i++) {
						SellerAccount temp2 = l.sellerList.get(i);
						if(temp2.userName.equals(temp.userName)) {
							usernameChecker = true;
						}
					}
					
					// Adds account to sellerList
					if(usernameChecker == false) {
						l.sellerList.add(temp);
					}
					
					l.sellerList.save();
					
				} else {
					//message tells user textfield was left blank
					SU.emptyModal(f, SU, backGround);
					return;
				}
				
				
				//Switch back to login screen
				f.remove(SU);
				f.add(l);
				f.repaint();
				
			} else {
				//message tells user textfield was left blank 
				SU.emptyModal(f, SU, backGround);
			}
		});
		
        
		//SellerHome button to see edit inventory
		sHome.Inventory.addActionListener(e1 ->{
			inventory.removeAllActions();
			f.remove(sHome);
			inventory.displayInv(eInv.info, backGround, width-width/4, sHome.currentUser.userName);
			f.add(eInv);		
			
			for(int i = 0; i < inventory.editInv.size(); i++) {
				final int i1 = i;
				inventory.editInv.get(i).addActionListener(e ->{
					eInv.editProduct(inventory, sHome.currentUser.userName, f, width-width/4, i1);
					
				});
			}
			
			for(int j = 0; j < inventory.deleteInv.size(); j++) {
				final int i2 = j;
				inventory.deleteInv.get(j).addActionListener(e ->{
					eInv.deleteProduct(inventory, sHome.currentUser.userName, f, width-width/4, i2);
					
				});
			}
			
			f.repaint();
			
		});
		
		//Adds product to inventory
		eInv.addItem.addActionListener(e1 ->{
			
			eInv.addProduct(inventory, sHome.currentUser.userName, f, width-width/4);

		});
		
		
	
		//Home Action listener for edit Inventory
		eInv.home.addActionListener(e ->{
			f.remove(eInv);
			f.add(sHome);
			f.repaint();
		});
		
		
		//Home Action listener for Lets shop
		letsShop.home.addActionListener(e ->{
			f.remove(letsShop);
			bHome.updateOrderHistory((width-width/4)/2-50, backGround);
			f.add(bHome);
			f.repaint();
		});
		
		//Home Action listener for Lets shop
		checkout.home.addActionListener(e ->{
			f.remove(checkout);
			bHome.updateOrderHistory((width-width/4)/2-50, backGround);
			f.add(bHome);
			f.repaint();
		});
		
		//Cart Action listener for Lets shop
		letsShop.cart.addActionListener(e ->{
			shopping.removeAllActions();
			f.remove(letsShop);
			shopping.displayShopping(checkout.info, backGround, width-width/4);
			for(int j = 0; j < shopping.shoppingCart.size(); j++) {
				final int i6 = j;
				shopping.editQuantity.get(j).addActionListener(e1 ->{
				checkout.editConfirmation(shopping, inventory, width, i6, backGround, f);
				});
			}
			for(int j = 0; j < shopping.shoppingCart.size(); j++) {
				final int i5 = j;
				shopping.removeItem.get(j).addActionListener(e1 ->{
				checkout.deleteConfirmation(shopping, inventory, width, i5, backGround, f);
				});
			}
			checkout.getSummary(shopping);
			f.add(checkout);
			f.repaint();
		});
		
		//Cart Action listener for buyer home
		bHome.cart.addActionListener(e ->{
			shopping.removeAllActions();
			f.remove(bHome);
			shopping.displayShopping(checkout.info, backGround, width-width/4);
			for(int j = 0; j < shopping.shoppingCart.size(); j++) {
				final int i10 = j;
				shopping.editQuantity.get(j).addActionListener(e1 ->{
				checkout.editConfirmation(shopping, inventory, width, i10, backGround, f);
				});
			}
			for(int j = 0; j < shopping.shoppingCart.size(); j++) {
				final int j10 = j;
				shopping.removeItem.get(j).addActionListener(e1 ->{
				checkout.deleteConfirmation(shopping, inventory, width, j10, backGround, f);
				});
			}
			checkout.getSummary(shopping);
			f.add(checkout);
			f.repaint();
		});
		
		

		
		bHome.LetsShop.addActionListener(e ->{
			inventory.removeAllActions();
			f.remove(bHome);
			inventory.removeInv(letsShop.info);
			inventory.displayShopping(letsShop.info, backGround, width-width/4);
			for(int j = 0; j < inventory.addInv.size(); j++) {
				final int i8 = j;
				inventory.addInv.get(j).addActionListener(e1 ->{
					letsShop.confirmation( inventory, shopping, i8, backGround);
				});
			}
			f.add(letsShop);
			f.repaint();
		});
		
		letsShop.LetsShop.addActionListener(e ->{
			inventory.removeAllActions();
			
			f.remove(letsShop);
			inventory.removeInv(letsShop.info);
			inventory.displayShopping(letsShop.info, backGround, width-width/4);
			for(int j = 0; j < inventory.addInv.size(); j++) {
				final int i3 = j;
				inventory.addInv.get(j).addActionListener(e1 ->{
					letsShop.confirmation( inventory, shopping, i3, backGround);
				});
			}
			f.add(letsShop);
			f.repaint();
		});
		
		checkout.LetsShop.addActionListener(e ->{
			inventory.removeAllActions();
			
			f.remove(checkout);
			inventory.removeInv(letsShop.info);
			inventory.displayShopping(letsShop.info, backGround, width-width/4);
			for(int j = 0; j < inventory.addInv.size(); j++) {
				final int i3 = j;
				inventory.addInv.get(j).addActionListener(e1 ->{
					letsShop.confirmation( inventory, shopping, i3, backGround);
				});
			}
			f.add(letsShop);
			f.repaint();
		});
		
		checkout.checkout.addActionListener(e ->{
			checkoutConfirm.checkout(f, checkout, width, backGround, shopping, l, inventory, bHome);
			
		});
		
		
	
        f.setLayout(null);
		f.pack();
		f.setSize(width,height);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
    
    
    }
    
    
    
    
    
}