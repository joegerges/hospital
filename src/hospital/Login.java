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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JFrame frame;
	private JPanel contentPane;
	private JTextField internal_number;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 333, 204);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		internal_number = new JTextField();
		internal_number.setBounds(193, 49, 96, 20);
		contentPane.add(internal_number);
		internal_number.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(193, 80, 96, 20);
		contentPane.add(password);
		password.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Internal Number");
		lblNewLabel.setBounds(52, 52, 131, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(52, 86, 64, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int _internal_number = Integer.parseInt(internal_number.getText());
					String pass = password.getText();
					DatabaseHelper dbHelper = new DatabaseHelper();
					boolean login = dbHelper.Login(_internal_number, pass);
					
					if(login)
					{
						GUI gui = new GUI();	
						gui.frame.setVisible(true);
						setVisible(false);
					}
					else
					{
						JOptionPane.showMessageDialog(frame, "Invalid username or password", "Unsuccessful Login Attempt", JOptionPane.ERROR_MESSAGE);
					}
					}
					catch(Exception e1)
					{
						JOptionPane.showMessageDialog(frame, "Oops, something went wrong", "Error", JOptionPane.ERROR_MESSAGE);
					}
			}
		});
		btnNewButton.setBounds(140, 125, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_5 = new JLabel("Login");
		lblNewLabel_5.setBounds(148, 11, 141, 30);
		contentPane.add(lblNewLabel_5);
		
		JButton btnNewButton_1 = new JButton("exit");
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
