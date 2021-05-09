package hospital;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hospital.DataContracts.Patient;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Add_Patient extends JFrame {

	private JFrame frame;
	private JPanel contentPane;
	private JTextField patient_ssn;
	private JTextField patient_fn;
	private JTextField patient_ln;
	private JTextField patient_room;
	private JTextField patient_floor;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Patient frame = new Add_Patient();
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
	public Add_Patient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 315);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		patient_ssn = new JTextField();
		patient_ssn.setBounds(193, 49, 96, 20);
		contentPane.add(patient_ssn);
		patient_ssn.setColumns(10);
		
		patient_fn = new JTextField();
		patient_fn.setBounds(193, 80, 96, 20);
		contentPane.add(patient_fn);
		patient_fn.setColumns(10);
		
		patient_ln = new JTextField();
		patient_ln.setBounds(193, 111, 96, 20);
		contentPane.add(patient_ln);
		patient_ln.setColumns(10);
		
		patient_room = new JTextField();
		patient_room.setBounds(193, 142, 96, 20);
		contentPane.add(patient_room);
		patient_room.setColumns(10);
		
		DatabaseHelper dbHelper = new DatabaseHelper();
		ArrayList<Integer> floor_numbers = dbHelper.GetFloorNumbers();
		JComboBox<Integer> floor_number = new JComboBox<Integer>();
		floor_number.setBounds(193, 173, 96, 20);
		for(Integer floor: floor_numbers)
		{
			floor_number.addItem(floor);
		}
		contentPane.add(floor_number);
		floor_number.setSelectedItem(null);
		
		JLabel lblNewLabel = new JLabel("SSN");
		lblNewLabel.setBounds(52, 52, 49, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setBounds(52, 86, 64, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Last Name");
		lblNewLabel_2.setBounds(52, 117, 86, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Room Number");
		lblNewLabel_3.setBounds(52, 148, 86, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Floor Number");
		lblNewLabel_4.setBounds(52, 179, 86, 14);
		contentPane.add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(193, 204, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Arrival Date");
		lblNewLabel_6.setBounds(52, 207, 86, 14);
		contentPane.add(lblNewLabel_6);
		
		JButton btnNewButton = new JButton("submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String fn = patient_fn.getText();
				String ln = patient_ln.getText();
				int ssn = Integer.parseInt(patient_ssn.getText());
				int floor = (int) floor_number.getSelectedItem();
				int room = Integer.parseInt(patient_room.getText());
				String _arrival = textField.getText();
				
				Patient pat = new Patient();
				pat.ssn = ssn;
				pat.fname = fn;
				pat.lname = ln;
				pat.floor_number = floor;
				pat.room_number = room;
				pat.last_entered = _arrival;
				
				DatabaseHelper dbHelper = new DatabaseHelper();
				dbHelper.AddPatient(pat);
				JOptionPane.showMessageDialog(frame, "Successfully added this patient", "Success", JOptionPane.INFORMATION_MESSAGE);
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(frame, "Oops, something went wrong", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(193, 238, 96, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_5 = new JLabel("Add Patient");
		lblNewLabel_5.setBounds(209, 7, 141, 30);
		contentPane.add(lblNewLabel_5);
		
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
