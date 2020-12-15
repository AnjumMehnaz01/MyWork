package io.db;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.awt.Color;

import java.awt.Image;
import java.awt.Font;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import java.awt.Button;
import java.awt.SystemColor;

public class MenuJ extends JFrame {

	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuJ frame = new MenuJ();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection = null;
	private JTable table;
	private JTable table_1;
	private JRadioButton assigned1,assigned2;
	private String date,activ="Active",inactiv="Inactive";
	private JLabel username11,emailid11;
	private JTable table_2;
	private JTextField soeid;
	private String string,com1,com2;
	private JTextField textField;
	
	
	
	
	
	/**
	 * Create the frame.
	 */
	public MenuJ() {
		getContentPane().setBackground(new Color(70, 130, 180));
		setTitle("Task Management System");
		connection = ConnectionJ.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 870, 497);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(SystemColor.desktop);
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu_1 = new JMenu("Task");
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		menuBar.add(mnNewMenu_1);
		
		JMenu mnNewMenu_5 = new JMenu("New Task    ");
		mnNewMenu_1.add(mnNewMenu_5);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Main Task   ");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Maintask maintask = new Maintask();
				maintask.setVisible(true);
			}
		});
		mnNewMenu_5.add(mntmNewMenuItem);
		mntmNewMenuItem.setEnabled(false);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Sub Task    ");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Subtask subtask = new Subtask();
				subtask.setVisible(true);
			}
		});
		mnNewMenu_5.add(mntmNewMenuItem_1);
		mntmNewMenuItem_1.setEnabled(false);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Task List");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Taskslist tasklist = new Taskslist();
				tasklist.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_6);
		
		JMenu mnNewMenu_2 = new JMenu("Maintenance");
		menuBar.add(mnNewMenu_2);
		
		JMenu mnNewMenu_6 = new JMenu("User");
		mnNewMenu_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		mnNewMenu_2.add(mnNewMenu_6);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Add User");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Adduser adduser = new Adduser();
				adduser.setVisible(true);
			}
		});
		mnNewMenu_6.add(mntmNewMenuItem_3);
		mntmNewMenuItem_3.setEnabled(false);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Update User");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Updateuser updateuser = new Updateuser();
				updateuser.setVisible(true);
			}
		});
		mnNewMenu_6.add(mntmNewMenuItem_4);
		mntmNewMenuItem_4.setEnabled(false);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Delete User");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Deleteuser deleteuser = new Deleteuser();
				deleteuser.setVisible(true);
			}
		});
		mnNewMenu_6.add(mntmNewMenuItem_8);
		mntmNewMenuItem_8.setEnabled(false);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Users List");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Userslist userslist = new Userslist();
				userslist.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_5);
		
		JMenu mnNewMenu_3 = new JMenu("Timesheet");
		mnNewMenu_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
							}
		});
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Timesheet Entry");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Timesheet timesheet = new Timesheet();
				timesheet.setVisible(true);
				

			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_9);
		
		JMenu mnNewMenu_4 = new JMenu("My Settings");
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("My Account");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Change Password");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfirmP confirmp = new ConfirmP();
				confirmp.setVisible(true);
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_7);
		getContentPane().setLayout(null);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 33, 834, 394);
		getContentPane().add(scrollPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(SystemColor.inactiveCaption);
		scrollPane.setViewportView(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setForeground(SystemColor.desktop);
		tabbedPane.addTab(" Home ", null, panel, null);
		panel.setLayout(null);
		
		JInternalFrame internalFrame = new JInternalFrame("New JInternalFrame");
		internalFrame.setBounds(616, 11, 201, 165);
		panel.add(internalFrame);
		internalFrame.getContentPane().setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		desktopPane.setBounds(0, 0, 185, 136);
		internalFrame.getContentPane().add(desktopPane);
		
		JLabel lblNewLabel = new JLabel("Not Yet Started");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 21, 115, 17);
		desktopPane.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 255));
		panel_2.setBounds(143, 21, 17, 17);
		desktopPane.add(panel_2);
		
		JLabel lblInProcess = new JLabel("In Process");
		lblInProcess.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInProcess.setBounds(10, 49, 115, 17);
		desktopPane.add(lblInProcess);
		
		JLabel lblCompleted = new JLabel("Completed");
		lblCompleted.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCompleted.setBounds(10, 77, 115, 17);
		desktopPane.add(lblCompleted);
		
		JLabel lblLate = new JLabel("Late");
		lblLate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLate.setBounds(10, 105, 115, 17);
		desktopPane.add(lblLate);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(new Color(50, 205, 50));
		panel_2_1.setBounds(143, 49, 17, 17);
		desktopPane.add(panel_2_1);
		
		JPanel panel_2_2 = new JPanel();
		panel_2_2.setBackground(new Color(255, 255, 0));
		panel_2_2.setBounds(143, 77, 17, 17);
		desktopPane.add(panel_2_2);
		
		JPanel panel_2_3 = new JPanel();
		panel_2_3.setBackground(Color.RED);
		panel_2_3.setForeground(Color.WHITE);
		panel_2_3.setBounds(143, 105, 17, 17);
		desktopPane.add(panel_2_3);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 11, 596, 165);
		panel.add(scrollPane_3);
		
		table_2 = new JTable();
		scrollPane_3.setViewportView(table_2);
		table_2.setBorder(UIManager.getBorder("DesktopIcon.border"));
		
		
		JPanel container = new JPanel();
		JScrollPane jsp = new JScrollPane(container);
		
		
		
		internalFrame.setVisible(true);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaption);
		tabbedPane.addTab(" Main Projects", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 11, 807, 331);
		panel_1.add(scrollPane_1);
		
		table = new JTable();
		scrollPane_1.setViewportView(table);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(SystemColor.inactiveCaption);
		tabbedPane.addTab("Tickets", null, panel_4, null);
		panel_4.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(SystemColor.menu);
		panel_5.setBounds(0, 0, 196, 364);
		panel_4.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Filter Tickets");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(4, 0, 98, 20);
		panel_5.add(lblNewLabel_1);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(SystemColor.menu);
		panel_6.setBounds(595, 0, 232, 364);
		panel_4.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_1_3 = new JLabel("Tickets List");
		lblNewLabel_1_3.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel_1_3.setBounds(4, 0, 98, 20);
		panel_6.add(lblNewLabel_1_3);
		
		Panel panel_7 = new Panel();
		panel_7.setBackground(SystemColor.scrollbar);
		panel_7.setBounds(196, 0, 400, 22);
		panel_4.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("New Ticket");
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabel_3.setBounds(4, 1, 82, 18);
		panel_7.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Name");
		lblNewLabel_4.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(206, 26, 46, 18);
		panel_4.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("*");
		lblNewLabel_5.setForeground(new Color(255, 0, 0));
		lblNewLabel_5.setBounds(246, 28, 17, 14);
		panel_4.add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setBounds(304, 26, 260, 20);
		panel_4.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_4_1 = new JLabel("Type");
		lblNewLabel_4_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblNewLabel_4_1.setBounds(206, 51, 36, 18);
		panel_4.add(lblNewLabel_4_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Permission Request", "Project Request", "Purchasing Request", "Report Request", "Telephony Request", "Training Request", "Workplace Move Request"}));
		comboBox.setBounds(304, 51, 162, 20);
		panel_4.add(comboBox);
		
		JLabel lblNewLabel_5_1 = new JLabel("*");
		lblNewLabel_5_1.setForeground(Color.RED);
		lblNewLabel_5_1.setBounds(238, 53, 17, 14);
		panel_4.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Status");
		lblNewLabel_4_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblNewLabel_4_1_1.setBounds(206, 80, 36, 18);
		panel_4.add(lblNewLabel_4_1_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.inactiveCaption);
		tabbedPane.addTab("My Account", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("User Name");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(18, 36, 75, 14);
		panel_3.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Emain Id");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(18, 61, 75, 14);
		panel_3.add(lblNewLabel_1_2);
		
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(18, 165, 799, 174);
		panel_3.add(scrollPane_2);
		
		table_1 = new JTable();
		scrollPane_2.setViewportView(table_1);
		
		
		
		
		
		
		username11 = new JLabel("User Id");
		username11.setFont(new Font("Tahoma", Font.PLAIN, 14));
		username11.setBounds(119, 32, 315, 23);
		panel_3.add(username11);
		
		emailid11 = new JLabel("User Id");
		emailid11.setFont(new Font("Tahoma", Font.PLAIN, 14));
		emailid11.setBounds(119, 57, 315, 23);
		
		
		panel_3.add(emailid11);
		
		soeid = new JTextField();
		soeid.setBackground(new Color(255, 255, 255));
		string = soeid.getText();
		activ = "Active";
		
		JButton btnNewButton_2 = new JButton("Go");
		btnNewButton_2.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		btnNewButton_2.setBackground(SystemColor.menu);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					String query = "select * from tasks";
					PreparedStatement ps = connection.prepareStatement(query);
					ResultSet rs = ps.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					String query1 = "select profile from users where userId='"+ soeid.getText() +"' ";
					PreparedStatement ps1 = connection.prepareStatement(query1);
					ResultSet rs1 = ps1.executeQuery();
					if(rs1.next())
					{
						String com1 = rs1.getString(1);
						if(com1.contentEquals("developer"))
						{
							mntmNewMenuItem_3.setEnabled(false);
							mntmNewMenuItem_4.setEnabled(false);
							mntmNewMenuItem_8.setEnabled(false);
							mntmNewMenuItem.setEnabled(false);
							mntmNewMenuItem_1.setEnabled(false);
						}
						else
						{
							
							mntmNewMenuItem_3.setEnabled(true);
							mntmNewMenuItem_4.setEnabled(true);
							mntmNewMenuItem_8.setEnabled(true);
							mntmNewMenuItem.setEnabled(true);
							mntmNewMenuItem_1.setEnabled(true);
						}
					}
					
					
					
					String query2 = "select username from users where userId='"+ soeid.getText() +"' ";
					PreparedStatement ps2 = connection.prepareStatement(query2);
					ResultSet rs2 = ps2.executeQuery();
					if(rs2.next())
					{
						String d2 = rs2.getString(1);
						username11.setText(d2);
					}
					
					
					String query3 = "select email from users where userId='"+soeid.getText()+"'";
					PreparedStatement ps3 = connection.prepareStatement(query3);
					ResultSet rs3 = ps3.executeQuery();
					if(rs3.next())
					{
						String d3 = rs3.getString(1);
						emailid11.setText(d3);
					}
					
					String query4 = "select maintaskId,maintaskname,assignedto,status from tasks";
					PreparedStatement ps4 = connection.prepareStatement(query4);
					ResultSet rs4 = ps4.executeQuery();
					table_2.setModel(DbUtils.resultSetToTableModel(rs4));
					
					
					String query5 = "UPDATE mydb.users set current_state=? where userId='"+ soeid.getText() +"'  ";
					PreparedStatement ps5 = connection.prepareStatement(query5);
					
					ps5.setString(1,  activ);
					ps5.execute();
					ps5.close();
					
					
					ps.close();
					rs.close();
					
					
					ps2.close();
					rs2.close();
					ps3.close();
					rs3.close();
					ps4.close();
					rs4.close();
				}catch(Exception e1) {
					e1.printStackTrace();
				}
				
				soeid.setEditable(false);
			}
		});
		inactiv = "Inactive";
		JButton btnNewButton = new JButton("Logout");
		btnNewButton.setBackground(SystemColor.menu);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query6 = "UPDATE mydb.users set current_state=? where userId='"+ soeid.getText() +"'  ";
					PreparedStatement ps6 = connection.prepareStatement(query6);
					
					ps6.setString(1,  inactiv);
					ps6.execute();
					ps6.close();
					
					int x = JOptionPane.showConfirmDialog(null, "Do you really want to quit?", "Comfirm", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
					if(x==JOptionPane.YES_OPTION)
					{
						dispose();
					}
					
					
					
					
				}catch(Exception e1) {
					e1.printStackTrace();
					
				}
				
			}
		});
		btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		btnNewButton.setBounds(755, 4, 89, 23);
		getContentPane().add(btnNewButton);
		
		
		assigned1 = new JRadioButton("Main Tasks assigned to me");
		assigned1.setBackground(SystemColor.inactiveCaption);
		assigned1.setForeground(SystemColor.desktop);
		assigned1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(assigned1.isSelected())
				{
					assigned2.setSelected(false);
				}
				try {
					String query = "select maintaskId,maintaskname,assignedby,startdate,enddate,status from mydb.tasks";
					PreparedStatement ps = connection.prepareStatement(query);
					ResultSet rs = ps.executeQuery();
					table_1.setModel(DbUtils.resultSetToTableModel(rs));
					
					
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		assigned1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		assigned1.setBounds(18, 140, 207, 23);
		panel_3.add(assigned1);
		
		assigned2 = new JRadioButton("Sub Tasks assigned to me");
		assigned2.setBackground(SystemColor.inactiveCaption);
		assigned2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(assigned2.isSelected())
				{
					assigned1.setSelected(false);
				}
				try {
					String query1 = "select subtaskId,subtaskname,maintaskname,assignedby,startdate,enddate,status from mydb.subtask";
					PreparedStatement ps1 = connection.prepareStatement(query1);
					ResultSet rs1 = ps1.executeQuery();
					table_1.setModel(DbUtils.resultSetToTableModel(rs1));
					
					
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		assigned2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		assigned2.setBounds(227, 140, 207, 23);
		panel_3.add(assigned2);
		
			
		
		
		
		btnNewButton_2.setBounds(115, 5, 67, 23);
		getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("My Id:");
		lblNewLabel_2.setBounds(10, 8, 46, 18);
		getContentPane().add(lblNewLabel_2);
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		
		soeid.setBounds(50, 8, 51, 18);
		getContentPane().add(soeid);
		soeid.setColumns(10);
		
		Image img = new ImageIcon(this.getClass().getResource("/properties.png")).getImage();
		
		
	}
	}
	

