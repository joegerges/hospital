package hospital;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

public class page2 extends JFrame {

	private JPanel contentPane;
	private JTextField payment_date;
	private JTextField treatment;
	private JTextField medicine;
	private JTextField ageNum;
	private JTextField totalNum;
	private JTable table;
	private JFrame frame;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					page2 frame = new page2();
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
	public page2() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 607, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Let's find all patients that payed on 2020-09-05, with a total above 200000 ,");
		lblNewLabel.setBounds(20, 22, 517, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("older than 21, having taken the Chemiotherapy treatment and panadol");
		lblNewLabel_1.setBounds(20, 46, 539, 39);
		contentPane.add(lblNewLabel_1);
		
		payment_date = new JTextField();
		payment_date.setText("2020-09-05");
		payment_date.setBounds(10, 90, 98, 20);
		contentPane.add(payment_date);
		payment_date.setColumns(10);
		
		treatment = new JTextField();
		treatment.setText("chemiotherapy");
		treatment.setColumns(10);
		treatment.setBounds(271, 90, 116, 20);
		contentPane.add(treatment);
		
		JLabel lblNewLabel_2 = new JLabel("Age");
		lblNewLabel_2.setBounds(10, 144, 48, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNurseExperience = new JLabel("Total");
		lblNurseExperience.setBounds(221, 144, 98, 14);
		contentPane.add(lblNurseExperience);
		
		JComboBox operators_patient = new JComboBox();
		operators_patient.setToolTipText("");
		operators_patient.setBounds(10, 169, 42, 20);
		contentPane.add(operators_patient);
		operators_patient.addItem(">");
		operators_patient.addItem("<");
		operators_patient.addItem(">=");
		operators_patient.addItem("<");
		operators_patient.addItem("<=");
		operators_patient.addItem("=");
		
		JComboBox operators_total = new JComboBox();
		operators_total.setToolTipText("");
		operators_total.setBounds(221, 169, 42, 20);
		contentPane.add(operators_total);
		operators_total.addItem(">");
		operators_total.addItem("<");
		operators_total.addItem(">=");
		operators_total.addItem("<=");
		operators_total.addItem("=");
		
		medicine = new JTextField();
		medicine.setText("panadol");
		medicine.setColumns(10);
		medicine.setBounds(130, 90, 116, 20);
		contentPane.add(medicine);
		
		JScrollPane scrollPane = new JScrollPane();
		
		table = new JTable();
		table.setBounds(10, 99, 414, 197);
		scrollPane.setViewportView(table);
		scrollPane.setBounds(10, 200, 578, 176);
		getContentPane().add(scrollPane);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				String _operators_patient= (String) operators_patient.getSelectedItem();
				String _operators_nurse= (String) operators_total.getSelectedItem();
				int _Age = Integer.parseInt(ageNum.getText());
				int _total = Integer.parseInt(totalNum.getText());
				String _paymend_date = payment_date.getText();
				String _treatment = treatment.getText();		
				String _medicine = medicine.getText();	
				
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				String age = LocalDate.now().minusYears(_Age).format(formatter);
				
				String _pat_op="";
				
				switch(_operators_patient) {
				case ">": _pat_op = "<";
						  break;
				case "<": _pat_op = ">";
				  		  break;
				case ">=": _pat_op = "<=";
				          break;
				case "<=": _pat_op = ">=";
				           break;
				case "=": _pat_op = "=";
				  	      break;
				}
					
				DatabaseHelper dbHelper = new DatabaseHelper();
				ResultSet empsRs = dbHelper.GetDetailsComplexTwo(_paymend_date, _medicine, _treatment, _pat_op, age, _operators_nurse, _total);
				
				table.setModel(DbUtils.resultSetToTableModel(empsRs));
				
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(frame, "Oops, something went wrong", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnSubmit.setBounds(433, 168, 89, 23);
		contentPane.add(btnSubmit);
		
		JButton btnNewButton = new JButton("back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		btnNewButton.setBounds(0, 0, 89, 23);
		contentPane.add(btnNewButton);
		
		ageNum = new JTextField();
		ageNum.setBounds(62, 169, 98, 20);
		contentPane.add(ageNum);
		ageNum.setColumns(10);
		
		totalNum = new JTextField();
		totalNum.setBounds(271, 169, 116, 20);
		contentPane.add(totalNum);
		totalNum.setColumns(10);
		
		
	}
}