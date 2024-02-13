package com.billing.MedcialBillingSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class Login extends JFrame implements ActionListener{

	JLabel label1,label2,label3;
	JTextField text2;
	JPasswordField pass3;
	JButton b1,b2;
	
	Login(){
		super("Medical Billing System");
		label1 = new JLabel("WELCOME TO MEDICAL BILLING SYSTEM");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("AvantGarde", Font.BOLD, 28));
        label1.setBounds(160,60,600,40);
        add(label1);
		
        label2 = new JLabel("Username :");
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("AvantGarde", Font.BOLD, 20));
        label2.setBounds(180,150,600,40);
        add(label2);
        
        text2 =new JTextField();
        text2.setBounds(300,160,300,25);
        text2.setFont(new Font("Arial", Font.BOLD,18));
        add(text2);
        
        label3 = new JLabel("Password :");
        label3.setForeground(Color.WHITE);
        label3.setFont(new Font("AvantGarde", Font.BOLD, 20));
        label3.setBounds(180,200,600,40);
        add(label3);
        
        pass3 = new JPasswordField();
        pass3.setBounds(300,210,300,25);
        pass3.setFont(new Font("Arial", Font.BOLD,18));
        add(pass3);		
        
        b1 = new JButton("LOGIN");
        b1.setFont(new Font("Arial", Font.BOLD, 18));
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.setBounds(300,300,100, 40);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("CLEAR");
        b2.setFont(new Font("Arial", Font.BOLD, 18));
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.setBounds(450,300,100, 40);
        b2.addActionListener(this);
        add(b2);
        
    	ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("rose-petals.png"));
		Image i2 = i1.getImage().getScaledInstance(850, 480, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 850,480);
		add(image);
		
		setLayout(null);
        setSize(850,480);
        setLocation(350,200);
//      setUndecorated(true);
        setVisible(true);
        
        getRootPane().setDefaultButton(b1);

        // Add Enter key binding for the LOGIN button
        b1.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enterPressed");
        b1.getActionMap().put("enterPressed", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                b1.doClick();
            }
        });
	}
	@Override
	public void actionPerformed(ActionEvent e) {

		try {
			if(e.getSource() == b1) {
			String username = text2.getText();
			String password = pass3.getText();
			
			if (username.equals("1111") && password.equals("1111")) {
			    new Menu();
			    dispose();
			}
			else if(username.isEmpty() && password.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Please enter username and password");
			}
			else {
				JOptionPane.showMessageDialog(this,"Incorrent username or password");
			}
			}
			if(e.getSource() == b2) {
				text2.setText("");
				pass3.setText("");
			}
			}
		catch(Exception E) {
			E.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new Login();
	}
	
}
