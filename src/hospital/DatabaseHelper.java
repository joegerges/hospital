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

		  String query = " insert into medecine (code_number, quantity, expiry_date, price)"
			        + " values (?, ?, ?, ?)";

	      PreparedStatement preparedStmt = _con.prepareStatement(query);
	      preparedStmt.setInt(1, med.code_number);
	      preparedStmt.setInt(2, med.quantity);
	      preparedStmt.setString(3, med.expiry_date);
	      preparedStmt.setInt(4, med.price);
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
	
	

	public ResultSet GetEmployees(String type, int ssn, String salary_operator, int salary)
	{
		ResultSet rs = null;
		try {
			Statement stmt = _con.createStatement();
			String query = "SELECT * FROM " + type + "_emp WHERE ssn IS NOT NULL";
			if(salary_operator != "None" && salary != -1)
			{
				query += " AND salary" + salary_operator + salary;
			}
			if(ssn != -1)
			{
				query += " AND e.ssn LIKE '%"+ssn+"%'";
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
				query += " WHERE patient_ssn="+ssn_filter;
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
	
	
	public ResultSet FetchPatientOrRecord(int patient_ssn, String type)
	{
		ResultSet rs = null;
		try {
			Statement stmt = _con.createStatement();
			String query = "SELECT * FROM " + type;
			if(patient_ssn != -1)
			{
				query += " WHERE ssn LIKE '%" + patient_ssn + "%'";
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
	
}
