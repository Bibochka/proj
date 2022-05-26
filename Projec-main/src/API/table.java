package API;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Vector;
import java.util.jar.Attributes.Name;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;



public class table  extends JFrame {

	public void tabl(String id1, String name, String balls,int counter) {
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		ArrayList<String> datArrayList = new ArrayList<String>() ;
		datArrayList.add(id1);
		datArrayList.add(name);
		datArrayList.add(balls);
		list.add((ArrayList<String>) datArrayList);
		
	
	      
	Object[][]  data ={list.toArray(new Object[list.size()])};
	       
	        	System.out.println(list);
	        	DefaultTableModel model = new DefaultTableModel();
	        	  model.addColumn("id");
	        model.addColumn("name");
	        model.addColumn("balls");
	       JTable table = new JTable( model);
	       model.addRow(data);
     	 
	      
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        // Создание таблицы
	      
	        // Настройка заголовков таблицы
	        JTableHeader header = table.getTableHeader();
	        header.setReorderingAllowed(false);
	        header.setResizingAllowed(false);
	    
	        // Размещение таблицы в панели прокрутки
	        getContentPane().add(new JScrollPane(table));
	        // Вывод окна на экран
	        setSize(420, 300);
	        setVisible(true);
	       
	      
	}
}
	    
	
	

	   
	
	