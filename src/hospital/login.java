package hospital;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class login {

	private JFrame frame;
	private JTextField usernameTxt;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Login Page");
		frame.getContentPane().setLayout(null);
		
		JButton loginBtn = new JButton("Login");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ssn = Integer.parseInt(usernameTxt.getText());
				String password = passwordField.getText();
				
				if(ssn == 1234 && password.equals("admin"))
				{
					welcome welcomePage = new welcome();
					welcomePage.setVisible(true);
					frame.setVisible(false);
				}
				else
				{
					JOptionPane.showMessageDialog(frame, "Invalid username or password", "Unsuccessful Login Attempt", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		loginBtn.setBounds(74, 171, 89, 23);
		frame.getContentPane().add(loginBtn);
		
		usernameTxt = new JTextField();
		usernameTxt.setBounds(40, 58, 154, 20);
		frame.getContentPane().add(usernameTxt);
		usernameTxt.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(40, 126, 154, 20);
		frame.getContentPane().add(passwordField);
		
		JLabel lblNewLabel = new JLabel("Receptionist SSN");
		lblNewLabel.setBounds(40, 42, 112, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(40, 109, 89, 14);
		frame.getContentPane().add(lblPassword);
	}
}
