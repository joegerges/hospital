package hospital;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hospital.DataContracts.Medicine;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Add_Medicine extends JFrame {

	private JFrame frame;
	private JPanel contentPane;
	private JTextField code;
	private JTextField quantity;
	private JTextField expiry_date;
	private JTextField price;
	private JTextField medName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Medicine frame = new Add_Medicine();
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
	public Add_Medicine() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		code = new JTextField();
		code.setBounds(193, 46, 96, 20);
		contentPane.add(code);
		code.setColumns(10);
		
		quantity = new JTextField();
		quantity.setBounds(193, 103, 96, 20);
		contentPane.add(quantity);
		quantity.setColumns(10);
		
		expiry_date = new JTextField();
		expiry_date.setBounds(193, 134, 96, 20);
		contentPane.add(expiry_date);
		expiry_date.setColumns(10);
		
		price = new JTextField();
		price.setBounds(193, 165, 96, 20);
		contentPane.add(price);
		price.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Code");
		lblNewLabel.setBounds(52, 52, 49, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Quantity");
		lblNewLabel_1.setBounds(52, 106, 64, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Expiry Date");
		lblNewLabel_2.setBounds(52, 137, 86, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Price");
		lblNewLabel_3.setBounds(52, 168, 86, 14);
		contentPane.add(lblNewLabel_3);
		
		medName = new JTextField();
		medName.setColumns(10);
		medName.setBounds(193, 72, 96, 20);
		contentPane.add(medName);
		
		JButton btnNewButton = new JButton("submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String exp = expiry_date.getText();
				int _code = Integer.parseInt(code.getText());
				int qte = Integer.parseInt(quantity.getText());
				int _price = Integer.parseInt(price.getText());
				String _med_name = medName.getText();
				
				Medicine med = new Medicine();
				med.code_number = _code;
				med.expiry_date = exp;
				med.price = _price;
				med.quantity = qte;
				med.med_name = _med_name;
				
				DatabaseHelper dbHelper = new DatabaseHelper();
				dbHelper.AddMedicine(med);
				
				JOptionPane.showMessageDialog(frame, "Successfully added this medecine", "Success", JOptionPane.INFORMATION_MESSAGE);
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(frame, "Oops, something went wrong", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnNewButton.setBounds(143, 196, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_5 = new JLabel("Add Medicine");
		lblNewLabel_5.setBounds(133, 11, 141, 30);
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
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(52, 81, 49, 14);
		contentPane.add(lblName);
	
	}
}