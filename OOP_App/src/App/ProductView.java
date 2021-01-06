package App;

import java.awt.*;
import javax.swing.*;

public class ProductView extends JPanel{

	JLabel quantity;
	
	public ProductView(Product product, Color backGround, int xloc, int yloc) {
		
		Font fn = new Font("Arial", Font.BOLD, 25);
		Font fn1 = new Font("Arial", Font.BOLD, 15);
		this.setBounds(xloc, yloc, 270, 140);
		
		//add Image to panel
		ImageIcon imgIcon = new ImageIcon(product.path);
		
		JLabel img = new JLabel();
		img.setIcon(imgIcon);
		img.setBounds(5,5,90,90);
		img.setOpaque(true);
		img.setBorder(BorderFactory.createLineBorder(Color.black));
		
		this.add(img);
		
		//Product name
		JLabel name = new JLabel(product.title);
		name.setBounds(105,5, 120, 30);
		name.setFont(fn);
		name.setOpaque(true);
		name.setBackground(backGround);
		
		this.add(name);
		
		//Quantity left
		quantity = new JLabel("In Stock: " + Integer.toString(product.quantity));
		quantity.setBounds(105,35, 140, 30);
		quantity.setFont(fn1);
		quantity.setOpaque(true);
		quantity.setBackground(backGround);
		
		this.add(quantity);
		
		//Price
		JLabel price = new JLabel("Price: $" + String.format("%.2f", product.price));
		price.setBounds(105,65, 140, 30);
		price.setFont(fn1);
		price.setOpaque(true);
		price.setBackground(backGround);
		
		this.add(price);
		
		
		this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setBackground(backGround);
        this.setOpaque(true);
        this.setLayout(null);
	}
	
	public void checkoutAddOn(Product product) {
		quantity.setText("Quantity: " + Integer.toString(product.quantity));
		
	}
	
	
}
