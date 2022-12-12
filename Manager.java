package microproject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.xdevapi.Statement;

import net.proteanit.sql.DbUtils;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Manager extends JFrame {

	private JPanel contentPane;
	private JTextField ManagerID;
	private JTextField ManagerName;
	private JTextField ManagerPassword;
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
			String q = "select * from managertable";
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
					Manager frame = new Manager();
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
	public Manager() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1124, 661);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 128, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		panel.setBackground(new Color(240, 240, 240));
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel, 20, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel, 172, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel, 599, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel, 0, SpringLayout.EAST, contentPane);
		contentPane.add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JLabel lblNewLabel = new JLabel("MANAGE MANAGER");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setForeground(new Color(255, 128, 0));
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel, 22, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel, 339, SpringLayout.WEST, panel);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ManagerID");
		lblNewLabel_1.setForeground(new Color(255, 128, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 110, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1, 57, SpringLayout.WEST, panel);
		panel.add(lblNewLabel_1);
		
		ManagerID = new JTextField();
		ManagerID.setFont(new Font("Tahoma", Font.PLAIN, 23));
		ManagerID.setForeground(new Color(0, 0, 0));
		sl_panel.putConstraint(SpringLayout.WEST, ManagerID, 51, SpringLayout.EAST, lblNewLabel_1);
		sl_panel.putConstraint(SpringLayout.SOUTH, ManagerID, 0, SpringLayout.SOUTH, lblNewLabel_1);
		panel.add(ManagerID);
		ManagerID.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Name");
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1_1, 0, SpringLayout.WEST, lblNewLabel_1);
		lblNewLabel_1_1.setForeground(new Color(255, 128, 0));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		panel.add(lblNewLabel_1_1);
		
		ManagerName = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1, 4, SpringLayout.NORTH, ManagerName);
		sl_panel.putConstraint(SpringLayout.NORTH, ManagerName, 26, SpringLayout.SOUTH, ManagerID);
		sl_panel.putConstraint(SpringLayout.EAST, ManagerName, 0, SpringLayout.EAST, ManagerID);
		ManagerName.setForeground(Color.BLACK);
		ManagerName.setFont(new Font("Tahoma", Font.PLAIN, 23));
		ManagerName.setColumns(10);
		panel.add(ManagerName);
		
		JLabel lblNewLabel_1_2 = new JLabel("Password");
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1_2, 0, SpringLayout.SOUTH, lblNewLabel_1);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_1_2, -302, SpringLayout.EAST, panel);
		lblNewLabel_1_2.setForeground(new Color(255, 128, 0));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 22));
		panel.add(lblNewLabel_1_2);
		
		ManagerPassword = new JTextField();
		sl_panel.putConstraint(SpringLayout.SOUTH, ManagerPassword, 0, SpringLayout.SOUTH, lblNewLabel_1);
		sl_panel.putConstraint(SpringLayout.EAST, ManagerPassword, -55, SpringLayout.EAST, panel);
		ManagerPassword.setForeground(Color.BLACK);
		ManagerPassword.setFont(new Font("Tahoma", Font.PLAIN, 23));
		ManagerPassword.setColumns(10);
		panel.add(ManagerPassword);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Gender");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1_1, 0, SpringLayout.NORTH, lblNewLabel_1_1);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1_1_1, 82, SpringLayout.EAST, ManagerName);
		lblNewLabel_1_1_1.setForeground(new Color(255, 128, 0));
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		panel.add(lblNewLabel_1_1_1);
		
		JComboBox comboBox = new JComboBox();
		sl_panel.putConstraint(SpringLayout.NORTH, comboBox, -4, SpringLayout.NORTH, lblNewLabel_1_1);
		sl_panel.putConstraint(SpringLayout.WEST, comboBox, 0, SpringLayout.WEST, ManagerPassword);
		sl_panel.putConstraint(SpringLayout.EAST, comboBox, 0, SpringLayout.EAST, ManagerPassword);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 23));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		panel.add(comboBox);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(ManagerID.getText().isEmpty()||ManagerName.getText().isEmpty()||ManagerPassword.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"Enter Full Information");
				}
				else
				{
				try
				{
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/microprojectajp","root","root");
					String sql = "insert into managertable (ManagerID,ManagerName,ManagerPassword,ManagerGender) values (?,?,?,?)";
					pst= con.prepareStatement(sql);
					pst.setInt(1,Integer.valueOf(ManagerID.getText()));
					pst.setString(2,ManagerName.getText());
					pst.setString(3,ManagerPassword.getText());
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
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton, 102, SpringLayout.SOUTH, lblNewLabel_1);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 23));
		btnNewButton.setBackground(new Color(255, 128, 0));
		btnNewButton.setForeground(new Color(0, 0, 0));
		panel.add(btnNewButton);
		
		JButton btnEdit = new JButton("EDIT");
		btnEdit.addMouseListener(new MouseAdapter() {
			@Override
			 public void mouseClicked(MouseEvent e) {
				if(ManagerID.getText().isEmpty()||ManagerName.getText().isEmpty()||ManagerPassword.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"Enter Full Information");
				}
				else
				{
				try
				{
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/microprojectajp","root","root");
					String sql = "update managertable set ManagerName='"+ManagerName.getText()+"'"+",ManagerPassword='"+ManagerPassword.getText()+"'"+",ManagerGender='"+comboBox.getSelectedItem().toString()+"'"+"where ManagerID="+ManagerID.getText();
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
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton, -98, SpringLayout.WEST, btnEdit);
		sl_panel.putConstraint(SpringLayout.NORTH, btnEdit, 0, SpringLayout.NORTH, btnNewButton);
		btnEdit.setForeground(Color.BLACK);
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 23));
		btnEdit.setBackground(new Color(255, 128, 0));
		panel.add(btnEdit);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(ManagerID.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"Enter ManagerID to Delete");
				}
				else
				{
					try
					{
						con = DriverManager.getConnection("jdbc:mysql://localhost:3306/microprojectajp","root","root");
						String mid = ManagerID.getText();
						String sql = "Delete from managertable where ManagerID="+mid;
						pst=con.prepareStatement(sql);
						pst.executeUpdate();
						fetch();					
					}
					catch(Exception e1)
					{
						e1.printStackTrace();
						
					}
				}
			}
		});
		sl_panel.putConstraint(SpringLayout.EAST, btnEdit, -98, SpringLayout.WEST, btnDelete);
		sl_panel.putConstraint(SpringLayout.NORTH, btnDelete, 0, SpringLayout.NORTH, btnNewButton);
		sl_panel.putConstraint(SpringLayout.EAST, btnDelete, 0, SpringLayout.EAST, lblNewLabel_1_2);
		btnDelete.setForeground(Color.BLACK);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 23));
		btnDelete.setBackground(new Color(255, 128, 0));
		panel.add(btnDelete);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ManagerID.setText("");
				ManagerName.setText("");
				ManagerPassword.setText("");
				
			}
		});
		sl_panel.putConstraint(SpringLayout.NORTH, btnClear, 0, SpringLayout.NORTH, btnNewButton);
		sl_panel.putConstraint(SpringLayout.WEST, btnClear, 84, SpringLayout.EAST, btnDelete);
		btnClear.setForeground(Color.BLACK);
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 23));
		btnClear.setBackground(new Color(255, 128, 0));
		panel.add(btnClear);
		
		JPanel panel_1 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_1, 38, SpringLayout.SOUTH, btnNewButton);
		sl_panel.putConstraint(SpringLayout.WEST, panel_1, 0, SpringLayout.WEST, lblNewLabel_1);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_1, -9, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_1, -55, SpringLayout.EAST, panel);
		panel.add(panel_1);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		sl_panel_1.putConstraint(SpringLayout.NORTH, scrollPane, 240, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, scrollPane, 10, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, scrollPane, 9, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, scrollPane, 806, SpringLayout.WEST, panel_1);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				int myIndex = table.getSelectedRow();
				ManagerID.setText(model.getValueAt(myIndex, 0).toString());
				ManagerName.setText(model.getValueAt(myIndex, 1).toString());
				ManagerPassword.setText(model.getValueAt(myIndex, 2).toString());
			}
		});
		sl_panel_1.putConstraint(SpringLayout.NORTH, table, 6, SpringLayout.SOUTH, scrollPane);
		sl_panel_1.putConstraint(SpringLayout.WEST, table, 10, SpringLayout.WEST, scrollPane);
		table.setForeground(new Color(0, 0, 0));
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		sl_panel_1.putConstraint(SpringLayout.SOUTH, table, -16, SpringLayout.NORTH, scrollPane);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"ID", "NAME", "PASSWORD", "GENDER"
			}
		));
		table.getColumnModel().getColumn(3).setResizable(false);
		sl_panel_1.putConstraint(SpringLayout.EAST, table, 0, SpringLayout.EAST, scrollPane);
		panel_1.add(table);
		
		JLabel lblNewLabel_1_3 = new JLabel("ManageProducts");
		lblNewLabel_1_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Product m = new Product();
				m.fetch();
				m.setVisible(true);
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1_3, 139, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1_3, 0, SpringLayout.WEST, contentPane);
		lblNewLabel_1_3.setForeground(new Color(255, 232, 208));
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("ManageUsers");
		lblNewLabel_1_3_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				user u = new user();
				u.fetch();
				u.setVisible(true);
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1_3_1, 78, SpringLayout.SOUTH, lblNewLabel_1_3);
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
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1_3_1_1, 15, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_1_3_1_1, -52, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_1_3_1_1, 101, SpringLayout.WEST, contentPane);
		lblNewLabel_1_3_1_1.setForeground(new Color(255, 232, 208));
		lblNewLabel_1_3_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		contentPane.add(lblNewLabel_1_3_1_1);
	}
}
