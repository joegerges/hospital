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

public class Add_Patient extends JFrame {

	private JFrame frame;
	private JPanel contentPane;
	private JTextField patient_ssn;
	private JTextField patient_fn;
	private JTextField patient_ln;
	private JTextField patient_room;
	private JTextField patient_floor;

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
		setBounds(100, 100, 450, 300);
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
		
		patient_floor = new JTextField();
		patient_floor.setBounds(193, 173, 96, 20);
		contentPane.add(patient_floor);
		patient_floor.setColumns(10);
		
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
		
		JButton btnNewButton = new JButton("submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fn = patient_fn.getText();
				String ln = patient_ln.getText();
				int ssn = Integer.parseInt(patient_ssn.getText());
				int floor = Integer.parseInt(patient_floor.getText());
				int room = Integer.parseInt(patient_room.getText());
				System.out.println(fn + " " + ln + " " + ssn + " " + floor + " " + room );
				setVisible(false);
				dispose();
			}
		});
		btnNewButton.setBounds(200, 213, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_5 = new JLabel("Add Patient");
		lblNewLabel_5.setBounds(148, 11, 141, 30);
		contentPane.add(lblNewLabel_5);
	}
}
