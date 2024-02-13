package com.billing.MedcialBillingSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JButton;

public class Stocks extends JFrame implements ActionListener {
	
	static Conn connection = new Conn();
	static JTable table;
	private DefaultTableModel tableModel = new DefaultTableModel();
	JButton backButton,exitButton;
	JScrollPane scrollpane;
	
	Stocks(){
		JLabel l1 = new JLabel("Medical Billing Management System");
	    l1.setFont(new Font("System",Font.BOLD,38));
		l1.setBounds(475, 5, 1000, 50);
		add(l1);
		
		JSeparator separator1 = new JSeparator();
		separator1.setForeground(Color.BLACK);
	    separator1.setBounds(0, 60, 2500, 20); 
	    add(separator1);
		
	    table = new JTable();
	    scrollpane = new JScrollPane(table);
	    scrollpane.setBounds(50, 140, 1400, 500);
	    add(scrollpane);
	    
	     backButton = new JButton("Back");
	     backButton.setFont(new Font("System", Font.BOLD, 26));
	     backButton.setBounds(539, 650, 200, 50);
	     backButton.addActionListener(this);
	     add(backButton);
	     
	     exitButton = new JButton("Exit");
	     exitButton.setFont(new Font("System", Font.BOLD, 26));
	     exitButton.setBounds(822, 650, 200, 50);
	     exitButton.addActionListener(this);
	     add(exitButton);
	    
		setLayout(null);
		setSize(1550, 1080);
	    setLocation(0, 0);
	    setVisible(true);
	    
		stocksData();
			    
	}
	
	private static void stocksData() {
		 try {
	            Connection conn = connection.getConnection(); // Get connection from Conn object
	            if (conn != null) {
	                String query = "SELECT * FROM stocks";
	                Statement st = conn.createStatement();
	                ResultSet rs = st.executeQuery(query);
	                ResultSetMetaData rsmd = rs.getMetaData();
	                DefaultTableModel model = (DefaultTableModel) table.getModel();

	                int cols = rsmd.getColumnCount();
	                String[] colName = new String[cols];
	                for (int i = 0; i < cols; i++) {
	                    colName[i] = rsmd.getColumnName(i+1); // Use getColumnName instead of getColumnClassName
	                    model.setColumnIdentifiers(colName);
	                    String sr_no,tab,medicine_name,quantity,price;
	                    while(rs.next()) {
	                    	sr_no = rs.getString(1);
	                    	tab = rs.getString(2);
	                    	medicine_name = rs.getString(3);
	                    	quantity = rs.getString(4);
	                    	price = rs.getString(5);
	                    	
	                    	
	                    	String[] row = {sr_no,tab,medicine_name,quantity,price};
	                    	model.addRow(row);
	                    }
	                }
	                
	                table.setRowHeight(40); 
	                JTableHeader header = table.getTableHeader();
	            	 header.setFont(new Font("System", Font.BOLD, 24));
	            	 
	            	 Font cellFont = new Font("Arial", Font.PLAIN, 22); // Change the font and size as needed
	                 table.setFont(cellFont);
	                 

	            } else {
	                System.out.println("Connection is null. Check your Conn class implementation.");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	
	public static void main(String[] args) {
		new Stocks();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if(e.getSource() == backButton) {
				new Menu();
				dispose();
			}
			if(e.getSource() == exitButton) {
				dispose();
			}
		}
		catch(Exception E)
		{
			E.printStackTrace();
		}
	}
}
