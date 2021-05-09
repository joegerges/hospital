package hospital;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

public class page1 extends JFrame {

	private JPanel contentPane;
	private JTextField txtBloodTyoe;
	private JTextField txtPatientArrivalDate;
	private JTable table;
	private JTextField patientAge;
	private JTextField nurseExperience;
	private JFrame frame;
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
		setBounds(100, 100, 974, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Let's find the details of patients with Blood Type X , older than Y, having arrived");
		lblNewLabel.setBounds(20, 24, 508, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("before Z date, whose nurse had more than M years of experience");
		lblNewLabel_1.setBounds(20, 50, 451, 39);
		contentPane.add(lblNewLabel_1);
		
		txtBloodTyoe = new JTextField();
		txtBloodTyoe.setText("Patient Blood type");
		txtBloodTyoe.setBounds(10, 90, 140, 20);
		contentPane.add(txtBloodTyoe);
		txtBloodTyoe.setColumns(10);
		
		txtPatientArrivalDate = new JTextField();
		txtPatientArrivalDate.setText("Patient Arrival Date");
		txtPatientArrivalDate.setColumns(10);
		txtPatientArrivalDate.setBounds(10, 121, 140, 20);
		contentPane.add(txtPatientArrivalDate);
		
		JLabel lblNewLabel_2 = new JLabel("Age");
		lblNewLabel_2.setBounds(10, 152, 48, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNurseExperience = new JLabel("Nurse  experience");
		lblNurseExperience.setBounds(187, 152, 138, 14);
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
		operators_nurse.setBounds(187, 169, 42, 20);
		contentPane.add(operators_nurse);
		operators_nurse.addItem(null);
		operators_nurse.addItem(">");
		operators_nurse.addItem("<");
		operators_nurse.addItem(">=");
		operators_nurse.addItem("<=");
		operators_nurse.addItem("=");
		
		JScrollPane scrollPane = new JScrollPane();
		
		table = new JTable();
		table.setBounds(10, 99, 414, 197);
		scrollPane.setViewportView(table);
		scrollPane.setBounds(10, 200, 948, 176);
		getContentPane().add(scrollPane);
			
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				String _operators_patient= (String) operators_patient.getSelectedItem();
				String _operators_nurse= (String) operators_nurse.getSelectedItem();
				int _Age= Integer.parseInt(patientAge.getText());
				int _experience= Integer.parseInt(nurseExperience.getText());
				String _Bloodtype = txtBloodTyoe.getText();
				String _PatientArrivalDate = txtPatientArrivalDate.getText();	
				
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				String age = LocalDate.now().minusYears(_Age).format(formatter);
				String exp = LocalDate.now().minusYears(_experience).format(formatter);
				
				String _pat_op="";
				String _nurse_op="";
				
				switch(_operators_patient) {
				case ">": _pat_op = "<";
						  break;
				case "<": _pat_op = ">";
				  		  break;
				case ">=": _pat_op = "<=";
				          break;
				case "<=": _pat_op = ">=";
				           break;
				case "=": _pat_op = "=";
				  	      break;
				}
				
				switch(_operators_nurse) {
				case ">": _nurse_op = "<";
						  break;
				case "<": _nurse_op = ">";
				  		  break;
				case ">=": _nurse_op = "<=";
				          break;
				case "<=": _nurse_op = ">=";
				           break;
				case "=": _nurse_op = "=";
				  	      break;
				}
				
				DatabaseHelper dbHelper = new DatabaseHelper();
				ResultSet empsRs = dbHelper.GetDetailsComplexOne(_Bloodtype, _PatientArrivalDate, _pat_op, age, _nurse_op, exp);
				
				table.setModel(DbUtils.resultSetToTableModel(empsRs));
				
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(frame, "Oops, something went wrong", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnSubmit.setBounds(335, 168, 89, 23);
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
		
		patientAge = new JTextField();
		patientAge.setBounds(64, 169, 86, 20);
		contentPane.add(patientAge);
		patientAge.setColumns(10);
		
		nurseExperience = new JTextField();
		nurseExperience.setBounds(239, 169, 86, 20);
		contentPane.add(nurseExperience);
		nurseExperience.setColumns(10);
	}
}
