package App;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;

import javax.swing.*;

class Login extends JPanel {

	
	JButton login = new JButton("Login");
	JLabel text = new JLabel("Sign in to Buy or Sell with us");
	JLabel user = new JLabel("Username");
	JTextField userenter = new JTextField();
	JLabel pass = new JLabel("Password");
    JTextField passenter = new JTextField();
    JButton signUp = new JButton("Signup");

    //Contains buyer accounts 
    SerilizationList<BuyerAccount> buyerList = new SerilizationList<BuyerAccount>("BuyerList.ser");
    //Contains seller accounts
    SerilizationList<SellerAccount> sellerList = new SerilizationList<SellerAccount>("SellerList.ser");
    
    
    
	public Login(int width, int height, Color backGround){
    	
        // Loads data into Buyer List
        buyerList.load();
    	
    	//Loads data into Seller List
        sellerList.load(); 
		
		
    	int rewidth = width/4;
    	int reheight = height/4;
    	int xpos = width/2 - width/8;
    	int ypos = height/2 - height/8;
    	
        
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setBounds(xpos, ypos, rewidth, reheight);
        
        //Signin to Shop with us
        text.setBounds(10, 10, rewidth-20, 30);
        Font fn= new Font("Arial", WIDTH, 25);
        text.setFont(fn);
        
        this.add(text);
        
        
        //username
        user.setBounds(10, 50, 300, 25);
        userenter.setBounds(10, 80, rewidth-20, 25);
        
        this.add(userenter);
        this.add(user);
        
        
        //password
        pass.setBounds(10, 110, 300, 25);
        passenter.setBounds(10, 135, rewidth-20, 25);
        
        this.add(passenter);
        this.add(pass);
        
        
        //login button
        login.setBackground(Color.white);
        login.setOpaque(true);
        login.setBounds(rewidth/8, reheight*13/16, 90, 25);
        
        
        this.add(login);
        
        
        //Signup button
        signUp.setBackground(Color.white);
        signUp.setOpaque(true);
        signUp.setBounds(rewidth*5/8, reheight*13/16, 90, 25);
        
        this.add(signUp);
        
        
        
        this.setBackground(backGround);
        this.setOpaque(true);
        
        this.setLayout(null);
        
    }

       
}