package API;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.security.PublicKey;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.UIManager.LookAndFeelInfo;




public class Main {
	
	

	private static int value;
	  private  static int counter;
	 
	  
public static void main(String[] args) {	
	Main gg = new Main();
	gg.frame();
}
	public void frame(){
                 JFrame frame1 = new JFrame ("Login");
             	frame1.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("149452.png")));
        JPanel mainPanel = new JPanel();
                 JLabel titleLable = new JLabel ("Система ");
                 titleLable.setForeground(Color.white);
                 JLabel nameLable = new JLabel ("Аккаунт:");
                 nameLable.setForeground(Color.white);
                 JLabel passwordLable = new JLabel ("Пароль:");
                 passwordLable.setForeground(Color.white);
        JTextField text1 = new JTextField();
        JPasswordField password = new JPasswordField();
        final JButton button = new JButton ( "Логин" );
        button.setUI ( new MyButtonUI () );
        
        final JButton exit = new JButton ( "Выход" );
        exit.setUI ( new MyButtonUI () );
                
                 button.addMouseListener(new MouseAdapter() { 
                     public void mouseClicked(MouseEvent e) { 
                   String logi = text1.getText();
                   String pass = password.getText();
               
                    Login acc = new Login();
                    acc.Protect(logi,pass);
                    frame1.setVisible(false);
                     	      }
                     	    });
	
                
            

        frame1.add(mainPanel);
        mainPanel.add(titleLable);
        mainPanel.add(nameLable);
        mainPanel.add(passwordLable);
        mainPanel.add(text1);
        mainPanel.add(password);
        mainPanel.add(button);
        mainPanel.add(exit);
       
                 // Пользовательский размер и размещение компонента
        mainPanel.setLayout(null);
        
        titleLable.setBounds(250,40,340,35);
                 // Установить шрифт, параметры: шрифт, статус, размер
                 titleLable.setFont (new Font ("Полужирный", Font.BOLD, 34));
      
        nameLable.setBounds(74,124,150,30);
                 nameLable.setFont (new Font ("Полужирный", Font.BOLD, 24));

        passwordLable.setBounds(74,174,150,30);
                 passwordLable.setFont (new Font ("Полужирный", Font.BOLD, 24));

        text1.setBounds(204,124,260,30);
                 text1.setFont (new Font ("Полужирный", Font.BOLD, 24));

        password.setBounds(204,174,260,30);
                 password.setFont (new Font ("Полужирный", Font.BOLD, 24));

        button.setBounds(200,232,120,30);
        button.setFont (new Font ("Bold", Font.BOLD, 22));

        exit.setBounds(350,232,120,30);
                 exit.setFont (new Font ("Полужирный", Font.BOLD, 22));

                 // Установить цвет фона формы
        mainPanel.setBackground(Color.gray);
       
        frame1.setBounds(600,380,700,400);
       

        frame1.setResizable(false);
        frame1.setVisible(true);
        frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
}
   
	public  void scoretb() {
		 
		
		JFrame frame = new JFrame("Frame");
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(null);
		JLabel titleLable0 = new JLabel ("Введите оценки");
		titleLable0.setForeground(Color.white);
		titleLable0.setBounds(104,94,260,30);
		titleLable0.setFont (new Font ("Полужирный", Font.BOLD, 24));
		  
		
		JLabel titleLable1 = new JLabel ("Введите Имя, Фамилию");
		titleLable1.setForeground(Color.white);		
		titleLable1.setBounds(54,14,300,30);
		titleLable1.setFont (new Font ("Полужирный", Font.BOLD, 24));
		  
		SpinnerNumberModel numberModel = new SpinnerNumberModel(
		        new Integer(50), // value
		        new Integer(0), // min
		        new Integer(100), // max
		        new Integer(1) // step
		        );
		    JSpinner numberChooser = new JSpinner(numberModel);
		   

		    numberChooser.setBounds(150,140,70,35);
		    numberChooser.setFont (new Font ("Полужирный", Font.BOLD, 34));
		    
	

		final JButton button1 = new JButton ( "Далее" );
        button1.setUI ( new MyButtonUI () );
        
        JTextField text1 = new JTextField();

        text1.setBounds(60,55,260,30);
                 text1.setFont (new Font ("Полужирный", Font.BOLD, 24));
		  button1.addMouseListener(new MouseAdapter() {
		      @Override
		      public void mouseClicked(MouseEvent e) {
		        value += (int) numberChooser.getValue();
		         
		        counter++;
		        System.out.println(value);
		        if(counter==5) {
		        	   String name = text1.getText();
		        	   System.out.println(name);
		        	average av = new average();
					  try {
						av.avscrore(value,counter,name);
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					  counter=0;
					  value=0;
		        }
		       
		      }
		   
		    });
		 
		  
		  button1.setBounds(135,200,100,35);
	      button1.setFont (new Font ("Bold", Font.BOLD, 22));

	    mainPanel.setBackground(Color.gray);
		frame.add(mainPanel);

          frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("149452.png")));
		mainPanel.add(titleLable1);
		mainPanel.add(titleLable0);
		mainPanel.add(numberChooser);
		mainPanel.add(text1);
		mainPanel.add(button1);
		
		 
		frame.setBackground(Color.black);
		frame.setBounds(600,380,400,300);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}

}


            
        





