package hospital;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class View_Treatment extends JFrame {

	private JPanel contentPane;
	private JTextField search_id;
	private JTable table;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_Treatment frame = new View_Treatment();
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
	public View_Treatment() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 617, 367);
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
		
		JScrollPane scrollPane = new JScrollPane();
		
		table = new JTable();
		table.setBounds(10, 99, 414, 197);
		scrollPane.setViewportView(table);
		scrollPane.setBounds(10, 93, 584, 227);
		getContentPane().add(scrollPane);
		
		JButton btnNewButton_1 = new JButton("submit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				int _search_id = -1;
				if(!search_id.getText().isEmpty()) _search_id = Integer.parseInt(search_id.getText());
				
				DatabaseHelper dbHelper = new DatabaseHelper();
				ResultSet empsRs = dbHelper.GetTreatment(_search_id);
				
				table.setModel(DbUtils.resultSetToTableModel(empsRs));
				
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(frame, "Oops, something went wrong", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_1.setBounds(505, 59, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("View Treatment");
		lblNewLabel_2.setBounds(259, 15, 130, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Search by ID");
		lblNewLabel_4.setBounds(37, 63, 96, 14);
		contentPane.add(lblNewLabel_4);
		
		search_id = new JTextField();
		search_id.setBounds(143, 60, 96, 20);
		contentPane.add(search_id);
		search_id.setColumns(10);
		
		
		
	}
}
