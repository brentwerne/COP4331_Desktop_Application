package App;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.*;

public class EditInventory extends JPanel{

	
	JLabel menuBar = new JLabel();
	JButton home = new JButton("Home");
	JButton Inventory = new JButton("Inventory");
	JLabel info = new JLabel();
	Color backGround;
	Color bg = new Color(221,221,221);
	JLabel editField = new JLabel();
	JButton addItem = new JButton("Add Item");
	JButton summit = new JButton("Submit");
	JButton summit1 = new JButton("Submit");
	JButton Cancel = new JButton("Cancel");
	JButton Confirm	= new JButton("Confirm");
	
	
	
	public EditInventory(int width, int height, Color abackGround, Inventory inv, JFrame frame) {
			
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
		
		
		
		//Edit Inventory
		Inventory.setBounds(200, 0, 200, 100);
		Inventory.setBorder(BorderFactory.createLineBorder(Color.black));
		Inventory.setLayout(null);
		Inventory.setHorizontalAlignment(JLabel.CENTER);
		
		Inventory.setFont(new Font("Arial", Font.BOLD, 35));
		Inventory.setBackground(backGround);
		Inventory.setOpaque(true);
		Inventory.setForeground(Color.white);
		
		menuBar.add(Inventory);
		
		
		//Home label
		addItem.setBounds(width-width/4-200, 0, 200, 100);
		addItem.setBorder(BorderFactory.createLineBorder(Color.black));
		addItem.setLayout(null);
		addItem.setHorizontalAlignment(JTextField.CENTER);
		
		addItem.setFont(new Font("Arial", Font.BOLD, 35));
		addItem.setBackground(backGround);
		addItem.setOpaque(true);
		addItem.setForeground(Color.white);
		
		menuBar.add(addItem);
		
		//Profile information
		info.setBounds(0, 100, width-width/4-20, height*2);
		info.setBackground(bg);
		info.setOpaque(true);
		
		
		this.add(info);
		
		
		//scroll bar
		JScrollBar s = new JScrollBar(JScrollBar.VERTICAL, 0, 50, 0, height);
		s.setBounds(width-width/4-20, 100, 20, height-200);
		
		//Action listener for scroll bar
		s.addAdjustmentListener(new AdjustmentListener() {  
			public void adjustmentValueChanged(AdjustmentEvent e) {  
				info.setLocation((0), (int) -s.getValue()*2+100);

				frame.repaint();
			}  
		});  
		 
		
		
		this.add(s);
		
		
		
		
		
		
		this.setBackground(bg);
		this.setOpaque(true);
		this.setLayout(null);
		
	}

	
	
	

	//add product modal
	public void addProduct(Inventory inventory, String userName, JFrame frame, int width) {

		//JFrame popup to add item
		JFrame f = new JFrame();
		JPanel addP = new JPanel();
		JLabel titleAdd = new JLabel("Add Product");
		Font fn= new Font("Arial", WIDTH, 30);
		Font fn1= new Font("Arial", WIDTH, 20);
		
		//Title for user to add Product
        titleAdd.setBounds(0, 0, 450, 100);
        titleAdd.setFont(fn);
        titleAdd.setHorizontalAlignment(JTextField.CENTER);
        titleAdd.setVerticalAlignment(JTextField.CENTER);
		
		addP.add(titleAdd);
		
		//Product Name label
		JLabel proName = new JLabel("Product Name");
		proName.setBounds(10, 120, 450, 40);
		proName.setFont(fn1);
				
		addP.add(proName);
		
		//Product Name textfield
		JTextField txtName = new JTextField();
		txtName.setBounds(10, 160, 300, 30);
		
		addP.add(txtName);
		
		//File image name
		JLabel proImg = new JLabel("Product Image (insert file name)");
		proImg.setBounds(10, 200, 500, 40);
		proImg.setFont(fn1);
				
		addP.add(proImg);
		
		//Product image textfield
		JTextField txtImg = new JTextField();
		txtImg.setBounds(10, 240, 300, 30);
		
		addP.add(txtImg);
		
		
		//Product price
		JLabel proPrice = new JLabel("Product Price");
		proPrice.setBounds(10, 280, 500, 40);
		proPrice.setFont(fn1);
				
		addP.add(proPrice);
		
		//Product price textfield
		JTextField txtPrice = new JTextField();
		txtPrice.setBounds(10, 320, 300, 30);
		
		addP.add(txtPrice);
		
		//Product Cost
		JLabel proCost = new JLabel("Product Cost");
		proCost.setBounds(10, 360, 500, 40);
		proCost.setFont(fn1);
				
		addP.add(proCost);
		
		//Product Cost textfield
		JTextField txtCost = new JTextField();
		txtCost.setBounds(10, 400, 300, 30);
		
		addP.add(txtCost);
		
		
		//Product quantity
		JLabel proQuatity = new JLabel("Amount in Stock");
		proQuatity.setBounds(10, 440, 500, 40);
		proQuatity.setFont(fn1);
				
		addP.add(proQuatity);
		
		//Product quantity textfield
		JTextField txtQuatity = new JTextField();
		txtQuatity.setBounds(10, 480, 300, 30);
		
		addP.add(txtQuatity);
		
		//Add product
		
		summit.setBounds(350, 520, 90, 25);
		
		addP.add(summit);
		
		
		summit.addActionListener(l ->{
			//need to add temp to inventory
			inventory.inv.add(new Product(userName, txtImg.getText(), txtName.getText(), txtPrice.getText(), txtCost.getText(), txtQuatity.getText()));
			inventory.inv.save();
			inventory.removeInv(info);
			inventory.displayInv(info, backGround, width, userName);
			f.dispose();
			frame.repaint();
			summit.removeActionListener((ActionListener) l);
		});
		
		addP.setBounds(0,0,500,700);
		addP.setBackground(bg);
		addP.setOpaque(true);
		addP.setLayout(null);
		addP.setBackground(backGround);
		f.add(addP);
		f.setLayout(null);
		f.pack();
		f.setSize(500, 700);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
        
	}
	
	
	//edit product modal
	public void editProduct(Inventory inventory, String userName, JFrame frame, int width, int i) {

		//JFrame popup to edit item
		JFrame f1 = new JFrame();
		JPanel editP = new JPanel();
		JLabel titleAdd = new JLabel("Edit Product");
		Font fn= new Font("Arial", WIDTH, 30);
		Font fn1= new Font("Arial", WIDTH, 20);
		
		//Title for user to edit Product
        titleAdd.setBounds(0, 0, 450, 100);
        titleAdd.setFont(fn);
        titleAdd.setHorizontalAlignment(JTextField.CENTER);
        titleAdd.setVerticalAlignment(JTextField.CENTER);
		
        editP.add(titleAdd);
		
		//Product Name label
		JLabel proName = new JLabel("Product Name");
		proName.setBounds(10, 120, 450, 40);
		proName.setFont(fn1);
				
		editP.add(proName);
		
		//Product Name textfield
		JTextField txtName = new JTextField();
		txtName.setBounds(10, 160, 300, 30);
		
		editP.add(txtName);
		
		//File image name
		JLabel proImg = new JLabel("Product Image (insert file name)");
		proImg.setBounds(10, 200, 500, 40);
		proImg.setFont(fn1);
				
		editP.add(proImg);
		
		//Product image textfield
		JTextField txtImg = new JTextField();
		txtImg.setBounds(10, 240, 300, 30);
		
		editP.add(txtImg);
		
		
		//Product price
		JLabel proPrice = new JLabel("Product Price");
		proPrice.setBounds(10, 280, 500, 40);
		proPrice.setFont(fn1);
				
		editP.add(proPrice);
		
		//Product price textfield
		JTextField txtPrice = new JTextField();
		txtPrice.setBounds(10, 320, 300, 30);
		
		editP.add(txtPrice);
		
		//Product Cost
		JLabel proCost = new JLabel("Product Cost");
		proCost.setBounds(10, 360, 500, 40);
		proCost.setFont(fn1);
				
		editP.add(proCost);
		
		//Product Cost textfield
		JTextField txtCost = new JTextField();
		txtCost.setBounds(10, 400, 300, 30);
		
		editP.add(txtCost);
		
		
		//Product quantity
		JLabel proQuatity = new JLabel("Amount in Stock");
		proQuatity.setBounds(10, 440, 500, 40);
		proQuatity.setFont(fn1);
				
		editP.add(proQuatity);
		
		//Product quantity textfield
		JTextField txtQuatity = new JTextField();
		txtQuatity.setBounds(10, 480, 300, 30);
		
		editP.add(txtQuatity);
		
		//Add product
		
		summit1.setBounds(350, 520, 90, 25);
		
		editP.add(summit1);
		
		
		summit1.addActionListener(e ->{
			
			//need to edit temp to inventory
			inventory.inv.set(i, new Product(userName, txtImg.getText(), txtName.getText(), txtPrice.getText(), txtCost.getText(), txtQuatity.getText()));
			inventory.inv.save();
			f1.setVisible(false);
			inventory.removeInv(info);
			inventory.displayInv(info, backGround, width, userName);
			frame.repaint();
			summit1.removeActionListener((ActionListener) e);
		});
		
		editP.setBounds(0,0,500,700);
		editP.setBackground(bg);
		editP.setOpaque(true);
		editP.setLayout(null);
		editP.setBackground(backGround);
		f1.add(editP);
		f1.setLayout(null);
		f1.pack();
		f1.setSize(500, 700);
		f1.setLocationRelativeTo(null);
		f1.setVisible(true);
        
	}
	
	
		
	public void deleteProduct(Inventory inventory, String userName, JFrame frame,  int width, int i) {
		
		//JFrame popup to edit item
		JFrame f2 = new JFrame();
		JPanel deleteP = new JPanel();
		JLabel titleAdd = new JLabel("Confirm Deleting Product");
		Font fn= new Font("Arial", WIDTH, 30);
				
		//Title for user to edit Product
        titleAdd.setBounds(0, 0, 450, 100);
        titleAdd.setFont(fn);
        titleAdd.setHorizontalAlignment(JTextField.CENTER);
        titleAdd.setVerticalAlignment(JTextField.CENTER);
		
        deleteP.add(titleAdd);
				
		
        Cancel.setBounds(200, 200, 90, 25);
        deleteP.add(Cancel);
        
        Confirm.setBounds(300, 200, 90, 25);
        deleteP.add(Confirm);
        
        Cancel.addActionListener(e ->{
        	f2.setVisible(false);
        	Cancel.removeActionListener((ActionListener) e);
        });
        
        Confirm.addActionListener(e ->{
			inventory.inv.remove(i);
			inventory.inv.save();
			f2.setVisible(false);
			inventory.removeInv(info);
			inventory.displayInv(info, backGround, width, userName);
			frame.repaint();
			Confirm.removeActionListener((ActionListener) e);
        });
        
				
		deleteP.setBounds(0,0,500,300);
		deleteP.setBackground(bg);
		deleteP.setOpaque(true);
		deleteP.setLayout(null);
		deleteP.setBackground(backGround);
		f2.add(deleteP);
		f2.setLayout(null);
		f2.pack();
		f2.setSize(500, 300);
		f2.setLocationRelativeTo(null);
		f2.setVisible(true);		
				
		
	}
	

}
