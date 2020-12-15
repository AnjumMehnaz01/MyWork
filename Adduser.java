package io.db;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.*;

public class Adduser extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JComboBox comboBoxName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Adduser frame = new Adduser();
					frame.setTitle("Add User");
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
	public Adduser() {
		connection = ConnectionJ.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 583, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("  Add User");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(208, 11, 145, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(81, 62, 97, 22);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("First Name");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(81, 96, 97, 22);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Last Name");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(81, 129, 97, 22);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("User Id");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_3.setBounds(81, 162, 97, 22);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel userprofile = new JLabel("Profile");
		userprofile.setFont(new Font("Tahoma", Font.PLAIN, 16));
		userprofile.setBounds(81, 197, 97, 22);
		contentPane.add(userprofile);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(218, 63, 249, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(218, 96, 249, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_2.setColumns(10);
		textField_2.setBounds(218, 130, 249, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_3.setColumns(10);
		textField_3.setBounds(218, 163, 249, 20);
		contentPane.add(textField_3);
		
		JButton btnNewButton_1 = new JButton("Save");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query = "insert into users (userId,username,firstname,lastname,profile,email,password,current_state) values(?,?,?,?,?,?,?,?)";
					PreparedStatement ps = connection.prepareStatement(query);
					
					ps.setString(1, textField_3.getText());
					ps.setString(2, textField.getText());
					ps.setString(3, textField_1.getText());
					ps.setString(4, textField_2.getText());
					
					String value = comboBoxName.getSelectedItem().toString();
					ps.setString(5, value);
					ps.setString(6, textField_4.getText());
					ps.setString(7, textField_5.getText());
					ps.setString(8, "Inactive");
					
					ps.execute();
					
					JOptionPane.showMessageDialog(null, "Data Saved");
					
					ps.close();
					dispose();
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "Invalid Data");
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton_1.setBounds(335, 297, 103, 31);
		contentPane.add(btnNewButton_1);
		
		JLabel useremail = new JLabel("Email Id");
		useremail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		useremail.setBounds(81, 228, 97, 22);
		contentPane.add(useremail);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_4.setColumns(10);
		textField_4.setBounds(218, 229, 249, 20);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_5.setColumns(10);
		textField_5.setBounds(218, 264, 249, 20);
		contentPane.add(textField_5);
		
		JLabel userpassword = new JLabel("Password");
		userpassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		userpassword.setBounds(81, 263, 97, 22);
		contentPane.add(userpassword);
		
		comboBoxName = new JComboBox();
		comboBoxName.setModel(new DefaultComboBoxModel(new String[] {"admin", "manager", "developer"}));
		comboBoxName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBoxName.setBounds(218, 196, 249, 21);
		contentPane.add(comboBoxName);
		
		JButton reset = new JButton("Reset");
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				
				
			}
		});
		reset.setFont(new Font("Tahoma", Font.PLAIN, 22));
		reset.setBounds(108, 297, 103, 31);
		contentPane.add(reset);
		
	}
}
