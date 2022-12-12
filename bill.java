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
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.xdevapi.Statement;

import net.proteanit.sql.DbUtils;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class bill extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	int uPrice, Uquantity, total;
	int i=0;
	
	Connection con = null;
	Statement st = null;
	ResultSet Rs = null;
	PreparedStatement pst = null;

	public void fetch()
	{
		try
		{
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/microprojectajp","root","root");
			String q = "select * from producttable";
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
					bill frame = new bill();
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
	public bill() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1125, 676);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 128, 0));
		contentPane.setForeground(new Color(255, 128, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JPanel panel = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel, 5, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel, 142, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel, 624, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel, 1096, SpringLayout.WEST, contentPane);
		contentPane.add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JLabel lblBillingPoint = new JLabel("BILLING POINT\r\n");
		sl_panel.putConstraint(SpringLayout.NORTH, lblBillingPoint, 24, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblBillingPoint, -350, SpringLayout.EAST, panel);
		lblBillingPoint.setToolTipText("");
		lblBillingPoint.setForeground(new Color(255, 128, 0));
		lblBillingPoint.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel.add(lblBillingPoint);
		
		JLabel lblNewLabel_1 = new JLabel("Product Name");
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1, 29, SpringLayout.WEST, panel);
		lblNewLabel_1.setForeground(new Color(255, 128, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField, 36, SpringLayout.SOUTH, lblBillingPoint);
		sl_panel.putConstraint(SpringLayout.WEST, textField, 50, SpringLayout.EAST, lblNewLabel_1);
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 4, SpringLayout.NORTH, textField);
		textField.setForeground(Color.BLACK);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 23));
		textField.setColumns(10);
		panel.add(textField);
		
		JLabel lblNewLabel_1_1 = new JLabel("Quantity");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1, 25, SpringLayout.SOUTH, textField);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1_1, 0, SpringLayout.WEST, lblNewLabel_1);
		lblNewLabel_1_1.setForeground(new Color(255, 128, 0));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		panel.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField_1, -4, SpringLayout.NORTH, lblNewLabel_1_1);
		sl_panel.putConstraint(SpringLayout.WEST, textField_1, 0, SpringLayout.WEST, textField);
		textField_1.setForeground(Color.BLACK);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		textField_1.setColumns(10);
		panel.add(textField_1);
		
		JLabel lblProductsList = new JLabel("PRODUCTS LIST\r\n");
		sl_panel.putConstraint(SpringLayout.NORTH, lblProductsList, -3, SpringLayout.NORTH, lblNewLabel_1);
		sl_panel.putConstraint(SpringLayout.EAST, lblProductsList, -148, SpringLayout.EAST, panel);
		lblProductsList.setToolTipText("");
		lblProductsList.setForeground(new Color(255, 128, 0));
		lblProductsList.setFont(new Font("Tahoma", Font.BOLD, 25));
		panel.add(lblProductsList);
		
		JPanel panel_1 = new JPanel();
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_1, -25, SpringLayout.SOUTH, panel);
		panel_1.setBackground(new Color(255, 128, 0));
		sl_panel.putConstraint(SpringLayout.NORTH, panel_1, 17, SpringLayout.SOUTH, lblProductsList);
		sl_panel.putConstraint(SpringLayout.WEST, panel_1, 45, SpringLayout.EAST, textField_1);
		sl_panel.putConstraint(SpringLayout.EAST, panel_1, -21, SpringLayout.EAST, panel);
		panel.add(panel_1);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		sl_panel_1.putConstraint(SpringLayout.NORTH, scrollPane, 433, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, scrollPane, 10, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, scrollPane, 13, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, scrollPane, 442, SpringLayout.WEST, panel_1);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD, 10));
		table.setForeground(new Color(0, 0, 0));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				int myIndex = table.getSelectedRow();
				textField.setText(model.getValueAt(myIndex, 1).toString());
				uPrice=Integer.valueOf(model.getValueAt(myIndex, 2).toString());
				Uquantity=Integer.valueOf(model.getValueAt(myIndex, 3).toString());
				
				if(Uquantity<= 0)
				{
					JOptionPane.showMessageDialog(null,"Product is currently Unavailable");
				}
			}
		});
		sl_panel_1.putConstraint(SpringLayout.NORTH, table, 19, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, table, 20, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, table, -6, SpringLayout.NORTH, scrollPane);
		sl_panel_1.putConstraint(SpringLayout.EAST, table, -24, SpringLayout.EAST, panel_1);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"ID", "Product Name", "Price", "Quantity"
			}
		));
		panel_1.add(table);
		
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Tahoma", Font.BOLD, 12));
		textArea.setForeground(new Color(0, 0, 0));
		sl_panel.putConstraint(SpringLayout.NORTH, textArea, -309, SpringLayout.SOUTH, panel_1);
		sl_panel.putConstraint(SpringLayout.WEST, textArea, 29, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, textArea, -25, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, textArea, 0, SpringLayout.EAST, textField);
		panel.add(textArea);
		textArea.setText(textArea.getText()+"\t***SuperMarket Management System***"+"\n"+"No."+"	ProductName"+"\tPrice"+"\tQuantity"+"\tTotal\n");
		
		
		
		JButton btnAddToBill = new JButton("Add to Bill");
		btnAddToBill.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(textField_1.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"Enter product quantity");
				}
				else if(Uquantity <Integer.parseInt(textField_1.getText())  )
					{
					 JOptionPane.showMessageDialog(null,"Product is not in required quantity");
					}
				else 
				{
					i++;
					total = uPrice*Integer.parseInt(textField_1.getText());
					textArea.setText(textArea.getText()+"\n"+i+"\t"+textField.getText()+"\t"+uPrice+"\t"+textField_1.getText()+"\t"+total);
				}
			}
		});
		sl_panel.putConstraint(SpringLayout.NORTH, btnAddToBill, 33, SpringLayout.SOUTH, lblNewLabel_1_1);
		sl_panel.putConstraint(SpringLayout.WEST, btnAddToBill, 66, SpringLayout.WEST, panel);
		btnAddToBill.setForeground(new Color(255, 255, 255));
		btnAddToBill.setFont(new Font("Tahoma", Font.BOLD, 23));
		btnAddToBill.setBackground(new Color(255, 128, 0));
		panel.add(btnAddToBill);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText("");
				textField_1.setText("");
				
			}
		});
		sl_panel.putConstraint(SpringLayout.NORTH, btnClear, 0, SpringLayout.NORTH, btnAddToBill);
		sl_panel.putConstraint(SpringLayout.WEST, btnClear, 68, SpringLayout.EAST, btnAddToBill);
		btnClear.setForeground(new Color(255, 255, 255));
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 23));
		btnClear.setBackground(new Color(255, 128, 0));
		panel.add(btnClear);
			
		JLabel lblNewLabel_1_3_1_1 = new JLabel("LogOut");
		lblNewLabel_1_3_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				login l = new login();
				l.setVisible(true);
			}
		});
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1_3_1_1, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_1_3_1_1, -82, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_1_3_1_1, 93, SpringLayout.WEST, contentPane);
		lblNewLabel_1_3_1_1.setForeground(new Color(255, 232, 208));
		lblNewLabel_1_3_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		contentPane.add(lblNewLabel_1_3_1_1);
	}
}
