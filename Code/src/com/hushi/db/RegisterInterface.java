package com.hushi.db;

import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
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

public class RegisterInterface {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	
			public void run() {
				try {
					RegisterInterface window = new RegisterInterface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}


	/**
	 * Create the application.
	 */
	public RegisterInterface() {
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
		
		JLabel label = new JLabel("\u7528\u6237\u540D\uFF1A");
		label.setBounds(87, 38, 54, 15);
		panel.add(label);
		
		JLabel label_1 = new JLabel("\u5BC6\u7801\uFF1A");
		label_1.setBounds(87, 94, 54, 15);
		panel.add(label_1);
		
		JLabel lblNewLabel = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		lblNewLabel.setBounds(87, 143, 73, 15);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(178, 35, 66, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(178, 91, 66, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(178, 140, 66, 21);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("\u786E\u8BA4\u6CE8\u518C");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username=textField.getText();
				String password=textField_1.getText();
				String password1=textField_2.getText();
				//判定条件
				if(!password.equals(password1))
				{
					JOptionPane.showMessageDialog(null, "密码必须一致！");
					return;
				} 
				String sql="insert into 账户(用户名,密码) values('"+username+"','"+password+"')";
				int resule=0;
				try {
					Connection con=Linkdb.getcon();
					PreparedStatement ps=con.prepareStatement(sql);
					resule=ps.executeUpdate();
					
					if(resule>0)
					{
						JOptionPane.showMessageDialog(null, "注册成功！");
						LoginInterface rw=new LoginInterface();
						rw.main(null);
						frame.setVisible(false);
					}else{
						JOptionPane.showMessageDialog(null, "注册失败！");
					}
					con.close();
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(127, 193, 93, 23);
		panel.add(btnNewButton);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u8FD4\u56DE");
		mnNewMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				LoginInterface rw=new LoginInterface();
				rw.main(null);
				frame.setVisible(false);
			}
		});
		menuBar.add(mnNewMenu);
	}
}
