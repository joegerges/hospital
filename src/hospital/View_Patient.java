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

public class View_Patient extends JFrame {

	private JPanel contentPane;
	private JTextField search;
	private JTable table;
	private JFrame frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_Patient frame = new View_Patient();
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
	public View_Patient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 713, 363);
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
		scrollPane.setBounds(10, 93, 679, 227);
		getContentPane().add(scrollPane);
		
		JComboBox search_by = new JComboBox();
		search_by.setBounds(117, 60, 96, 22);
		contentPane.add(search_by);
		search_by.addItem("None");
		search_by.addItem("ssn");
		search_by.addItem("fname");
		search_by.addItem("lname");
		search_by.setSelectedItem("None");
		
		JButton btnNewButton_1 = new JButton("submit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					String _search_by = (String) search_by.getSelectedItem();
					String _search_value = "-1";
					
					if(!search.getText().isEmpty()) _search_value=search.getText();
					
					DatabaseHelper dbHelper = new DatabaseHelper();
					ResultSet medRs = dbHelper.FetchPatientOrRecord(_search_by, _search_value, "patient");
					
					table.setModel(DbUtils.resultSetToTableModel(medRs));
					
					}
					catch(Exception e1)
					{
						JOptionPane.showMessageDialog(frame, "Oops, something went wrong", "Error", JOptionPane.ERROR_MESSAGE);
					}
				
			}
		});
		btnNewButton_1.setBounds(600, 59, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("View Patient");
		lblNewLabel_2.setBounds(313, 15, 130, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Search by:");
		lblNewLabel_4.setBounds(37, 63, 96, 14);
		contentPane.add(lblNewLabel_4);
		
		search = new JTextField();
		search.setBounds(247, 62, 96, 20);
		contentPane.add(search);
		search.setColumns(10);
		
		
		
		
	}
}
