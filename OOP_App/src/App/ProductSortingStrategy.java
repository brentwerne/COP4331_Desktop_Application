package App;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

public interface ProductSortingStrategy {
	
	public void execute(JFrame frame, ShoppingView letsShop, ShoppingCart shopping,  JLabel label, int width, Color backGround, Inventory inventory);
	
	
	
}
