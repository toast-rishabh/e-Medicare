package com.hm.emc.dao;

import java.sql.*;

import java.util.Date;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.HashMap;

import java.util.Map;

import com.hm.emc.bean.AppointmentBean;

import com.hm.emc.bean.DoctorBean;

import com.hm.emc.bean.PatientBean;

import com.hm.emc.service.Patient;

import com.hm.emc.util.DBUtil;

public class PatientDAO implements Patient {
	public static Connection con = DBUtil.getDBConnection("com.mysql.cj.jdbc.Driver");
	public static PreparedStatement ps = null;
	public static ResultSet rs = null;

	@Override
	public String addAilmentDetails(PatientBean pB) {
		int i = 0;
		int data = 0;
		try {
			ps = con.prepareStatement("insert into demo3 values()");
			i = ps.executeUpdate();
		} catch (Exception sql) {
		}
		try {
			ps = con.prepareStatement("select id from demo3");
			rs = ps.executeQuery();
			while (rs.next()) {
				data = rs.getInt(1);
			}
		} catch (SQLException sql) {
			System.out.println(sql);
		}
		try {
			ps = con.prepareStatement("Insert into OCS_TBL_Patient values(?,?,?,?,?,?)");
			ps.setString(1, "PI" + data);
			ps.setString(2, pB.getUserID());
			java.sql.Date d = new java.sql.Date(pB.getAppointmentDate().getDate());
			ps.setDate(3, d);
			ps.setString(4, pB.getAilmentType());
			ps.setString(5, pB.getAilmentDetails());
			ps.setString(6, pB.getDiagnosisHistory());
			i = ps.executeUpdate();
		} catch (SQLException sql) {
			System.out.println(sql);
		}
		if (i == 1) {
			return "SUCCESS";
		} else {
			return "FAIL";
		}
	}

	@Override
	public String modifyAilmentDetails(PatientBean pB) {
		int i = 0;
		try {
			ps = con.prepareStatement(
					"update OCS_TBL_Patient set ailmentType = ?,ailmentDetails = ?,diagnosisHistory = ? where patientID=?");
			ps.setString(1, pB.getAilmentType());
			ps.setString(2, pB.getAilmentDetails());
			ps.setString(3, pB.getDiagnosisHistory());
			ps.setString(4, pB.getPatientID());
			i = ps.executeUpdate();
		} catch (SQLException sql) {
			System.out.println(sql);
		}
		if (i == 1) {
			return "SUCCESS";
		} else {
			return "FAIL";
		}
	}

	@Override
	public ArrayList<PatientBean> viewAilmentDetails(String patientID) {
		ArrayList<PatientBean> res = new ArrayList<PatientBean>();
		try {
			ps = con.prepareStatement("select * from OCS_TBL_Patient where patientid=?");
			ps.setString(1, patientID);
			rs = ps.executeQuery();
			if (rs.next()) {
				PatientBean pB = new PatientBean();
				pB.setPatientID(rs.getString(1));
				pB.setUserID(rs.getString(2));
				pB.setAppointmentDate(rs.getDate(3));
				pB.setAilmentType(rs.getString(4));
				pB.setAilmentDetails(rs.getString(5));
				pB.setDiagnosisHistory(rs.getString(6));
				res.add(pB);
			}
		}
		catch (SQLException sql)
		{
			System.out.println(sql);
		}
		return res;
	}

	public ArrayList<DoctorBean> viewListOfDoctors(String specialization) {

		ArrayList<DoctorBean> arr = new ArrayList<DoctorBean>();

		try {

			Connection con = DBUtil.getDBConnection("com.mysql.cj.jdbc.Driver");

			PreparedStatement ps = con.prepareStatement("select * from OCS_TBL_DOCTOR "

					+ "where SPECIALIZATION = (?)  ");

			ps.setString(1, specialization);

// 
//
//		ps.setDate(2, (java.sql.Date) date);
//
// 
//
//		ps.setDate(3, (java.sql.Date) date);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				DoctorBean doc = new DoctorBean();

				doc.setDoctorID(rs.getString("DOCTORID"));

				doc.setCity(rs.getString("CITY"));

				doc.setContactNumber(rs.getString("CONTACTNUMBER"));

				doc.setDateOfBirth(rs.getDate("DATEOFBIRTH"));

				doc.setDateOfJoining(rs.getDate("DATEOFJOINING"));

				doc.setDoctorName(rs.getString("DOCTORNAME"));

				doc.setEmailID(rs.getString("EMAILID"));

				doc.setGender(rs.getString("GENDER"));

				doc.setLocation(rs.getString("LOCATION"));

				doc.setPincode(rs.getString("PINCODE"));

				doc.setQualification(rs.getString("QUALIFICATION"));

				doc.setSpecialization(rs.getString("SPECIALIZATION"));

				doc.setState(rs.getString("STATE"));

				doc.setStreet(rs.getString("STREET"));

				doc.setYearsOfExperience(rs.getInt("YEARSOFEXPERIENCE"));

				arr.add(doc);

			}

		}

		catch (SQLException sql)

		{

			System.out.println(sql);

		}

		return arr;

	}

	public String requestForAppointment(String patientID, String doctorID, java.sql.Date appointmentDate) {
		AppointmentBean aB = new AppointmentBean();
		AppointmentDAO apdao = new AppointmentDAO();
		int i = 0;
		try {
//			PreparedStatement ps = con.prepareStatement("Select l.doctorID from ocs_tbl_leave l join ocs_tbl_appointments a on l.doctorid = a.doctorid where l.doctorID=? and a.appointmentDate=? not between l.leave_from and l.leave_to limit 1");
			PreparedStatement ps = con.prepareStatement(
					"Select doctorID from ocs_tbl_leave  where doctorID=? and ? not between leave_from and leave_to limit 1");
			ps.setString(1, doctorID);
//			SimpleDateFormat sqlDateFormat = new SimpleDateFormat("yyyy-mm-dd");
//			String forDate = sqlDateFormat.format(appointmentDate);
//			 java.sql.Date dob = java.sql.Date.valueOf(forDate);
			ps.setDate(2, new java.sql.Date(appointmentDate.getTime()));
//			 ps.setDate(2, dob);
//			i = ps.executeUpdate();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				i = 1;
				aB.setDoctorID(rs.getString("DOCTORID"));
				aB.setPatientID(patientID);
				aB.setAppointmentDate(appointmentDate);

			}

		} catch (SQLException sql) {
			System.out.println(sql);
		}
		if (i == 1) {
			apdao.addAppointment(aB);
			return "SUCCESS";
		} else
			return "FAIL";

	}

	@Override

	public Map<AppointmentBean, PatientBean> viewAppointmentDetails(String patientID, Date date) {

//		PatientBean pB = new PatientBean();

//		Map<AppointmentBean, PatientBean> res = new HashMap<AppointmentBean, PatientBean>();

//		try {

//			ps=con.prepareStatement("select * from OCS_TBL_Appointments where patientID = ?")

//			ps.setString(1, patientID);

//			rs=ps.executeQuery();

//			if(rs.next())

//			{

//				

//			}

//		}

//		catch()

//		{

//			

//		}

		// TODO Auto-generated method stub

		return null;

	}

}
