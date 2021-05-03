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

public class Add_Treatment extends JFrame {

	private JFrame frame;
	private JPanel contentPane;
	private JTextField id;
	private JTextField type;
	private JTextField price;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Treatment frame = new Add_Treatment();
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
	public Add_Treatment() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		id = new JTextField();
		id.setBounds(193, 49, 96, 20);
		contentPane.add(id);
		id.setColumns(10);
		
		type = new JTextField();
		type.setBounds(193, 111, 96, 20);
		contentPane.add(type);
		type.setColumns(10);
		
		price = new JTextField();
		price.setBounds(193, 142, 96, 20);
		contentPane.add(price);
		price.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(52, 52, 49, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Insurance Covered");
		lblNewLabel_1.setBounds(52, 86, 131, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Type");
		lblNewLabel_2.setBounds(52, 117, 86, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Price");
		lblNewLabel_3.setBounds(52, 148, 86, 14);
		contentPane.add(lblNewLabel_3);
		

		
		JComboBox insurance_covered = new JComboBox();
		insurance_covered.setBounds(193, 80, 96, 20);
		contentPane.add(insurance_covered);

		insurance_covered.addItem("yes");
		insurance_covered.addItem("no");
		contentPane.add(insurance_covered);
		insurance_covered.setSelectedItem(null);
		
		
		JButton btnNewButton = new JButton("submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String _type = type.getText();
				int _id= Integer.parseInt(id.getText());
				
				String _insurance = (String) insurance_covered.getSelectedItem();
				int _price = Integer.parseInt(price.getText());
				System.out.println(_type + " " + _insurance + " " + _price + " " + " " + _id);
				
			}
		});
		btnNewButton.setBounds(122, 186, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_5 = new JLabel("Add Treatment");
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
		
		

		
		
	}
}