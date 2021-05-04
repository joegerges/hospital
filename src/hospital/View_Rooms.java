package hospital;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class View_Rooms extends JFrame {

	private JPanel contentPane;
	private JTextField room_nb;
	private JTable table;
	private JFrame frame;
	
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
		setBounds(100, 100, 712, 467);
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
		lblNewLabel.setBounds(336, 15, 108, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Floor number");
		lblNewLabel_1.setBounds(50, 66, 76, 14);
		contentPane.add(lblNewLabel_1);
		
		DatabaseHelper dbHelper = new DatabaseHelper();
		ArrayList<Integer> floor_numbers = dbHelper.GetFloorNumbers();
		JComboBox<Integer> floor_number = new JComboBox<Integer>();
		for(Integer floor: floor_numbers)
		{
			floor_number.addItem(floor);
		}
		floor_number.setBounds(165, 62, 97, 22);
		contentPane.add(floor_number);
		floor_number.setSelectedItem(null);
		
		JScrollPane scrollPane = new JScrollPane();
		
		table = new JTable();
		table.setBounds(10, 99, 414, 197);
		scrollPane.setViewportView(table);
		scrollPane.setBounds(10, 133, 679, 284);
		getContentPane().add(scrollPane);
		
		JButton btnNewButton_1 = new JButton("submit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				Integer _room_nb = null, _floor_nb = null;
				_floor_nb = (Integer) floor_number.getSelectedItem();
				if(!room_nb.getText().isEmpty()) _room_nb = Integer.parseInt(room_nb.getText());
				ResultSet roomsRs = dbHelper.GetRooms(_floor_nb, _room_nb);
				table.setModel(DbUtils.resultSetToTableModel(roomsRs));
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(frame, "Oops, something went wrong", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_1.setBounds(600, 99, 89, 23);
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
