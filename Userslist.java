package io.db;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.Font;

public class Userslist extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Userslist frame = new Userslist();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection = null;
	private JTable table;
	private JButton btnNewButton;
	private JLabel lblUserList;
	private JButton btnNewButton_1;
	
	/**
	 * Create the frame.
	 */
	public Userslist() {
		connection = ConnectionJ.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 735, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(56, 40, 611, 325);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnNewButton = new JButton("Refresh Table");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try {
					String query = "select * from users";
					PreparedStatement ps = connection.prepareStatement(query);
					ResultSet rs = ps.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(318, 376, 137, 31);
		contentPane.add(btnNewButton);
		
		lblUserList = new JLabel("User List");
		lblUserList.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblUserList.setBounds(56, 11, 106, 25);
		contentPane.add(lblUserList);
		
		btnNewButton_1 = new JButton("Close");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
					
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			}
				
		});
		btnNewButton_1.setBounds(581, 382, 89, 23);
		contentPane.add(btnNewButton_1);
		
		
	}
	
}
