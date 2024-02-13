package com.billing.MedcialBillingSystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Random;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.SwingConstants;

public class Purchase extends JFrame implements ActionListener{
	
	Conn Connection = new Conn();
	Random ran = new Random();
	long no4 = (ran.nextLong(9000) + 1000);
	String no = "P" + Math.abs(no4);
	LocalDate date =LocalDate.now();
	JTextField Textdistributor,TextID,Textphone,Textaddress,sr,type,Mname,qnt,price,amt,subtotal,grandtotal; 
	private JTable table;
	private DefaultTableModel tableModel;
	private JButton addButton, saveButton,backButton,printButton;
	JComboBox comboBox;
	private int srcounter=1,check;
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	String formattedDate = LocalDate.now().format(formatter);
	
	public Purchase(){

	JLabel l1 = new JLabel("Medical Billing Management System");
    l1.setFont(new Font("System",Font.BOLD,38));
	l1.setBounds(475, 10, 1000, 50);
	add(l1);
	
	JSeparator separator1 = new JSeparator();
	separator1.setForeground(Color.BLACK);
    separator1.setBounds(0, 60, 2500, 20); 
    add(separator1);

    JLabel l2 = new JLabel("Bill no : "+no);
    l2.setFont(new Font("System",Font.BOLD,28));
	l2.setBounds(10, 70, 250, 40);
	add(l2);
	
	JLabel l3 = new JLabel("Date :"+date);
    l3.setFont(new Font("System",Font.BOLD,28));
	l3.setBounds(1300, 70, 500, 40);
	add(l3);
    
    JLabel l4 = new JLabel("Distributor Name :");
    l4.setFont(new Font("System",Font.BOLD,28));
	l4.setBounds(10, 130, 250, 40);
	add(l4);

	String distributor[] = {"BH Pharma","Arihant Distributor","Laxmi Distributor"};
    comboBox = new JComboBox(distributor);
    comboBox.setBackground(new Color(252,208,76));
    comboBox.setFont(new Font("Raleway",Font.BOLD,22));
    comboBox.setBounds(270, 130, 330, 40);
    comboBox.addActionListener(this);
    add(comboBox);

    JLabel l5 = new JLabel("Distributor ID:");
    l5.setFont(new Font("System",Font.BOLD,28));
   	l5.setBounds(10, 200, 250, 40);
   	add(l5);	
   	
   	TextID =new JTextField();
   	TextID.setBounds(210, 200, 250, 40);
   	TextID.setFont(new Font("Arial", Font.BOLD,18));
    add(TextID);
   	
    JLabel l6 = new JLabel("Phone no :");
    l6.setFont(new Font("System",Font.BOLD,28));
   	l6.setBounds(1230, 130, 250, 40);
   	add(l6);
    
	Textphone =new JTextField();
    Textphone.setBounds(1380, 130, 140, 40);
    Textphone.setFont(new Font("Arial", Font.BOLD,18));
    add(Textphone);
    
    JLabel l7 = new JLabel("Bill Type : Purchase");
    l7.setFont(new Font("System",Font.BOLD,28));
   	l7.setBounds(1230, 200, 280, 40);
   	add(l7);
   	
   	JLabel l8 = new JLabel("Address :");
   	l8.setFont(new Font("System",Font.BOLD,28));
	l8.setBounds(610, 130, 250, 40);
	add(l8);
	
	Textaddress = new JTextField();
	Textaddress.setBounds(750, 130, 450, 40);
    Textaddress.setFont(new Font("Arial", Font.BOLD,18));
    add(Textaddress);
		
    //table
	JSeparator separator2 = new JSeparator();
	separator2.setForeground(Color.BLACK);
    separator2.setBounds(0, 250, 2310, 20); 
    add(separator2);

    JLabel l10 = new JLabel("Type");
	l10.setHorizontalAlignment(SwingConstants.CENTER);
	l10.setFont(new Font("System",Font.BOLD,28));
	l10.setBackground(Color.white);
	l10.setBounds(10, 270, 95, 40);
	add(l10);
	
	type = new JTextField();
	type.setBounds(122, 270, 109, 40);
	type.setFont(new Font("Arial", Font.BOLD,18));
    add(type);
    
    JLabel l11 = new JLabel("Medicine Name");
	l11.setHorizontalAlignment(SwingConstants.CENTER);
	l11.setFont(new Font("System",Font.BOLD,28));
	l11.setBackground(Color.white);
	l11.setBounds(241, 270, 234, 40);
	add(l11);
	
	Mname = new JTextField();
	Mname.setBounds(485, 270, 338, 40);
	Mname.setFont(new Font("Arial", Font.BOLD,18));
    add(Mname);
    
	JLabel l12 = new JLabel("Quantity");
	l12.setHorizontalAlignment(SwingConstants.CENTER);
	l12.setFont(new Font("System",Font.BOLD,28));
	l12.setBackground(Color.white);
	l12.setBounds(844, 270, 150, 40);
	add(l12);
	
    qnt = new JTextField();
    qnt.setBounds(1004, 270 , 109, 40);
    qnt.setFont(new Font("Arial", Font.BOLD,18));
    add(qnt);
	
	JLabel l13 = new JLabel("Price");
	l13.setHorizontalAlignment(SwingConstants.CENTER);
	l13.setFont(new Font("System",Font.BOLD,28));
	l13.setBackground(Color.white);
	l13.setBounds(1111, 270, 109, 40);
	add(l13);
	
    price = new JTextField();
    price.setBounds(1230, 270, 124, 40);
    price.setFont(new Font("Arial", Font.BOLD,18));
    add(price);
    
    setBackground(new Color(225,225,225));	
	setLayout(null);
	
	 tableModel = new DefaultTableModel();
     tableModel.addColumn("Sr_no");
     tableModel.addColumn("Type");
     tableModel.addColumn("Medicine Name");
     tableModel.addColumn("Quantity");
     tableModel.addColumn("Price");
     tableModel.addColumn("Amount");
     
     table = new JTable(tableModel);
     table.setFont(new Font("Arial", Font.PLAIN, 18)); // Adjust the font size as needed
 	 table.setRowHeight(40); // Adjust the row height as needed
 	 JTableHeader header = table.getTableHeader();
 	 header.setFont(new Font("System", Font.BOLD, 24)); // Adjust the font size as needed
 	
     JScrollPane scrollPane = new JScrollPane(table);
     scrollPane.setBounds(0, 340, 1550, 300);
     add(scrollPane);

     addButton = new JButton("INSERT");
     addButton.setFont(new Font("System", Font.BOLD, 22));
     addButton.setBounds(1364, 260, 159, 50);
     addButton.addActionListener(this);
     add(addButton);
     
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
 	 
 	 JLabel l15 = new JLabel("wholesale rate  : 40%");
     l15.setFont(new Font("System",Font.BOLD,28));
	 l15.setBackground(Color.white);
	 l15.setBounds(1178, 690, 300, 40);
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
	 
	 
     
    setSize(1550, 1080);
    setLocation(0, 0);
    setVisible(true);
    
    getRootPane().setDefaultButton(addButton);

    // Add Enter key binding for the LOGIN button
    addButton.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enterPressed");
    addButton.getActionMap().put("enterPressed", new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	addButton.doClick();
        }
    });
    
}
   
public static void main(String[] args) {
		new Purchase();  //initialization of constructor
	}

//adding medicine into table
private void addMedicine() {
    String sr_no = String.valueOf(srcounter++);
    String Mtype = type.getText();
    String medicineName = Mname.getText();
    String quantity = qnt.getText();
    String Mprice = price.getText();
    
    //check if fields are empty or not
    if ( Mtype.isEmpty() || medicineName.isEmpty() || quantity.isEmpty() || Mprice.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please fill in all the fields.");
        return;
    }
    
    try {
    // converting string mprice and quantity into integer
   //and storing it in amountvalue as a string
    double amountValue = Double.parseDouble(Mprice) * Integer.parseInt(quantity);
    String amount = String.valueOf(amountValue);
    
    //adding value in the table
    Object[] rowData = {sr_no, Mtype, medicineName, quantity, Mprice, amount};
    tableModel.addRow(rowData);

    double updatedSubtotal = 0.0;
    //adding the value of all price rows into updatedSubtotal
    for (int row = 0; row < tableModel.getRowCount(); row++) {
        updatedSubtotal += Double.parseDouble(tableModel.getValueAt(row, 5).toString());
    }
    double discount = 0.4 * updatedSubtotal;
    double updatedGrandtotal = updatedSubtotal - discount;
    
    //seting and clearing textboxes
    subtotal.setText(String.valueOf(updatedSubtotal));
    grandtotal.setText(String.valueOf(updatedGrandtotal));
    type.setText("");
    Mname.setText("");
    qnt.setText("");
    price.setText("");
    }
    catch(NumberFormatException e) {
    	 JOptionPane.showMessageDialog(this, "Please enter valid integers for Quantity and Price.");
    }
    catch(Exception e) {
    	e.printStackTrace();
    }
    }

//adding distributor data into purchase table
private void distributordata() {
	String bill_no = no;
	LocalDate date1 = date;
	String distributor = (String) comboBox.getSelectedItem();
	String address = Textaddress.getText();
	String phone = Textphone.getText();
	String disID = TextID.getText();

    try {
    	 Connection = new Conn();
    	 String query = "INSERT INTO Purchase (bill_no, date, distributor_name, address, phone_no, distributor_id) VALUES (?, ?, ?, ?, ?, ?)";
    	 PreparedStatement preparedStatement = Connection.prepareStatement(query);
    	    
        preparedStatement.setString(1, bill_no);
        preparedStatement.setString(2, date1.toString());
        preparedStatement.setString(3, distributor);
        preparedStatement.setString(4, address);
        preparedStatement.setString(5, phone);
        preparedStatement.setString(6, disID);
        preparedStatement.executeUpdate();
        
    } catch (SQLException E) {
        E.printStackTrace();
    }
}

//creating a table on with the name as value billno
private void saveData() {
    String tableName = no; 
    try {
        Connection = new Conn();
        String query1 = "CREATE TABLE IF NOT EXISTS " + tableName + " (sr_no INT AUTO_INCREMENT PRIMARY KEY, type VARCHAR(30), medicine_name VARCHAR(30), quantity VARCHAR(30), price VARCHAR(30), amount VARCHAR(30))";
        PreparedStatement preparedStatement = Connection.prepareStatement(query1);
        preparedStatement.execute();

    } catch (SQLException e) {
        e.printStackTrace();
    } 
    finally {
        try {
            if (Connection != null) {
                Connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //adding medicines into the database 
    //accessing all the rows and coloumn 
    for (int row = 0; row < tableModel.getRowCount(); row++) {
        String sr_no = tableModel.getValueAt(row, 0).toString();
        String type = tableModel.getValueAt(row, 1).toString();
        String medicineName = tableModel.getValueAt(row, 2).toString();
        String quantity = tableModel.getValueAt(row, 3).toString();
        String price = tableModel.getValueAt(row, 4).toString();
        String amount = tableModel.getValueAt(row, 5).toString();
    	
        int quantity1 = Integer.parseInt(quantity);
        int price1 = Integer.parseInt(price);
        updateStocksTable(type.toLowerCase(),medicineName.toLowerCase(),quantity1,price1);
        
        try{
            Connection = new Conn();
            String query2 = "INSERT INTO " + tableName + " (type, medicine_name, quantity, price, amount) VALUES ( ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = Connection.prepareStatement(query2);

            preparedStatement.setString(1, type);
            preparedStatement.setString(2, medicineName);
            preparedStatement.setString(3, quantity);
            preparedStatement.setString(4, price);
            preparedStatement.setString(5, amount);

            int rowsAffected = preparedStatement.executeUpdate();
            check = rowsAffected;
            preparedStatement.close();
           
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (Connection != null) {
                    Connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }   
    }
    if (check > 0) {
        JOptionPane.showMessageDialog(this, "Data saved successfully!");
    } else {
        JOptionPane.showMessageDialog(this, "Data failed to save!");
    }
}

//updating stocks in database
private void updateStocksTable(String type,String medicineName, int quantity,int price) {
    try {
        Connection = new Conn();
        String updateQuery = "Insert into Stocks (tab,medicine_name,quantity,price) values (?,?,?,?)";
        PreparedStatement preparedStatement = Connection.prepareStatement(updateQuery);

        preparedStatement.setString(1, type);
        preparedStatement.setString(2, medicineName);
        preparedStatement.setInt(3, quantity);
        preparedStatement.setInt(4, price);
        
        preparedStatement.executeUpdate();
        
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (Connection != null) {
                Connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

//checking which distributor is selected as per that textfields are changes
private void setDistributorDetails(String selectedDistributor) {
    switch (selectedDistributor) {
        case "BH Pharma":
            Textaddress.setText("Infront Gajanan Mandir");
            Textphone.setText("7896573252");
            TextID.setText("BH07810");
            break;
        case "Arihant Distributor":
            Textaddress.setText("Samarth nagar,Opposite of Vivekanand College");
            Textphone.setText("8778256514");
            TextID.setText("AD06910");
            break;
        case "Laxmi Distributor":
            Textaddress.setText("CIDCO MIDC");
            Textphone.setText("9865754869");
            TextID.setText("LD04310");
            break;
        default:
            Textaddress.setText("");
            Textphone.setText("");
            break;
    }
}


@Override
public void actionPerformed(ActionEvent e) {

	try {
		if(e.getSource()==addButton) {
			addMedicine();
		}
	}
	catch(Exception E) {
		E.printStackTrace();
	}
	try {
		if(e.getSource()==saveButton) {
		distributordata();
		saveData();	
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
	try {
		String selectedDistributor = (String) comboBox.getSelectedItem();
		setDistributorDetails(selectedDistributor);
	}
	catch(Exception E) {
		E.printStackTrace();
	}
}
}
