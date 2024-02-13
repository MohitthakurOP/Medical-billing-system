package com.billing.MedcialBillingSystem;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class Search extends JFrame implements ActionListener {
	Conn connection = new Conn();
	JComboBox select;
	JButton show,enter,saveButton,backButton,printButton;
	JTextField billno,subtotal,grandtotal;
	JTable table;
	private DefaultTableModel tableModel = new DefaultTableModel();;
	JScrollPane scrollpane;
	
	public Search() {
		
		JLabel l1 = new JLabel("Medical Billing Management System");
	    l1.setFont(new Font("System",Font.BOLD,38));
		l1.setBounds(475, 5, 1000, 50);
		add(l1);
		
		JSeparator separator1 = new JSeparator();
		separator1.setForeground(Color.BLACK);
	    separator1.setBounds(0, 60, 2500, 20); 
	    add(separator1);
	    
		JLabel t1 = new JLabel("TYPE OF BILL :");
		t1.setBounds(5, 80, 200, 40);
		t1.setFont(new Font("System",Font.BOLD, 26));
		add(t1);
		
		String bill_type[] = {"Purchase","Sale"};
		select = new JComboBox(bill_type);
		select.setBackground(new Color(252,208,76));
		select.setFont(new Font("Raleway",Font.BOLD,26));
		select.setBounds(200, 80, 150, 40);
		select.addActionListener(this);
	    add(select);
	    
	    show = new JButton("SHOW");
	    show.setBounds(360, 80, 150, 40);
	    show.setFont(new Font("System",Font.BOLD, 26));
	    show.addActionListener(this);
		add(show);
		
		JLabel t2 = new JLabel("ENTER BILL NO :");
		t2.setBounds(600, 80, 300, 40);
		t2.setFont(new Font("System",Font.BOLD, 26));
		add(t2);
		
		billno = new JTextField();
		billno.setBounds(830, 80, 200, 40);
		billno.setFont(new Font("System",Font.BOLD, 26));
		add(billno);
		
		enter = new JButton("ENTER");
		enter.setBounds(1050, 80, 150, 40);
		enter.setFont(new Font("System",Font.BOLD, 26));
		enter.addActionListener(this);
		add(enter);
		
		 table = new JTable();
	     scrollpane = new JScrollPane(table);
	     scrollpane.setBounds(50, 140, 1400, 500);
	     add(scrollpane);
	     
	     backButton = new JButton("Back");
	     backButton.setFont(new Font("System", Font.BOLD, 26));
	     backButton.setBounds(160, 650, 200, 50);
	     backButton.addActionListener(this);
	     add(backButton);
	     
	     saveButton = new JButton("Save");
	     saveButton.setFont(new Font("System", Font.BOLD, 26));
	     saveButton.setBounds(450, 650, 200, 50);
	     saveButton.addActionListener(this);
	     add(saveButton);
	     
	     printButton = new JButton("Print");
	     printButton.setFont(new Font("System", Font.BOLD, 26));
	     printButton.setBounds(740, 650, 200, 50);
	     printButton.addActionListener(this);
	     add(printButton);
	     
	     JLabel l14 = new JLabel("Sub Total :");
	     l14.setFont(new Font("System",Font.BOLD,28));
	 	 l14.setBackground(Color.white);
	 	 l14.setBounds(1178, 650, 162, 40);
	 	 add(l14);
	 	 
	 	 subtotal = new JTextField();
	 	 subtotal.setFont(new Font("System",Font.BOLD,28));
	 	 subtotal.setBounds(1330, 650, 180, 40);
	 	 add(subtotal);
	 	 
	 	 JLabel l15 = new JLabel("Discount  : 10%");
	     l15.setFont(new Font("System",Font.BOLD,28));
		 l15.setBackground(Color.white);
		 l15.setBounds(1178, 690, 220, 40);
		 add(l15);
		 
		 JLabel l16 = new JLabel("Grand Total :");
	     l16.setFont(new Font("System",Font.BOLD,28));
	 	 l16.setBackground(Color.white);
	 	 l16.setBounds(1178, 730, 250, 40);
	 	 add(l16);
	 	 
	 	 grandtotal = new JTextField();
	 	 grandtotal.setFont(new Font("System",Font.BOLD,28));
		 grandtotal.setBounds(1360, 730, 150, 40);
		 add(grandtotal);
		
		setLayout(null);
		setSize(1550, 1080);
	    setLocation(0, 0);
	    setVisible(true);
	}
	
	public static void main(String[] args) {
		new Search();
	}
	
	

	 private void SalesData() {
		 try {
	            Connection conn = connection.getConnection(); // Get connection from Conn object
	            if (conn != null) {
	                String query = "SELECT * FROM Sales";
	                Statement st = conn.createStatement();
	                ResultSet rs = st.executeQuery(query);
	                ResultSetMetaData rsmd = rs.getMetaData();
	                DefaultTableModel model = (DefaultTableModel) table.getModel();

	                int cols = rsmd.getColumnCount();
	                String[] colName = new String[cols];
	                for (int i = 0; i < cols; i++) {
	                    colName[i] = rsmd.getColumnName(i+1); // Use getColumnName instead of getColumnClassName
	                    model.setColumnIdentifiers(colName);
	                    String sr_no,bill_no,date,patient_name,address,phone_no,doctor_name;
	                    while(rs.next()) {
	                    	sr_no = rs.getString(1);
	                    	bill_no = rs.getString(2);
	                    	date = rs.getString(3);
	                    	patient_name = rs.getString(4);
	                    	address = rs.getString(5);
	                    	phone_no = rs.getString(6);
	                    	doctor_name = rs.getString(7);
	                    	
	                    	String[] row = {sr_no,bill_no,date,patient_name,address,phone_no,doctor_name};
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

	 private void PurchaseData() {
		 try {
			 Connection conn = connection.getConnection();
			 if(conn != null) {
				 String query = "Select * from purchase";
				 Statement st = conn.createStatement();
	             ResultSet rs = st.executeQuery(query);
	             ResultSetMetaData rsmd = rs.getMetaData();
	             
	             DefaultTableModel model = (DefaultTableModel) table.getModel();

	                int cols = rsmd.getColumnCount();
	                String[] colName = new String[cols];
	                for (int i = 0; i < cols; i++) {
	                    colName[i] = rsmd.getColumnName(i + 1); // Use getColumnName instead of getColumnClassName
	                    model.setColumnIdentifiers(colName);
	                    String sr_no,bill_no,date,Distributor_name,address,phone_no,DistributorID;
	                    while(rs.next()) {
	                    	sr_no = rs.getString(1);
	                    	bill_no = rs.getString(2);
	                    	date = rs.getString(3);
	                    	Distributor_name = rs.getString(4);
	                    	address = rs.getString(5);
	                    	phone_no = rs.getString(6);
	                    	DistributorID = rs.getString(7);
	                    	
	                    	String[] row = {sr_no,bill_no,date,Distributor_name,address,phone_no,DistributorID};
	                    	model.addRow(row);
	                    }
	                }
	                
	                table.setRowHeight(40); //
	                JTableHeader header = table.getTableHeader();
	            	 header.setFont(new Font("System", Font.BOLD, 24));
	            	 
	            	 Font cellFont = new Font("Arial", Font.PLAIN, 22); // Change the font and size as needed
	                 table.setFont(cellFont);

	            } else {
	                System.out.println("Connection is null. Check your Conn class implementation.");
	            }
	        }
		 catch(Exception E) {
			 
		 }
	 }
	 
	 private void billData(){
		 String bill_No = billno.getText();
		 Connection conn = connection.getConnection();

		 try {
			 
			 if(conn != null) {
				 String query = "Select * from "+bill_No;
				 Statement st = conn.createStatement();
	             ResultSet rs = st.executeQuery(query);
	             ResultSetMetaData rsmd = rs.getMetaData();
	             
	             DefaultTableModel model = (DefaultTableModel) table.getModel();

	                int cols = rsmd.getColumnCount();
	                String[] colName = new String[cols];
	                for (int i = 0; i < cols; i++) {
	                    colName[i] = rsmd.getColumnName(i + 1); // Use getColumnName instead of getColumnClassName
	                    model.setColumnIdentifiers(colName);
	                    String sr_no,expiryDate,type,medicine_name,quantity,price;
	                    while(rs.next()) {
	                    	sr_no = rs.getString(1);
	                    	expiryDate = rs.getString(2);
	                    	type = rs.getString(3);
	                    	medicine_name = rs.getString(4);
	                    	quantity = rs.getString(5);
	                    	price = rs.getString(6);
	                    	
	                    	String[] row = {sr_no,expiryDate,type,medicine_name,quantity,price};
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
		 }
		 catch(Exception E) {
			 E.printStackTrace();
		 }
	 }
	@Override
	public void actionPerformed(ActionEvent e) {
		  try {
	            if (e.getSource() == show) {
	                String selecteditem = (String) select.getSelectedItem();
	                
	                DefaultTableModel model = (DefaultTableModel) table.getModel();
	                
	                // Clear existing data in the table
	                model.setRowCount(0);
	                model.setColumnCount(0);
	                
	                if ("Purchase".equals(selecteditem)) {
	                    PurchaseData();
	                } 
	                else {
	                	SalesData();
	                }	
	                }
	}	catch (Exception E) {
	            E.printStackTrace();
	        }
		  try {
		        if (e.getSource() == enter) {
		            DefaultTableModel model = (DefaultTableModel) table.getModel();

		            // Clear existing data in the table
		            model.setRowCount(0);
		            model.setColumnCount(0);

		            billData();

		            double updatedSubtotal = 0.0;

		            for (int row = 0; row < model.getRowCount(); row++) {
		                // Adjust the column index based on your data structure
		                updatedSubtotal += Double.parseDouble(model.getValueAt(row, 5).toString());
		            }

		            double discount = 0.1 * updatedSubtotal;
		            double updatedGrandtotal = updatedSubtotal - discount;

		            subtotal.setText(String.valueOf(updatedSubtotal));
		            grandtotal.setText(String.valueOf(updatedGrandtotal));
		        }
		    } catch (Exception ex) {
		        ex.printStackTrace();
		    }
		  try {
				if(e.getSource()==saveButton) {
//				distributordata();
//				saveData();	
				}
			}
			catch(Exception E) {
				E.printStackTrace();;
			}
			try {
				if(e.getSource() == backButton) {
					new Menu();
					dispose();
				}
			}
			catch(Exception E) {
				E.printStackTrace();
			}
			try {
				if(e.getSource() == printButton) {
					JOptionPane.showMessageDialog(this,"Bill is Printed.");
				}
			}
			catch(Exception E) {
				E.printStackTrace();
			}
	}
}
