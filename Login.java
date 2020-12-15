package io.db;
import java.sql.*;
import javax.swing.*;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frame;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	} 
	Connection connection = null;
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel lblNewLabel;
	private String username22;
	private String x;
	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
		connection = ConnectionJ.dbConnector();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 702, 388);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(UIManager.getColor("InternalFrame.activeTitleGradient"));
		panel.setBounds(0, 0, 686, 350);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel username = new JLabel("UserName");
		username.setBounds(260, 123, 105, 33);
		username.setFont(new Font("Tahoma", Font.PLAIN, 22));
		panel.add(username);
		
		JLabel password = new JLabel("Password");
		password.setBounds(260, 167, 105, 33);
		password.setFont(new Font("Tahoma", Font.PLAIN, 22));
		panel.add(password);
		
		textField = new JTextField();
		textField.setBounds(397, 106, 249, 52);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton loginbutton = new JButton("Login");
		Image img = new ImageIcon(this.getClass().getResource("/ok.png")).getImage();
		loginbutton.setIcon(new ImageIcon(img));
		loginbutton.setBounds(431, 266, 127, 39);
		loginbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try {
					x = textField.getText();
					String query = "select * from mydb.users where userId=? and password=? ";
					PreparedStatement ps = connection.prepareStatement(query);
					ps.setString(1, textField.getText());
					ps.setString(2, passwordField.getText());
					
					ResultSet rs = ps.executeQuery();
					
					
					
					int count=0;
					
					while(rs.next())
					{
						
						count = count+1;
					}
					if(count==1)
					{
						
						frame.dispose();
						MenuJ menuj = new MenuJ();
						menuj.setVisible(true);
					
					}
					else if(count>1)
					{
						JOptionPane.showMessageDialog(null, "Duplicate Username and Password");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Username and Password is not Correct Try again...");
					}
					
					rs.close();
					ps.close();
				}catch(Exception e) 
				{
					JOptionPane.showMessageDialog(null, e);
				}
				
				
				
			}
		});
		loginbutton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(loginbutton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(397, 162, 249, 52);
		panel.add(passwordField);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(70, 86, 180, 203);
		Image img1 = new ImageIcon(this.getClass().getResource("/login.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img1));
		panel.add(lblNewLabel);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRegister.setBounds(222, 266, 127, 39);
		panel.add(btnRegister);
		
		
		
	}
}
