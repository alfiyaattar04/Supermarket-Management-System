package microproject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.xdevapi.Statement;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	
	Connection con = null;
	Statement st = null;
	ResultSet Rs = null;
	PreparedStatement pst = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1127, 646);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 128, 0));
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel, 15, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel, 15, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel, -5, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel, 538, SpringLayout.WEST, contentPane);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel_1, 30, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel_1, 6, SpringLayout.EAST, panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JLabel lblNewLabel = new JLabel("");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel, 104, SpringLayout.WEST, panel);
		lblNewLabel.setIcon(new ImageIcon("C:\\TY Diploma\\5TH SEM\\advanced java programming (AJP)\\LOGIN PAGE IMAGE.jpg"));
		lblNewLabel.setBackground(new Color(240, 240, 240));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\r\n");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 55, SpringLayout.SOUTH, lblNewLabel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1, 141, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, 297, SpringLayout.SOUTH, lblNewLabel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_1, -153, SpringLayout.EAST, panel);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\TY Diploma\\5TH SEM\\advanced java programming (AJP)\\LOGIN PAGE CART.png"));
		panel.add(lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel_1, 0, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel_1, -4, SpringLayout.EAST, contentPane);
		contentPane.add(panel_1);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);
		
		JLabel lblNewLabel_2 = new JLabel("SuperMarket Management System");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 10, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel_2, -33, SpringLayout.EAST, panel_1);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel_2.setForeground(new Color(255, 128, 0));
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Login");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 30, SpringLayout.SOUTH, lblNewLabel_2);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel_3, -243, SpringLayout.EAST, panel_1);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_3.setForeground(new Color(255, 128, 0));
		panel_1.add(lblNewLabel_3);
		
		JComboBox comboBox = new JComboBox();
		sl_panel_1.putConstraint(SpringLayout.NORTH, comboBox, 64, SpringLayout.SOUTH, lblNewLabel_3);
		sl_panel_1.putConstraint(SpringLayout.WEST, comboBox, 293, SpringLayout.WEST, panel_1);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox.setForeground(new Color(255, 128, 0));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Admin", "Manager", "User"}));
		panel_1.add(comboBox);
		
		JLabel lblNewLabel_4_1 = new JLabel("ID");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_4_1, 204, SpringLayout.SOUTH, lblNewLabel_2);
		lblNewLabel_4_1.setForeground(new Color(255, 128, 0));
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1.add(lblNewLabel_4_1);
		
		textField = new JTextField();
		sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel_4_1, -107, SpringLayout.WEST, textField);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		sl_panel_1.putConstraint(SpringLayout.NORTH, textField, 0, SpringLayout.NORTH, lblNewLabel_4_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, textField, 0, SpringLayout.WEST, comboBox);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("PASSWORD\r\n");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_4_1_1, 43, SpringLayout.SOUTH, lblNewLabel_4_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_4_1_1, 68, SpringLayout.WEST, panel_1);
		lblNewLabel_4_1_1.setForeground(new Color(255, 128, 0));
		lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1.add(lblNewLabel_4_1_1);
		
		textField_1 = new JTextField();
		sl_panel_1.putConstraint(SpringLayout.SOUTH, textField_1, 0, SpringLayout.SOUTH, lblNewLabel_4_1_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, textField_1, 0, SpringLayout.EAST, textField);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_1.setColumns(10);
		panel_1.add(textField_1);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(comboBox.getSelectedItem().toString().equals("Admin") && textField.getText().equals("Admin") && textField_1.getText().equals("Admin"))
				{
					Manager m = new Manager();
					m.fetch();
					m.setVisible(true);
				}
				else if(comboBox.getSelectedItem().toString()=="Manager")
				{
					
					try
					{
						con = DriverManager.getConnection("jdbc:mysql://localhost:3306/microprojectajp","root","root");
						String q = "select * from managertable where ManagerID='"+textField.getText()+"'"+" and ManagerPassword='"+textField_1.getText()+"'";
						pst= con.prepareStatement(q);
						Rs=pst.executeQuery();
						while(Rs.next())
						{
							mProducts mp = new mProducts();
							mp.fetch();
							mp.setVisible(true);
						}
					}
					catch(Exception e1)
					{
						JOptionPane.showMessageDialog(null,e1);
					}
				}
				else if(comboBox.getSelectedItem().toString()=="User")
				{
					try
					{
						con = DriverManager.getConnection("jdbc:mysql://localhost:3306/microprojectajp","root","root");
						String q = "select * from Usertable where userID='"+textField.getText()+"'"+" and UserPassword='"+textField_1.getText()+"'";
						pst= con.prepareStatement(q);
						Rs=pst.executeQuery();
						while(Rs.next())
						{
							bill b = new bill();
							b.fetch();
							b.setVisible(true);
						}
					}
					catch(Exception e1)
					{
						JOptionPane.showMessageDialog(null,e1);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Something went wrong..Try again!!");
				}
			}
		});
		sl_panel_1.putConstraint(SpringLayout.NORTH, btnNewButton, 58, SpringLayout.SOUTH, textField_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, btnNewButton, 202, SpringLayout.WEST, panel_1);
		btnNewButton.setForeground(new Color(255, 128, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 23));
		panel_1.add(btnNewButton);
		
		JLabel lblNewLabel_4_1_2 = new JLabel("Select Role");
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_4_1_2, -112, SpringLayout.EAST, lblNewLabel_4_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblNewLabel_4_1_2, -51, SpringLayout.NORTH, lblNewLabel_4_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel_4_1_2, 0, SpringLayout.EAST, lblNewLabel_4_1);
		lblNewLabel_4_1_2.setForeground(new Color(255, 128, 0));
		lblNewLabel_4_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1.add(lblNewLabel_4_1_2);
		
		JLabel lblNewLabel_4 = new JLabel("Visit Website");
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_4, 191, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblNewLabel_4, -32, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel_4, 12, SpringLayout.EAST, lblNewLabel_3);
		lblNewLabel_4.setForeground(new Color(255, 179, 102));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.ITALIC, 20));
		panel_1.add(lblNewLabel_4);
	}
}
