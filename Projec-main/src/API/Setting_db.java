package API;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class Setting_db extends average {
	public static Connection conn;
	public static Statement statmt;
	public static ResultSet resSet;
	
	
	// --------ПОДКЛЮЧЕНИЕ К БАЗЕ ДАННЫХ--------
	public static void Conn() throws ClassNotFoundException, SQLException 
	   {
		   conn = null;
		   Class.forName("org.sqlite.JDBC");
		   conn = DriverManager.getConnection("jdbc:sqlite:TEST1.s3db");
		   
		   System.out.println("База Подключена!");
	   }
	
	// --------Создание таблицы--------
	public static void CreateDB(String name1, int avrage) throws ClassNotFoundException, SQLException
	   {
		statmt = conn.createStatement();
		statmt.execute("CREATE TABLE if not exists 'users' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'name' text, 'balls' INT);");
		
		System.out.println("Таблица создана или уже существует.");
	   }
	
	// --------Заполнение таблицы--------
	public static void WriteDB(String name1, int avrage) throws SQLException
	{
		  statmt.execute("INSERT INTO 'users' ('name', 'balls') VALUES (" + name1 +","+ avrage +"); ");
		   
		  
		   System.out.println("Таблица заполнена");
	}
	
	// -------- Вывод таблицы--------
	public static void ReadDB(int counter) throws ClassNotFoundException, SQLException
	   {
		resSet = statmt.executeQuery("SELECT * FROM users");
		
		while(resSet.next())
		{
			int id = resSet.getInt("id");
			String id1 = id+"";
			String  name = resSet.getString("name");
			String balls = resSet.getString("balls");
		
			
			
	         System.out.println( "ID = " + id );
	         System.out.println( "name = " + name );
	         System.out.println( "balls = " + balls);
	    
	         System.out.println();
	        
		      
	       
	         table tb = new table();
	         tb.tabl(id1, name , balls, counter);
	     
		}	
		
		System.out.println("Таблица выведена");
	    }
	
		// --------Закрытие--------
		public static void CloseDB() throws ClassNotFoundException, SQLException
		   {
			conn.close();
			statmt.close();
			resSet.close();
			
			System.out.println("Соединения закрыты");
		   }

}