package API;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Login extends Main  {
	  public void Protect(String logi, String pass) {
		String prot = "nikita";	 
		String prot1 = "masha";	
		String prot2 = "inna";	
		String	pass1="";
		if(logi.equals(prot)) {
			pass1="123123";
			
			
		}
		if(logi.equals(prot1)) {
			 pass1 = "111111";
		}
		if(logi.equals(prot2)) {
			pass1 = "000000";
		}		
	if(pass.equals(pass1)) {
	 Login lg = new Login();
	 lg.scoretb();
	 
	
	}else {
		System.exit(0);
		
	};
		 	
	  }
}
