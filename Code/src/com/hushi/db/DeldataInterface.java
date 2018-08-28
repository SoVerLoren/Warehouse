package com.hushi.db;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.print.attribute.standard.JobMessageFromOperator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DeldataInterface {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	
			public void run() {
				try {
					DeldataInterface window = new DeldataInterface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}


	/**
	 * Create the application.
	 */
	public DeldataInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel label = new JLabel("\u8F93\u5165\u51FA\u5E93\u8D27\u7269\u7F16\u53F7");
		label.setBounds(55, 75, 116, 15);
		panel.add(label);
		
		textField = new JTextField();
		textField.setBounds(233, 72, 66, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("\u786E\u5B9A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ID=textField.getText();
				String nub=textField_1.getText();

				
				
				Connection con=Linkdb.getcon();
				int resule=0;
				String sql="update 货物 set 货物数量=货物数量-"+nub+"where 货物编号="+ID;
				try {
					PreparedStatement ps=con.prepareStatement(sql);
					ResultSet rs=ps.executeQuery();
					resule=ps.executeUpdate();
					
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if (resule>0) {
					JOptionPane.showMessageDialog(null, "货物出库成功！");
				}else{
					JOptionPane.showMessageDialog(null, "货物出库成功！");
				}
			}

			private QueryInterface QueryInterface() {
				// TODO Auto-generated method stub
				return null;
			}
		});
		button.setBounds(139, 185, 93, 23);
		panel.add(button);
		
		JLabel label_1 = new JLabel("\u51FA\u5E93\u6570\u91CF");
		label_1.setBounds(55, 131, 66, 15);
		panel.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(233, 128, 66, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u8FD4\u56DE");
		menu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HomeScreen rw=new HomeScreen();
				rw.run();
				frame.setVisible(false);
			}
		});
		menuBar.add(menu);
	}
}
