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

public class page1 extends JFrame {

	private JPanel contentPane;
	private JTextField txtBloodTyoe;
	private JTextField txtPatientArrivalDate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					page1 frame = new page1();
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
	public page1() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Let's find all patients with Blood Type A- , older than 25, having arrived");
		lblNewLabel.setBounds(20, 24, 508, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("before 2020, whose nurse had more than 5 years of experience");
		lblNewLabel_1.setBounds(20, 50, 451, 39);
		contentPane.add(lblNewLabel_1);
		
		txtBloodTyoe = new JTextField();
		txtBloodTyoe.setText("Blood type");
		txtBloodTyoe.setBounds(10, 90, 86, 20);
		contentPane.add(txtBloodTyoe);
		txtBloodTyoe.setColumns(10);
		
		txtPatientArrivalDate = new JTextField();
		txtPatientArrivalDate.setText("Patient Arrival Date");
		txtPatientArrivalDate.setColumns(10);
		txtPatientArrivalDate.setBounds(221, 90, 116, 20);
		contentPane.add(txtPatientArrivalDate);
		
		JComboBox Age = new JComboBox();
		Age.setToolTipText("");
		Age.setBounds(62, 169, 76, 20);
		contentPane.add(Age);
		Age.addItem(null);
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
		
		JLabel lblNurseExperience = new JLabel("Nurse  experience");
		lblNurseExperience.setBounds(221, 144, 181, 14);
		contentPane.add(lblNurseExperience);
		
		JComboBox operators_patient = new JComboBox();
		operators_patient.setToolTipText("");
		operators_patient.setBounds(10, 169, 42, 20);
		contentPane.add(operators_patient);
		operators_patient.addItem(null);
		operators_patient.addItem(">");
		operators_patient.addItem("<");
		operators_patient.addItem(">=");
		operators_patient.addItem("<");
		operators_patient.addItem("<=");
		operators_patient.addItem("=");
		
		JComboBox operators_nurse = new JComboBox();
		operators_nurse.setToolTipText("");
		operators_nurse.setBounds(221, 169, 42, 20);
		contentPane.add(operators_nurse);
		operators_nurse.addItem(null);
		operators_nurse.addItem(">");
		operators_nurse.addItem("<");
		operators_nurse.addItem(">=");
		operators_nurse.addItem("<=");
		operators_nurse.addItem("=");
		

		JComboBox experience = new JComboBox();
		experience.setToolTipText("");
		experience.setBounds(273, 169, 76, 20);
		contentPane.add(experience);
		experience.addItem(null);
		experience.addItem(0);
		experience.addItem(1);
		experience.addItem(2);
		experience.addItem(3);
		experience.addItem(5);
		experience.addItem(7);
		experience.addItem(10);
		experience.addItem(15);
		experience.addItem(20);
			
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String _operators_patient= (String) operators_patient.getSelectedItem();
				String _operators_nurse= (String) operators_nurse.getSelectedItem();
				int _Age= (int) Age.getSelectedItem();
				int _experience= (int) experience.getSelectedItem();
				String _Bloodtype = txtBloodTyoe.getText();
				String _PatientArrivalDate = txtPatientArrivalDate.getText();	
				
				
				System.out.println(_Age+ " " +_Bloodtype+ " " +_experience+ " " +_operators_nurse+ " " +_operators_patient+ " " +_PatientArrivalDate);
				
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
