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
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTable;

public class View_Bill extends JFrame {

	private JPanel contentPane;
	private JTextField search_ssn;
	private JTable table;
	private JFrame frame;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_Bill frame = new View_Bill();
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
	public View_Bill() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 346);
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
		scrollPane.setBounds(10, 99, 414, 197);
		getContentPane().add(scrollPane);
		
		JButton btnNewButton_1 = new JButton("submit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				int _search_ssn = -1;
				if(!search_ssn.getText().isEmpty())
				{
					_search_ssn = Integer.parseInt(search_ssn.getText());
				}
				
				DatabaseHelper dbHelper = new DatabaseHelper();
				ResultSet billsRs = dbHelper.GetBills(_search_ssn);
				
				table.setModel(DbUtils.resultSetToTableModel(billsRs));
				
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(frame, "Oops, something went wrong", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_1.setBounds(265, 59, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("View Bills");
		lblNewLabel_2.setBounds(177, 15, 130, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Search by SSN");
		lblNewLabel_4.setBounds(37, 63, 96, 14);
		contentPane.add(lblNewLabel_4);
		
		search_ssn = new JTextField();
		search_ssn.setBounds(143, 60, 96, 20);
		contentPane.add(search_ssn);
		search_ssn.setColumns(10);
		
		
	}
}
