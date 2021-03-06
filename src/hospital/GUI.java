package hospital;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		//initialize();
		frame= new JFrame();
		//JButton button = new JButton("Click me");

		JPanel panel = new JPanel();
		//panel.setBorder(BorderFactory.createEmptyBorder(300,300,200,400));
		panel.setBorder(BorderFactory.createEmptyBorder(50,150,100,200));

		//button.add(button);
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JButton btnAddDoctor = new JButton("Add Doctor");	
		btnAddDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Add_Doctor varAddDoctor = new Add_Doctor();	
				varAddDoctor.setVisible(true);
			}
		});
		
		JButton btnViewBill = new JButton("View Bill");
		btnViewBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				View_Bill varViewBills = new View_Bill();	
				varViewBills.setVisible(true);
			}
		});
		
		JButton btnViewRoom = new JButton("View Rooms");
		btnViewRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				View_Rooms varViewRooms = new View_Rooms();	
				varViewRooms.setVisible(true);
			}
		});
		
		JButton btnMedicalRec = new JButton("View Medical Record");
		btnMedicalRec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				View_MedicalRecord varViewMed = new View_MedicalRecord();	
				varViewMed.setVisible(true);
			}
		});
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnNewButton_4 = new JButton("View Employees");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				View_Employees varViewEmp = new View_Employees();	
				varViewEmp.setVisible(true);
			}
		});
		
		JButton btnNewButton_8 = new JButton("Doctor Info");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Doctor_Info vardocinfo = new Doctor_Info();	
				vardocinfo.setVisible(true);
			}
		});
		panel.add(btnNewButton_8);
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_3 = new JButton("View Treatments");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				View_Treatment varViewTreatment = new View_Treatment();	
				varViewTreatment.setVisible(true);
			}
		});
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_2 = new JButton("View Medicines");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				View_Medicine varViewMedicine = new View_Medicine();	
				varViewMedicine.setVisible(true);
			}
		});
		panel.add(btnNewButton_2);
		panel.add(btnMedicalRec);
		
		JButton btnViewPatient = new JButton("View Patient");
		btnViewPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				View_Patient varViewPatient = new View_Patient();	
				varViewPatient.setVisible(true);
			}
		});
		panel.add(btnViewPatient);
		panel.add(btnViewRoom);
		panel.add(btnViewBill);
		
		JButton btnAddBill = new JButton("Add Bill");
		btnAddBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add_Bill varAddBill = new Add_Bill();	
				varAddBill.setVisible(true);
			}
		});
		panel.add(btnAddBill);
		
		JButton btnAddroom = new JButton("Add Room");
		btnAddroom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add_Rooms varAddRooms = new Add_Rooms();	
				varAddRooms.setVisible(true);
			}
		});
		panel.add(btnAddroom);
		
		JButton btnAddmedicalRecord = new JButton("Add Medical Record");
		btnAddmedicalRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add_MedicalRecord varAddMedicalRecord = new Add_MedicalRecord();	
				varAddMedicalRecord.setVisible(true);
			}
		});
		panel.add(btnAddmedicalRecord);
		
		JButton btnAddreceptionist = new JButton("Add Receptionist");
		btnAddreceptionist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add_Receptionist varAddReceptionist = new Add_Receptionist();	
				varAddReceptionist.setVisible(true);
			}
		});
		panel.add(btnAddreceptionist);
		
		JButton btnAddPatient = new JButton("Add Patient");
		btnAddPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add_Patient varAddPatient = new Add_Patient();	
				varAddPatient.setVisible(true);
			}
		});
		panel.add(btnAddPatient);
		
		JButton btnAddjanitor = new JButton("Add Janitor");
		btnAddjanitor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add_Janitor varAddJanitor = new Add_Janitor();	
				varAddJanitor.setVisible(true);
			}
		});
		panel.add(btnAddjanitor);
		
		JButton btnAddnurse = new JButton("Add Nurse");
		btnAddnurse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add_Nurse varAddNurse = new Add_Nurse();	
				varAddNurse.setVisible(true);
			}
		});
		panel.add(btnAddnurse);
		panel.add(btnAddDoctor);
		
		JButton btnNewButton = new JButton("Add Medicine ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add_Medicine varAddMedicine = new Add_Medicine();	
				varAddMedicine.setVisible(true);
			}
		});
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Add Treatment");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add_Treatment varAddTreatment = new Add_Treatment();	
				varAddTreatment.setVisible(true);
			}
		});
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_5 = new JButton("Assign Emp. to Room");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Assign_toRoom varAssign = new Assign_toRoom();	
				varAssign.setVisible(true);
			}
		});
		panel.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("page1");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				page1 varpage1 = new page1();	
				varpage1.setVisible(true);
			}
		});
		panel.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("page2");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				page2 varpage2 = new page2();	
				varpage2.setVisible(true);
			}
		});
		panel.add(btnNewButton_7);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Hospital");	
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(1000, 1000, 4500, 3000);
		//frame.setBounds(100, 100, 500, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}