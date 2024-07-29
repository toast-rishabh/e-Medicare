package com.hm.emc.dao;

import java.sql.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;

import com.hm.emc.bean.*;
import com.hm.emc.service.*;
import com.hm.emc.util.*;

public class AdministratorDAO implements Administrator {
	public static void justThrowException() throws SQLException {
		throw new SQLException("Error occured while running query");
	}

	public static Connection con = DBUtil.getDBConnection("com.mysql.cj.jdbc.Driver");
	public static PreparedStatement ps = null;
	public static ResultSet rs = null;
//	SimpleDateFormat sqlDateFormat = new SimpleDateFormat("yyyy-mm-dd");

	// adding doctor to ocs_doctor table and return success if added properly
	public String addDoctor(DoctorBean db) {
		int i = 0;
		int data = 0;
		try {
			ps = con.prepareStatement("insert into demo values()");
			i = ps.executeUpdate();
		} catch (SQLException sql) {
		}
		try {
			ps = con.prepareStatement("select id from demo");
			rs = ps.executeQuery();
			while (rs.next()) {
				data = rs.getInt(1);
				justThrowException();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			ps = con.prepareStatement("insert into ocs_tbl_doctor values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, (db.getDoctorName().substring(0, 2)) + data);
			ps.setString(2, db.getDoctorName());
//	        String forDate = sqlDateFormat.format(db.getDateOfBirth().getDate());
			java.sql.Date dob = new java.sql.Date(db.getDateOfBirth().getDate());
//	        java.sql.Date dob = java.sql.Date.valueOf(forDate);
			ps.setDate(3, dob);
			java.sql.Date doj = new java.sql.Date(db.getDateOfJoining().getDate());
//	        java.sql.Date doj=java.sql.Date.valueOf(forDate1);
			ps.setDate(4, doj);
			ps.setString(5, db.getGender());
			ps.setString(6, db.getQualification());
			ps.setString(7, db.getSpecialization());
			ps.setInt(8, db.getYearsOfExperience());
			ps.setString(9, db.getStreet());
			ps.setString(10, db.getLocation());
			ps.setString(11, db.getCity());
			ps.setString(12, db.getState());
			ps.setString(13, db.getPincode());
			ps.setString(14, db.getContactNumber());
			ps.setString(15, db.getEmailID());
			i = ps.executeUpdate();
			justThrowException();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (i == 1) {
			return "SUCCESS";
		}
		if (i == 0) {
			return "FAIL";
		} else {
			return "ERROR";
		}

	}

	@SuppressWarnings("deprecation")
	@Override
	public Boolean modifyDoctor(DoctorBean db) {
		// modifies doctor table values
		int i = 0;
		Boolean res = false;
		try {
			PreparedStatement ps = con.prepareStatement(
					"update ocs_tbl_doctor set doctorName=?, dateOfBirth=?, dateOfjoining=?,gender=?,qualification=?, specialization=?,yearsOfExperience=? where doctorId=?");
			ps.setString(1, db.getDoctorName());
			java.sql.Date dob = new java.sql.Date(db.getDateOfBirth().getDate());
			ps.setDate(2, dob);
			java.sql.Date doj = new java.sql.Date(db.getDateOfJoining().getDate());
			ps.setDate(3, doj);
			ps.setString(4, db.getGender());
			ps.setString(5, db.getQualification());
			ps.setString(6, db.getSpecialization());
			ps.setInt(7, db.getYearsOfExperience());
			ps.setString(8, db.getDoctorID());
			;
			i = ps.executeUpdate();
			justThrowException();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (i == 1) {
			res = true;
		}
		return res;
	}

	@Override
	public ArrayList<DoctorBean> viewAllDoctors() {
		//
		ArrayList<DoctorBean> res = new ArrayList<>();

		try {
			ps = con.prepareStatement("Select * from ocs_tbl_doctor");
			rs = ps.executeQuery();

			while (rs.next()) {
				DoctorBean db = new DoctorBean();
				db.setDoctorID(rs.getString(1));
				db.setDoctorName(rs.getString(2));
				db.setDateOfBirth(rs.getDate(3));
				db.setDateOfJoining(rs.getDate(4));
				db.setGender(rs.getString(5));
				db.setQualification(rs.getString(6));
				db.setSpecialization(rs.getString(7));
				db.setYearsOfExperience(rs.getInt(8));
				db.setStreet(rs.getString(9));
				db.setLocation(rs.getString(10));
				db.setCity(rs.getString(11));
				db.setState(rs.getString(12));
				db.setPincode(rs.getString(13));
				db.setContactNumber(rs.getString(14));
				db.setEmailID(rs.getString(15));
				// add to array list
				res.add(db);
				justThrowException();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;

	}

	@Override
	public int removeDoctor(String doctorID) {
		int i = 0;
		try {
			ps = con.prepareStatement("Delete from ocs_tbl_doctor where doctorID=?");
			ps.setString(1, doctorID);
			i = ps.executeUpdate();
			justThrowException();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public ArrayList<DoctorBean> suggestDoctors(String patientID, Date date) {
		return null;
	}

	@Override
	public ArrayList<PatientBean> viewPatientsByDate(Date appointmetnDate) {
		ArrayList<PatientBean> res = new ArrayList<>();
		try {
			ps = con.prepareStatement("Select * from ocs_tbl_patient where appointmentDate = ?");
			ps.setDate(1, appointmetnDate);
			rs = ps.executeQuery();

			while (rs.next()) {
				PatientBean pb = new PatientBean();
				pb.setPatientID(rs.getString(1));
				pb.setUserID(rs.getString(2));
				pb.setAppointmentDate(rs.getDate(3));
				pb.setAilmentType(rs.getString(4));
				pb.setAilmentDetails(rs.getString(5));
				pb.setDiagnosisHistory(rs.getString(6));
				res.add(pb);
			}
			justThrowException();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	public static ArrayList<String> fetchAllDoctors(String ailmentType) {
		ArrayList<String> docIDS = new ArrayList<>();
		try {
			Connection con = DBUtil.getDBConnection("com.mysql.cj.jdbc.Driver");
			PreparedStatement ps = con.prepareStatement("SELECT DOCTORID FROM OCS_TBL_DOCTOR WHERE SPECIALIZATION = ?");
			ps.setString(1, ailmentType);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				docIDS.add(rs.getString(1));
			}
			justThrowException();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return docIDS;
	}
}
