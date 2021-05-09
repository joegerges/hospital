package hospital;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class page2 extends JFrame {

	private JPanel contentPane;
	private JTextField payment_date;
	private JTextField treatment;
	private JTextField medicine;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					page2 frame = new page2();
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
	public page2() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Let's find all patients that payed on 03-05-2021, with a total above 15 000 ,");
		lblNewLabel.setBounds(20, 22, 517, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("older than 64, having taken the Chemiotherapy treatment and dexamethasone");
		lblNewLabel_1.setBounds(20, 46, 539, 39);
		contentPane.add(lblNewLabel_1);
		
		payment_date = new JTextField();
		payment_date.setText("Date");
		payment_date.setBounds(10, 90, 98, 20);
		contentPane.add(payment_date);
		payment_date.setColumns(10);
		
		treatment = new JTextField();
		treatment.setText("Treatment");
		treatment.setColumns(10);
		treatment.setBounds(271, 90, 116, 20);
		contentPane.add(treatment);
		
		JComboBox Age = new JComboBox();
		Age.setToolTipText("");
		Age.setBounds(62, 169, 76, 20);
		contentPane.add(Age);
		Age.addItem(18);
		Age.addItem(21);
		Age.addItem(25);
		Age.addItem(30);
		Age.addItem(40);
		Age.addItem(50);
		Age.addItem(64);
		Age.addItem(70);
		Age.addItem(80);
		Age.addItem(90);
		Age.addItem(100);
		
		JLabel lblNewLabel_2 = new JLabel("Age");
		lblNewLabel_2.setBounds(30, 144, 48, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNurseExperience = new JLabel("Total");
		lblNurseExperience.setBounds(221, 144, 98, 14);
		contentPane.add(lblNurseExperience);
		
		JComboBox operators_patient = new JComboBox();
		operators_patient.setToolTipText("");
		operators_patient.setBounds(10, 169, 42, 20);
		contentPane.add(operators_patient);
		operators_patient.addItem(">");
		operators_patient.addItem("<");
		operators_patient.addItem(">=");
		operators_patient.addItem("<");
		operators_patient.addItem("<=");
		operators_patient.addItem("=");
		
		JComboBox operators_total = new JComboBox();
		operators_total.setToolTipText("");
		operators_total.setBounds(221, 169, 42, 20);
		contentPane.add(operators_total);
		operators_total.addItem(">");
		operators_total.addItem("<");
		operators_total.addItem(">=");
		operators_total.addItem("<=");
		operators_total.addItem("=");
		

		JComboBox total = new JComboBox();
		total.setToolTipText("");
		total.setBounds(273, 169, 76, 20);
		contentPane.add(total);
		total.addItem(10);
		total.addItem(50);
		total.addItem(100);
		total.addItem(200);
		total.addItem(300);
		total.addItem(500);
		total.addItem(1000);
		total.addItem(2000);
		total.addItem(3000);
		total.addItem(5000);
		total.addItem(10000);
		total.addItem(15000);
		total.addItem(20000);
		total.addItem(50000);
		
		medicine = new JTextField();
		medicine.setText("Medicine");
		medicine.setColumns(10);
		medicine.setBounds(130, 90, 116, 20);
		contentPane.add(medicine);
		
			
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String _operators_patient= (String) operators_patient.getSelectedItem();
				String _operators_nurse= (String) operators_total.getSelectedItem();
				int _Age = (int) Age.getSelectedItem();
				int _total = (int) total.getSelectedItem();
				String _paymend_date = payment_date.getText();
				String _treatment = treatment.getText();		
				String _medicine = medicine.getText();	
				
				
				System.out.println(_Age+ " " +_paymend_date+ " " +_treatment+ " " +_medicine+ " " +_operators_nurse+ " " +_operators_patient+ " " + _total);
				
			}
		});
		btnSubmit.setBounds(142, 227, 89, 23);
		contentPane.add(btnSubmit);
		
		JButton btnNewButton = new JButton("back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		btnNewButton.setBounds(0, 0, 89, 23);
		contentPane.add(btnNewButton);
		
		
	}
}