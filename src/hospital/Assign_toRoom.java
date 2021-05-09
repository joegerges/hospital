package hospital;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hospital.DataContracts.Room;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Assign_toRoom extends JFrame {

	private JPanel contentPane;
	private JTextField room_number;
	private JTextField janitor_ssn;
	private JFrame frame;
	private JTextField nurse_ssn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Assign_toRoom frame = new Assign_toRoom();
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
	public Assign_toRoom() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		room_number = new JTextField();
		room_number.setBounds(163, 155, 96, 20);
		contentPane.add(room_number);
		room_number.setColumns(10);
		
		janitor_ssn = new JTextField();
		janitor_ssn.setBounds(163, 94, 96, 20);
		contentPane.add(janitor_ssn);
		janitor_ssn.setColumns(10);
		
		JComboBox<Integer> room_floor = new JComboBox<Integer>();
		DatabaseHelper dbHelper = new DatabaseHelper();
		ArrayList<Integer> floor_numbers = dbHelper.GetFloorNumbers();
		room_floor.setBounds(163, 124, 96, 22);
		for(Integer floor: floor_numbers)
		{
			room_floor.addItem(floor);
		}
		contentPane.add(room_floor);
		room_floor.setSelectedItem(null);
		
		JButton btnNewButton = new JButton("submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				int _nurse_ssn = Integer.parseInt(nurse_ssn.getText());
				int _janitor_ssn = Integer.parseInt(janitor_ssn.getText());
				int _room_number = Integer.parseInt(room_number.getText());
				int _room_floor = (Integer) room_floor.getSelectedItem();
				
				DatabaseHelper dbHelper = new DatabaseHelper();
				dbHelper.AssignNurseJanToRoom(_nurse_ssn, _janitor_ssn, _room_number, _room_floor);
				JOptionPane.showMessageDialog(frame, "Successfully assigned nurse and janitor to this room", "Success", JOptionPane.INFORMATION_MESSAGE);
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
					JOptionPane.showMessageDialog(frame, "Oops, something went wrong", "Error", JOptionPane.ERROR_MESSAGE);
				}
		
			}
		});
		btnNewButton.setBounds(126, 229, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Assign Empoyee to Room");
		lblNewLabel.setBounds(148, 11, 234, 14);
		contentPane.add(lblNewLabel);
		
		JLabel rooms_number = new JLabel("Room Number");
		rooms_number.setBounds(47, 158, 106, 14);
		contentPane.add(rooms_number);
		
		JLabel lblNewLabel_2 = new JLabel("Janitor SSN");
		lblNewLabel_2.setBounds(47, 97, 89, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel numbeds = new JLabel("Room Floor");
		numbeds.setBounds(47, 128, 133, 14);
		contentPane.add(numbeds);
		
		JButton btnNewButton_1 = new JButton("back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		btnNewButton_1.setBounds(10, 7, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Nurse SSN");
		lblNewLabel_1.setBounds(47, 66, 89, 14);
		contentPane.add(lblNewLabel_1);
		
		nurse_ssn = new JTextField();
		nurse_ssn.setBounds(163, 63, 96, 20);
		contentPane.add(nurse_ssn);
		nurse_ssn.setColumns(10);
		
		
		
	}
}
