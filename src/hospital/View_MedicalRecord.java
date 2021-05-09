package hospital;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import hospital.DataContracts.MedicalRecord;
import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;

public class View_MedicalRecord extends JFrame {

	private JPanel contentPane;
	private JTextField search;
	private JTable table;
	private JFrame frame;
	private final JLabel lblNewLabel = new JLabel("Selected Record:");
	private JTextField addressEdit;
	private JTextField phoneEdit;
	private JComboBox<Boolean> hasInsuranceEdit;
	private JTextField dobEdit;
	private JTextField bloodTypeEdit;
	private JTextField maintainerSsnEdit;
	private JButton editBtn;
	private JButton btnDelete;
	private JComboBox search_by;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_MedicalRecord frame = new View_MedicalRecord();
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
	public View_MedicalRecord() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 760, 437);
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
		scrollPane.setBounds(10, 93, 724, 227);
		getContentPane().add(scrollPane);
		
		search_by = new JComboBox();
		search_by.setBounds(103, 60, 103, 22);
		contentPane.add(search_by);
		search_by.addItem("ssn");
		search_by.addItem("first name");
		search_by.addItem("last name");
		search_by.addItem("blood type");
		search_by.addItem("DOB");
		search_by.setSelectedItem(null);
		
		JButton btnNewButton_1 = new JButton("submit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
			try {
				
				String _search_by = (String) search_by.getSelectedItem();
				
				int _search_ssn = -1;
				if(!search.getText().isEmpty()) _search_ssn = Integer.parseInt(search.getText());
				
				DatabaseHelper dbHelper = new DatabaseHelper();
				ResultSet medRs = dbHelper.FetchPatientOrRecord(_search_ssn, "medical_record");
				
				table.setModel(DbUtils.resultSetToTableModel(medRs));
				
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(frame, "Oops, something went wrong", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnNewButton_1.setBounds(645, 59, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("View Medical Records");
		lblNewLabel_2.setBounds(285, 15, 130, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Search by:");
		lblNewLabel_4.setBounds(37, 63, 96, 14);
		contentPane.add(lblNewLabel_4);
		
		search = new JTextField();
		search.setBounds(228, 62, 96, 20);
		contentPane.add(search);
		search.setColumns(10);
		lblNewLabel.setBounds(10, 331, 123, 31);
		contentPane.add(lblNewLabel);
		
		addressEdit = new JTextField();
		addressEdit.setColumns(10);
		addressEdit.setBounds(10, 363, 86, 20);
		contentPane.add(addressEdit);
		
		phoneEdit = new JTextField();
		phoneEdit.setColumns(10);
		phoneEdit.setBounds(106, 363, 86, 20);
		contentPane.add(phoneEdit);
		
		hasInsuranceEdit = new JComboBox<Boolean>();
		hasInsuranceEdit.addItem(true);
		hasInsuranceEdit.addItem(false);
		hasInsuranceEdit.setBounds(202, 363, 86, 20);
		contentPane.add(hasInsuranceEdit);
		hasInsuranceEdit.setSelectedItem(null);
		
		dobEdit = new JTextField();
		dobEdit.setColumns(10);
		dobEdit.setBounds(298, 363, 86, 20);
		contentPane.add(dobEdit);
		
		bloodTypeEdit = new JTextField();
		bloodTypeEdit.setColumns(10);
		bloodTypeEdit.setBounds(394, 363, 86, 20);
		contentPane.add(bloodTypeEdit);
		
		maintainerSsnEdit = new JTextField();
		maintainerSsnEdit.setColumns(10);
		maintainerSsnEdit.setBounds(490, 363, 86, 20);
		contentPane.add(maintainerSsnEdit);
		
		editBtn = new JButton("edit");
		editBtn.setBounds(586, 362, 70, 23);
		contentPane.add(editBtn);
		
		btnDelete = new JButton("delete");
		btnDelete.setBounds(664, 362, 70, 23);
		contentPane.add(btnDelete);
		
		
		
		MedicalRecord medc = new MedicalRecord();
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				medc.ssn = (int) table.getModel().getValueAt(row, 0);
				addressEdit.setText((String) table.getModel().getValueAt(row, 1));
				phoneEdit.setText(String.valueOf(table.getModel().getValueAt(row, 2)));
				hasInsuranceEdit.setSelectedItem(table.getModel().getValueAt(row, 3));
				dobEdit.setText( (String) ((Date) table.getModel().getValueAt(row, 4)).toString());
				bloodTypeEdit.setText((String) table.getModel().getValueAt(row, 5));
				maintainerSsnEdit.setText(String.valueOf(table.getModel().getValueAt(row, 6)));
			}
		});
		
		
		editBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DatabaseHelper dbHelper = new DatabaseHelper();
				try {
					int _search_ssn = -1;
					if(!search.getText().isEmpty()) _search_ssn = Integer.parseInt(search.getText());
					
					medc.address = addressEdit.getText();
					medc.phone = Integer.parseInt(phoneEdit.getText());
					medc.has_insurance = (boolean) hasInsuranceEdit.getSelectedItem();
					medc.dob = dobEdit.getText();
					medc.blood_type = bloodTypeEdit.getText();
					medc.maintainer_ssn = Integer.parseInt(maintainerSsnEdit.getText());
					dbHelper.EditMedicalRecord(medc);
					
					ResultSet medRs = dbHelper.FetchPatientOrRecord(_search_ssn, "medical_record");	
					table.setModel(DbUtils.resultSetToTableModel(medRs));
					
					JOptionPane.showMessageDialog(frame, "Successfully edited this record", "Success", JOptionPane.INFORMATION_MESSAGE);
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(frame, "Oops, something went wrong", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DatabaseHelper dbHelper = new DatabaseHelper();
				try {
					int _search_ssn = -1;
					if(!search.getText().isEmpty()) _search_ssn = Integer.parseInt(search.getText());
					dbHelper.DeleteMedicalRecord(medc.ssn);
					ResultSet medRs = dbHelper.FetchPatientOrRecord(_search_ssn, "medical_record");	
					table.setModel(DbUtils.resultSetToTableModel(medRs));
					JOptionPane.showMessageDialog(frame, "Successfully deleted this record", "Success", JOptionPane.INFORMATION_MESSAGE);
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
					JOptionPane.showMessageDialog(frame, "Oops, something went wrong", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		
	}
}
