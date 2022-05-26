package API;
import java.sql.SQLException;
 class DataBase extends average {
		public  void datab (String name1 , int avrage, int counter ) throws ClassNotFoundException, SQLException {
			
			Setting_db.Conn();
			Setting_db.CreateDB( name1,  avrage);
			Setting_db.WriteDB(name1, avrage);
			Setting_db.ReadDB(counter);
			Setting_db.CloseDB();
			
		}
 }


