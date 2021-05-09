package hospital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import hospital.DataContracts.Bill;
import hospital.DataContracts.Doctor;
import hospital.DataContracts.Employee;
import hospital.DataContracts.Janitor;
import hospital.DataContracts.MedicalRecord;
import hospital.DataContracts.Medicine;
import hospital.DataContracts.Nurse;
import hospital.DataContracts.Patient;
import hospital.DataContracts.Receptionist;
import hospital.DataContracts.Room;
import hospital.DataContracts.Treatment;

public class DatabaseHelper {
	Connection _con;
	
	public DatabaseHelper()
	{
		try {
			_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean Login(int internal_number, String password)
	{
		ResultSet rs = null;
		try {
			Statement stmt = _con.createStatement();
			String query = "SELECT * FROM receptionist WHERE internal_number=" + internal_number + " AND pass='"+ password + "'";
			rs = stmt.executeQuery(query);
			
			if(!rs.next())
			{
				return false;
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	public void AddEmployee(Employee emp)
	{
		try {
			String query = " insert into employee (ssn, fname, lname, salary, phone, dob, gender, country, zip, street, start_date)"
			        + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	      PreparedStatement preparedStmt = _con.prepareStatement(query);
	      preparedStmt.setInt(1, emp.ssn);
	      preparedStmt.setString(2, emp.fname);
	      preparedStmt.setString(3, emp.lname);
	      preparedStmt.setInt(4, emp.salary);
	      preparedStmt.setInt(5, emp.phone);
	      preparedStmt.setString(6, emp.dob);
	      preparedStmt.setString(7, emp.gender);
	      preparedStmt.setString(8, emp.country);
	      preparedStmt.setInt(9, emp.zip);
	      preparedStmt.setString(10, emp.street);
	      preparedStmt.setString(11, emp.start_date);
	      
	      preparedStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void AddReceptionist(Receptionist rec) throws SQLException
	{
	
		  String query = " insert into receptionist (ssn, working_hours, internal_number, pass)"
			        + " values (?, ?, ?, ?)";

	      PreparedStatement preparedStmt = _con.prepareStatement(query);
	      preparedStmt.setInt(1, rec.ssn);
	      preparedStmt.setInt(2, rec.working_hours);
	      preparedStmt.setInt(3, rec.internal_number);
	      preparedStmt.setString(4, rec.pass);
	      
	      preparedStmt.execute();
	
		
	}
	
	public void AddNurse(Nurse nur) throws SQLException
	{

		  String query = " insert into nurse (ssn, working_hours)"
			        + " values (?, ?)";

	      PreparedStatement preparedStmt = _con.prepareStatement(query);
	      preparedStmt.setInt(1, nur.ssn);
	      preparedStmt.setInt(2, nur.working_hours);
	      
	      preparedStmt.execute();

	}
	
	public void AddJanitor(Janitor jan) throws SQLException
	{

		  String query = " insert into janitor (ssn, working_hours, nationality)"
			        + " values (?, ?, ?)";

	      PreparedStatement preparedStmt = _con.prepareStatement(query);
	      preparedStmt.setInt(1, jan.ssn);
	      preparedStmt.setInt(2, jan.working_hours);
	      preparedStmt.setString(3, jan.nationality);
	      
	      
	      preparedStmt.execute();

	}
	
	public void AddDoctor(Doctor doc) throws SQLException
	{

		  String query = " insert into doctor (ssn, type, has_clinic)"
			        + " values (?, ?, ?)";

	      PreparedStatement preparedStmt = _con.prepareStatement(query);
	      preparedStmt.setInt(1, doc.ssn);
	      preparedStmt.setString(2, doc.type);
	      preparedStmt.setBoolean(3, doc.has_clinic);
	      
	      
	      preparedStmt.execute();

	}
	
	public void AddQualifications(int doc_ssn, String qualifications) throws SQLException
	{

		String[] quals = qualifications.split(",");
		for(String qual: quals)
		{
		  String query = " insert into qualification (ssn, qualification)"
			        + " values (?, ?)";

	      PreparedStatement preparedStmt = _con.prepareStatement(query);
	      preparedStmt.setInt(1, doc_ssn);
	      preparedStmt.setString(2, qual);
	      
	      
	      preparedStmt.execute();
		}

	}
	
	public void AddSpecializations(int doc_ssn, String specialiaztions) throws SQLException
	{

		String[] specs = specialiaztions.split(",");
		for(String spec: specs)
		{
		  String query = " insert into specialization (ssn, specialization)"
			        + " values (?, ?)";

	      PreparedStatement preparedStmt = _con.prepareStatement(query);
	      preparedStmt.setInt(1, doc_ssn);
	      preparedStmt.setString(2, spec);
	      
	      
	      preparedStmt.execute();
		}

	}
	
	public void AddRoom(Room room) throws SQLException
	{

		  String query = " insert into room (number, floor_number, number_beds, type)"
			        + " values (?, ?, ?, ?)";

	      PreparedStatement preparedStmt = _con.prepareStatement(query);
	      preparedStmt.setInt(1, room.number);
	      preparedStmt.setInt(2, room.floor_number);
	      preparedStmt.setInt(3, room.number_beds);
	      preparedStmt.setString(4, room.type);
	      
	      preparedStmt.execute();

	}
	
	public void AddPatient(Patient pat) throws SQLException
	{

		  String query = " insert into patient (ssn, fname, lname, room_number, floor_number, last_entered)"
			        + " values (?, ?, ?, ?, ?, ?)";

	      PreparedStatement preparedStmt = _con.prepareStatement(query);
	      preparedStmt.setInt(1, pat.ssn);
	      preparedStmt.setString(2, pat.fname);
	      preparedStmt.setString(3, pat.lname);
	      preparedStmt.setInt(4, pat.room_number);
	      preparedStmt.setInt(5, pat.floor_number);
	      preparedStmt.setString(6, pat.last_entered);
	      
	      preparedStmt.execute();

	}
	
	public void AddMedicalRecord(MedicalRecord med) throws SQLException
	{

		  String query = " insert into medical_record (ssn, address, phone, has_insurance, dob, blood_type, maintainer_ssn)"
			        + " values (?, ?, ?, ?, ?, ?, ?)";

	      PreparedStatement preparedStmt = _con.prepareStatement(query);
	      preparedStmt.setInt(1, med.ssn);
	      preparedStmt.setString(2, med.address);
	      preparedStmt.setInt(3, med.phone);
	      preparedStmt.setBoolean(4, med.has_insurance);
	      preparedStmt.setString(5, med.dob);
	      preparedStmt.setString(6, med.blood_type);
	      preparedStmt.setInt(7, med.maintainer_ssn);
	      preparedStmt.execute();

	}
	
	public void AddMedicine(Medicine med) throws SQLException
	{

		  String query = " insert into medecine (code_number, med_name, quantity, expiry_date, price)"
			        + " values (?, ?, ?, ?, ?)";

	      PreparedStatement preparedStmt = _con.prepareStatement(query);
	      preparedStmt.setInt(1, med.code_number);
	      preparedStmt.setString(2, med.med_name);
	      preparedStmt.setInt(3, med.quantity);
	      preparedStmt.setString(4, med.expiry_date);
	      preparedStmt.setInt(5, med.price);
	      preparedStmt.execute();

	}
	
	public ArrayList<Integer> GetMedicines() throws SQLException
	{
		ResultSet rs = null;
		ArrayList<Integer> result = new ArrayList<Integer>();
		try {
			Statement stmt = _con.createStatement();
			String query = "SELECT code_number FROM medecine";
			rs = stmt.executeQuery(query);
			
			while(rs.next())
			{
				result.add(rs.getInt("code_number"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int GetMedPrice(int code) throws SQLException
	{
		ResultSet rs = null;
		int result = 0;
		try {
			Statement stmt = _con.createStatement();
			String query = "SELECT price FROM medecine WHERE code_number=" + code;
			rs = stmt.executeQuery(query);
			
			while(rs.next())
			{
				result+=rs.getInt("price");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int GetTreatmentPrice(int id) throws SQLException
	{
		ResultSet rs = null;
		int result = 0;
		try {
			Statement stmt = _con.createStatement();
			String query = "SELECT price FROM treatment WHERE id=" + id;
			rs = stmt.executeQuery(query);
			
			while(rs.next())
			{
				result+=rs.getInt("price");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public ArrayList<Integer> GetTreatments() throws SQLException
	{
		ResultSet rs = null;
		ArrayList<Integer> result = new ArrayList<Integer>();
		try {
			Statement stmt = _con.createStatement();
			String query = "SELECT id FROM treatment";
			rs = stmt.executeQuery(query);
			
			while(rs.next())
			{
				result.add(rs.getInt("id"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public void AddTreatment(Treatment tre) throws SQLException
	{

		  String query = " insert into treatment (id, type, price, insurance_covered)"
			        + " values (?, ?, ?, ?)";

	      PreparedStatement preparedStmt = _con.prepareStatement(query);
	      preparedStmt.setInt(1, tre.id);
	      preparedStmt.setString(2, tre.type);
	      preparedStmt.setInt(3, tre.price);
	      preparedStmt.setBoolean(4, tre.insurance_covered);
	      preparedStmt.execute();
	}
	
	public void AddBill(Bill bill) throws SQLException
	{

		  String query = " insert into bill (med_code, treatment_id, patient_ssn, total_price)"
			        + " values (?, ?, ?, ?)";

	      PreparedStatement preparedStmt = _con.prepareStatement(query);
	      preparedStmt.setInt(1, bill.med_code);
	      preparedStmt.setInt(2, bill.treatment_id);
	      preparedStmt.setInt(3, bill.patient_ssn);
	      preparedStmt.setInt(4, bill.total_price);
	      preparedStmt.execute();
	}
	
	

	public ResultSet GetEmployees(String type, String search_by, String search_value, String salary_operator, int salary)
	{
		ResultSet rs = null;
		try {
			Statement stmt = _con.createStatement();
			String query = "SELECT * FROM " + type + "_emp WHERE ssn IS NOT NULL";
			if(salary_operator != "None" && salary != -1)
			{
				query += " AND salary" + salary_operator + salary;
			}
			if(search_by != "None" && search_value != "-1")
			{
				query += " AND " + search_by + " LIKE '%"+search_value+"%'";
			}
			
			rs = stmt.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet GetBills(int ssn_filter)
	{
		ResultSet rs = null;
		try {
			Statement stmt = _con.createStatement();
			String query = "SELECT patient_ssn, med_code, treatment_id, total_price FROM bill";
			if(ssn_filter != -1)
			{
				query += " WHERE patient_ssn LIKE '%"+ssn_filter+"%'";
			}
			rs = stmt.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet GetMedicine(int code)
	{
		ResultSet rs = null;
		try {
			Statement stmt = _con.createStatement();
			String query = "SELECT * FROM medecine";
			if(code != -1)
			{
				query += " WHERE code_number LIKE '%"+code+"'";
			}
			rs = stmt.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet GetTreatment(int id)
	{
		ResultSet rs = null;
		try {
			Statement stmt = _con.createStatement();
			String query = "SELECT * FROM treatment";
			if(id != -1)
			{
				query += " WHERE id LIKE '%"+id+"'";
			}
			rs = stmt.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ArrayList<Integer> GetFloorNumbers()
	{
		ResultSet rs = null;
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		try {
			Statement stmt = _con.createStatement();
			String query = "SELECT DISTINCT floor_number FROM room ORDER BY floor_number";
			rs = stmt.executeQuery(query);
			
			while(rs.next())
			{
				result.add(rs.getInt("floor_number"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public ResultSet GetRooms(Integer floor_number, Integer room_number)
	{
		ResultSet rs = null;
		try {
			Statement stmt = _con.createStatement();
			String query = "SELECT number AS room_number, number_beds AS number_of_beds, type  FROM room";
			if(floor_number != null)
			{
				query += " WHERE floor_number=" + floor_number;
			}
			if(room_number != null)
			{
				query += " AND number LIKE '%" + room_number + "%'";
			}
			rs = stmt.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	
	public ResultSet FetchPatientOrRecord(String search_by, String search_value, String type)
	{
		ResultSet rs = null;
		try {
			Statement stmt = _con.createStatement();
			String query = "SELECT * FROM " + type;
			if(search_value != "-1" && search_by != "None")
			{
				query += " WHERE " + search_by + " LIKE '%" + search_value + "%'";
			}
			rs = stmt.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public void EditMedicalRecord(MedicalRecord med) throws SQLException
	{
		  String query = "UPDATE medical_record SET address = ?, phone = ?, has_insurance = ?, dob = ?, blood_type = ?, maintainer_ssn = ? WHERE ssn=" + med.ssn;
	      PreparedStatement preparedStmt = _con.prepareStatement(query);
	      preparedStmt.setString(1, med.address);
	      preparedStmt.setInt(2, med.phone);
	      preparedStmt.setBoolean(3, med.has_insurance);
	      preparedStmt.setString(4, med.dob);
	      preparedStmt.setString(5, med.blood_type);
	      preparedStmt.setInt(6, med.maintainer_ssn);
	      System.out.println(preparedStmt.toString());
	      preparedStmt.executeUpdate();
	}
	
	public void DeleteMedicalRecord(int patient_ssn) throws SQLException
	{
		 String query = "DELETE FROM medical_record WHERE ssn=" + patient_ssn;
		 PreparedStatement preparedStmt = _con.prepareStatement(query);
		 preparedStmt.execute();
	}
	
	public ResultSet GetDocQualOrSpec(String type, int ssn)
	{
		ResultSet rs = null;
		try {
			Statement stmt = _con.createStatement();
			String query = "SELECT * FROM doctor_"+type;
			if(ssn != -1)
			{
				query+=" WHERE ssn="+ssn;
			}
			rs = stmt.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public void AssignNurseJanToRoom(int nurse_ssn, int jan_ssn, int room_num, int floor_num) throws SQLException
	{
		String query = "insert into in_charge (nurse_ssn, janitor_ssn, room_number, floor_number)"
		        + " values (?, ?, ?, ?)";

        PreparedStatement preparedStmt = _con.prepareStatement(query);
        preparedStmt.setInt(1, nurse_ssn);
        preparedStmt.setInt(2, jan_ssn);
        preparedStmt.setInt(3, room_num);
        preparedStmt.setInt(4, floor_num);
        preparedStmt.execute();
	}
	
	public ResultSet GetDetailsComplexOne(String pat_blood_type, String pat_arrival_date, String age_operator, String ageDate, String experience_operator, String experienceDate)
	{
		ResultSet rs = null;
		try {
			Statement stmt = _con.createStatement();
			String query = "SELECT * FROM complex_nurse_patient_view WHERE blood_type='"+pat_blood_type+"' AND last_entered='"+pat_arrival_date+"' AND dob"+age_operator+"'"+ageDate+ "' AND nurse_start_date"+experience_operator+"'"+experienceDate+"'";
			rs = stmt.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet GetDetailsComplexTwo(String payment_date, String med_name, String treatment, String ageOperator, String ageDate, String paidOperator, int totalSum)
	{
		ResultSet rs = null;
		try {
			Statement stmt = _con.createStatement();
			String query = "SELECT ssn, fname, lname, last_entered, dob, phone, SUM(total_price) AS total_paid FROM complex_patient_payment_view WHERE last_entered='"+payment_date+"' AND med_name='"+med_name+"'AND treatment='"+treatment+"' AND dob"+ageOperator+"'"+ageDate+ "'"+" GROUP BY ssn HAVING total_paid"+paidOperator+""+totalSum;
			rs = stmt.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
}
