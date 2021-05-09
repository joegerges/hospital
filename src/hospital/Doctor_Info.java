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

public class Doctor_Info extends JFrame {

	private JPanel contentPane;
	private JTextField doc_ssn;
	private JTable table;
	private JFrame frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Doctor_Info frame = new Doctor_Info();
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
	public Doctor_Info() {
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
		search_by.addItem("qualifications");
		search_by.addItem("specializations");
		search_by.setSelectedItem(null);
		
		JButton btnNewButton_1 = new JButton("submit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					String _search_by = (String) search_by.getSelectedItem();
					
					int _doc_ssn = -1;
					if(!doc_ssn.getText().isEmpty()) _doc_ssn = Integer.parseInt(doc_ssn.getText());
					
					DatabaseHelper dbHelper = new DatabaseHelper();
					_search_by = (_search_by=="qualifications" ? "qual": "spec");
					ResultSet medRs = dbHelper.GetDocQualOrSpec(_search_by, _doc_ssn);
					
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
		
		JLabel lblNewLabel_2 = new JLabel("View Doctor Info");
		lblNewLabel_2.setBounds(315, 11, 130, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Filter by:");
		lblNewLabel_4.setBounds(37, 63, 96, 14);
		contentPane.add(lblNewLabel_4);
		
		doc_ssn = new JTextField();
		doc_ssn.setBounds(365, 62, 96, 20);
		contentPane.add(doc_ssn);
		doc_ssn.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Doctor SSN:");
		lblNewLabel.setBounds(289, 64, 110, 14);
		contentPane.add(lblNewLabel);
		
		
		
		
	}
}
