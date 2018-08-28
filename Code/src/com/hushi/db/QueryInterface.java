package com.hushi.db;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.JTableHeader;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.security.Timestamp;
import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class QueryInterface {

	private JFrame frame;
	private JTable table;
	private Object[][] jet;
	private JMenuBar menuBar;
	private JMenu menu;
	/**
	 * Launch the application.
	 */

			public void run() {
				try {
					QueryInterface window = new QueryInterface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			public void getjetlength()
			{
				Connection con=Linkdb.getcon();
				int count=0;
				String sql="select count(*) from 货物";
			
				
						try {
							PreparedStatement ps=con.prepareStatement(sql);
							ResultSet rs=ps.executeQuery();
							while(rs.next()){
								count=rs.getInt(1);
							}
							
							con.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						jet=new Object[count][];

					}
			
					public void getdata(){
						Connection con=Linkdb.getcon();
						String sql="select  * from 货物";
						
							try {
								PreparedStatement ps=con.prepareStatement(sql);
								ResultSet rs=ps.executeQuery();
								

								int index=0;
								while(rs.next())
								{
									int id=rs.getInt(1);
									String name=rs.getString(2);
									String name1=rs.getString(3);
									SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
									String format1 = sdf.format(rs.getDate(4));
									String format2 = sdf.format(rs.getDate(5));								
									int num=rs.getInt(6);
									int num1=rs.getInt(7);
									Object[] p={id,name,name1,format1,format2,num,num1};
									jet[index]=p;
									index++;
								}
								
								
								con.close();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}							
					}


	private double Date(int int1) {
						// TODO Auto-generated method stub
						return 0;
					}
	private double Timestamp(int int1) {
						// TODO Auto-generated method stub
						return 0;
					}
	/**
	 * Create the application.
	 */
	public QueryInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		getjetlength();
		getdata();
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 434, 262);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			 jet,
			new String[] {
				"\u8D27\u7269\u7F16\u53F7", "\u8D27\u7269\u540D\u79F0", "\u751F\u4EA7\u5382\u5BB6", "\u751F\u4EA7\u65F6\u95F4", "\u5165\u5E93\u65F6\u95F4", "\u8D27\u7269\u6570\u91CF", "\u8D27\u7269\u5355\u4EF7"
			}
		));
		scrollPane.setViewportView(table);
		
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		menu = new JMenu("\u8FD4\u56DE");
		menu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				HomeScreen rw=new HomeScreen();
				rw.run();
				frame.setVisible(false);
			}
		});
		menuBar.add(menu);
	}
}
