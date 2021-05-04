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
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Add_Rooms extends JFrame {

	private JPanel contentPane;
	private JTextField number;
	private JTextField floor_number;
	private JTextField number_beds;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Rooms frame = new Add_Rooms();
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
	public Add_Rooms() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		number = new JTextField();
		number.setBounds(178, 63, 96, 20);
		contentPane.add(number);
		number.setColumns(10);
		
		floor_number = new JTextField();
		floor_number.setBounds(178, 94, 96, 20);
		contentPane.add(floor_number);
		floor_number.setColumns(10);
		
		number_beds = new JTextField();
		number_beds.setBounds(178, 125, 96, 20);
		contentPane.add(number_beds);
		number_beds.setColumns(10);
		
		JComboBox type = new JComboBox();
		type.setBounds(178, 155, 96, 22);
		contentPane.add(type);
		type.addItem("ER");
		type.addItem("ICU");
		type.addItem("Normal");
		type.setSelectedItem(null);
		JButton btnNewButton = new JButton("submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String _type = (String) type.getSelectedItem();
				int _number_beds = Integer.parseInt(number_beds.getText());
				int _number = Integer.parseInt(number.getText());
				int _floor_number = Integer.parseInt(floor_number.getText());
				
				Room room = new Room();
				room.number = _number;
				room.floor_number = _floor_number;
				room.number_beds = _number_beds;
				room.type = _type;
				
				DatabaseHelper dbHelper = new DatabaseHelper();
				dbHelper.AddRoom(room);
				
				JOptionPane.showMessageDialog(frame, "Successfully added this room", "Success", JOptionPane.INFORMATION_MESSAGE);
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(frame, "Oops, something went wrong", "Error", JOptionPane.ERROR_MESSAGE);
				}
		
			}
		});
		btnNewButton.setBounds(126, 229, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Add Rooms ");
		lblNewLabel.setBounds(148, 11, 103, 14);
		contentPane.add(lblNewLabel);
		
		JLabel rooms_number = new JLabel("Number");
		rooms_number.setBounds(47, 66, 49, 14);
		contentPane.add(rooms_number);
		
		JLabel lblNewLabel_2 = new JLabel("floor number");
		lblNewLabel_2.setBounds(47, 97, 89, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel numbeds = new JLabel("number of beds");
		numbeds.setBounds(47, 128, 133, 14);
		contentPane.add(numbeds);
		
		JLabel lblNewLabel_4 = new JLabel("Type");
		lblNewLabel_4.setBounds(47, 159, 49, 14);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton_1 = new JButton("back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		btnNewButton_1.setBounds(10, 7, 89, 23);
		contentPane.add(btnNewButton_1);
		
	}
}
