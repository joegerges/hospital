package hospital;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class View_Employees extends JFrame {

	private JPanel contentPane;
	private JTextField salary_amount;
	private JTextField search_ssn;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox salary_operators = new JComboBox();
		salary_operators.addItem("<");
		salary_operators.addItem("<=");
		salary_operators.addItem(">");
		salary_operators.addItem(">=");
		salary_operators.addItem("=");
		salary_operators.setBounds(153, 154, 53, 22);
		contentPane.add(salary_operators);
		salary_operators.setSelectedItem(null);
		
		JComboBox emp_type = new JComboBox();
		emp_type.addItem("nurse");
		emp_type.addItem("janitor");
		emp_type.addItem("doctor");
		emp_type.addItem("receptionist");
		emp_type.setBounds(153, 61, 77, 22);
		emp_type.setSelectedItem(null);
		contentPane.add(emp_type);
		
		
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
				
				setVisible(false);
				dispose();
			}
		});
		btnNewButton.setBounds(10, 11, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("filter by salary");
		lblNewLabel.setBounds(37, 154, 123, 23);
		contentPane.add(lblNewLabel);
		
		
		salary_amount = new JTextField();
		salary_amount.setBounds(211, 155, 96, 20);
		contentPane.add(salary_amount);
		salary_amount.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("amount in LBP");
		lblNewLabel_1.setBounds(211, 142, 123, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("submit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String _operator = (String) salary_operators.getSelectedItem();
				String _emp_type = (String) emp_type.getSelectedItem();
				int _salary_amount = Integer.parseInt(salary_amount.getText());
				int _search_ssn = Integer.parseInt(search_ssn.getText());
				System.out.println(_emp_type + " " + _operator + " " +  _salary_amount);
				System.out.println(_search_ssn);
				setVisible(false);
				dispose();
			}
		});
		btnNewButton_1.setBounds(177, 229, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("View Employees");
		lblNewLabel_2.setBounds(177, 15, 130, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Employee type");
		lblNewLabel_3.setBounds(37, 65, 96, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Search by SSN");
		lblNewLabel_4.setBounds(37, 108, 96, 14);
		contentPane.add(lblNewLabel_4);
		
		search_ssn = new JTextField();
		search_ssn.setBounds(153, 105, 96, 20);
		contentPane.add(search_ssn);
		search_ssn.setColumns(10);
		
		
		
	}
}
