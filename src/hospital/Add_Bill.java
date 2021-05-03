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
		setBounds(100, 100, 450, 300);
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
		

		
		JComboBox treatment_id = new JComboBox();
		treatment_id.setBounds(193, 80, 96, 20);
		contentPane.add(treatment_id);


		contentPane.add(treatment_id);
		treatment_id.setSelectedItem(null);
		
		JComboBox medicine_code = new JComboBox();
		medicine_code.setBounds(193, 111, 96, 20);
		contentPane.add(medicine_code);
		
		JButton btnNewButton = new JButton("submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int _patient_id = Integer.parseInt(patient_id.getText());
				int _treatment_id = (int) treatment_id.getSelectedItem();
				int _medicine_code = (int) medicine_code.getSelectedItem();
				int _price = 0 ;
				System.out.println(_patient_id + " " + _treatment_id + " " + _medicine_code+ " " + " " + _price);
				setVisible(false);
				dispose();
				
			}
		});
		btnNewButton.setBounds(122, 186, 89, 23);
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
		
	
		
		

		
		
	}
}