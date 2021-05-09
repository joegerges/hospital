package hospital;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class View_Employees extends JFrame {

	private JPanel contentPane;
	private JTextField salary_amount;
	private JTextField search_ssn;
	private JTable table;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_Employees frame = new View_Employees();
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
	public View_Employees() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1149, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox<String> salary_operators = new JComboBox<String>();
		salary_operators.addItem("None");
		salary_operators.addItem("<");
		salary_operators.addItem("<=");
		salary_operators.addItem(">");
		salary_operators.addItem(">=");
		salary_operators.addItem("=");
		salary_operators.setBounds(153, 154, 77, 23);
		contentPane.add(salary_operators);
		salary_operators.setSelectedItem("None");
		
		JComboBox<String> emp_type = new JComboBox<String>();
		emp_type.addItem("nurse");
		emp_type.addItem("janitor");
		emp_type.addItem("doctor");
		emp_type.addItem("receptionist");
		emp_type.setBounds(153, 61, 194, 22);
		emp_type.setSelectedItem(null);
		contentPane.add(emp_type);
		
		JScrollPane scrollPane = new JScrollPane();
		
		table = new JTable();
		table.setBounds(10, 99, 414, 197);
		scrollPane.setViewportView(table);
		scrollPane.setBounds(10, 205, 1113, 261);
		getContentPane().add(scrollPane);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
				
				setVisible(false);
				dispose();
			}
		});
		btnNewButton.setBounds(10, 11, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Filter by salary");
		lblNewLabel.setBounds(37, 154, 123, 23);
		contentPane.add(lblNewLabel);
		
		
		salary_amount = new JTextField();
		salary_amount.setBounds(251, 155, 96, 20);
		contentPane.add(salary_amount);
		salary_amount.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("amount in LBP");
		lblNewLabel_1.setBounds(251, 140, 123, 14);
		contentPane.add(lblNewLabel_1);
		

		JComboBox search_by = new JComboBox();
		search_by.setBounds(119, 104, 123, 22);
		contentPane.add(search_by);
		search_by.addItem("None");
		search_by.addItem("ssn");
		search_by.addItem("fname");
		search_by.addItem("lname");
		search_by.addItem("gender");
		search_by.addItem("country");
		search_by.setSelectedItem("None");
		
		JButton btnNewButton_1 = new JButton("submit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
				String _search_by = (String) search_by.getSelectedItem();
					
				int _salary_amount = -1;
				String _search_value = "-1";
				
				String _operator = (String) salary_operators.getSelectedItem();
				String _emp_type = (String) emp_type.getSelectedItem();
				if(!salary_amount.getText().isEmpty()) _salary_amount = Integer.parseInt(salary_amount.getText());
				if(!search_ssn.getText().isEmpty()) _search_value = search_ssn.getText();
				
				DatabaseHelper dbHelper = new DatabaseHelper();
				ResultSet empsRs = dbHelper.GetEmployees(_emp_type, _search_by, _search_value, _operator, _salary_amount);
				
				table.setModel(DbUtils.resultSetToTableModel(empsRs));
				
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(frame, "Oops, something went wrong", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnNewButton_1.setBounds(1034, 176, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("View Employees");
		lblNewLabel_2.setBounds(193, 15, 130, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Employee type");
		lblNewLabel_3.setBounds(37, 65, 96, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Search by:");
		lblNewLabel_4.setBounds(37, 108, 96, 14);
		contentPane.add(lblNewLabel_4);
		
		search_ssn = new JTextField();
		search_ssn.setBounds(263, 105, 144, 20);
		contentPane.add(search_ssn);
		search_ssn.setColumns(10);
		
		
		
	}
}
