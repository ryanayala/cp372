package client;


import javax.swing.JPanel;
import java.io.Reader;
import javax.swing.JTextArea;
import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Shape;

import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;
import java.awt.event.WindowEvent;
import java.awt.Color;
import java.net.*;
import java.io.*;


public class Client extends JFrame {
    public static final int WIDTH = 1500;
    public static final int HEIGHT = 1800;
    private JTextArea textbox;
    private JTextField ip_address;
    private JTextField port_num;
    private JTextField isbn;
    private JTextField title;
    private JTextField author;
    private JTextField publisher;
    private JTextField year;
    
    
    Socket clientServer;
    PrintWriter out = null;
    BufferedReader in = null;
    PrintWriter	pr;
    
    
    public class connect implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String ip_string= "";
			String port_string ="";
			int ip = 0;
			
			
			
			ip_string = ip_address.getText();
			ip_string.trim();
			port_string = port_num.getText();
			port_string.trim();
			
			ip = Integer.parseInt(port_string);
			
			try {
				clientServer = new Socket(ip_string,ip);
				pr = new PrintWriter(clientServer.getOutputStream());
	            
				
				textbox.setText("Client is connected to serever \n ");
				
				
	        } catch (UnknownHostException e0) {
	            System.err.println("Don't know about host: taranis.");
	            textbox.setText("Port Number is invlaid (hint try port 80) \n" );
	          
	            //System.exit(1);
	        } catch (IOException e1) {
	            System.err.println("Couldn't get I/O for the connection to: taranis.");
	            textbox.setText("Ip address is invalid(try 127.0.01) \n ");
	            //System.exit(1);
	        }
			
			
			

			
			
			
	        
	        
			}
		}
    
    
    private class disconnect implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
  			String Command="C";
  			
  			
  			pr.println(Command);
			pr.flush();
			
			textbox.setText("You have been diconnected from server\n");
			
		}
    	
    }
    	
    	
    
    
    private class search_command implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String ISBN;
			String TITLE;
			String AUTHOR;
			String PUB;
			String YEAR;
			String Command = "S";
			
			ISBN = isbn.getText();
			ISBN.toUpperCase();
			TITLE = title.getText();
			TITLE.toUpperCase();
			AUTHOR = author.getText();
			AUTHOR.toUpperCase();
			PUB = publisher.getText();
			PUB.toUpperCase();
			YEAR = year.getText();
			YEAR.toUpperCase();
			
			pr.println(Command + ","+ISBN +","+ TITLE + "," + AUTHOR + "," +PUB +"," + YEAR);
			pr.flush();
			
			
			try {
				InputStreamReader in = new InputStreamReader(clientServer.getInputStream());
				BufferedReader bf = new BufferedReader(in);
				String str = bf.readLine();
				textbox.setText(str +"\n");
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
    	
    }
    
    
    private class upload_command implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String ISBN1;
			String TITLE1;
			String AUTHOR1;
			String PUB1;
			String YEAR1;
			String Command = "U";
			
			ISBN1 = isbn.getText();
			ISBN1.toUpperCase();
			TITLE1 = title.getText();
			TITLE1.toUpperCase();
			AUTHOR1 = author.getText();
			AUTHOR1.toUpperCase();
			PUB1 = publisher.getText();
			PUB1.toUpperCase();
			YEAR1 = year.getText();
			YEAR1.toUpperCase();
			
			pr.println(Command +","+ISBN1 +","+ TITLE1 + "," + AUTHOR1 + "," +PUB1 +"," + YEAR1);
			pr.flush();
			try {
				InputStreamReader in = new InputStreamReader(clientServer.getInputStream());
				BufferedReader bf = new BufferedReader(in);
				
				String str = bf.readLine();
				
				//String str = bf.readLine();
				textbox.setText(str +"\n");
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
		}
    }
	
    
     private class delete_command implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String ISBN2;
			String TITLE2;
			String AUTHOR2;
			String PUB2;
			String YEAR2;
			String Command = "D";
			
			ISBN2 = isbn.getText();
			ISBN2.toUpperCase();
			TITLE2 = title.getText();
			TITLE2.toUpperCase();
			AUTHOR2 = author.getText();
			AUTHOR2.toUpperCase();
			PUB2 = publisher.getText();
			PUB2.toUpperCase();
			YEAR2 = year.getText();
			YEAR2.toUpperCase();
			
			pr.println(Command +","+ISBN2 +","+ TITLE2 + "," + AUTHOR2 + "," +PUB2 +"," + YEAR2);
			pr.flush();
			
			try {
				InputStreamReader in = new InputStreamReader(clientServer.getInputStream());
				BufferedReader bf = new BufferedReader(in);
				String str = bf.readLine();
				textbox.setText(str +"\n");
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		}
    	
    }
    
    private class edit_command implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String ISBN3;
			String TITLE3;
			String AUTHOR3;
			String PUB3;
			String YEAR3;
			String Command= "E";
			
			ISBN3 = isbn.getText();
			ISBN3.toUpperCase();
			TITLE3 = title.getText();
			TITLE3.toUpperCase();
			AUTHOR3 = author.getText();
			AUTHOR3.toUpperCase();
			PUB3 = publisher.getText();
			PUB3.toUpperCase();
			YEAR3 = year.getText();
			YEAR3.toUpperCase();
			
			pr.println( Command+","+ISBN3 +","+ TITLE3 + "," + AUTHOR3 + "," +PUB3 +"," + YEAR3);
			pr.flush();
			
			try {
				InputStreamReader in = new InputStreamReader(clientServer.getInputStream());
				BufferedReader bf = new BufferedReader(in);
				String str = bf.readLine();
				textbox.setText(str +"\n");
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
		}
			
			
    	
    }
    
    
    private class  recent_author_command implements ActionListener{

  		@Override
  		public void actionPerformed(ActionEvent e) {
  			// TODO Auto-generated method stub
  			String ISBN1 ="";
  			String TITLE1 ="";
  			String AUTHOR1="";
  			String PUB1="";
  			String YEAR1="";
  			String Command="R";
  			
  			
  			
  			
  			pr.println(Command +","+ISBN1 +","+ TITLE1 + "," + AUTHOR1 + "," +PUB1 +"," + YEAR1);
  			
  			pr.flush();
  			
  			
  			try {
				InputStreamReader in = new InputStreamReader(clientServer.getInputStream());
				BufferedReader bf = new BufferedReader(in);
				String str = bf.readLine();
				textbox.setText(str +"\n");
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
  			
  			
  		}
  		}
    
    
    public Client(){
    	
        super();
        setSize(WIDTH,HEIGHT);

        setTitle("Lib");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setLayout(new GridLayout(0,2));
        
        JPanel main_panel = new JPanel();
        main_panel.setLayout(new GridLayout(3,0));
       
        
        JPanel text_panel = new JPanel();
        text_panel.setLayout(new BorderLayout());
        text_panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        add(main_panel);
        add(text_panel);
        
        textbox = new JTextArea(20,100);
        textbox.setBackground(Color.WHITE);
        textbox.setEditable(false);
        
        text_panel.add(textbox,BorderLayout.CENTER);
        
		

        
        JPanel search_boxes = new JPanel();
        search_boxes.setLayout(new FlowLayout());
        
        isbn = new JTextField(13);
        isbn.setBackground(Color.WHITE);
        isbn.setText("isbn");
        
        title = new JTextField(20);
        title.setBackground(Color.WHITE);
        title.setText("title");
        
        author = new JTextField(20);
        author.setBackground(Color.WHITE);
        author.setText("Author");
        
        publisher = new JTextField(20);
        publisher.setBackground(Color.WHITE);
        publisher.setText("Publisher");
        
        year = new JTextField(4);
        year.setBackground(Color.WHITE);
        year.setText("Year");
        
        search_boxes.add(isbn);
        search_boxes.add(title);
        search_boxes.add(author);
        search_boxes.add(publisher);
        search_boxes.add(year);
        
        JPanel ip_panel  = new JPanel();
        ip_panel.setLayout(new FlowLayout());
        main_panel.add(ip_panel);
        
        JButton connect_button = new JButton("Connect");
        JButton disconnect_button = new JButton("Disconnect");
        ip_address = new JTextField(20);
        ip_address.setBackground(Color.WHITE);
        ip_address.setText("ip_address");
        
        port_num = new JTextField(20);
        port_num.setBackground(Color.WHITE);
        port_num.setText("port_num");
        
        ip_panel.add(connect_button);
        ip_panel.add(disconnect_button);
        ip_panel.add(ip_address);
        ip_panel.add(port_num);
        
       connect_button.addActionListener(new connect());
       
        
        
        main_panel.add(search_boxes);
        
        JPanel button_panel = new JPanel();
        button_panel.setLayout(new FlowLayout());
        main_panel.add(button_panel);
        
        JButton search_button = new JButton("Search");
        JButton upload_button = new JButton("Upload");
        JButton delete_button = new JButton("Delete");
        JButton edit_button = new JButton("Edit");
        JButton recent_author = new JButton("Most Recent Added");
        
        search_button.setBackground(Color.ORANGE);
        upload_button.setBackground(Color.BLUE);
        delete_button.setBackground(Color.GREEN);
        edit_button.setBackground(Color.RED);
        recent_author.setBackground(Color.WHITE);
        
        button_panel.add(search_button);
        button_panel.add(upload_button);
        button_panel.add(delete_button);
        button_panel.add(edit_button);
        button_panel.add(recent_author);
       
        search_button.addActionListener(new search_command());
        upload_button.addActionListener(new upload_command());
        edit_button.addActionListener(new edit_command());
        delete_button.addActionListener(new delete_command());  
        recent_author.addActionListener(new recent_author_command() );
        disconnect_button.addActionListener(new disconnect());
        




    }
}