package App;

import java.awt.*;
import javax.swing.*;

public class SignUp extends JPanel{
	
	
	JLabel user = new JLabel("Username");
	JTextField userEnter = new JTextField();
	JLabel pass = new JLabel("Password");
	JTextField passEnter = new JTextField();
	JLabel fName = new JLabel("First Name");
	JTextField fNameEnter = new JTextField();
	JLabel lName = new JLabel("Last Name");
	JTextField lNameEnter = new JTextField();
	JLabel type = new JLabel("Username");
	JTextField typrEnter = new JTextField();
	JLabel info = new JLabel();
	Color bg = new Color(221,221,221);
	JLabel title = new JLabel("Sign up to create an account.");
	JLabel form = new JLabel();
	String tog = "Buyer"; // Text in toggle button
    JToggleButton toggle = new JToggleButton(tog, true);
    JButton submit = new JButton("Submit");
    JLabel toggleLabel = new JLabel("Choose account type: ");
    JButton back = new JButton("Back");
    
    int rewidth;
	int reheight;
	int xpos;
	int ypos;
    
    
	
	public SignUp(int width, int height, Color backGround) {
	
		rewidth = width/4;
    	reheight = height/4;
    	xpos = width/2 - width/8;
    	ypos = height/2 - height/8;
		
		
		this.setBounds(width/8, 1, width-width/4, height);
		
		title.setBounds(0, 0, width-width/4, 100);
		title.setBackground(backGround);
		title.setOpaque(true);
		title.setBorder(BorderFactory.createLineBorder(Color.black));
		
		title.setBorder(BorderFactory.createLineBorder(Color.black));
		title.setLayout(null);
		title.setHorizontalAlignment(JTextField.CENTER);
		
		title.setFont(new Font("Arial", Font.BOLD, 50));
		title.setBackground(backGround);
		title.setOpaque(true);
		title.setForeground(Color.white);
		
		this.add(title);
		
		
		//Profile information
		info.setBounds(0, 100, width-width/4, height-100);
		info.setBackground(bg);
		info.setOpaque(true);
		info.setBorder(BorderFactory.createLineBorder(Color.black));
		
		this.add(info);
		
		
		//Width of Form - will be reverences again
		int formWidth = width-width*3/8;
		int formHeight = height-300;
		
		//Form 
		form.setBounds(width/16, 60, formWidth, formHeight);
		form.setBackground(backGround);
		form.setOpaque(true);
		form.setBorder(BorderFactory.createLineBorder(Color.black));
		
		
		info.add(form);
		
		//Username
		user.setBounds(20, 20, 300, 50);
		user.setFont(new Font("Arial", Font.BOLD, 20));
		
		userEnter.setBounds(20, 65, 300, 25);
		
		form.add(user);
		form.add(userEnter);
		
		//Password
		pass.setBounds(formWidth/2, 20, 300, 50);
		pass.setFont(new Font("Arial", Font.BOLD, 20));
		
		passEnter.setBounds(formWidth/2, 65, 300, 25);
		
		form.add(pass);
		form.add(passEnter);
		
		
		//First name
		fName.setBounds(20, 100, 300, 50);
		fName.setFont(new Font("Arial", Font.BOLD, 20));
		
		fNameEnter.setBounds(20, 145, 300, 25);
		
		form.add(fName);
		form.add(fNameEnter);
		
		//Last name
		lName.setBounds(formWidth/2, 100, 300, 50);
		lName.setFont(new Font("Arial", Font.BOLD, 20));
		
		lNameEnter.setBounds(formWidth/2, 145, 300, 25);
		
		form.add(lName);
		form.add(lNameEnter);
		
		
		//Label for toggle button
		toggleLabel.setBounds(20, 280, 300, 50);
		toggleLabel.setFont(new Font("Arial", Font.BOLD, 20));
		
		form.add(toggleLabel);
		
		
        //toggle button
        toggle.setBounds(20, 320, 90, 25);
        
        
        form.add(toggle);
        		
        
		
        //Go back to login page
        back.setBackground(Color.white);
        back.setOpaque(true);
        back.setBounds(formWidth - 230, formHeight - 100, 90, 25);
      
        form.add(back);
        
		
		
		//Sumbit form
		submit.setBackground(Color.white);
        submit.setOpaque(true);
        submit.setBounds(formWidth - 120, formHeight - 100, 90, 25);
        
        
        form.add(submit);
        
        
		this.setBackground(bg);
		this.setOpaque(true);		
		this.setLayout(null);
	}
	
	// Boolean value is returned after checking textfields
	public Boolean checkInformation() {
		//check if any field is blank
		if(userEnter.getText().equals("") || passEnter.getText().equals("") || fNameEnter.getText().equals("") || lNameEnter.getText().equals("")) {
			return false;
		}
		//no fields are left blank
		return true;
	}
	
	// If any textfield is left blank
	public void emptyModal(JFrame frame, JPanel Sign, Color backGround) {
		JPanel emptyModal = new JPanel();
		JLabel message = new JLabel("Textfield was left bank.");
		JButton back1 = new JButton("Back");
		
		//message for user when textfield is blank
        message.setBounds(10, 10, rewidth-20, 30);
        Font fn= new Font("Arial", WIDTH, 25);
        message.setFont(fn);
        message.setHorizontalAlignment(JTextField.CENTER);
        message.setVerticalAlignment(JTextField.CENTER);
        
        
        emptyModal.add(message);
        
        //back button for user to go back to signup page
        back1.setBackground(Color.white);
        back1.setOpaque(true);
        back1.setBounds(rewidth*3/8, reheight*13/16, 90, 25);
      
        emptyModal.add(back1);
        
        //ActionListener for back button
    	back1.addActionListener(e1 ->{
    		frame.remove(emptyModal);
    		frame.add(Sign);
    		frame.repaint();
    	});
        
		
        //modal for message
		emptyModal.setBounds(xpos, ypos, rewidth, reheight);
		emptyModal.setBackground(backGround);
		emptyModal.setOpaque(true);		
		
		
		emptyModal.setBorder(BorderFactory.createLineBorder(Color.black));
		
		
		frame.remove(Sign);
		frame.add(emptyModal);
		frame.repaint();
		
	}
	
	
	

	
}
