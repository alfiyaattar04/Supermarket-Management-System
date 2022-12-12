package microproject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.xdevapi.Statement;

import net.proteanit.sql.DbUtils;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class user extends JFrame {

	private JPanel contentPane;
	private JTextField UserID;
	private JTextField UserName;
	private JTextField UserPassword;
	private JTable table;
	
	Connection con = null;
	Statement st = null;
	ResultSet Rs = null;
	PreparedStatement pst = null;

	public void fetch()
	{
		try
		{
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/microprojectajp","root","root");
			String q = "select * from usertable";
			pst= con.prepareStatement(q);
			Rs=pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(Rs));
		}
		catch(Exception e)
		{
			//JOptionPane.showMessageDialog(null,e);
			e.printStackTrace();
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					user frame = new user();
					frame.fetch();
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
	public user() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1122, 677);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 128, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JPanel panel = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel, 15, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel, 187, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel, 615, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel, 1083, SpringLayout.WEST, contentPane);
		contentPane.add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JLabel lblManageProducts = new JLabel("MANAGE USERS");
		lblManageProducts.setToolTipText("");
		sl_panel.putConstraint(SpringLayout.NORTH, lblManageProducts, 21, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblManageProducts, -282, SpringLayout.EAST, panel);
		lblManageProducts.setForeground(new Color(255, 128, 0));
		lblManageProducts.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel.add(lblManageProducts);
		
		JLabel lblNewLabel_1 = new JLabel("UserID");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 39, SpringLayout.SOUTH, lblManageProducts);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1, 40, SpringLayout.WEST, panel);
		lblNewLabel_1.setForeground(new Color(255, 128, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		panel.add(lblNewLabel_1);
		
		UserID = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, UserID, 32, SpringLayout.SOUTH, lblManageProducts);
		sl_panel.putConstraint(SpringLayout.WEST, UserID, 218, SpringLayout.WEST, panel);
		UserID.setForeground(Color.BLACK);
		UserID.setFont(new Font("Tahoma", Font.PLAIN, 23));
		UserID.setColumns(10);
		panel.add(UserID);
		
		JLabel lblNewLabel_1_1 = new JLabel("Name");
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1_1, 0, SpringLayout.WEST, lblNewLabel_1);
		lblNewLabel_1_1.setForeground(new Color(255, 128, 0));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		panel.add(lblNewLabel_1_1);
		
		UserName = new JTextField();
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1_1, 0, SpringLayout.SOUTH, UserName);
		sl_panel.putConstraint(SpringLayout.NORTH, UserName, 22, SpringLayout.SOUTH, lblNewLabel_1);
		sl_panel.putConstraint(SpringLayout.EAST, UserName, 0, SpringLayout.EAST, UserID);
		UserName.setForeground(Color.BLACK);
		UserName.setFont(new Font("Tahoma", Font.PLAIN, 23));
		UserName.setColumns(10);
		panel.add(UserName);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Password");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1_1, 0, SpringLayout.NORTH, lblNewLabel_1);
		lblNewLabel_1_1_1.setForeground(new Color(255, 128, 0));
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		panel.add(lblNewLabel_1_1_1);
		
		UserPassword = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, UserPassword, 0, SpringLayout.NORTH, UserID);
		sl_panel.putConstraint(SpringLayout.EAST, UserPassword, -44, SpringLayout.EAST, panel);
		UserPassword.setForeground(Color.BLACK);
		UserPassword.setFont(new Font("Tahoma", Font.PLAIN, 23));
		UserPassword.setColumns(10);
		panel.add(UserPassword);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Gender");
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_1_1_2, -300, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1_1_1, 0, SpringLayout.WEST, lblNewLabel_1_1_2);
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1_2, 0, SpringLayout.NORTH, lblNewLabel_1_1);
		lblNewLabel_1_1_2.setForeground(new Color(255, 128, 0));
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 22));
		panel.add(lblNewLabel_1_1_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		sl_panel.putConstraint(SpringLayout.NORTH, comboBox, 45, SpringLayout.SOUTH, comboBox);
		sl_panel.putConstraint(SpringLayout.NORTH, comboBox, 0, SpringLayout.NORTH, lblNewLabel_1_1);
		sl_panel.putConstraint(SpringLayout.WEST, comboBox, 0, SpringLayout.WEST, UserPassword);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 23));
		panel.add(comboBox);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(UserID.getText().isEmpty()||UserName.getText().isEmpty()||UserPassword.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"Enter Full Information");
				}
				else
				{
				try
				{
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/microprojectajp","root","root");
					String sql = "insert into usertable (UserID,UserName,UserPassword,UserGender) values (?,?,?,?)";
					pst= con.prepareStatement(sql);
					pst.setInt(1,Integer.valueOf(UserID.getText()));
					pst.setString(2,UserName.getText());
					pst.setString(3,UserPassword.getText());
					pst.setString(4,comboBox.getSelectedItem().toString());
					pst.executeUpdate();
					fetch();
				}
				catch (Exception e)
				{
					e.printStackTrace();
					JOptionPane.showMessageDialog(null,e);
				}
			}
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 23));
		btnNewButton.setBackground(new Color(255, 128, 0));
		panel.add(btnNewButton);
		
		JButton btnEdit = new JButton("EDIT");
		btnEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(UserID.getText().isEmpty()||UserName.getText().isEmpty()||UserPassword.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"Enter Full Information");
				}
				else
				{
				try
				{
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/microprojectajp","root","root");
					String sql = "update Usertable set UserName='"+UserName.getText()+"'"+",UserPassword='"+UserPassword.getText()+"'"+",UserGender='"+comboBox.getSelectedItem().toString()+"'"+"where UserID="+UserID.getText();
					pst= con.prepareStatement(sql);
					pst.executeUpdate();
					fetch();
				}
				catch (Exception e2)
				{
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null,e2);
				}
			}
			}
		});
		sl_panel.putConstraint(SpringLayout.NORTH, btnEdit, 54, SpringLayout.SOUTH, UserName);
		sl_panel.putConstraint(SpringLayout.WEST, btnEdit, 312, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton, 0, SpringLayout.NORTH, btnEdit);
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton, -94, SpringLayout.WEST, btnEdit);
		btnEdit.setForeground(Color.BLACK);
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 23));
		btnEdit.setBackground(new Color(255, 128, 0));
		panel.add(btnEdit);
		
		JButton btnDelete = new JButton("DELETE");
		sl_panel.putConstraint(SpringLayout.NORTH, btnDelete, 54, SpringLayout.SOUTH, lblNewLabel_1_1_2);
		sl_panel.putConstraint(SpringLayout.WEST, btnDelete, 108, SpringLayout.EAST, btnEdit);
		btnDelete.setForeground(Color.BLACK);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 23));
		btnDelete.setBackground(new Color(255, 128, 0));
		panel.add(btnDelete);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UserID.setText("");
				UserName.setText("");
				UserPassword.setText("");
			}
		});
		sl_panel.putConstraint(SpringLayout.NORTH, btnClear, 0, SpringLayout.NORTH, btnNewButton);
		sl_panel.putConstraint(SpringLayout.WEST, btnClear, 98, SpringLayout.EAST, btnDelete);
		btnClear.setForeground(Color.BLACK);
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 23));
		btnClear.setBackground(new Color(255, 128, 0));
		panel.add(btnClear);
		
		JPanel panel_1 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_1, -289, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, panel_1, 0, SpringLayout.WEST, lblNewLabel_1);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_1, -10, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_1, 0, SpringLayout.EAST, UserPassword);
		panel.add(panel_1);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		sl_panel_1.putConstraint(SpringLayout.NORTH, scrollPane, 7, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, scrollPane, 839, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, scrollPane, 294, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, scrollPane, 1, SpringLayout.WEST, panel_1);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setForeground(new Color(0, 0, 0));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				int myIndex = table.getSelectedRow();
				UserID.setText(model.getValueAt(myIndex, 0).toString());
				UserName.setText(model.getValueAt(myIndex, 1).toString());
				UserPassword.setText(model.getValueAt(myIndex, 2).toString());
			}
		});
		sl_panel_1.putConstraint(SpringLayout.NORTH, table, 0, SpringLayout.NORTH, scrollPane);
		sl_panel_1.putConstraint(SpringLayout.WEST, table, 10, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, table, 0, SpringLayout.SOUTH, scrollPane);
		sl_panel_1.putConstraint(SpringLayout.EAST, table, -6, SpringLayout.WEST, scrollPane);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"USERID", "NAME", "PASSWORD", "GENDER"
			}
		));
		table.getColumnModel().getColumn(0).setResizable(false);
		panel_1.add(table);
		
		JLabel lblNewLabel_1_3 = new JLabel("ManageManager");
		lblNewLabel_1_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Manager m = new Manager();
				m.fetch();
				m.setVisible(true);
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1_3, 139, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1_3, 0, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_1_3, -6, SpringLayout.WEST, panel);
		lblNewLabel_1_3.setForeground(new Color(255, 232, 208));
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("ManageProduct");
		lblNewLabel_1_3_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Product m = new Product();
				m.fetch();
				m.setVisible(true);
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1_3_1, 87, SpringLayout.SOUTH, lblNewLabel_1_3);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1_3_1, 0, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_1_3_1, -6, SpringLayout.WEST, panel);
		lblNewLabel_1_3_1.setForeground(new Color(255, 232, 208));
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblNewLabel_1_3_1);
		
		JLabel lblNewLabel_1_3_1_1 = new JLabel("LogOut");
		lblNewLabel_1_3_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				login l = new login();
				l.setVisible(true);
			}
		});
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1_3_1_1, 0, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_1_3_1_1, -57, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_1_3_1_1, 94, SpringLayout.WEST, contentPane);
		lblNewLabel_1_3_1_1.setForeground(new Color(255, 232, 208));
		lblNewLabel_1_3_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		contentPane.add(lblNewLabel_1_3_1_1);
		
		
		
	}
}
