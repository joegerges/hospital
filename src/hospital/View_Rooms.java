package hospital;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class View_Rooms extends JFrame {

	private JPanel contentPane;
	private JTextField room_nb;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_Rooms frame = new View_Rooms();
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
	public View_Rooms() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				setVisible(false);
				dispose();
			}
		});
		btnNewButton.setBounds(10, 11, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("View Rooms");
		lblNewLabel.setBounds(185, 15, 108, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("floor number");
		lblNewLabel_1.setBounds(50, 66, 76, 14);
		contentPane.add(lblNewLabel_1);
		
		JComboBox floor_number = new JComboBox();
		floor_number.setBounds(165, 62, 97, 22);
		contentPane.add(floor_number);
		
		JButton btnNewButton_1 = new JButton("submit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int _floor_nb = Integer.parseInt((String) floor_number.getSelectedItem());
				String _room_nb = room_nb.getText();
				System.out.println(_room_nb + " " + _floor_nb);
			}
		});
		btnNewButton_1.setBounds(292, 99, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Room Number");
		lblNewLabel_2.setBounds(50, 103, 114, 14);
		contentPane.add(lblNewLabel_2);
		
		room_nb = new JTextField();
		room_nb.setBounds(165, 100, 96, 20);
		contentPane.add(room_nb);
		room_nb.setColumns(10);
	}
}
