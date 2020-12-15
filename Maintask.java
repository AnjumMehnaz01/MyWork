package io.db;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.border.EmptyBorder;
import java.sql.*;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Maintask extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Maintask frame = new Maintask();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection = null;
	private JTextField taskname;
	private JTextField taskId;
	private JTextField assignedby;
	private JTextField startdate;
	private JTextField enddate;
	private JTextField assignedto;
	private JComboBox comboBoxName;
	
	/**
	 * Create the frame.
	 */
	public Maintask() {
		connection = ConnectionJ.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 710, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel taskicon = new JLabel("");
		taskicon.setBounds(10, 11, 37, 50);
		Image img1 = new ImageIcon(this.getClass().getResource("/task.png")).getImage();
		taskicon.setIcon(new ImageIcon(img1));
		contentPane.add(taskicon);
		
		JLabel lblNewLabel = new JLabel("Main Task Details");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(46, 21, 222, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Main Task");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(46, 83, 101, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Task Id");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(46, 115, 101, 21);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Assigned by");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(46, 147, 101, 21);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Start Date");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_2.setBounds(46, 211, 101, 21);
		contentPane.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("End Date");
		lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_3.setBounds(46, 243, 101, 21);
		contentPane.add(lblNewLabel_1_1_3);
		
		taskname = new JTextField();
		taskname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		taskname.setBounds(157, 83, 297, 22);
		contentPane.add(taskname);
		taskname.setColumns(10);
		
		taskId = new JTextField();
		taskId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		taskId.setColumns(10);
		taskId.setBounds(157, 115, 297, 22);
		contentPane.add(taskId);
		
		assignedby = new JTextField();
		assignedby.setFont(new Font("Tahoma", Font.PLAIN, 15));
		assignedby.setColumns(10);
		assignedby.setBounds(157, 147, 297, 22);
		contentPane.add(assignedby);
		
		startdate = new JTextField();
		startdate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		startdate.setColumns(10);
		startdate.setBounds(157, 210, 297, 22);
		contentPane.add(startdate);
		
		enddate = new JTextField();
		enddate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		enddate.setColumns(10);
		enddate.setBounds(157, 242, 297, 22);
		contentPane.add(enddate);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Assigned to");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1.setBounds(46, 179, 101, 21);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		assignedto = new JTextField();
		assignedto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		assignedto.setColumns(10);
		assignedto.setBounds(157, 178, 297, 22);
		contentPane.add(assignedto);
		
		JLabel lblNewLabel_1_1_3_2 = new JLabel("Status");
		lblNewLabel_1_1_3_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_3_2.setBounds(46, 275, 101, 21);
		contentPane.add(lblNewLabel_1_1_3_2);
		
		comboBoxName = new JComboBox();
		comboBoxName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBoxName.setModel(new DefaultComboBoxModel(new String[] {"Not Yet Started", "In Process", "Completed", "Late"}));
		comboBoxName.setBounds(157, 275, 297, 22);
		contentPane.add(comboBoxName);
		
		JButton save = new JButton("Save ");
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "insert into tasks(maintaskId,maintaskname,startdate,enddate,status,assignedby,assignedto) values (?,?,?,?,?,?,?)";
					PreparedStatement ps = connection.prepareStatement(query);
					
					ps.setString(1, taskId.getText());
					ps.setString(2, taskname.getText());
					ps.setString(3, startdate.getText());
					ps.setString(4, enddate.getText());
					ps.setString(6, assignedby.getText());
					ps.setString(7, assignedto.getText());
					String value = comboBoxName.getSelectedItem().toString();
					ps.setString(5, value);
					
					
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
		save.setFont(new Font("Tahoma", Font.PLAIN, 16));
		save.setBounds(305, 341, 89, 28);
		contentPane.add(save);
		
		JButton btnNewButton_1 = new JButton("Add Sub Task");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Subtask subtask = new Subtask();
				subtask.setVisible(true);
				String s= taskname.getText();
				subtask.setName(s);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(513, 81, 128, 28);
		contentPane.add(btnNewButton_1);
		
		JButton reset = new JButton("Reset");
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				taskname.setText("");
				taskId.setText("");
				assignedby.setText("");
				assignedto.setText("");
				startdate.setText("");
				enddate.setText("");
				
				
			}
		});
		reset.setFont(new Font("Tahoma", Font.PLAIN, 16));
		reset.setBounds(109, 341, 89, 28);
		contentPane.add(reset);
	}
}
