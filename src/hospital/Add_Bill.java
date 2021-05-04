package hospital;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hospital.DataContracts.Bill;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Add_Bill extends JFrame {

	private JFrame frame;
	private JPanel contentPane;
	private JTextField patient_id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Bill frame = new Add_Bill();
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
	public Add_Bill() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 376, 246);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Patient ID");
		lblNewLabel.setBounds(52, 52, 86, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Treatment ID");
		lblNewLabel_1.setBounds(52, 86, 131, 14);
		contentPane.add(lblNewLabel_1);
		
		DatabaseHelper dbHelper = new DatabaseHelper();
		
		JComboBox<Integer> treatment_id = new JComboBox<Integer>();
		ArrayList<Integer> treatments = new ArrayList<Integer>();
		try {
			treatments = dbHelper.GetTreatments();
			for(int treat: treatments)
			{
				treatment_id.addItem(treat);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		treatment_id.setBounds(193, 80, 96, 20);
		contentPane.add(treatment_id);


		contentPane.add(treatment_id);
		treatment_id.setSelectedItem(null);
		
		JComboBox<Integer> medicine_code = new JComboBox<Integer>();
		ArrayList<Integer> medecines = new ArrayList<Integer>();
		try {
			medecines = dbHelper.GetMedicines();
			for(int med: medecines)
			{
				medicine_code.addItem(med);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		medicine_code.setBounds(193, 111, 96, 20);
		contentPane.add(medicine_code);
		medicine_code.setSelectedItem(null);
		
		JButton btnNewButton = new JButton("submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				int _patient_id = Integer.parseInt(patient_id.getText());
				int _treatment_id = (int) treatment_id.getSelectedItem();
				int _medicine_code = (int) medicine_code.getSelectedItem();
				
				Bill bill = new Bill();
				bill.med_code = _medicine_code;
				bill.patient_ssn = _patient_id;
				bill.treatment_id = _treatment_id;
				bill.total_price = dbHelper.GetMedPrice(_medicine_code) + dbHelper.GetTreatmentPrice(_treatment_id);
				dbHelper.AddBill(bill);
				JOptionPane.showMessageDialog(frame, "Successfully added this bill", "Success", JOptionPane.INFORMATION_MESSAGE);
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(frame, "Oops, something went wrong", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnNewButton.setBounds(149, 158, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_5 = new JLabel("Add Bill");
		lblNewLabel_5.setBounds(133, 11, 141, 30);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblMedicineId = new JLabel("Medicine Code");
		lblMedicineId.setBounds(52, 117, 131, 14);
		contentPane.add(lblMedicineId);
		
		patient_id = new JTextField();
		patient_id.setBounds(193, 49, 96, 20);
		contentPane.add(patient_id);
		patient_id.setColumns(10);
		
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