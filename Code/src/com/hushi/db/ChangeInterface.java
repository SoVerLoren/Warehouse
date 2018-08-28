package com.hushi.db;

import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChangeInterface {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	
			public void run() {
				try {
					ChangeInterface window = new ChangeInterface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	

	/**
	 * Create the application.
	 */
	public ChangeInterface() {
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
		
		JLabel lblNewLabel = new JLabel("\u8D27\u7269\u7F16\u53F7\uFF1A");
		lblNewLabel.setBounds(75, 79, 71, 15);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u66F4\u6539\u8D27\u7269\u5355\u4EF7\u4E3A\uFF1A");
		lblNewLabel_1.setBounds(79, 147, 104, 15);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(193, 76, 66, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("\u786E\u5B9A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID=textField.getText();
				String num=textField_2.getText();
				
				Connection con=Linkdb.getcon();
				int resule=0;
				String sql="update 货物  set 货物单价= "+num+" where 货物编号="+ID;
				try {
					PreparedStatement ps=con.prepareStatement(sql);
					resule=ps.executeUpdate();
					
					if(resule>0)
					{
						JOptionPane.showMessageDialog(null, "更改成功！");
					}else{
						JOptionPane.showMessageDialog(null, "更改出错！");
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(156, 196, 93, 23);
		panel.add(button);
		
		textField_2 = new JTextField();
		textField_2.setBounds(193, 144, 66, 21);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u8FD4\u56DE");
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
