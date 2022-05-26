package API;

import java.sql.SQLException;

public class average extends Main {
public void avscrore(int value, int counter,String name) throws ClassNotFoundException, SQLException {
	
	int avrage= value/counter;
	System.out.println(avrage);
	String name1 = "'"+name+"'";
	 
	
	DataBase db = new DataBase();
     db.datab(name1,avrage,counter );

}
}
