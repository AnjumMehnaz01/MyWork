package io.db;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;
import java.sql.*;


import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConfirmP extends JFrame {

	private JPanel contentPane;
	private String datetime;
	private JPasswordField passwordField_1;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfirmP frame = new ConfirmP();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
	Connection connection = null;
	
	
	
	/**
	 * Create the frame.
	 */
	public ConfirmP() {
		connection = ConnectionJ.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 421, 252);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Update Password");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(111, 25, 199, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewPassword = new JLabel("New Password");
		lblNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewPassword.setBounds(80, 113, 104, 17);
		contentPane.add(lblNewPassword);
		
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query = "UPDATE users set password=? where userid='"+textField.getText() +"'  ";
					PreparedStatement ps = connection.prepareStatement(query);
					
					ps.setString(1, passwordField_1.getText() );
					
					
					ps.execute();
					
					JOptionPane.showMessageDialog(null, "Password Changed");
					
					ps.close();
					dispose();
					
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			}
			
		});
		
	
		
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(159, 159, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblUserId = new JLabel("User Id");
		lblUserId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUserId.setBounds(80, 80, 104, 20);
		contentPane.add(lblUserId);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(175, 112, 172, 20);
		contentPane.add(passwordField_1);
		
		textField = new JTextField();
		textField.setBounds(175, 82, 172, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		
		
	}
}
