package com.hushi.db;

import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.html.HTMLDocument.HTMLReader.ParagraphAction;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.PseudoColumnUsage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UpdataInterface {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	
			public void run() {
				try {
					UpdataInterface window = new UpdataInterface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

	/**
	 * Create the application.
	 */
	public UpdataInterface() {
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
		
		JLabel lblNewLabel = new JLabel("\u8D27\u7269\u7F16\u53F7");
		lblNewLabel.setBounds(44, 20, 54, 15);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(102, 17, 66, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("\u8D27\u7269\u540D\u79F0");
		label.setBounds(44, 70, 54, 15);
		panel.add(label);
		
		textField_1 = new JTextField();
		textField_1.setBounds(102, 67, 66, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_1 = new JLabel("\u751F\u4EA7\u5382\u5BB6");
		label_1.setBounds(44, 113, 54, 15);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("\u751F\u4EA7\u65E5\u671F");
		label_2.setBounds(44, 160, 54, 15);
		panel.add(label_2);
		
		JLabel lblNewLabel_1 = new JLabel("\u5165\u5E93\u65F6\u95F4");
		lblNewLabel_1.setBounds(44, 204, 54, 15);
		panel.add(lblNewLabel_1);
		
		JLabel label_3 = new JLabel("\u8D27\u7269\u6570\u91CF");
		label_3.setBounds(252, 70, 54, 15);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("\u8D27\u7269\u5355\u4EF7");
		label_4.setBounds(252, 134, 54, 15);
		panel.add(label_4);
		
		textField_2 = new JTextField();
		textField_2.setBounds(102, 110, 66, 21);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(102, 157, 66, 21);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(102, 201, 66, 21);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(316, 67, 66, 21);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(316, 131, 66, 21);
		panel.add(textField_6);
		textField_6.setColumns(10);
		
		JButton button = new JButton("\u786E\u8BA4");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String huowu0=textField.getText();
				String huowu1=textField_1.getText();
				String huowu2=textField_2.getText();
				String huowu3=textField_3.getText();
				String huowu4=textField_4.getText();
				String huowu5=textField_5.getText();
				String huowu6=textField_6.getText();
			
				Connection con=Linkdb.getcon();
				int resule=0;
				
				String sql="insert into 货物(货物编号,货物名称,生产厂家,生产日期,入库时间,货物数量,货物单价) values ('"+huowu0+"','"+huowu1+"','"+huowu2+"','"+huowu3+"','"+huowu4+"','"+huowu5+"','"+huowu6+"')" ;                    
				
				try {
					PreparedStatement ps=con.prepareStatement(sql);
					resule=ps.executeUpdate();
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if(resule>0)
				{
					JOptionPane.showMessageDialog(null, "添加数据成功");
				}else{
					JOptionPane.showMessageDialog(null, "添加数据失败");
				}
				
			}
		});
		button.setBounds(237, 200, 93, 23);
		panel.add(button);
		
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
	public void FEC()
	{
		String ID=textField.getText();
		Connection con=Linkdb.getcon();
		String sql="select 货物.货物编号 from 货物";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			Object[][] o=new Object[1][];
			int index=0;
			while(rs.next())
			{
				int id=rs.getInt(1);
				Object[] p={id};
				o[index]=p;
				index++;
			}
			con.close();
			boolean p=true;
			for (int i = 0; i < o.length; i++)
			{
				String IDLI=(String) o[1][i];
				if(IDLI==ID)
				{
					p=false;
				}
			}
			if(p==false)
			{
				JOptionPane.showMessageDialog(null, "货物编号已存在，请重新输入！");
				return;
			}
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
