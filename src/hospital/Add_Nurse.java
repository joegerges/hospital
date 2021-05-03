package hospital;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Add_Nurse extends JFrame {

	private JFrame frame;
	private JPanel contentPane;
	private JTextField emp_ssn;
	private JTextField emp_fn;
	private JTextField emp_ln;
	private JTextField salary;
	private JTextField phone_number;
	private JTextField dob;
	private JTextField fax;
	private JTextField country;
	private JTextField zip;
	private JTextField street;
	private JTextField working_hours;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Nurse frame = new Add_Nurse();
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
	public Add_Nurse() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		emp_ssn = new JTextField();
		emp_ssn.setBounds(104, 49, 96, 20);
		contentPane.add(emp_ssn);
		emp_ssn.setColumns(10);
		
		emp_fn = new JTextField();
		emp_fn.setBounds(104, 80, 96, 20);
		contentPane.add(emp_fn);
		emp_fn.setColumns(10);
		
		emp_ln = new JTextField();
		emp_ln.setBounds(104, 111, 96, 20);
		contentPane.add(emp_ln);
		emp_ln.setColumns(10);
		
		salary = new JTextField();
		salary.setBounds(104, 142, 96, 20);
		contentPane.add(salary);
		salary.setColumns(10);
		
		phone_number = new JTextField();
		phone_number.setBounds(104, 173, 96, 20);
		contentPane.add(phone_number);
		phone_number.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("SSN");
		lblNewLabel.setBounds(10, 52, 49, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setBounds(10, 83, 64, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Last Name");
		lblNewLabel_2.setBounds(10, 114, 86, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Salary");
		lblNewLabel_3.setBounds(10, 145, 86, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Phone Number");
		lblNewLabel_4.setBounds(10, 176, 86, 14);
		contentPane.add(lblNewLabel_4);
		
		JComboBox gender = new JComboBox();
		gender.addItem("male");
		gender.addItem("female");
		gender.setBounds(347, 141, 96, 22);
		contentPane.add(gender);
		gender.setSelectedItem(null);
		
		JButton btnNewButton = new JButton("submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fn = emp_fn.getText();
				String _dob = dob.getText();
				String _fax = fax.getText();
				String _country = country.getText();
				String _street = street.getText();
				int _zip = Integer.parseInt(zip.getText());
				String ln = emp_ln.getText();
				String _type = working_hours.getText();
				String _gender = (String) gender.getSelectedItem();
				int ssn = Integer.parseInt(emp_ssn.getText());
				int phone_numberr = Integer.parseInt(phone_number.getText());
				int salaryy = Integer.parseInt(salary.getText());
				System.out.println(fn + " " + ln + " " + ssn + " " + salaryy + " " +phone_numberr );
				System.out.println( _gender + " " + _zip + " " + _street + " " +_type );
				System.out.println(_street + " " + _country );
				System.out.println(_fax + " " + _dob );
			
			}
		});
		btnNewButton.setBounds(199, 256, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_5 = new JLabel("Add Nurse");
		lblNewLabel_5.setBounds(211, 11, 141, 30);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("DOB");
		lblNewLabel_6.setBounds(10, 213, 49, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Fax");
		lblNewLabel_7.setBounds(258, 207, 49, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Gender");
		lblNewLabel_8.setBounds(258, 145, 49, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_11 = new JLabel("Country");
		lblNewLabel_11.setBounds(258, 52, 49, 14);
		contentPane.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("ZIP");
		lblNewLabel_12.setBounds(258, 83, 49, 14);
		contentPane.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Street");
		lblNewLabel_13.setBounds(258, 114, 49, 14);
		contentPane.add(lblNewLabel_13);
		
		dob = new JTextField();
		dob.setBounds(104, 204, 96, 20);
		contentPane.add(dob);
		dob.setColumns(10);
		
		fax = new JTextField();
		fax.setBounds(347, 201, 96, 20);
		contentPane.add(fax);
		fax.setColumns(10);
		
		country = new JTextField();
		country.setBounds(347, 49, 96, 20);
		contentPane.add(country);
		country.setColumns(10);
		
		zip = new JTextField();
		zip.setBounds(347, 80, 96, 20);
		contentPane.add(zip);
		zip.setColumns(10);
		
		street = new JTextField();
		street.setBounds(347, 111, 96, 20);
		contentPane.add(street);
		street.setColumns(10);
		
		JLabel lblType = new JLabel("Working Hours");
		lblType.setBounds(258, 176, 116, 14);
		contentPane.add(lblType);
		
		working_hours = new JTextField();
		working_hours.setColumns(10);
		working_hours.setBounds(347, 173, 96, 20);
		contentPane.add(working_hours);
		
		JButton btnNewButton_1 = new JButton("back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		btnNewButton_1.setBounds(10, 11, 89, 23);
		contentPane.add(btnNewButton_1);
		
	
		

	}
}
