package com.hushi.db;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class HomeScreen {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	
			public void run() {
				try {
					HomeScreen window = new HomeScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	
	/**
	 * Create the application.
	 */
	public HomeScreen() {
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
		
		JLabel label = new JLabel("\u6B22\u8FCE\u6765\u5230\u4ED3\u5E93\u7BA1\u7406\u7CFB\u7EDF");
		label.setFont(new Font("ËÎÌו", Font.PLAIN, 16));
		label.setBounds(129, 27, 172, 23);
		panel.add(label);
		
		JLabel label_1 = new JLabel("\u8BF7\u9009\u62E9\u529F\u80FD");
		label_1.setBounds(64, 60, 71, 15);
		panel.add(label_1);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2\u5E93\u5B58");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				QueryInterface re=new QueryInterface();
				re.run();
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(64, 96, 93, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u5E93\u5B58\u66F4\u6539");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ChangeInterface rw=new ChangeInterface();
				rw.run();
				frame.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(259, 96, 93, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u8D27\u7269\u5165\u5E93");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UpdataInterface rw=new UpdataInterface();
				rw.run();
				frame.setVisible(false);
			}
		});
		btnNewButton_2.setBounds(64, 161, 93, 23);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\u8D27\u7269\u51FA\u5E93");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DeldataInterface rw=new DeldataInterface();
				rw.run();
				frame.setVisible(false);
			}
		});
		btnNewButton_3.setBounds(259, 161, 93, 23);
		panel.add(btnNewButton_3);
		
		JMenu menu = new JMenu("\u9000\u51FA\u767B\u5F55");
		menu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginInterface rw=new LoginInterface();
				rw.main(null);
				frame.setVisible(false);
			}
		});
		menu.setBounds(338, 0, 107, 22);
		panel.add(menu);
	}

	protected QueryInterface QueryInterface() {
		// TODO Auto-generated method stub
		return null;
	}
	

	
}
