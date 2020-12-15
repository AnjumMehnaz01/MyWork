package io.db;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.sql.*;
import javax.swing.*;
import java.util.*;
import java.util.Date;

public class Timesheet extends JFrame {

	private JPanel contentPane;
	private JTextField hours;
	private JComboBox comboBox1,comboBox2,comboBox,comboBox_1,comboBox_2;
	private JTextArea textarea1,textarea2;
	private String maintask,subtask,hours1;
	
	private String workdone,day,month,year,date;
	private String other,textfield;

	/**
	 * Launch the application.
	 */
	

	public static void main(String[] args) {
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Timesheet frame = new Timesheet();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					
				}
			}
		});
	}
	
	
	Connection connection = null;
	private JTextField textField;
	/**
	 * Create the frame.
	 */
	public Timesheet() {
		connection = ConnectionJ.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 860, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Timesheet Entry");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(10, 11, 223, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Main Task Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 62, 136, 25);
		contentPane.add(lblNewLabel_1);
		
		hours = new JTextField();
		hours.setBounds(308, 108, 76, 20);
		contentPane.add(hours);
		hours.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Hours");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(308, 62, 76, 25);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Work Done");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(394, 62, 87, 25);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Sub Task Name");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_3.setBounds(156, 62, 142, 25);
		contentPane.add(lblNewLabel_1_3);
		
		comboBox1 = new JComboBox();
		comboBox1.setModel(new DefaultComboBoxModel(new String[] {"ProjectTask1", "Project2", "P3"}));
		comboBox1.setBounds(10, 108, 136, 20);
		contentPane.add(comboBox1);
		
		comboBox2 = new JComboBox();
		comboBox2.setModel(new DefaultComboBoxModel(new String[] {"Ps1", "S1", "S3", "none"}));
		comboBox2.setBounds(156, 108, 142, 20);
		contentPane.add(comboBox2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(394, 109, 210, 138);
		contentPane.add(scrollPane);
		
		textarea1 = new JTextArea();
		scrollPane.setViewportView(textarea1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(614, 108, 210, 138);
		contentPane.add(scrollPane_1);
		
		textarea2 = new JTextArea();
		scrollPane_1.setViewportView(textarea2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Other");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_1.setBounds(614, 62, 87, 25);
		contentPane.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_2 = new JLabel("Day");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(422, 25, 22, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton save = new JButton("Submit");
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				maintask = comboBox1.getSelectedItem().toString();
				subtask = comboBox2.getSelectedItem().toString();
				hours1 = hours.getText();
				workdone = textarea1.getText();
				other = textarea2.getText();
				day = comboBox.getSelectedItem().toString();
				month = comboBox_1.getSelectedItem().toString();
				year = comboBox_2.getSelectedItem().toString();
				date = year + "-" + month + "-" + day;
				textfield = textField.getText();
				
				
				try {
					String query = "insert into timesheet(maintaskname,subtaskname,date,hours,workdone,other,userId) values(?,?,?,?,?,?,?)";
					PreparedStatement ps = connection.prepareStatement(query);
					
					
					ps.setString(1, maintask);
					ps.setString(2, subtask);
					ps.setString(3, date);
					ps.setString(4, hours1);
					
					
					ps.setString(5, workdone);
					
					ps.setString(6, other);
					ps.setString(7, textfield);
					
					
					ps.execute();
					
					
					
					
					ps.close();
					dispose();
					
				}catch(Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Enter Valid Data!!");
				}
				
			}
		});
		save.setFont(new Font("Tahoma", Font.PLAIN, 14));
		save.setBounds(361, 271, 95, 32);
		contentPane.add(save);
		
		JLabel lblNewLabel_2_1 = new JLabel("Month");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_1.setBounds(491, 25, 35, 15);
		contentPane.add(lblNewLabel_2_1);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboBox_1.setBounds(531, 23, 36, 20);
		contentPane.add(comboBox_1);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBox.setBounds(446, 23, 35, 20);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Year");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_1_1.setBounds(576, 26, 35, 14);
		contentPane.add(lblNewLabel_2_1_1);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"2020"}));
		comboBox_2.setBounds(605, 23, 54, 20);
		contentPane.add(comboBox_2);
		
		JLabel lblNewLabel_1_4 = new JLabel("User Id");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_4.setBounds(10, 157, 62, 25);
		contentPane.add(lblNewLabel_1_4);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(82, 161, 76, 20);
		contentPane.add(textField);
	}
}
