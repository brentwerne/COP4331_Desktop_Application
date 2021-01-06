package App;
import java.io.*;
import java.util.*;

import App.BuyerAccount;
import App.SellerAccount;

public class SerilizationList<T> extends LinkedList<T> implements Serializable {
  
	public String fileName;
	
	public SerilizationList (String afileName){
		fileName = afileName;
	}
	
   
    
	public void save() {
		
		ArrayList<T> temp = new ArrayList<T>();
		
		for(int i = 0; i < this.size(); i++) {
			temp.add(this.get(i));
		}
		
        try {
            FileOutputStream fos = new FileOutputStream(this.fileName);
            ObjectOutputStream os = new ObjectOutputStream(fos);
            os.writeObject(temp); 
            os.close();
            fos.close();

            System.out.println("works");
        } catch (Exception x) {
           System.out.print("x - save error"); 
        }
        
        temp.clear();
		
	}
    
	public void load() {
		
		ArrayList<T> temp = new ArrayList<T>();
    	//Loads data into Buyer list
        try {
            FileInputStream fis = new FileInputStream(this.fileName);
            ObjectInputStream is = new ObjectInputStream(fis);
            
            temp = (ArrayList<T>) is.readObject(); 
           
            is.close();
            fis.close();
            System.out.println("works");
            
    	} catch (Exception x) {
           System.out.print(" x - load error"); 
    	}
	
    
		for(int i =0; i < temp.size(); i++) {
			this.add(temp.get(i));
		}
		
		temp.clear();
		
	}
}
