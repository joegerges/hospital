package hospital;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hospital.DataContracts.MedicalRecord;
import hospital.DataContracts.Patient;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Add_MedicalRecord extends JFrame {

	private JFrame frame;
	private JPanel contentPane;
	private JTextField MedicalRecord_ssn;
	private JTextField Record_Address;
	private JTextField Record_Phone;
	private JTextField DOB;
	private JTextField Blood_Type;
	private JTextField maintener_ssn;
	private Boolean has_insb;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_MedicalRecord frame = new Add_MedicalRecord();
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
	public Add_MedicalRecord() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		MedicalRecord_ssn = new JTextField();
		MedicalRecord_ssn.setBounds(193, 80, 96, 20);
		contentPane.add(MedicalRecord_ssn);
		MedicalRecord_ssn.setColumns(10);
		
		Record_Address = new JTextField();
		Record_Address.setBounds(193, 111, 96, 20);
		contentPane.add(Record_Address);
		Record_Address.setColumns(10);
		
		Record_Phone = new JTextField();
		Record_Phone.setBounds(193, 142, 96, 20);
		contentPane.add(Record_Phone);
		Record_Phone.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("SSN");
		lblNewLabel.setBounds(50, 83, 49, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Address");
		lblNewLabel_2.setBounds(52, 117, 86, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Phone");
		lblNewLabel_3.setBounds(52, 148, 86, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Has Insurance");
		lblNewLabel_4.setBounds(52, 176, 119, 14);
		contentPane.add(lblNewLabel_4);
		JLabel lblNewLabel_5 = new JLabel("Add Medical Record");
		lblNewLabel_5.setBounds(188, 7, 141, 30);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblDob = new JLabel("DOB");
		lblDob.setBounds(52, 207, 86, 14);
		contentPane.add(lblDob);
		
		DOB = new JTextField();
		DOB.setColumns(10);
		DOB.setBounds(193, 204, 96, 20);
		contentPane.add(DOB);
		
		JLabel lblBloodtype = new JLabel("Blood_Type");
		lblBloodtype.setBounds(52, 240, 86, 14);
		contentPane.add(lblBloodtype);
		
		Blood_Type = new JTextField();
		Blood_Type.setColumns(10);
		Blood_Type.setBounds(193, 237, 96, 20);
		contentPane.add(Blood_Type);
		
		JLabel lblMaintainerssn = new JLabel("Maintainer_SSN");
		lblMaintainerssn.setBounds(52, 279, 141, 14);
		contentPane.add(lblMaintainerssn);
		
		maintener_ssn = new JTextField();
		maintener_ssn.setColumns(10);
		maintener_ssn.setBounds(193, 276, 96, 20);
		contentPane.add(maintener_ssn);
		
		JComboBox has_insurance = new JComboBox();
		has_insurance.addItem("yes");
		has_insurance.addItem("no");
		has_insurance.setBounds(193, 172, 96, 22);
		contentPane.add(has_insurance);
		has_insurance.setSelectedItem(null);
		
		JButton btnNewButton = new JButton("submit");
		btnNewButton.setBounds(200, 330, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String patient_address = Record_Address.getText();
				String _DOB = DOB.getText();
				String blood = Blood_Type.getText();
				String _has_insurance = (String) has_insurance.getSelectedItem();
				int ssn = Integer.parseInt(MedicalRecord_ssn.getText());
				int phone = Integer.parseInt(Record_Phone.getText());
				int maintainer_ssn = Integer.parseInt(maintener_ssn.getText());
				
				MedicalRecord med = new MedicalRecord();
				med.ssn = ssn;
				med.address = patient_address;
				med.blood_type = blood;
				med.dob = _DOB;
				med.has_insurance = (_has_insurance == "yes"? true: false);
				med.maintainer_ssn = maintainer_ssn;
				med.phone = phone;
				
				DatabaseHelper dbHelper = new DatabaseHelper();
				dbHelper.AddMedicalRecord(med);
				JOptionPane.showMessageDialog(frame, "Successfully added this medical record", "Success", JOptionPane.INFORMATION_MESSAGE);
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(frame, "Oops, something went wrong", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		contentPane.add(btnNewButton);
		
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