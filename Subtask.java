package io.db;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.border.EmptyBorder;
import javax.swing.text.Caret;

import java.sql.*;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Subtask extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Subtask frame = new Subtask();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection = null;
	private JTextField subtaskId;
	private JTextField subtaskname;
	private JTextField maintaskname;
	private JTextField assignedby;
	private JTextField assignedto;
	private JTextField startdate;
	private JTextField enddate;
	public void setName(String s)
	{
		maintaskname.setText(s);
		maintaskname.setEnabled(false);
	}
	/**
	 * Create the frame.
	 */
	public Subtask() {
		connection = ConnectionJ.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		setBounds(100, 100, 697, 456);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel taskicon1 = new JLabel("");
		taskicon1.setBounds(10, 11, 31, 52);
		Image img1 = new ImageIcon(this.getClass().getResource("/subtask.png")).getImage();
		taskicon1.setIcon(new ImageIcon(img1));
		contentPane.add(taskicon1);
		
		JLabel lblSubTaskDetails = new JLabel("Sub Task Details");
		lblSubTaskDetails.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblSubTaskDetails.setBounds(43, 21, 222, 28);
		contentPane.add(lblSubTaskDetails);
		
		JLabel lblNewLabel_1 = new JLabel("Sub Task Id");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(46, 83, 101, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel assignedby1 = new JLabel("Assigned by");
		assignedby1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		assignedby1.setBounds(46, 179, 101, 21);
		contentPane.add(assignedby1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Sub Task");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(46, 115, 101, 21);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Main Task");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_1.setBounds(46, 147, 101, 21);
		contentPane.add(lblNewLabel_1_2_1);
		
		JLabel assignedto1 = new JLabel("Assigned to");
		assignedto1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		assignedto1.setBounds(46, 211, 101, 21);
		contentPane.add(assignedto1);
		
		JLabel startdate1 = new JLabel("Start Date");
		startdate1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		startdate1.setBounds(46, 243, 101, 21);
		contentPane.add(startdate1);
		
		JLabel enddate1 = new JLabel("End Date");
		enddate1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		enddate1.setBounds(46, 275, 101, 21);
		contentPane.add(enddate1);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Status");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1_1.setBounds(46, 307, 101, 21);
		contentPane.add(lblNewLabel_1_1_1_1_1_1);
		
		subtaskId = new JTextField();
		subtaskId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		subtaskId.setColumns(10);
		subtaskId.setBounds(175, 82, 297, 22);
		contentPane.add(subtaskId);
		
		subtaskname = new JTextField();
		subtaskname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		subtaskname.setColumns(10);
		subtaskname.setBounds(175, 114, 297, 22);
		contentPane.add(subtaskname);
		
		maintaskname = new JTextField();
		maintaskname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		maintaskname.setColumns(10);
		maintaskname.setBounds(175, 146, 297, 22);
		contentPane.add(maintaskname);
		
		assignedby = new JTextField();
		assignedby.setFont(new Font("Tahoma", Font.PLAIN, 15));
		assignedby.setColumns(10);
		assignedby.setBounds(175, 178, 297, 22);
		contentPane.add(assignedby);
		
		assignedto = new JTextField();
		assignedto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		assignedto.setColumns(10);
		assignedto.setBounds(175, 210, 297, 22);
		contentPane.add(assignedto);
		
		startdate = new JTextField();
		startdate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		startdate.setColumns(10);
		startdate.setBounds(175, 242, 297, 22);
		contentPane.add(startdate);
		
		enddate = new JTextField();
		enddate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		enddate.setColumns(10);
		enddate.setBounds(175, 274, 297, 22);
		contentPane.add(enddate);
		
		JComboBox comboBoxName = new JComboBox();
		comboBoxName.setModel(new DefaultComboBoxModel(new String[] {"Not Yet Started", "In Process", "Completed", "Late"}));
		comboBoxName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBoxName.setBounds(175, 309, 297, 22);
		contentPane.add(comboBoxName);
		
		JButton save = new JButton("Save ");
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "insert into subtask(subtaskId,subtaskname,maintaskname,assignedby,assignedto,startdate,enddate,status) values (?,?,?,?,?,?,?,?)";
					PreparedStatement ps = connection.prepareStatement(query);
					
					ps.setString(1, subtaskId.getText());
					ps.setString(2, subtaskname.getText());
					ps.setString(3, maintaskname.getText());
					ps.setString(4, assignedby.getText());
					ps.setString(5, assignedto.getText());
					ps.setString(6, startdate.getText());
					ps.setString(7, enddate.getText());
					String value = comboBoxName.getSelectedItem().toString();
					ps.setString(8, value);
					
					
					ps.execute();
					
					JOptionPane.showMessageDialog(null, "Sub Task Saved");
					
					ps.close();
					dispose();
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "Invalid Data");
					e1.printStackTrace();
				}
			}
		});
		save.setFont(new Font("Tahoma", Font.PLAIN, 16));
		save.setBounds(336, 355, 89, 28);
		contentPane.add(save);
		
		JButton reset = new JButton("Reset");
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subtaskname.setText("");
				maintaskname.setText("");
				subtaskId.setText("");
				assignedby.setText("");
				assignedto.setText("");
				startdate.setText("");
				enddate.setText("");
			}
		});
		reset.setFont(new Font("Tahoma", Font.PLAIN, 16));
		reset.setBounds(115, 355, 89, 28);
		contentPane.add(reset);
	}
}
